package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.ActivityAnnouncement;


public interface ActivityAnnouncementDao extends DAO<String, ActivityAnnouncement> {

    @Override
    default ActivityAnnouncement create(String name) {
        return new ActivityAnnouncement(name);
    }
}
