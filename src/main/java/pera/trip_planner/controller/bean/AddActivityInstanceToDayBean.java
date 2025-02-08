package pera.trip_planner.controller.bean;

import pera.trip_planner.model.domain.Activity;

import java.time.LocalDateTime;

public class AddActivityInstanceToDayBean {
    private final Activity activity;
    private final LocalDateTime date;

    public AddActivityInstanceToDayBean(final Activity activity, final LocalDateTime date) {
        this.activity = activity;
        this.date = date;
    }

    public Activity getActivity() {
        return activity;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
