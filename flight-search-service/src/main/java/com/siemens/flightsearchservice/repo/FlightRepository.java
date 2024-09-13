package com.siemens.flightsearchservice.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siemens.flightsearchservice.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureCityAndArrivalCityAndDepartureDate(String departureCity, String arrivalCity, LocalDateTime departureDate);
}
