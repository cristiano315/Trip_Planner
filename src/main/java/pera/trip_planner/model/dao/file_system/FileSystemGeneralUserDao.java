package pera.trip_planner.model.dao.file_system;

import pera.trip_planner.model.dao.GeneralUserDao;
import pera.trip_planner.model.domain.GeneralUser;

public abstract class FileSystemGeneralUserDao<K extends GeneralUser<?,?>> extends FileSystemDao<String, K> implements GeneralUserDao<K> {
    @Override
    protected String getKey(K value) {
        return value.getUsername();
    }
}
