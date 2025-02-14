package pera.trip_planner.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {    private static Connection connection;

    private ConnectionFactory() {}

    static{
        try (InputStream input = new FileInputStream("./src/main/resources/pera/trip_planner/DataBase/worldDB.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            String connection_url = properties.getProperty("CONNECTION_URL");
            String user = properties.getProperty("USER_USER");
            String pass = properties.getProperty("USER_PASS");

            connection = DriverManager.getConnection(connection_url, user, pass);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        return connection;
    }

//    public static void changeRole(Role role) throws SQLException{
//        connection.close();
//
//        try(InputStream input = new FileInputStream("./src/main/resources/db.properties")){
//            Properties properties = new Properties();
//            properties.load(input);
//
//            String connection_url = properties.getProperty("CONNECTION_URL");
//            String user = properties.getProperty(role.name() + "_USER");
//            String pass = properties.getProperty(role.name() + "_PASS");
//
//            connection = DriverManager.getConnection(connection_url, user, pass);
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
//    }
}

