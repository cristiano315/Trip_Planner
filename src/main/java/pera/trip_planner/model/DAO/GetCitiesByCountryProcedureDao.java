package pera.trip_planner.model.DAO;

import pera.trip_planner.exception.DAOException;
import pera.trip_planner.model.domain.City;
import pera.trip_planner.model.domain.CityList;
import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.CountryList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCitiesByCountryProcedureDao implements GenericProcedureDAO<CityList>{
    @Override
    public CityList execute(Object... params) throws DAOException {
        CityList cities = new CityList();
        String name = (String) params[0];

        try{
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call get_cities_in_country(?)}");
            cs.setString(1, name);
            boolean status = cs.execute();

            if (status) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    City city = new City(rs.getString(1));
                    cities.addCity(city);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("GetCities error: " + e.getMessage());
        }
        return cities;
    }
}
