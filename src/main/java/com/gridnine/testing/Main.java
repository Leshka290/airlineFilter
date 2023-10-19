package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.service.OutputInfoService;
import com.gridnine.testing.service.impl.FlightFilterImpl;
import com.gridnine.testing.util.FlightBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        Scanner scanner = new Scanner(System.in);

        OutputInfoService.printFlights(flights);

        FlightFilter flightFilter = new FlightFilterImpl();

        while (true) {
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    OutputInfoService.printFlights(flightFilter
                            .departureBeforeCurrentTime(flights, LocalDateTime.now()));
                    break;
                case "2":
                    OutputInfoService.printFlights(flightFilter
                            .arrivalDateToDepartureDate(flights));
                    break;
                case "3":
                    OutputInfoService.printFlights(flightFilter
                            .downtimeExceedsTwoHours(flights));
                    break;
                case "0":
                    return;
            }
        }
    }
}
