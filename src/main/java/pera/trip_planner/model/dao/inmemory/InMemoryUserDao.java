package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.UserDao;
import pera.trip_planner.model.domain.GeneralUser;
import pera.trip_planner.model.domain.User;

public class InMemoryUserDao extends InMemoryGeneralUserDao<User> implements UserDao {
    private static InMemoryUserDao instance;

    private InMemoryUserDao() {}

    public static InMemoryUserDao getInstance() {
        if (instance == null) {
            instance = new InMemoryUserDao();
        }
        return instance;
    }
}
