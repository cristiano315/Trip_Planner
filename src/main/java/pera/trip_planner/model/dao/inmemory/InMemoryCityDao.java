package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.CityDao;
import pera.trip_planner.model.domain.City;


public class InMemoryCityDao extends InMemoryDao<String, City> implements CityDao {
    private static InMemoryCityDao instance;

    protected InMemoryCityDao() {}

    public static InMemoryCityDao getInstance() {
        if (instance == null) {
            instance = new InMemoryCityDao();
        }
        return instance;
    }

    protected String getKey(City city) {
        return city.getName();
    }
}
