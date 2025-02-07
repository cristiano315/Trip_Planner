package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.ActivityInstance;

import java.time.LocalDateTime;

public interface ActivityInstanceDao extends DAO<LocalDateTime, ActivityInstance> {

    @Override
    default ActivityInstance create(LocalDateTime date) {
        return new ActivityInstance(date);
    }
}
