package pera.trip_planner.model.domain;

import pera.trip_planner.model.domain.entity_lists.TripDayList;

import java.time.LocalDate;

public class Trip {
    private Country country;
    private LocalDate startDate;
    private LocalDate endDate;
    private TripDayList tripDays = new TripDayList();
    private String name;

    public Trip(Country country, LocalDate startDate, LocalDate endDate, String name) {
        this.name = name;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Trip(String name){
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public TripDayList getTripDays() {
        return tripDays;
    }

    public String getName() {
        return name;
    }
}
