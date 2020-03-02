package com.suyash.flightreservation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyash.flightreservation.dto.ReservationRequest;
import com.suyash.flightreservation.entities.Flight;
import com.suyash.flightreservation.entities.Passenger;
import com.suyash.flightreservation.entities.Reservation;
import com.suyash.flightreservation.repos.FlightRepository;
import com.suyash.flightreservation.repos.PassengerRepository;
import com.suyash.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	ReservationRepository reservationRepository;

	//@Autowired
	//PDFGenerator pdfGenerator;

	//@Autowired
	//EmailUtil emailUtil;

	//private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {

		//LOGGER.info("Inside bookFlight()");
		// Make Payment

		Long flightId = request.getFlightId();
		//LOGGER.info("Fetching  flight for flight id:" + flightId);
		Optional<Flight> flight = flightRepository.findById(flightId);

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		//LOGGER.info("Saving the passenger:" + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight.get());
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		//LOGGER.info("Saving the reservation:" + reservation);
		Reservation savedReservation = reservationRepository.save(reservation);

		//String filePath = ITINERARY_DIR + savedReservation.getId()/+ ".pdf";
		//LOGGER.info("Generating  the itinerary");
		//pdfGenerator.generateItinerary(savedReservation, filePath);
		//LOGGER.info("Emailing the Itinerary");
		//emailUtil.sendItinerary(passenger.getEmail(), filePath);

		return savedReservation;
	}
}
