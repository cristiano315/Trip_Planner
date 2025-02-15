package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.TripDao;
import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.entity_lists.TripList;

public class InMemoryTripDao extends InMemoryDao<String, Trip> implements TripDao {
    private static InMemoryTripDao instance;

    protected InMemoryTripDao() {}

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

    @Override
    public TripList tripList() {
        TripList list = new TripList();
        for(Trip trip : this.memory.values()){
            list.addEntity(trip);
        }
        return list;
    }
}
