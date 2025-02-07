package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.City;

public interface CityDao extends DAO<String, City>{

    @Override
    default City create(String name){
        return new City(name);
    }

}
