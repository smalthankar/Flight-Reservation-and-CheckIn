package com.suyash.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suyash.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
