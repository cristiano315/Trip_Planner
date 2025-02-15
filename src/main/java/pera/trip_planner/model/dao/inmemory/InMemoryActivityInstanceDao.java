package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.ActivityInstanceDao;
import pera.trip_planner.model.domain.ActivityInstance;

import java.time.LocalDateTime;

public class InMemoryActivityInstanceDao extends InMemoryDao<LocalDateTime, ActivityInstance> implements ActivityInstanceDao {
    private static InMemoryActivityInstanceDao instance;

    protected InMemoryActivityInstanceDao() {}

    public static InMemoryActivityInstanceDao getInstance() {
        if (instance == null) {
            instance = new InMemoryActivityInstanceDao();
        }
        return instance;
    }

    @Override
    protected LocalDateTime getKey(ActivityInstance value) {
        return value.getDateTime();
    }
}
