package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Event;
import com.example.springapp.repository.EventRepository;


@Service
public class EventService 
{
	
	@Autowired
	private EventRepository eventRepository;
	

	public EventService() 
	{
		super();
	}

	public EventService(EventRepository eventRepository) 
	{
		super();
		this.eventRepository = eventRepository;
	}
	
	public  EventRepository getEventRepository() {
		return eventRepository;
	}

	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	
	public Event createEvent(Event event)
	{
        return this.eventRepository.save(event);
    }

    public Event updateEvent(Event event,Long id) 
    {
         Optional<Event> opt = this.eventRepository.findById(id);
         if(opt.isPresent())
         {
        	 Event e = opt.get();
        	 e.setName(event.getName());
        	 e.setDescription(event.getDescription());
        	 e.setStartDate(event.getStartDate());
        	 e.setEndDate(event.getEndDate());
        	 e.setLocation(event.getLocation());
        	 e.setTotalTicket(event.getTotalTicket());
         return this.eventRepository.save(e);
         }
         return event;
    }

    public boolean deleteEvent(Long id)
    {
		Optional<Event> opt = this.eventRepository.findById(id);
		if (opt.isPresent())
		{
			eventRepository.deleteById(id);
			return true;
		}
		return false;
    }

    public List<Event> getAllEvent()
    {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) 
    {
      Optional<Event> e = eventRepository.findById(id);
      return e.get();	   
    }
	
	
	

}
