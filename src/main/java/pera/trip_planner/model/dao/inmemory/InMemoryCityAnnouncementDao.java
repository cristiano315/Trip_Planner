package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.CityAnnouncementDao;
import pera.trip_planner.model.domain.CityAnnouncement;

public class InMemoryCityAnnouncementDao extends InMemoryDao<String, CityAnnouncement> implements CityAnnouncementDao {
    private static InMemoryCityAnnouncementDao instance;

    private InMemoryCityAnnouncementDao() {}

    public static InMemoryCityAnnouncementDao getInstance() {
        if (instance == null) {
            instance = new InMemoryCityAnnouncementDao();
        }
        return instance;
    }

    @Override
    protected String getKey(CityAnnouncement value) {
        return value.getName();
    }
}
