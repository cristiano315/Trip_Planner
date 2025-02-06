package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.ActivityAnnouncement;


public interface ActivityAnnouncementDao {
    ActivityAnnouncement load(String id, String city, String country);
    void store(ActivityAnnouncement entity, String activity, String city, String country);
    void delete(String id, String activity, String city, String country);
    boolean exists(String id, String activity, String city, String country);



    default ActivityAnnouncement create(String name) {
        return new ActivityAnnouncement(name);
    }
}
