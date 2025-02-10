package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.ActivityManagerUser;

public interface ActivityManagerUserDao extends GeneralUserDao<ActivityManagerUser> {
    @Override
    default ActivityManagerUser create(String username){
        return new ActivityManagerUser(username);
    }
}
