package pera.trip_planner.model.dao.file_system;

import com.fasterxml.jackson.core.type.TypeReference;
import pera.trip_planner.model.dao.UserDao;
import pera.trip_planner.model.domain.User;

import java.util.HashMap;

public class FileSystemUserDao extends FileSystemGeneralUserDao<User> implements UserDao {
    private static FileSystemUserDao instance;

    private FileSystemUserDao() {}

    public static FileSystemUserDao getInstance() {
        if (instance == null) {
            instance = new FileSystemUserDao();
            instance.initialize();
        }
        return instance;
    }

    @Override
    protected TypeReference<HashMap<String, User>> getTypeReference() {
        return new TypeReference<HashMap<String, User>>() {};
    }

    @Override
    protected String getFileName() {
        return "User";
    }

}
