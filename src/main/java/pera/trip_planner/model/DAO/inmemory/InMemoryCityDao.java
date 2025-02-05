package pera.trip_planner.model.DAO.inmemory;

import pera.trip_planner.model.DAO.CityDao;
import pera.trip_planner.model.domain.City;


public class InMemoryCityDao implements CityDao {
    private static InMemoryCityDao instance;

    private InMemoryCityDao() {}

    public static InMemoryCityDao getInstance() {
        if (instance == null) {
            instance = new InMemoryCityDao();
        }
        return instance;
    }

    @Override
    public City load(String name, String country) {
        return InMemoryCountryDao.getInstance().load(country).getCities().getCityByName(name);
    }

    @Override
    public void store(City city, String country) {
        InMemoryCountryDao.getInstance().load(country).addCity(city);
    }

    @Override
    public void delete(String city, String country) {
        InMemoryCountryDao.getInstance().load(country).removeCity(city);
    }

    @Override
    public boolean exists(String city, String country) {
        return InMemoryCountryDao.getInstance().load(country).getCities().contains(city);
    }

    protected String getKey(City city) {
        return city.getName();
    }
}
