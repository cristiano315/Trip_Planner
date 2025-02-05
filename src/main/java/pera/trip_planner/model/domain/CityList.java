package pera.trip_planner.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CityList implements Serializable {
    List<City> cities = new ArrayList<>();

    public void addCity(City city) {
        cities.add(city);
    }

    public List<City> getCities() {
        return cities;
    }

    public void sort(){
        cities.sort(new Comparator<City>() {
            public int compare(City o1, City o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void removeCity(String city) {
        cities.remove(city);
    }

    public City getCityByName(String name) {
        return cities.get(cities.indexOf(name));
    }

    public boolean contains(String city) {
        return cities.contains(city);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (City city : cities) {
            sb.append(city.getName()).append("\n");
        }
        return sb.toString();
    }
}
