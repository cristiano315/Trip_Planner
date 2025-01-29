package pera.Trip_Planner.model.DAO;

import pera.Trip_Planner.exception.DAOException;
import pera.Trip_Planner.model.domain.Country;
import pera.Trip_Planner.model.domain.CountryList;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetCountriesProcedureDAO implements GenericProcedureDAO<CountryList>{
    @Override
    public CountryList execute(Object... params) throws DAOException {
        CountryList countries = new CountryList();

        try{
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call get_countries()}");
            boolean status = cs.execute();

            if (status) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    Country country = new Country(rs.getString(1));
                    countries.addCountry(country);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("GetCountries error: " + e.getMessage());
        }
        return countries;
    }
}
