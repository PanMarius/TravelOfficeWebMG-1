package com.inqoo.TavelOfficeWeb.model;

public class DomesticTrip extends Trip {
    private double ownArrivalDiscount;

    @Override
    public String toString() {
        return "DomesticTrip{" +
                "ownArrivalDiscount=" + ownArrivalDiscount +
                '}';
    }

    public double getPrice() {
        return super.getPrice() - ownArrivalDiscount;
    }

    public void setOwnArrivalDiscount(double ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }
}
