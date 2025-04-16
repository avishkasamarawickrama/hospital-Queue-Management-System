package lk.ijse.hospital.controller;

import lk.ijse.hospital.dto.PaymentRequest;
import lk.ijse.hospital.dto.ResponseDTO;
import lk.ijse.hospital.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<ResponseDTO> processPayment(@RequestBody PaymentRequest paymentRequest) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(200)
                        .message("Payment processed successfully")
                        .data(paymentService.processPayment(paymentRequest))
                        .build(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<ResponseDTO> getPaymentDetails(@PathVariable Long paymentId) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(200)
                        .message("Payment details retrieved")
                        .data(paymentService.getPaymentById(paymentId))
                        .build(),
                HttpStatus.OK
        );
    }
}