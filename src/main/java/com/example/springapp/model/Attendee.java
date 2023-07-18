package com.example.springapp.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="Attendee")
public class Attendee 
{
	  @Id 
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	
	   @Column(name="AttendeeName")
	   private String name;
       @Column(name="AttendeeEmail")
	   private String email;
       @Column(name="AttendeePhone")
	   private String phone;
       @Column(name="AttendeeAddress")
	   private String address;

	   @ManyToOne
	   @JsonBackReference
	   @JoinColumn(name="event_id")
	   private Event event;

	  public Attendee() 
	  {
		super();
	  }	

	public Attendee(Long id, String name, String email, String phone, String address, Event event) 
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.event = event;
	}

   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	   
	   
	   
}



