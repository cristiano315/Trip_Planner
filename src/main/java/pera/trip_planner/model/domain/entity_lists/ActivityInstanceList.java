package pera.trip_planner.model.domain.entity_lists;

import pera.trip_planner.model.domain.ActivityInstance;

import java.util.Comparator;

public class ActivityInstanceList extends EntityList<ActivityInstance> {
    @Override
    protected String getName(ActivityInstance entity) {
        return entity.getActivity().activityName();
    }

    @Override
    public void sort(){
        itemsList.sort(new Comparator<ActivityInstance>() {
            public int compare(ActivityInstance o1, ActivityInstance o2) {
                return o1.getDateTime().compareTo(o2.getDateTime());
            }
        });
    }
}
