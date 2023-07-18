package com.example.springapp.service;





import java.util.List;

import com.example.springapp.model.Payment;

public interface PaymentService 
{
    public Payment savePayment(Payment payment);
    public List<Payment> getAllPayments();
}
