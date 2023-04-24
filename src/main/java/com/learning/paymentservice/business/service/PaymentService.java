package com.learning.paymentservice.business.service;

import com.learning.paymentservice.business.enums.PaymentStatus;
import com.learning.paymentservice.model.api.PaymentRequest;
import com.learning.paymentservice.model.api.PaymentResponse;

public interface PaymentService {

    public PaymentResponse makePayment(PaymentRequest paymentRequest);
    public PaymentStatus checkStatus(Long id);
}
