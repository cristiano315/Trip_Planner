package pera.trip_planner.model.domain;

public class CityAnnouncementList extends EntityList<CityAnnouncement> {
    @Override
    public String getName(CityAnnouncement announcement) {
        return announcement.getName();
    }
}
