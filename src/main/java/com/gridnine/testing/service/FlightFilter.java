package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightFilter {

    List<Flight> departureBeforeCurrentTime(List<Flight> flights, LocalDateTime currentTime);

    List<Flight> arrivalDateToDepartureDate(List<Flight> flights);

    List<Flight> downtimeExceedsTwoHours(List<Flight> flights);
}
