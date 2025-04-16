package lk.ijse.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private Integer appointmentId;  // Changed from Long to Integer
    private String paymentMethod;
    private CardDetails cardDetails;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CardDetails {
        private String cardNumber;
        private String expiryDate;
        private String cvv;
        private String cardHolderName;
    }
}