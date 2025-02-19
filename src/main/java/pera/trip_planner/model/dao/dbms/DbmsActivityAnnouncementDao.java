package pera.trip_planner.model.dao.dbms;

import pera.trip_planner.exception.DAOException;
import pera.trip_planner.model.dao.ActivityAnnouncementDao;
import pera.trip_planner.model.dao.ConnectionFactory;
import pera.trip_planner.model.domain.ActivityAnnouncement;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;

public class DbmsActivityAnnouncementDao implements ActivityAnnouncementDao {
    private static DbmsActivityAnnouncementDao instance;
    private HashMap<String, ActivityAnnouncement> memory = new HashMap<>();
    private Connection conn;
    private static final String ERROR_MESSAGE = "Error in dbms activity announcement dao";

    protected DbmsActivityAnnouncementDao() {}

    public static DbmsActivityAnnouncementDao getInstance() {
        if (instance == null) {
            instance = new DbmsActivityAnnouncementDao();
            instance.initialize();
        }
        return instance;
    }

    private void store(String key, ActivityAnnouncement value) {
        memory.put(key, value);
        writeToDbms(value);
    }

    private void writeToDbms(ActivityAnnouncement value) {
        String insertDataQuery = "INSERT INTO activity_announcement (name, description, issuing_date) VALUES (?,?,?)";
        try(PreparedStatement stmt = conn.prepareStatement(insertDataQuery)) {
            stmt.setString(1, value.getName());
            stmt.setString(2, value.getDescription());
            stmt.setDate(3, Date.valueOf(value.getIssuingDate()));
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new DAOException(ERROR_MESSAGE);
        }
    }

    public void removeFromDbms(ActivityAnnouncement value) {
        String removeDataQuery = "DELETE FROM activity_announcement WHERE name = ? AND issuing_date = ?";
        try(PreparedStatement stmt = conn.prepareStatement(removeDataQuery)) {
            stmt.setString(1, value.getName());
            stmt.setDate(2, Date.valueOf(value.getIssuingDate()));
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new DAOException(ERROR_MESSAGE);
        }
    }

    private void initialize(){
        conn = ConnectionFactory.getConnection();
        createTable();
        deserialize();
    }

    private void deserialize() {
        String selectDataQuery = "SELECT name, description, issuing_date FROM activity_announcement";
        try(Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(selectDataQuery);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                LocalDate date = resultSet.getDate("issuing_date").toLocalDate();
                ActivityAnnouncement announcement = create(name);
                announcement.addDescription(description);
                announcement.setIssuingDate(date);
                memory.put(name, announcement);
            }
        } catch (SQLException e) {
            throw new DAOException(ERROR_MESSAGE);
        }
    }

    private void createTable() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS activity_announcement (name TEXT PRIMARY KEY, description TEXT NOT NULL, issuing_date DATE NOT NULL)";
        try(Statement stmt = conn.createStatement()) {
            stmt.execute(createTableQuery);
        } catch (SQLException e) {
            throw new DAOException(ERROR_MESSAGE);
        }
    }

    @Override
    public ActivityAnnouncement load(String id) {
        return memory.get(id);
    }

    @Override
    public void store(ActivityAnnouncement entity) {
        String key = entity.getName();
        store(key, entity);
    }

    @Override
    public void delete(String id) {
        ActivityAnnouncement entity = memory.get(id);
        memory.remove(id);
        removeFromDbms(entity);
    }

    @Override
    public boolean exists(String id) {
        return memory.containsKey(id);
    }
}
