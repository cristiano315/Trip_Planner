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

    @Override
    public TripDayDao getTripDayDao() {
        return InMemoryTripDayDao.getInstance();
    }

    @Override
    public ActivityInstanceDao getActivityInstanceDao() {
        return InMemoryActivityInstanceDao.getInstance();
    }

    @Override
    public UserDao getUserDao() {
        return InMemoryUserDao.getInstance();
    }

    @Override
    public CityCouncilUserDao getCityCouncilUserDao() {
        return InMemoryCityCouncilUserDao.getInstance();
    }

    @Override
    public ActivityManagerUserDao getActivityManagerUserDao() {
        return InMemoryActivityManagerUserDao.getInstance();
    }


}
