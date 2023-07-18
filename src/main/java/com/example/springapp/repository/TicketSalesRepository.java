package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.TicketSales;

public interface TicketSalesRepository extends JpaRepository<TicketSales, Long>
{

}
