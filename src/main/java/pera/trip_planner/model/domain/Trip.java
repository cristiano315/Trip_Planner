package pera.trip_planner.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import pera.trip_planner.model.dao.file_system.serializers.CountryDeserializer;
import pera.trip_planner.model.dao.file_system.serializers.CountrySerializer;
import pera.trip_planner.model.domain.entity_lists.TripDayList;

import java.time.LocalDate;

public class Trip {
    @JsonSerialize(using = CountrySerializer.class)
    @JsonDeserialize(using = CountryDeserializer.class)
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

    public Trip() {}

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

    public void setName(String name){
        this.name = name;
    }

    public void resetDaysList(){
        tripDays = new TripDayList();
    }
}
