package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.entity_lists.CountryList;

public interface CountryDao extends DAO<String, Country>{

    @Override
    default Country create(String name){
        return new Country(name);
    }

    CountryList countryList();
}
