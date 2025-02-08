package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.entity_lists.TripList;

public interface TripDao extends DAO<String, Trip>{
    @Override
    default Trip create(String name){
        return new Trip(name);
    }

    TripList tripList();
}
