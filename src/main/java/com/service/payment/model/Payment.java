package com.service.payment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`payment`")
public class Payment {
    private int id;
    private String orderId;
    private String paymentId;
    private int amount;
    private String paymentDate;
   // private String orderStatus;
    private String paymentMethod;
    private String companyName;
    private String companyAddress;
    private PaymentStatus orderStatus;

    public Payment(){

    }
    public Payment(int id, String orderId, String paymentId, int amount, String paymentDate, PaymentStatus orderStatus, String paymentMethod, String companyName, String companyAddress) {
        this.id = id;
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
    
    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public enum PaymentStatus {
		APPROVED;
	}
    
    public PaymentStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(PaymentStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
