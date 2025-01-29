package pera.Trip_Planner.model.DAO;

import pera.Trip_Planner.exception.DAOException;

import java.sql.SQLException;

public interface GenericProcedureDAO <P> {

    P execute(Object... params) throws DAOException, SQLException;
}

