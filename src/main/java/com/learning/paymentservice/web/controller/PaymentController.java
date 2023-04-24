package com.learning.paymentservice.web.controller;

import com.learning.paymentservice.business.enums.PaymentStatus;
import com.learning.paymentservice.business.service.PaymentService;
import com.learning.paymentservice.model.api.PaymentRequest;
import com.learning.paymentservice.model.api.PaymentResponse;
import com.learning.paymentservice.model.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public PaymentResponse makePayment(@RequestBody PaymentRequest paymentRequest) {
        log.info("Request object in controller layer", paymentRequest);
        PaymentResponse paymentResponse= paymentService.makePayment(paymentRequest);

        return paymentResponse;
    }

    @GetMapping("/{id}")
    public PaymentStatus checkStatus(@PathVariable Long id) {
        log.info("Payment Id: {} Received in controller layer", id);
        //   paymentService.makePayment(paymentRequest);
        return paymentService.checkStatus(id);
    }
}
