package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.ActivityAnnouncementDao;
import pera.trip_planner.model.domain.ActivityAnnouncement;

public class InMemoryActivityAnnouncementDao extends InMemoryDao<String, ActivityAnnouncement> implements ActivityAnnouncementDao {
    private static InMemoryActivityAnnouncementDao instance;

    private InMemoryActivityAnnouncementDao() {}

    public static InMemoryActivityAnnouncementDao getInstance() {
        if (instance == null) {
            instance = new InMemoryActivityAnnouncementDao();
        }
        return instance;
    }

    @Override
    protected String getKey(ActivityAnnouncement value) {
        return value.getName();
    }
}
