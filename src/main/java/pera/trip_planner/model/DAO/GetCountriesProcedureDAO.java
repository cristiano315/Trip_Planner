package pera.trip_planner.model.DAO;

import pera.trip_planner.exception.DAOException;
import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.CountryList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


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
