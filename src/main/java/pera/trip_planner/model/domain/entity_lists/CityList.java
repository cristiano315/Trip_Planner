package pera.trip_planner.model.domain.entity_lists;

import pera.trip_planner.model.domain.City;

import java.io.Serializable;

public class CityList extends EntityList<City> implements Serializable {
    @Override
    protected String getName(City city) {
        return city.getName();
    }
}
