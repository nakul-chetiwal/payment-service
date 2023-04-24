package com.learning.paymentservice.business.repository.documents;

import com.learning.paymentservice.business.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "payment")
public class Payment {

    @Transient
    public static final String SEQUENCE_NAME = "payment_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Double price;
    private LocalDateTime dateTime;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
   // private List<Transaction> transactionList;
}
