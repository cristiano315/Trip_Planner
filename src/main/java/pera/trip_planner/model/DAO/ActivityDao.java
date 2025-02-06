package pera.trip_planner.model.DAO;

import pera.trip_planner.model.domain.Activity;

public interface ActivityDao {

    Activity load(String id, String city, String country);
    void store(Activity entity, String city, String country);
    void delete(String id, String city, String country);
    boolean exists(String id, String city, String country);


    default Activity create(String name){
        return new Activity(name);
    }
}
