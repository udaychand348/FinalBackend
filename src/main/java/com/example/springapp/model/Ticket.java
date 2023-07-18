package com.example.springapp.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;



@Entity
@Table(name="Ticket")
public class Ticket
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Double price;
	private String status;
    
	@ManyToOne
	@JsonBackReference
    @JoinColumn(name="event_id")
	private Event event;
	
    @ManyToOne
	@JoinColumn(name="attendee_id")
	private Attendee attendee;

	public Ticket() 
	{
		super();
		
	}

	
	public Ticket(Long id, Double price, String status, Event event, Attendee attendee) {
		this.id = id;
		this.price = price;
		this.status = status;
		this.event = event;
		this.attendee = attendee;
	}


	public Long getId()
	 {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Attendee getAttendee() {
		return attendee;
	}

	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}

}



