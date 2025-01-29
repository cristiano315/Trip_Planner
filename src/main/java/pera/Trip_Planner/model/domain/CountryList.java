package pera.Trip_Planner.model.domain;

import java.util.ArrayList;
import java.util.List;

public class CountryList {
    List<Country> countries = new ArrayList<Country>();

    public void addCountry(Country country) {
        countries.add(country);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Country country : countries) {
            sb.append(country.countryName()).append("\n");
        }
        return sb.toString();
    }
}
