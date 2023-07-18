package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Attendee;


public interface AttendeeRepository extends JpaRepository<Attendee,Long>
{
  List<Attendee> findAttendeeByEventId(Long id);
}

