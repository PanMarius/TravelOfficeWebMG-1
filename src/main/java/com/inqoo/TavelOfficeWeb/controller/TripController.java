package com.inqoo.TavelOfficeWeb.controller;

import com.inqoo.TavelOfficeWeb.model.Trip;
import com.inqoo.TavelOfficeWeb.model.exception.ErrorMsg;
import com.inqoo.TavelOfficeWeb.model.exception.NoTripByPriceFoundException;
import com.inqoo.TavelOfficeWeb.model.exception.NoTripByThisValue;
import com.inqoo.TavelOfficeWeb.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping(path = "/trips", consumes = "application/json")
    public ResponseEntity createCity(@RequestBody Trip trip) {
        System.out.println("Wycieczka do: " + trip);
        tripService.saveTrip(trip);
        return ResponseEntity.created(null).build();
    }

    @GetMapping(path = "/trips", produces = "application/json")
    public List<Trip> trips(@RequestParam(name = "tripFragment", required = false) String tripFragment) {
        System.out.println("Zapytanie zawierało parametr 'tripFragment' o wartości: " + tripFragment);
        return tripService.getAllCities(tripFragment);
    }

    @GetMapping(path = "/tripsByPrice", produces = "application/json")

    public List<Trip> getTripByValue(@RequestParam double rangeFrom, @RequestParam double rangeTo) {
        return tripService.getTripByValue(rangeFrom, rangeTo);
    }

    @ExceptionHandler(NoTripByPriceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMsg> handleNoTripByPriceFoundException(NoTripByPriceFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMsg(exception.getMessage(), HttpStatus.NOT_FOUND.value()));

    }

    @ExceptionHandler(NoTripByThisValue.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMsg> handleNoTripsValue(NoTripByThisValue exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMsg(exception.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @GetMapping(path = "/trips/{tripId}", produces = "application/json")
    public Trip tripsById(@PathVariable("tripId") Integer id) {
        Trip warszawa = new Trip();
        warszawa.setDestination("warszawa");
        warszawa.setEnd(LocalDate.of(2022, 12, 2));
        warszawa.setStart(LocalDate.of(2022, 11, 21));
        warszawa.setPriceEur(700);

        Trip krakow = new Trip();
        krakow.setDestination("kraków");
        krakow.setPriceEur(1500);
        krakow.setStart(LocalDate.of(2022, 12, 30));
        krakow.setEnd(LocalDate.of(2023, 01, 07));
        return 1 == id ? warszawa : krakow;
    }
}

