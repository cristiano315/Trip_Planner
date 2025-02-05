package pera.trip_planner.model.domain;

import pera.trip_planner.exception.AlreadyClaimedException;

import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable {
    private String name;
    private String description;
    private ArrayList<Activity> activities = new ArrayList<>();
    private ArrayList<Announcement> announcements = new ArrayList<>();
    private boolean claimed = false;

    public City(String name) {
        this.name = name;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void addAnnouncement(Announcement announcement) {
        announcements.add(announcement);
    }

    public void addDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public ArrayList<Announcement> getAnnouncements() {
        return announcements;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void claimCity() throws AlreadyClaimedException{
        if(!claimed){
            claimed = true;
        }
        else
            throw new AlreadyClaimedException();
    }
}
