package pera.trip_planner.model.domain;

import pera.trip_planner.model.domain.entity_lists.ActivityAnnouncementList;

import java.util.ArrayList;

public class Activity {
    private String name;
    private String description;
    private String location;
    private ArrayList<DayInfo> dayInfos = new ArrayList<>();
    private ActivityAnnouncementList announcements = new ActivityAnnouncementList();

    public Activity(String name) {
        this.name = name;
    }

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

    public void addDayInfo(DayInfo dayInfo) {
        for(DayInfo d : dayInfos){
            if(d.getDay().equals(dayInfo.getDay())){
                dayInfos.remove(d);
                break;
            }
        }
        dayInfos.add(dayInfo);
    }

    public DayInfo getDayInfo(DayType day) {
        if(dayInfos.contains(day)){
            return dayInfos.get(dayInfos.indexOf(day));
        }
        else
            return null;
    }

    public void addAnnouncement(ActivityAnnouncement announcement) {
        announcements.addEntity(announcement);
    }

    public ActivityAnnouncementList getAnnouncements() {
        return announcements;
    }

}
