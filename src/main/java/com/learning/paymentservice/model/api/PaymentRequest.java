package com.learning.paymentservice.model.api;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long orderId;
    private Double price;
}
