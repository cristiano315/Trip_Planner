package pera.TripPlanner.model.DAO;

import pera.TripPlanner.exception.DAOException;

import java.sql.SQLException;

public interface GenericProcedureDAO <P> {

    P execute(Object... params) throws DAOException, SQLException;
}

