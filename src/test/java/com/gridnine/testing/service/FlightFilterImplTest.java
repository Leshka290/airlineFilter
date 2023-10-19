package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.impl.FlightFilterImpl;
import com.gridnine.testing.util.FlightBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;


public class FlightFilterImplTest {
    private final FlightFilter flightFilter = new FlightFilterImpl();
    private final FlightBuilder flightBuilder = new FlightBuilder();
    private final List<Flight> flights = flightBuilder.createFlights();

    @Test
    public void departureBeforeCurrentTimeTest() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(1, flightFilter
                .departureBeforeCurrentTime(flights, LocalDateTime.now()).size());
    }

    @Test
    public void arrivalDateToDepartureDateTest() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(1, flightFilter
                .arrivalDateToDepartureDate(flights).size());
    }

    @Test
    public void downtimeExceedsTwoHoursTest() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(2, flightFilter
                .downtimeExceedsTwoHours(flights).size());
    }
}
