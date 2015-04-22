package com.markg1968.test_driven;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class HolidayBookingTest {
	
	private static final String FIRST_VILLA_NAME = "VillaOne";

	private static final String DESTINATION_AIRPORT = "PFO";
	private static final String START_AIRPORT = "LHR";
	private static final int HOLIDAY_YEAR = 2015;
	private static final int HOLIDAY_WEEK = 26;

	private VillaBookingService villaBookingService;
	private FlightBookingService flightBookingService;

	@Before
	public void setup() {
		villaBookingService = mock(VillaBookingService.class);
		flightBookingService = mock(FlightBookingService.class);
	}

	@Test
	public void whenFlightsAndVillaAreAvailableThenThereAreHolidays() {
		
		when(villaBookingService.getAvailableVillas(HOLIDAY_WEEK, HOLIDAY_YEAR)).thenReturn(getAllVillas());
		when(flightBookingService.hasAvailableFlights(HOLIDAY_WEEK, HOLIDAY_YEAR, START_AIRPORT, DESTINATION_AIRPORT)).thenReturn(true);
		
		assertThat(new HoildayBookingService(villaBookingService, flightBookingService).hasHolidays(26,2015, START_AIRPORT, DESTINATION_AIRPORT).all(), containsInAnyOrder(FIRST_VILLA_NAME));
	}

	private Villas getAllVillas() {
		return Villas.named(FIRST_VILLA_NAME);
	}

	@Test
	public void whenNoFlightsButVillaAreAvailableThenThereAreNoHolidays() {

		when(villaBookingService.getAvailableVillas(HOLIDAY_WEEK, HOLIDAY_YEAR)).thenReturn(getAllVillas());
		when(flightBookingService.hasAvailableFlights(HOLIDAY_WEEK, HOLIDAY_YEAR, START_AIRPORT, DESTINATION_AIRPORT)).thenReturn(false);

		assertThat(new HoildayBookingService(villaBookingService, flightBookingService).hasHolidays(26, 2015, START_AIRPORT, DESTINATION_AIRPORT).isEmpty(), is(true));
	}
}
