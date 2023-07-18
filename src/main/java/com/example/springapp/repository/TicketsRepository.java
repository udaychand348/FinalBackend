package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Ticket;



public interface TicketsRepository extends JpaRepository<Ticket,Long>
{
  List<Ticket>  findTicketByEventId(Long id);
  List<Ticket>  findTicketByAttendeeId(Long id);
}
