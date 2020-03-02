package com.suyash.flightcheckin.integration;

import com.suyash.flightcheckin.integration.dto.Reservation;
import com.suyash.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);
}
