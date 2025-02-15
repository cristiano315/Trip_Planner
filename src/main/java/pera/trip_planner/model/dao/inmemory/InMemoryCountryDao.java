package pera.trip_planner.model.dao.inmemory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pera.trip_planner.exception.JsonException;
import pera.trip_planner.model.dao.CountryDao;
import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.entity_lists.CountryList;

import java.io.File;
import java.io.IOException;
import java.util.Map;


public class InMemoryCountryDao extends InMemoryDao<String, Country> implements CountryDao {
    private static InMemoryCountryDao instance;

    protected InMemoryCountryDao() {}

    public static InMemoryCountryDao getInstance() {
        if (instance == null) {
            instance = new InMemoryCountryDao();
            loadCountriesFromFile(instance);
        }
        return instance;
    }

    @Override
    protected String getKey(Country country) {
        return country.getName();
    }

    private static void loadCountriesFromFile(InMemoryCountryDao instance) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("./src/main/resources/pera/trip_planner/Json/Country.json");
            TypeReference<Map<String, Country>> ref = new TypeReference<Map<String, Country>>(){};
            instance.memory = mapper.readValue(file, ref);
        } catch (IOException e) {
            throw new JsonException("Error reading countries");
        }
    }

    public CountryList countryList(){
        CountryList list = new CountryList();
        for(Country country : this.memory.values()){
            list.addEntity(country);
        }
        return list;
    }

    public Map<String, Country> getCountryMap(){
        return this.memory;
    }
}
