package com.learning.paymentservice.business.repository;

import com.learning.paymentservice.business.repository.documents.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface PaymentRepo extends MongoRepository<Payment,Long> {
}
