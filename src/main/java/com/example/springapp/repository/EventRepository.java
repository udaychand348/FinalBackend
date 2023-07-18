package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Event;



public interface EventRepository extends JpaRepository<Event, Long>
{

}
