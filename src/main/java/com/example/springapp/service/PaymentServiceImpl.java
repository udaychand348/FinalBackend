package com.example.springapp.service;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Payment;
import com.example.springapp.model.TransactionDetails;
import com.example.springapp.repository.PaymentRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService 
{
	
	
	private static final String KEY = "rzp_test_gT4dWWFeX1kHrU";
	private static final String KEY_SECRET = "6h7JEhXFX1IymJIiN7INdpUP";
	private static final String CURRENCY = "INR";

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

	@Override
	public TransactionDetails createTransaction(Double amount) 
	{
		try 
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("amount", (amount * 100));
			jsonObject.put("currency",CURRENCY);
			
			RazorpayClient razorpayClient = new RazorpayClient(KEY, KEY_SECRET);
			Order order = razorpayClient.orders.create(jsonObject);
			System.out.println(order);
		TransactionDetails tDetails = prepareTransactionDetails(order);
		
		return tDetails;
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			
		}
	return null;
	}
	
	public TransactionDetails prepareTransactionDetails(Order order)
	{
		String orderId  = order.get("id");
		String currency = order.get("currency");
		String amount =  order.get("amount").toString();
		
		TransactionDetails transactionDetails = new TransactionDetails(orderId,currency,amount,KEY);
		
		return transactionDetails;
	}
	
	
	
}
