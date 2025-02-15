package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.ActivityDao;
import pera.trip_planner.model.domain.Activity;

public class InMemoryActivityDao extends InMemoryDao<String, Activity> implements ActivityDao {
    private static InMemoryActivityDao instance;

    protected InMemoryActivityDao() {}

    public static InMemoryActivityDao getInstance() {
        if (instance == null) {
            instance = new InMemoryActivityDao();
        }
        return instance;
    }

    @Override
    protected String getKey(Activity value) {
        return value.activityName();
    }
}
