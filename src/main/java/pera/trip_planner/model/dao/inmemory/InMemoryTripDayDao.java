package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.TripDayDao;
import pera.trip_planner.model.domain.TripDay;

import java.time.LocalDate;

public class InMemoryTripDayDao extends InMemoryDao<LocalDate, TripDay> implements TripDayDao {
    private static InMemoryTripDayDao instance;

    private InMemoryTripDayDao() {}

    public static InMemoryTripDayDao getInstance() {
        if (instance == null) {
            instance = new InMemoryTripDayDao();
        }
        return instance;
    }

    @Override
    protected LocalDate getKey(TripDay value) {
        return value.getDate();
    }
}
