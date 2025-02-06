package pera.trip_planner.model.domain;

import java.io.Serializable;

public class CityList extends EntityList<City> implements Serializable {
    @Override
    protected String getName(City city) {
        return city.getName();
    }
}
