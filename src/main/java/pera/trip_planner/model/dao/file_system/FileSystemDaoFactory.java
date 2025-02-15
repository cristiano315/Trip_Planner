package pera.trip_planner.model.dao.file_system;

import pera.trip_planner.model.dao.*;
import pera.trip_planner.model.domain.Role;

public class FileSystemDaoFactory extends DaoFactory {

    @Override
    public CountryDao getCountryDao() {
        return FileSystemCountryDao.getInstance();
    }

    @Override
    public CityDao getCityDao() {
        return null;
    }

    @Override
    public ActivityDao getActivityDao() {
        return null;
    }

    @Override
    public CityAnnouncementDao getCityAnnouncementDao() {
        return null;
    }

    @Override
    public TripDao getTripDao() {
        return FileSystemTripDao.getInstance();
    }

    @Override
    public TripDayDao getTripDayDao() {
        return FileSystemTripDayDao.getInstance();
    }

    @Override
    public ActivityInstanceDao getActivityInstanceDao() {
        return FileSystemActivityInstanceDao.getInstance();
    }

    @Override
    public UserDao getUserDao() {
        return FileSystemUserDao.getInstance();
    }

    @Override
    public CityCouncilUserDao getCityCouncilUserDao() {
        return FileSystemCityCouncilUserDao.getInstance();
    }

    @Override
    public ActivityManagerUserDao getActivityManagerUserDao() {
        return FileSystemActivityManagerUserDao.getInstance();
    }

}
