package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.User;

public interface UserDao extends GeneralUserDao<User>{
    @Override
    default User create(String username){
        return new User(username);
    }
}
