package pera.trip_planner.model.DAO;

import pera.trip_planner.model.domain.Announcement;

import java.time.LocalDate;

public interface AnnouncementDao extends DAO<String, Announcement> {

    @Override
    default Announcement create(String name) {
        return new Announcement(name);
    }
}
