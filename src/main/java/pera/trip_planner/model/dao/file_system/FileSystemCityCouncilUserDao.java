package pera.trip_planner.model.dao.file_system;

import com.fasterxml.jackson.core.type.TypeReference;
import pera.trip_planner.model.dao.CityCouncilUserDao;
import pera.trip_planner.model.domain.CityCouncilUser;

import java.util.HashMap;

public class FileSystemCityCouncilUserDao extends FileSystemGeneralUserDao<CityCouncilUser> implements CityCouncilUserDao {
    private static FileSystemCityCouncilUserDao instance;

    protected FileSystemCityCouncilUserDao() {}

    public static FileSystemCityCouncilUserDao getInstance() {
        if (instance == null) {
            instance = new FileSystemCityCouncilUserDao();
            instance.initialize();
        }
        return instance;
    }

    @Override
    protected TypeReference<HashMap<String, CityCouncilUser>> getTypeReference() {
        return new TypeReference<HashMap<String, CityCouncilUser>>() {};
    }

    @Override
    protected String getFileName() {
        return "CityCouncilUser";
    }

}
