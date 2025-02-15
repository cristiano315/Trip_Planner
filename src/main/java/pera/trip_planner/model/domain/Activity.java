package pera.trip_planner.model.domain;

import pera.trip_planner.model.domain.entity_lists.ActivityAnnouncementList;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;

public class Activity implements Serializable {
    private String name;
    private String description;
    private String location;
    private ArrayList<DayInfo> dayInfos = new ArrayList<>();
    private ActivityAnnouncementList announcements = new ActivityAnnouncementList();

    public Activity(String name) {
        this.name = name;
    }

    public Activity() {}

    public void addDescription(String description) {
        this.description = description;
    }

    public void addLocation(String location) {
        this.location = location;
    }

    public String activityName() {
        return name;
    }

    public String activityDescription() {
        return description;
    }

    public String activityLocation() {
        return location;
    }

    public String getDescription(){
        return description;
    }

    public String getLocation(){
        return location;
    }

    public void addDayInfo(DayInfo dayInfo) {
        for(DayInfo d : dayInfos){
            if(d.getDay().equals(dayInfo.getDay())){
                dayInfos.remove(d);
                break;
            }
        }
        dayInfos.add(dayInfo);
    }

    public DayInfo getDayInfo(DayOfWeek day) {
        for(DayInfo d : dayInfos){
            if(d.getDay().equals(day)){
                return d;
            }
        }
        return null;
    }

    public String getName(){
        return name;
    }

    public void addAnnouncement(ActivityAnnouncement announcement) {
        announcements.addEntity(announcement);
    }

    public ActivityAnnouncementList getAnnouncements() {
        return announcements;
    }

    public ArrayList<DayInfo> getDayInfos() {
        return dayInfos;
    }
}
