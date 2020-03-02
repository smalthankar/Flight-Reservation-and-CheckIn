package com.suyash.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suyash.flightreservation.dto.ReservationUpdateRequest;
import com.suyash.flightreservation.entities.Reservation;
import com.suyash.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		//LOGGER.info("Inside findReservation() for id: " + id);
		return reservationRepository.findById(id).get();

	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		//LOGGER.info("Inside updateReservation() for " + request);
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		//LOGGER.info("Saving Reservation");
		return reservationRepository.save(reservation);

	}
	
}
