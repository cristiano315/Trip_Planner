package pera.trip_planner.model.domain.entity_lists;

import pera.trip_planner.model.domain.Country;

public class CountryList extends EntityList<Country> {
    @Override
    protected String getName(Country country){
        return country.getName();
    }
}
