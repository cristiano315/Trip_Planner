package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.TripDao;
import pera.trip_planner.model.domain.Trip;

public class InMemoryTripDao extends InMemoryDao<String, Trip> implements TripDao {
    private static InMemoryTripDao instance;

    private InMemoryTripDao() {}

    public static InMemoryTripDao getInstance() {
        if (instance == null) {
            instance = new InMemoryTripDao();
        }
        return instance;
    }

    @Override
    protected String getKey(Trip value) {
        return value.getName();
    }
}
