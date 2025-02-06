package pera.trip_planner.model.DAO;

import pera.trip_planner.model.domain.Activity;
import pera.trip_planner.model.domain.Announcement;
import pera.trip_planner.model.domain.CityAnnouncement;


public interface CityAnnouncementDao {
    CityAnnouncement load(String id, String city, String country);
    void store(CityAnnouncement entity, String city, String country);
    void delete(String id, String city, String country);
    boolean exists(String id, String city, String country);



    default CityAnnouncement create(String name) {
        return new CityAnnouncement(name);
    }
}
