package com.example.springapp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Ticket;
import com.example.springapp.repository.TicketsRepository;

@Service
public class TicketService 
{
	
	@Autowired
	private TicketsRepository ticketsRepository;

	public TicketService() {
		super();
		
	}

	public TicketService(TicketsRepository ticketsRepository) {
		
		this.ticketsRepository = ticketsRepository;
	}

	public TicketsRepository getTicketsRepository() {
		return ticketsRepository;
	}

	public void setTicketsRepository(TicketsRepository ticketsRepository) {
		this.ticketsRepository = ticketsRepository;
	}
	
	
	
	
	public List<Ticket> getAllTicket()
	{
		return ticketsRepository.findAll();
	}
	
	
	public Ticket getTicketById(Long id)
	{
	 Optional<Ticket> opt = ticketsRepository.findById(id);
	 return opt.get();
	}
	

	public List<Ticket> getTicketByAttendeeId(Long atttendeeId)
	{
		return ticketsRepository.findTicketByAttendeeId(atttendeeId);
	}
	
	public List<Ticket> getTicketByEventId(Long eventId)
	{
		return ticketsRepository.findTicketByEventId(eventId);
	}
	
	
	
	public Ticket createTicket(Ticket tickets)
	{
		return ticketsRepository.save(tickets);
	}
	
	
	public Ticket updateTicket(Ticket tickets,Long ticketId)
	{
	      Optional<Ticket> opt = ticketsRepository.findById(ticketId);
	      if(opt.isPresent())
	      {
	    	  Ticket t = opt.get();
	    	  t.setPrice(tickets.getPrice());
	    	  t.setStatus(tickets.getStatus());
	       return ticketsRepository.save(t);
	      }
	      return tickets;
	}
	
	
	public boolean deleteTicket(Long ticketId)
	{
	  Optional<Ticket> opt = ticketsRepository.findById(ticketId);	
	  if(opt.isPresent())
	  {
		  ticketsRepository.deleteById(ticketId);
	   return true;
	  }
	  return false;
	}
	

}


