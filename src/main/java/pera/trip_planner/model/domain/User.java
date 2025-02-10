package pera.trip_planner.model.domain;

import pera.trip_planner.model.domain.entity_lists.TripList;

public class User extends GeneralUser<TripList, Trip>{

    public User(String username) {
        super(username);
        this.userList = new TripList();
    }
}
