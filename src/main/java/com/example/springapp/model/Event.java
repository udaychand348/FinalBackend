package com.example.springapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;





@Entity
@Table(name = "events")
public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
	@JsonFormat(pattern ="yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private Date startDate;

    @Column(name = "endDate")
	@JsonFormat(pattern ="yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private Date endDate;

    @Column(name = "location")
    private String location;

    

    @Column(name = "totalTicket")
    private Long totalTicket;

    
    
    
    @OneToMany(mappedBy="event", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Attendee> attendees ;
    
    @OneToMany(mappedBy="event", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ticket> tickets;

    
	public Event() 
	{
		super();
	}
   


	public Event(Long id, String name, String description, Date startDate, Date endDate, String location,Long totalTicket)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.totalTicket = totalTicket;
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



	public String getDescription()
	{
		return description;
	}


	public void setDescription(String description) 
	{
		this.description = description;
	}


	public Date getStartDate() 
	{
		return startDate;
	}


	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}


	public Date getEndDate()
	{
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Long getTotalTicket() {
		return totalTicket;
	}


	public void setTotalTicket(Long totalTicket) {
		this.totalTicket = totalTicket;
	}


	public List<Attendee> getAttendees() {
		return attendees;
	}


	public void setAttendees(List<Attendee> attendees) 
	{
		this.attendees = attendees;
	}


	public List<Ticket> getTickets()
	{
		return tickets;
	}


	public void setTickets(List<Ticket> tickets)
	{
		this.tickets = tickets;
	}
}
