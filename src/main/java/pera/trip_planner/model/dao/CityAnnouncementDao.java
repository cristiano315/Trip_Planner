package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.CityAnnouncement;


public interface CityAnnouncementDao extends DAO<String, CityAnnouncement> {

    @Override
    default CityAnnouncement create(String name) {
        return new CityAnnouncement(name);
    }
}
