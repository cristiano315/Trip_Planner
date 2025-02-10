package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.*;
import pera.trip_planner.model.domain.Role;

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
    public GeneralUserDao getSpecificUserDao(Role role) {
        GeneralUserDao dao = InMemoryUserDao.getInstance();
        if(role == Role.USER){
            dao = InMemoryUserDao.getInstance();
        } else if (role == Role.CITY_COUNCIL){
            dao = InMemoryCityCouncilUserDao.getInstance();
        } else if (role == Role.ACTIVITY_MANAGER){
            dao = InMemoryActivityManagerUserDao.getInstance();
        }
        return dao;
    }
}
