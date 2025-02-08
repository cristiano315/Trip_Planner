package pera.trip_planner.controller.bean;

import pera.trip_planner.model.domain.Country;

import java.time.LocalDate;

public class CreateNewTripBean {
    private final Country tripCountry;
    private final LocalDate tripStartDate;
    private final LocalDate tripEndDate;
    private final String tripName;
    private final long tripDuration;

    public CreateNewTripBean(Country country, LocalDate startDate, LocalDate endDate, String name, long duration) {
        this.tripCountry = country;
        this.tripStartDate = startDate;
        this.tripEndDate = endDate;
        this.tripName = name;
        this.tripDuration = duration;
    }

    public Country getTripCountry() {
        return tripCountry;
    }

    public LocalDate getTripStartDate() {
        return tripStartDate;
    }

    public LocalDate getTripEndDate() {
        return tripEndDate;
    }

    public String getTripName() {
        return tripName;
    }

    public long getTripDuration() {
        return tripDuration;
    }
}
