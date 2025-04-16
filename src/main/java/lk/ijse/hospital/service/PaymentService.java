package lk.ijse.hospital.service;

import lk.ijse.hospital.dto.PaymentRequest;
import lk.ijse.hospital.dto.PaymentResponse;
import lk.ijse.hospital.entity.Payment;

import java.util.List;


    // PaymentService.java
    public interface PaymentService {
        PaymentResponse processPayment(PaymentRequest paymentRequest);
        Payment getPaymentById(Long paymentId);
        List<Payment> getPaymentsByAppointment(Long appointmentId);
    }


