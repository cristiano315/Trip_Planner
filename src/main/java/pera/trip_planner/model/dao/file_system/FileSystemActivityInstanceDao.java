package pera.trip_planner.model.dao.file_system;

import com.fasterxml.jackson.core.type.TypeReference;
import pera.trip_planner.model.dao.ActivityInstanceDao;
import pera.trip_planner.model.domain.ActivityInstance;

import java.time.LocalDateTime;
import java.util.HashMap;

public class FileSystemActivityInstanceDao extends FileSystemDao<LocalDateTime, ActivityInstance> implements ActivityInstanceDao {
    private static FileSystemActivityInstanceDao instance;

    protected FileSystemActivityInstanceDao() {}

    public static FileSystemActivityInstanceDao getInstance() {
        if (instance == null) {
            instance = new FileSystemActivityInstanceDao();
        }
        return instance;
    }

    @Override
    protected TypeReference<HashMap<LocalDateTime, ActivityInstance>> getTypeReference() {
        return new TypeReference<HashMap<LocalDateTime, ActivityInstance>>() {};
    }

    @Override
    protected String getFileName() {
        return "ActivityInstance";
    }

    @Override
    protected LocalDateTime getKey(ActivityInstance value) {
        return value.getDateTime();
    }
}
