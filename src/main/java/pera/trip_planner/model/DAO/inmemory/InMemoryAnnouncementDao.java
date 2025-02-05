package pera.trip_planner.model.DAO.inmemory;

import pera.trip_planner.model.DAO.AnnouncementDao;
import pera.trip_planner.model.domain.Activity;
import pera.trip_planner.model.domain.Announcement;

public class InMemoryAnnouncementDao extends InMemoryDao<String, Announcement> implements AnnouncementDao {
    private static InMemoryAnnouncementDao instance;

    private InMemoryAnnouncementDao() {}

    public static InMemoryAnnouncementDao getInstance() {
        if (instance == null) {
            instance = new InMemoryAnnouncementDao();
        }
        return instance;
    }

    @Override
    protected String getKey(Announcement announcement) {
        return announcement.getName();
    }
}
