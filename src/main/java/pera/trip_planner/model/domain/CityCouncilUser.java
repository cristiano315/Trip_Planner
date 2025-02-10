package pera.trip_planner.model.domain;

import pera.trip_planner.model.domain.entity_lists.CityList;

public class CityCouncilUser extends GeneralUser<CityList, City> {

    public CityCouncilUser(String username) {
        super(username);
        this.userList = new CityList();
    }
}
