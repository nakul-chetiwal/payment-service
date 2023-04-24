package com.learning.paymentservice.model.dto;

import com.learning.paymentservice.business.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {

    private Long orderId;
    private Double price;
    private LocalDateTime dateTime;
    private PaymentStatus paymentStatus;
    // private List<Transaction> transactionList;
}
