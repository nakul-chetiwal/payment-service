package com.learning.paymentservice.business.service.impl;

import com.learning.paymentservice.business.enums.PaymentStatus;
import com.learning.paymentservice.business.repository.PaymentRepo;
import com.learning.paymentservice.business.repository.documents.Payment;
import com.learning.paymentservice.business.service.PaymentService;
import com.learning.paymentservice.model.api.PaymentRequest;
import com.learning.paymentservice.model.api.PaymentResponse;
import com.learning.paymentservice.utils.SequenceGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;
    private final SequenceGenerator sequenceGenerator;


    @Override
    public PaymentResponse makePayment(PaymentRequest paymentRequest) {
        Long id = sequenceGenerator.getSequenceNumber(Payment.SEQUENCE_NAME);
      Payment payment=  Payment.builder()
                .id(id)
                .paymentStatus(PaymentStatus.SUCCESS)
                .price(paymentRequest.getPrice())
                .orderId(paymentRequest.getOrderId())
                .dateTime(LocalDateTime.now()).build();

      Payment payment1=  paymentRepo.save(payment);
        log.info("Payment Details saved {}", payment1);
      PaymentResponse paymentResponse=
        PaymentResponse.builder()
                .id(payment.getId())
                .orderId(payment1.getOrderId())
                .paymentStatus(payment1.getPaymentStatus())
                .dateTime(payment1.getDateTime())
                .price(payment1.getPrice()).build();

        return paymentResponse;
    }

    @Override
    public PaymentStatus checkStatus(Long id) {
       if(!paymentRepo.existsById(id)) {
            log.info("Id: {} does not exist in db ",id);
           return null;
       }
        Payment payment= paymentRepo.findById(id).get();
//        PaymentDto paymentDto=PaymentDto.builder()
//                .orderId(payment.getId())
//                .dateTime(payment.getDateTime())
//                .price(payment.getPrice())
//                .paymentStatus(payment.getPaymentStatus())
//                .build();

        return payment.getPaymentStatus();
    }
}
