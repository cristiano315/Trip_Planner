package pera.trip_planner.model.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CountryList {
    List<Country> countries = new ArrayList<>();

    public void addCountry(Country country) {
        countries.add(country);
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void sort(){
        countries.sort(new Comparator<Country>() {
            public int compare(Country o1, Country o2) {
                return o1.countryName().compareTo(o2.countryName());
            }
        });
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
