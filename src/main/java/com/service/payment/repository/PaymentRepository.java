package com.service.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.service.payment.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
}
