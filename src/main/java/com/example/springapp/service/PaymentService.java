package com.example.springapp.service;





import java.util.List;

import com.example.springapp.model.Payment;
import com.example.springapp.model.TransactionDetails;

public interface PaymentService 
{
    public Payment savePayment(Payment payment);
    public List<Payment> getAllPayments();
    public TransactionDetails createTransaction(Double amount);
}
