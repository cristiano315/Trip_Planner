package pera.trip_planner.controller.bean;

import pera.trip_planner.model.domain.Activity;

import java.time.LocalDateTime;

public class AddActivityInstanceToDayBean {
    private final String activity;
    private final LocalDateTime date;

    public AddActivityInstanceToDayBean(final String activity, final LocalDateTime date) {
        this.activity = activity;
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
