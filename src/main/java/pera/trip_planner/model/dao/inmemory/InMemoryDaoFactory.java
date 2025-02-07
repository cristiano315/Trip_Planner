package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.*;

public class InMemoryDaoFactory extends DaoFactory {
    @Override
    public CountryDao getCountryDao() {
        return InMemoryCountryDao.getInstance();
    }

    @Override
    public CityDao getCityDao() {
        return InMemoryCityDao.getInstance();
    }

    @Override
    public ActivityDao getActivityDao() {
        return InMemoryActivityDao.getInstance();
    }

    @Override
    public CityAnnouncementDao getCityAnnouncementDao() {
        return InMemoryCityAnnouncementDao.getInstance();
    }

    @Override
    public TripDao getTripDao() {
        return InMemoryTripDao.getInstance();
    }
}
