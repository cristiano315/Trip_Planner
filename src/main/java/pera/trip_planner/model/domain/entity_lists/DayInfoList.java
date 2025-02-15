package pera.trip_planner.model.domain.entity_lists;

import pera.trip_planner.model.domain.DayInfo;

public class DayInfoList extends EntityList<DayInfo> {
    @Override
    protected String getName(DayInfo dayInfo){
        return dayInfo.getDay().name();
    }
}
