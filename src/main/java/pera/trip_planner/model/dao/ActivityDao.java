package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.Activity;

public interface ActivityDao extends DAO<String, Activity> {

    default Activity create(String name){
        return new Activity(name);
    }
}
