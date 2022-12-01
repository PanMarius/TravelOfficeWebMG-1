package com.inqoo.TavelOfficeWeb.model;

import java.time.LocalDate;

/*
    Ta klasa ma:
    - przechowywać informacje o wycieczce (zakres i typy wg opisu)
    - udostępniać możliwość wyświetlania informacji o wycieczce
 */
public class Trip {
    private LocalDate start;
    private LocalDate end;
    private String destination;
    private double priceEur;

    public Trip() {
    }

    public Trip(LocalDate start, LocalDate end, String destination, double priceEur) {
        this.start = start;
        this.end = end;
        this.destination = destination;
        this.priceEur = priceEur;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "start=" + start +
                ", end=" + end +
                ", destination='" + destination + '\'' +
                ", priceEur=" + priceEur +
                '}';
    }

    public double getPrice() {
        return priceEur;
    }

    private boolean datesAreValid(LocalDate _start, LocalDate _end) {
        if (_end != null) {
            if (_start != null) {
                if (_start.isAfter(_end)) {
                    System.out.println("Data rozpoczęcia nie może być po dacie zakończenia");
                    return false;
                }
            }
        }
        return true;
    }

    void printInfo() {
        System.out.println("Trip to " + destination + " starts on: " + start + " ends on: " + end + ". Price is " + getPrice() + " EUR");
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Trip other = (Trip) o;
        return other.destination == destination;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate _start) {
        if (datesAreValid(_start, end)) {
            start = _start;
        }
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate _end) {
        if (datesAreValid(start, _end)) {
            end = _end;
        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPriceEur(double priceEur) {
        this.priceEur = priceEur;
    }
}
