package pera.trip_planner.model.domain;

import java.io.Serializable;

public class ActivityList extends EntityList<Activity> implements Serializable {
    @Override
    protected String getName(Activity activity) {
        return activity.activityName();
    }
}
