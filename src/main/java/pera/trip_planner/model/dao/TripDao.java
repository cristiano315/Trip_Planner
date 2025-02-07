package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.Trip;

public interface TripDao extends DAO<String, Trip>{
    @Override
    default Trip create(String name){
        return new Trip(name);
    }
}
