package pera.trip_planner.model.domain.entity_lists;

import pera.trip_planner.model.domain.ActivityInstance;

public class ActivityInstanceList extends EntityList<ActivityInstance> {
    @Override
    protected String getName(ActivityInstance entity) {
        return entity.getActivity().activityName();
    }
}
