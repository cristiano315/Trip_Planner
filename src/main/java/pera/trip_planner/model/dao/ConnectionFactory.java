package pera.trip_planner.model.dao;

import pera.trip_planner.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory() {}

    public static Connection getConnection() {
        if(connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/pera/trip_planner/DataBase/trip_planner.db");
            } catch (SQLException e) {
                throw new DAOException("Error getting connection");
            }
        }
        return connection;
    }

}

