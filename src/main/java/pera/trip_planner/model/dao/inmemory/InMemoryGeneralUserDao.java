package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.GeneralUserDao;
import pera.trip_planner.model.domain.GeneralUser;

public abstract class InMemoryGeneralUserDao<K extends GeneralUser<?,?>> extends InMemoryDao<String, K> implements GeneralUserDao<K> {

    @Override
    protected String getKey(K value) {
        return value.getUsername();
    }

}
