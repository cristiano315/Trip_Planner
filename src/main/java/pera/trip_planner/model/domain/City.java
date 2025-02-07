package pera.trip_planner.model.domain;

import pera.trip_planner.exception.AlreadyClaimedException;
import pera.trip_planner.model.domain.entity_lists.ActivityList;
import pera.trip_planner.model.domain.entity_lists.CityAnnouncementList;

import java.io.Serializable;

public class City implements Serializable {
    private String name;
    private String description;
    private ActivityList activities = new ActivityList();
    private CityAnnouncementList announcements = new CityAnnouncementList();
    private boolean claimed = false;

    public City(String name) {
        this.name = name;
    }

    public void addActivity(Activity activity) {
        activities.addEntity(activity);
    }

    public void addAnnouncement(CityAnnouncement announcement) {
        announcements.addEntity(announcement);
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

    public ActivityList getActivities() {
        return activities;
    }

    public CityAnnouncementList getAnnouncements() {
        return announcements;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void removeActivity(String activity){
        activities.removeEntity(activity);
    }

    public void removeAnnouncement(String announcement){
        announcements.removeEntity(announcement);
    }

    public void claimCity() throws AlreadyClaimedException{
        if(!claimed){
            claimed = true;
        }
        else
            throw new AlreadyClaimedException();
    }
}
