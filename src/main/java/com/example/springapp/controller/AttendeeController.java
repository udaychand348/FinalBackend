package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Attendee;
import com.example.springapp.service.AttendeeService;





@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/attendee")
public class AttendeeController 
{
	@Autowired
	private AttendeeService attendeeService;

	public AttendeeController()
	{
	}
	public AttendeeController(AttendeeService attendeeService) 
	{
		this.attendeeService = attendeeService;
	}
	
	public AttendeeService getAttendeeService() 
	{
		return attendeeService;
	}
	public void setAttendeeService(AttendeeService attendeeService) {
		this.attendeeService = attendeeService;
	}
	
	

	@PostMapping
	 public ResponseEntity<Attendee> registerAttendee(@RequestBody Attendee attendee)
	{
        Attendee registeredAttendee = attendeeService.registerAttendee(attendee);
        return ResponseEntity.ok(registeredAttendee);
    }
	
	@GetMapping
    public ResponseEntity<List<Attendee>> getAllAttendees()
	{
        List<Attendee> attendees = attendeeService.getAllAttendee();
      return ResponseEntity.ok(attendees);
    }
	
	
	@GetMapping("/attendee/{id}")
    public ResponseEntity<Attendee> getAttendee(@PathVariable("id") long id)
	{
        Attendee attendee = attendeeService.getAttendee(id);
      return ResponseEntity.ok(attendee);
    }
	
	
	
	
	
	@GetMapping("/{id}")
    public ResponseEntity<List<Attendee>> getAttendeeByEventId(@PathVariable("id") long id) 
	{
        List<Attendee> attendees = attendeeService.getAttendeeByEventId(id);
       return ResponseEntity.ok(attendees);
    }
	
	
    @PutMapping()
    public ResponseEntity<Attendee> updateAttendee(@RequestBody Attendee attendee) 
    { 
         Long attendeeId = attendee.getId();
    	 Attendee a = attendeeService.updateAttendeee(attendeeId,attendee);
    	 if(a!=null)
    	 {
    	 return ResponseEntity.ok(a);
    	 }
    	 else
    	 {
    		 return ResponseEntity.notFound().build();
    	 }
    	
    }
	
    
    @DeleteMapping("/{attendeeId}")
    public ResponseEntity<Boolean> removeAttendeeById(@PathVariable("attendeeId") Long attendeeId) 
    {
        boolean removed = attendeeService.removeAttendeeById(attendeeId);
       return ResponseEntity.ok(removed);
    }
}



