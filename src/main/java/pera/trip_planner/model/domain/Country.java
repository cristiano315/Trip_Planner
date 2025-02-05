package pera.trip_planner.model.domain;

import java.io.Serializable;

public class Country implements Serializable {
    private String Name;
    private CityList Cities = new CityList();

    public Country(String Name) {
        this.Name = Name;
    }

    public String countryName() {
        return Name;
    }

    public void addCity(City city) {
        Cities.addCity(city);
    }

    public void removeCity(String city) {
        Cities.removeCity(city);
    }

    public CityList getCities() {
        return Cities;
    }

    public void replaceList(CityList list){
        Cities = list;
    }
}
