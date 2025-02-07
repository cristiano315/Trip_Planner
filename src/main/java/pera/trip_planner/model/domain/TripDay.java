package pera.trip_planner.model.domain;

import pera.trip_planner.model.domain.entity_lists.ActivityInstanceList;

import java.io.Serializable;
import java.time.LocalDate;

public class TripDay implements Serializable {
    private DayType dayType;
    private City city;
    private ActivityInstanceList activityInstanceList = new ActivityInstanceList();
    private LocalDate date;

    public TripDay(DayType dayType, City city, LocalDate date) {
        this.dayType = dayType;
        this.city = city;
        this.date = date;
    }

    public void addActivityInstance(ActivityInstance activityInstance) {
        activityInstanceList.addEntity(activityInstance);
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
