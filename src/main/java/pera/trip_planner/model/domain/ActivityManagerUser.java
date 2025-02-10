package pera.trip_planner.model.domain;

import pera.trip_planner.model.domain.entity_lists.ActivityList;

public class ActivityManagerUser extends GeneralUser<ActivityList, Activity> {

    public ActivityManagerUser(String username) {
        super(username);
        this.userList = new ActivityList();
    }
}
