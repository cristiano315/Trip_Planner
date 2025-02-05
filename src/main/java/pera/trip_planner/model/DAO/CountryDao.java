package pera.trip_planner.model.DAO;

import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.CountryList;

public interface CountryDao extends DAO<String, Country>{

    @Override
    default Country create(String name){
        return new Country(name);
    }

    CountryList countryList();
}
