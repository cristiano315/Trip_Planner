package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.ActivityManagerUser;
import pera.trip_planner.model.domain.Role;

import java.lang.reflect.InvocationTargetException;

public abstract class DaoFactory {
    private static DaoFactory instance = null;
    private static PersistenceProvider persistenceProvider = null;

    public static void setPersistenceProvider(PersistenceProvider provider) {
        DaoFactory.persistenceProvider = provider;
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            try{
                instance = persistenceProvider.getDaoFactoryClass().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
                     InvocationTargetException | NoSuchMethodException | SecurityException e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    public abstract CountryDao getCountryDao();
    public abstract CityDao getCityDao();
    public abstract ActivityDao getActivityDao();
    public abstract CityAnnouncementDao getCityAnnouncementDao();
    public abstract TripDao getTripDao();
    public abstract TripDayDao getTripDayDao();
    public abstract ActivityInstanceDao getActivityInstanceDao();
    public abstract UserDao getUserDao();
    public abstract CityCouncilUserDao getCityCouncilUserDao();
    public abstract ActivityManagerUserDao getActivityManagerUserDao();
}
