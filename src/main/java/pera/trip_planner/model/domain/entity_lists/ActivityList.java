package pera.trip_planner.model.domain.entity_lists;

import pera.trip_planner.model.domain.Activity;

import java.io.Serializable;

public class ActivityList extends EntityList<Activity> implements Serializable {
    @Override
    protected String getName(Activity activity) {
        return activity.activityName();
    }
}
