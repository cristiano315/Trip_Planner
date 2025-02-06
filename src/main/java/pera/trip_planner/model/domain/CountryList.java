package pera.trip_planner.model.domain;

public class CountryList extends EntityList<Country> {
    @Override
    protected String getName(Country country){
        return country.countryName();
    }
}
