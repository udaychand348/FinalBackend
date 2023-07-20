package com.example.springapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Event;
import com.example.springapp.model.TicketSales;

import com.example.springapp.repository.TicketSalesRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class TicketSalesService 
{
	
	@Autowired
	private TicketSalesRepository ticketSalesRepository;
	
	@Autowired
	private EventService eventService;
	
	
	public TicketSales generateSalesReport(Long eventId)
	{
		Event event = eventService.getEventById(eventId);
		
		int ticketsbooked = event.getTickets().size();
		int eventattendees = event.getAttendees().size();
		Long ticketcount = event.getTotalTicket();
		Double price = (300.00 * ticketsbooked );
		
		
		
		TicketSales ticketSales = new TicketSales();
		ticketSales.setEventId(event.getId());
		ticketSales.setTotalTicketsBooked(Integer.toString(ticketsbooked));
		ticketSales.setAvailableTickets(Long.toString(ticketcount));
		ticketSales.setNoOfAttendees(Integer.toString(eventattendees));
		ticketSales.setTotalPrice(price);
		
        return  ticketSalesRepository.save(ticketSales);
	}

}
