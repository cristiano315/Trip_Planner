package pera.trip_planner.model.domain;

public class ActivityAnnouncementList extends EntityList<ActivityAnnouncement> {

    @Override
    protected String getName(ActivityAnnouncement entity) {
        return entity.getName();
    }
}
