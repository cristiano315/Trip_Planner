package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.City;

public interface CityDao extends AggregationDao<String, City, String> {

    default City create(String name){
        return new City(name);
    }

}
