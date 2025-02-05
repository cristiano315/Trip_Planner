package pera.trip_planner.model.DAO.inmemory;

import pera.trip_planner.model.DAO.CountryDao;
import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.CountryList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;


public class InMemoryCountryDao extends InMemoryDao<String, Country> implements CountryDao {
    private static InMemoryCountryDao instance;

    private InMemoryCountryDao() {}

    public static InMemoryCountryDao getInstance() {
        if (instance == null) {
            instance = new InMemoryCountryDao();
            loadCountriesFromFile(instance);
        }
        return instance;
    }

    @Override
    protected String getKey(Country country) {
        return country.countryName();
    }

    private static void loadCountriesFromFile(InMemoryCountryDao instance) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("src/main/resources/pera/trip_planner/program_data/program_data.dat");
            ois = new ObjectInputStream(fis);
            instance.memory = (HashMap<String, Country>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CountryList countryList(){
        CountryList list = new CountryList();
        for(Country country : this.memory.values()){
            list.addCountry(country);
        }
        return list;
    }

    public Map<String, Country> countryMap(){
        return this.memory;
    }
}
