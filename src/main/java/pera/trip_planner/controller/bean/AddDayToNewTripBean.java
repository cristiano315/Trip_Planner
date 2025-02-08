package pera.trip_planner.controller.bean;

import pera.trip_planner.model.domain.City;
import pera.trip_planner.model.domain.entity_lists.ActivityInstanceList;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class AddDayToNewTripBean {
    private final DayOfWeek dayType;
    private final City city;
    private final LocalDate date;

    public AddDayToNewTripBean(DayOfWeek dayType, City city, LocalDate date) {
        this.dayType = dayType;
        this.city = city;
        this.date = date;
    }

    public DayOfWeek getDayType() {
        return dayType;
    }

    public City getCity() {
        return city;
    }

    public LocalDate getDate() {
        return date;
    }

}
