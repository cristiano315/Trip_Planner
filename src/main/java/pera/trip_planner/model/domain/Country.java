package pera.trip_planner.model.domain;

import pera.trip_planner.model.domain.entity_lists.CityList;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private CityList cities = new CityList();

    public Country(String name) {
        this.name = name;
    }

    public String countryName() {
        return name;
    }

    public void addCity(City city) {
        cities.addEntity(city);
    }

    public void removeCity(String city) {
        cities.removeEntity(city);
    }

    public CityList getCities() {
        return cities;
    }

    public void replaceList(CityList list){
        cities = list;
    }
}
