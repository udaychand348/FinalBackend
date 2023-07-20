package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springapp.model.Payment;
import com.example.springapp.model.TransactionDetails;
import com.example.springapp.service.PaymentService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/save")
    public String save(@RequestBody Payment payment){
        paymentService.savePayment(payment);
        return "New Payment is added";
    }

    @GetMapping("/getAll")
    public List<Payment> list(){
        return paymentService.getAllPayments();
    }
    
    
   
   @GetMapping("/createTransaction/{amount}")
   public ResponseEntity<TransactionDetails> createTransaction(@PathVariable("amount") Double amount)
   {
    	TransactionDetails td = paymentService.createTransaction(amount);
    return ResponseEntity.ok(td);
   }
    
    
    
}