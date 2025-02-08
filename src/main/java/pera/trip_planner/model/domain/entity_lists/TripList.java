package pera.trip_planner.model.domain.entity_lists;

import pera.trip_planner.model.domain.Trip;

public class TripList extends EntityList<Trip> {
    @Override
    protected String getName(Trip entity) {
        return entity.getName();
    }
}
