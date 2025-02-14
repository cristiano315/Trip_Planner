package pera.trip_planner.test;

import pera.trip_planner.model.dao.GetCitiesByCountryProcedureDao;
import pera.trip_planner.model.dao.GetCountriesProcedureDAO;
import pera.trip_planner.model.domain.Activity;
import pera.trip_planner.model.domain.City;
import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.entity_lists.CountryList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class PopolazioneController {
    public void populate(){
        CountryList countries;
        countries = new GetCountriesProcedureDAO().execute();
        Map<String, Country> map = new HashMap<>();
        //popolazione paesi
        for(Country country : countries.getList()){
            map.put(country.countryName(), country);
        }
        //popolazione liste città
        for(Country country : countries.getList()) {
            map.get(country.countryName()).replaceList(new GetCitiesByCountryProcedureDao().execute(country.countryName()));
        }
        Activity prova = new Activity("prova");
        Activity prova2 = new Activity("prova2");
        Activity prova3 = new Activity("prova3");
        City roma = map.get("Italy").getCities().getEntityByName("Roma");
        roma.addActivity(prova);
        roma.addActivity(prova2);
        roma.addActivity(prova3);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("src/main/resources/pera/trip_planner/program_data/program_data.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
