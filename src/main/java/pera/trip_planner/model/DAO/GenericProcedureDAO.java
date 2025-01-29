package pera.trip_planner.model.DAO;

import pera.trip_planner.exception.DAOException;

import java.sql.SQLException;

public interface GenericProcedureDAO <P> {

    P execute(Object... params) throws DAOException, SQLException;
}

