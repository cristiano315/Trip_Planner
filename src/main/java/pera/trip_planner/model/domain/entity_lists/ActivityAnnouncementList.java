package pera.trip_planner.model.domain.entity_lists;

import pera.trip_planner.model.domain.ActivityAnnouncement;

public class ActivityAnnouncementList extends EntityList<ActivityAnnouncement> {

    @Override
    protected String getName(ActivityAnnouncement entity) {
        return entity.getName();
    }
}
