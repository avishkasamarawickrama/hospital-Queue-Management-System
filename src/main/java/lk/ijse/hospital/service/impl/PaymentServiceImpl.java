package lk.ijse.hospital.service.impl;

import lk.ijse.hospital.dto.PaymentRequest;
import lk.ijse.hospital.dto.PaymentResponse;
import lk.ijse.hospital.entity.Appointment;
import lk.ijse.hospital.entity.Payment;
import lk.ijse.hospital.repo.AppointmentRepo;
import lk.ijse.hospital.repo.PaymentRepo;
import lk.ijse.hospital.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;
    private final AppointmentRepo appointmentRepo;

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        // Validate appointment
        Appointment appointment = appointmentRepo.findById(paymentRequest.getAppointmentId())
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Create payment
        Payment payment = new Payment();
        payment.setAppointment(appointment);
        payment.setAmount(BigDecimal.valueOf(appointment.getChannelingFee()));
        payment.setPaymentMethod(paymentRequest.getPaymentMethod());
        payment.setStatus("COMPLETED");

        // For credit card payments
        if ("CREDIT_CARD".equals(paymentRequest.getPaymentMethod())) {
            String cardNumber = paymentRequest.getCardDetails().getCardNumber();
            payment.setCardLastFour(cardNumber.substring(cardNumber.length() - 4));
            payment.setCardType(determineCardType(cardNumber));
        }

        // Generate transaction ID
        payment.setTransactionId(generateTransactionId());

        // Save payment
        Payment savedPayment = paymentRepo.save(payment);

        appointment.setPaymentStatus(Appointment.PaymentStatus.PAID);
        appointment.setStatus(Appointment.AppointmentStatus.CONFIRMED);  appointmentRepo.save(appointment);

        return PaymentResponse.builder()
                .paymentId(savedPayment.getPaymentId())
                .transactionId(savedPayment.getTransactionId())
                .status(savedPayment.getStatus())
                .amount(savedPayment.getAmount())
                .build();
    }

    private String determineCardType(String cardNumber) {
        // Implement proper card type detection logic
        if (cardNumber.startsWith("4")) {
            return "VISA";
        } else if (cardNumber.startsWith("5")) {
            return "MASTERCARD";
        } else {
            return "OTHER";
        }
    }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepo.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public List<Payment> getPaymentsByAppointment(Long appointmentId) {
        return paymentRepo.findByAppointmentAppointmentId(appointmentId);
    }
}