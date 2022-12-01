package com.inqoo.TavelOfficeWeb.repository;

import com.inqoo.TavelOfficeWeb.model.Trip;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TripRepo {
    private static final List<Trip> trips = new ArrayList<>(); // dane

    public static List<Trip> getAllTrips() {
        return trips;
    }

    public void saveTrip(Trip trip) {
        trips.add(trip);
    } // logikę biznesową

    public List<Trip> findTripsByPriceRange(double rangeFrom, double rangeTo) {
        return trips.stream()
                .filter(t -> t.getPrice() > rangeFrom)
                .filter(t -> t.getPrice() < rangeTo)
                .collect(Collectors.toList());

    }

    @PostConstruct
    public void createTrips() {
        Trip c1 = new Trip();
        c1.setDestination("oslo");
        c1.setEnd(LocalDate.of(2022, 12, 2));
        c1.setStart(LocalDate.of(2022, 11, 21));
        c1.setPriceEur(1400);

        Trip c2 = new Trip();
        c2.setDestination("Sosnowiec");
        c2.setEnd(LocalDate.of(2022, 12, 2));
        c2.setStart(LocalDate.of(2022, 11, 21));
        c2.setPriceEur(1500);

        Trip c3 = new Trip();
        c3.setDestination("Londyn");
        c3.setEnd(LocalDate.of(2022, 12, 2));
        c3.setStart(LocalDate.of(2022, 11, 21));
        c3.setPriceEur(1600);

        trips.add(c1);
        trips.add(c2);
        trips.add(c3);
    }
}



