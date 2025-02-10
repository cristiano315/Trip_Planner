package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.ActivityManagerUserDao;
import pera.trip_planner.model.domain.ActivityManagerUser;

public class InMemoryActivityManagerUserDao extends InMemoryGeneralUserDao<ActivityManagerUser> implements ActivityManagerUserDao {
    private static InMemoryActivityManagerUserDao instance;

    public static InMemoryActivityManagerUserDao getInstance() {
        if (instance == null) {
            instance = new InMemoryActivityManagerUserDao();
        }
        return instance;
    }
}
