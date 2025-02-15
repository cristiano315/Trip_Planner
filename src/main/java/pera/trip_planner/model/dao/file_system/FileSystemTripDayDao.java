package pera.trip_planner.model.dao.file_system;

import com.fasterxml.jackson.core.type.TypeReference;
import pera.trip_planner.model.dao.TripDayDao;
import pera.trip_planner.model.domain.TripDay;

import java.time.LocalDate;
import java.util.HashMap;

public class FileSystemTripDayDao extends FileSystemDao<LocalDate, TripDay> implements TripDayDao {
    private static FileSystemTripDayDao instance;

    private FileSystemTripDayDao() {}

    public static FileSystemTripDayDao getInstance() {
        if (instance == null) {
            instance = new FileSystemTripDayDao();
        }
        return instance;
    }

    @Override
    protected TypeReference<HashMap<LocalDate, TripDay>> getTypeReference() {
        return new TypeReference<HashMap<LocalDate, TripDay>>() {};
    }

    @Override
    protected String getFileName() {
        return "TripDay";
    }

    @Override
    protected LocalDate getKey(TripDay value) {
        return value.getDate();
    }
}
