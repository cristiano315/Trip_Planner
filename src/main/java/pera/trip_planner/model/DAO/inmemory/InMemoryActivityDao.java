package pera.trip_planner.model.DAO.inmemory;

import pera.trip_planner.model.DAO.ActivityDao;
import pera.trip_planner.model.domain.Activity;

public class InMemoryActivityDao extends InMemoryDao<String, Activity> implements ActivityDao {
    private static InMemoryActivityDao instance;

    private InMemoryActivityDao() {}

    public static InMemoryActivityDao getInstance() {
        if (instance == null) {
            instance = new InMemoryActivityDao();
        }
        return instance;
    }

    @Override
    protected String getKey(Activity activity) {
        return activity.activityName();
    }
}
