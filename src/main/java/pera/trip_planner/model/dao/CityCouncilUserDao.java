package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.CityCouncilUser;

public interface CityCouncilUserDao extends GeneralUserDao<CityCouncilUser> {
    @Override
    default CityCouncilUser create(String username){
        return new CityCouncilUser(username);
    }
}
