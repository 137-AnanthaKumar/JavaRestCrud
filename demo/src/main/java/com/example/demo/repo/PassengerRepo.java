package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Passenger;
@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer> {

}
