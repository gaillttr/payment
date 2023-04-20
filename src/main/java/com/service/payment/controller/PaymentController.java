package com.service.payment.controller;

import java.util.List;
import java.util.NoSuchElementException;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.payment.model.Payment;
import com.service.payment.service.PaymentService;

@RestController
@RequestMapping("/api/payment/")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("/all")
    public List<Payment> list() {
        return paymentService.listAllPayment();
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<Payment> getPayment(@PathVariable int id) {
        try {
            Payment payment = paymentService.getPayment(id);
            return new ResponseEntity<Payment>(payment, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
    }

    // @GetMapping("/{paymentId}/status")
    // public ResponseEntity<Payment> getPayment(@PathVariable String orderStatus) {
    //     try {
    //         Payment payment = paymentService.getPayment(orderStatus);
    //         return new ResponseEntity<Payment>(payment, HttpStatus.OK);
    //     } catch (NoSuchElementException e) {
    //         return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
    //     }
    // }

    //  @PostMapping("/")
    // public void add(@RequestBody Payment payment) {
    //     paymentService.savePayment(payment);
    // }

    @PostMapping("/status_payment")
	public ResponseEntity<Payment> create(@RequestBody Payment payment) {
		return ResponseEntity.ok(paymentService.process(payment));
	}


    // @PutMapping("/update-payment/{id}")
    // public ResponseEntity<?> update(@RequestBody Payment payment, @PathVariable int id) {
    //     try {
    //         Payment existPayment = paymentService.getPayment(id);
    //         payment.setId(id);
    //         paymentService.savePayment(payment);
	// 		System.out.println("Update a Customer Successfully!");
    //         return new ResponseEntity<>(HttpStatus.OK);
    //     } catch (NoSuchElementException e) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

}
