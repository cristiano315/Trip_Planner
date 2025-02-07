package pera.trip_planner.model.domain.entity_lists;

import pera.trip_planner.model.domain.CityAnnouncement;

public class CityAnnouncementList extends EntityList<CityAnnouncement> {
    @Override
    public String getName(CityAnnouncement announcement) {
        return announcement.getName();
    }
}
