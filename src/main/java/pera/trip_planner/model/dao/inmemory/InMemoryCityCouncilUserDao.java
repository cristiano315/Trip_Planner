package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.CityCouncilUserDao;
import pera.trip_planner.model.domain.CityCouncilUser;

public class InMemoryCityCouncilUserDao extends InMemoryGeneralUserDao<CityCouncilUser> implements CityCouncilUserDao {
    private static InMemoryCityCouncilUserDao instance;

    protected InMemoryCityCouncilUserDao() {}

    public static InMemoryCityCouncilUserDao getInstance() {
        if (instance == null) {
            instance = new InMemoryCityCouncilUserDao();
        }
        return instance;
    }
}
