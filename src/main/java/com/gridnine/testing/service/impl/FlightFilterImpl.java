package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightFilter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterImpl implements FlightFilter {

    @Override
    public List<Flight> departureBeforeCurrentTime(List<Flight> flights, LocalDateTime currentTime) {
        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();

            for (Segment segment : segments) {
                if (segment.getDepartureDate().isBefore(currentTime)) {
                    result.add(flight);
                }
            }
        }
        return distinctFlights(result);
    }

    @Override
    public List<Flight> arrivalDateToDepartureDate(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();

            for (Segment segment : segments) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    result.add(flight);
                }
            }
        }
        return distinctFlights(result);
    }

    @Override
    public List<Flight> downtimeExceedsTwoHours(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        int specifiedDownTime = 2;

        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();

            int downtime = 0;
            if (segments.size() > 1) {
                for (int i = 0; i < segments.size() - 1; i++) {
                    downtime += Math.abs(Duration.between(segments.get(i).getArrivalDate(),
                            segments.get(i + 1).getDepartureDate()).toHours());
                }
                if (downtime > specifiedDownTime) {
                    result.add(flight);
                }
            }
        }
        return distinctFlights(result);
    }

    private List<Flight> distinctFlights(List<Flight> flights) {
        return flights.stream().distinct().collect(Collectors.toList());
    }
}
