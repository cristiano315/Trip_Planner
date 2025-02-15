package pera.trip_planner.model.dao.file_system;

import com.fasterxml.jackson.core.type.TypeReference;
import pera.trip_planner.model.dao.CountryDao;
import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.entity_lists.CountryList;

import java.util.HashMap;

public class FileSystemCountryDao extends FileSystemDao<String, Country> implements CountryDao {
    private static FileSystemCountryDao instance;

    private FileSystemCountryDao() {}

    public static FileSystemCountryDao getInstance() {
        if (instance == null) {
            instance = new FileSystemCountryDao();
            instance.initialize();
        }
        return instance;
    }

    @Override
    protected String getFileName() {
        return "Country";
    }

    @Override
    protected String getKey(Country value) {
        return value.getName();
    }

    @Override
    public CountryList countryList() {
        CountryList list = new CountryList();
        for(Country country : this.memory.values()){
            list.addEntity(country);
        }
        return list;
    }

    @Override
    protected TypeReference<HashMap<String, Country>> getTypeReference(){
        return new TypeReference<HashMap<String, Country>>() {};
    }
}
