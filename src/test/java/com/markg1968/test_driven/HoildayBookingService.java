package com.markg1968.test_driven;

public class HoildayBookingService {

	VillaBookingService villaBookingService;
	FlightBookingService flightBookingService;

	public HoildayBookingService(VillaBookingService villaBookingService, FlightBookingService flightBookingService) {
		this.flightBookingService = flightBookingService;
		this.villaBookingService = villaBookingService;
	}

	public Villas hasHolidays(int week, int year, String startAirport, String destinationAirport) {
		Villas availableVillas = villaBookingService.getAvailableVillas(week, year);

		if (flightBookingService.hasAvailableFlights(week, year, startAirport, destinationAirport)) {
			return availableVillas;
		} else {
			return Villas.none();
		}
	}

}
