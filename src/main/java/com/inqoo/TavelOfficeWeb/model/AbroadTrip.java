package com.inqoo.TavelOfficeWeb.model;

public class AbroadTrip extends Trip {
    private double insurrance;

    public double getPrice() {
        return super.getPrice() + insurrance;
    }

    public void setInsurrance(double insurrance) {
        this.insurrance = insurrance;
    }

    @Override
    public String toString() {
        return "AbroadTrip{" +
                "insurrance=" + insurrance +
                '}';
    }
}
