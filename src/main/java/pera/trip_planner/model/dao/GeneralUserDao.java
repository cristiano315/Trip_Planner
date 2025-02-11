package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.GeneralUser;

public interface GeneralUserDao<V extends GeneralUser<?,?>> extends DAO<String, V>{
}
