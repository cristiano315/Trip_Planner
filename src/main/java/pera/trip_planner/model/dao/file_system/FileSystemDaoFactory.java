package pera.trip_planner.model.dao.file_system;

import pera.trip_planner.model.dao.*;
import pera.trip_planner.model.domain.Role;

public class FileSystemDaoFactory extends DaoFactory {

    @Override
    public CountryDao getCountryDao() {
        return null;
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
        return null;
    }

    @Override
    public TripDayDao getTripDayDao() {
        return null;
    }

    @Override
    public ActivityInstanceDao getActivityInstanceDao() {
        return null;
    }

    @Override
    public GeneralUserDao<?> getSpecificUserDao(Role role) {
        return null;
    }

    @Override
    public UserDao getUserDao() {
        return null;
    }

    @Override
    public CityCouncilUserDao getCityCouncilUserDao() {
        return null;
    }

    @Override
    public ActivityManagerUserDao getActivityManagerUserDao() {
        return null;
    }

}
