package pera.trip_planner.controller.bean;

import pera.trip_planner.model.domain.City;
import pera.trip_planner.model.domain.DayType;
import pera.trip_planner.model.domain.entity_lists.ActivityInstanceList;

import java.time.LocalDate;

public class AddDaysToNewTripBean {
    private final DayType dayType;
    private final City city;
    private final ActivityInstanceList activityInstanceList;
    private final LocalDate date;

    public AddDaysToNewTripBean(DayType dayType, City city, LocalDate date, ActivityInstanceList activityInstanceList) {
        this.dayType = dayType;
        this.city = city;
        this.date = date;
        this.activityInstanceList = activityInstanceList;
    }

    public DayType getDayType() {
        return dayType;
    }

    public City getCity() {
        return city;
    }

    public LocalDate getDate() {
        return date;
    }

    public ActivityInstanceList getActivityInstanceList() {
        return activityInstanceList;
    }
}
