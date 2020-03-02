package com.suyash.flightreservation.services;

import com.suyash.flightreservation.dto.ReservationRequest;
import com.suyash.flightreservation.entities.Reservation;

public interface ReservationService {
	public Reservation bookFlight(ReservationRequest request);
}
