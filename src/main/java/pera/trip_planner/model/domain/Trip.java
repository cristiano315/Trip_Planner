package pera.trip_planner.model.domain;

import pera.trip_planner.model.domain.entity_lists.TripDayList;

import java.time.LocalDate;

public class Trip {
    private Country country;
    private LocalDate startDate;
    private LocalDate endDate;
    private TripDayList tripDays = new TripDayList();
    private String name;
    private boolean registered = false;

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

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void addTripDay(TripDay tripDay) {
        tripDays.addEntity(tripDay);
    }

    public void registerToAccount(){
        registered = true;
    }

    public boolean isRegistered(){
        return registered;
    }
}
