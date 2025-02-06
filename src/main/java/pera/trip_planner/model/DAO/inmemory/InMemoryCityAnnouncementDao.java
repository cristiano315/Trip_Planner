package pera.trip_planner.model.DAO.inmemory;

import pera.trip_planner.model.DAO.CityAnnouncementDao;
import pera.trip_planner.model.domain.Activity;
import pera.trip_planner.model.domain.Announcement;
import pera.trip_planner.model.domain.CityAnnouncement;

public class InMemoryCityAnnouncementDao implements CityAnnouncementDao {
    private static InMemoryCityAnnouncementDao instance;

    private InMemoryCityAnnouncementDao() {}

    public static InMemoryCityAnnouncementDao getInstance() {
        if (instance == null) {
            instance = new InMemoryCityAnnouncementDao();
        }
        return instance;
    }

    @Override
    public CityAnnouncement load(String name, String city, String country) {
        return InMemoryCityDao.getInstance().load(city, country).getAnnouncements().getEntityByName(name);
    }

    @Override
    public void store(CityAnnouncement announcement, String city, String country) {
        InMemoryCityDao.getInstance().load(city, country).addAnnouncement(announcement);
    }

    @Override
    public void delete(String announcement, String city, String country) {
        InMemoryCityDao.getInstance().load(city, country).removeAnnouncement(announcement);
    }

    @Override
    public boolean exists(String announcement, String city, String country) {
        return InMemoryCityDao.getInstance().load(city, country).getActivities().contains(announcement);
    }
}
