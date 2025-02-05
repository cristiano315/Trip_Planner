package pera.trip_planner.model.DAO;

import pera.trip_planner.model.domain.Activity;

public interface ActivityDao extends DAO<String, Activity>{

    @Override
    default Activity create(String name){
        return new Activity(name);
    }
}
