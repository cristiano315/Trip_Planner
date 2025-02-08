package pera.trip_planner.model.domain.entity_lists;

import pera.trip_planner.model.domain.TripDay;

public class TripDayList extends EntityList<TripDay> {
    @Override
    protected String getName(TripDay entity) {
        return entity.getDate().toString();
    }
}
