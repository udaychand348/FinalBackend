package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.TicketSales;
import com.example.springapp.service.TicketSalesService;


@CrossOrigin
@RestController
@RequestMapping("/ticket/sales-report")
public class TicketSalesController
{
	
	@Autowired
	private TicketSalesService ticketSalesService;
	
	
	
	@GetMapping("/eventId/{id}")
	public ResponseEntity<TicketSales> generateReport(@PathVariable("id") Long id)
	{
		TicketSales tSales = ticketSalesService.generateSalesReport(id);
	 return ResponseEntity.ok(tSales);
	}
	
	

}
