package com.service.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.payment.model.Payment;
import com.service.payment.model.Payment.PaymentStatus;
import com.service.payment.repository.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> listAllPayment() {
        return paymentRepository.findAll();
    }

    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public Payment getPayment(int id) {
        return paymentRepository.findById(id).get();
    }

    public Payment process(Payment payment) {
        payment.setOrderStatus(PaymentStatus.APPROVED);
        Payment paymentSaved = paymentRepository.save(payment);
        
        return paymentSaved;
        
    }

}
