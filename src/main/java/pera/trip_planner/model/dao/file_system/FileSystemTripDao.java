package pera.trip_planner.model.dao.file_system;

import com.fasterxml.jackson.core.type.TypeReference;
import pera.trip_planner.model.dao.TripDao;
import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.entity_lists.TripList;

import java.util.HashMap;

public class FileSystemTripDao extends FileSystemDao<String, Trip> implements TripDao {
    private static FileSystemTripDao instance;

    protected FileSystemTripDao() {}

    public static FileSystemTripDao getInstance() {
        if (instance == null) {
            instance = new FileSystemTripDao();
            instance.initialize();
        }
        return instance;
    }

    @Override
    protected TypeReference<HashMap<String, Trip>> getTypeReference() {
        return new TypeReference<HashMap<String, Trip>>() {};
    }

    @Override
    protected String getFileName() {
        return "Trip";
    }

    @Override
    protected String getKey(Trip value) {
        return value.getName();
    }

    @Override
    public TripList tripList() {
        TripList list = new TripList();
        for(Trip trip : this.memory.values()){
            list.addEntity(trip);
        }
        return list;
    }
}
