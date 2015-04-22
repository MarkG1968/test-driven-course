package com.markg1968.test_driven;

public interface FlightBookingService {

	boolean hasAvailableFlights(int week, int year, String originAirport, String destinationAirport);

}
