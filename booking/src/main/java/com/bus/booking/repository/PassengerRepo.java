package com.bus.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.booking.model.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer> {

}
