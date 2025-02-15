package pera.trip_planner.model.dao.file_system;

import com.fasterxml.jackson.core.type.TypeReference;
import pera.trip_planner.model.dao.ActivityAnnouncementDao;
import pera.trip_planner.model.domain.ActivityAnnouncement;

import java.util.HashMap;

public class FileSystemActivityAnnouncementDao extends FileSystemDao<String, ActivityAnnouncement> implements ActivityAnnouncementDao {
    private static FileSystemActivityAnnouncementDao instance;

    protected FileSystemActivityAnnouncementDao() {}

    public static FileSystemActivityAnnouncementDao getInstance() {
        if (instance == null) {
            instance = new FileSystemActivityAnnouncementDao();
        }
        return instance;
    }

    @Override
    protected TypeReference<HashMap<String, ActivityAnnouncement>> getTypeReference() {
        return new TypeReference<HashMap<String, ActivityAnnouncement>>() {};
    }

    @Override
    protected String getFileName() {
        return "ActivityAnnouncement";
    }

    @Override
    protected String getKey(ActivityAnnouncement value) {
        return value.getName();
    }
}
