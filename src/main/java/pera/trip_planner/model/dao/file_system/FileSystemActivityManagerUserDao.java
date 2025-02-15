package pera.trip_planner.model.dao.file_system;

import com.fasterxml.jackson.core.type.TypeReference;
import pera.trip_planner.model.dao.ActivityManagerUserDao;
import pera.trip_planner.model.domain.ActivityManagerUser;

import java.util.HashMap;

public class FileSystemActivityManagerUserDao extends FileSystemGeneralUserDao<ActivityManagerUser> implements ActivityManagerUserDao {
    private static FileSystemActivityManagerUserDao instance;

    private FileSystemActivityManagerUserDao() {}

    public static FileSystemActivityManagerUserDao getInstance() {
        if (instance == null) {
            instance = new FileSystemActivityManagerUserDao();
            instance.initialize();
        }
        return instance;
    }

    @Override
    protected TypeReference<HashMap<String, ActivityManagerUser>> getTypeReference() {
        return new TypeReference<HashMap<String, ActivityManagerUser>>() {};
    }

    @Override
    protected String getFileName() {
        return "ActivityManagerUser";
    }

}
