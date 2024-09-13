package com.siemens.flightsearchservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.siemens.flightsearchservice.model.Flight;
import com.siemens.flightsearchservice.repo.FlightRepository;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDateTime departureDate) {
        return flightRepository.findByDepartureCityAndArrivalCityAndDepartureDate(departureCity, arrivalCity, departureDate);
    }

    public Flight findFlightById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight updatedFlight) {
        Flight flight = findFlightById(id);
        flight.setPrice(updatedFlight.getPrice());
        flight.setSeatsAvailable(updatedFlight.getSeatsAvailable());
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
