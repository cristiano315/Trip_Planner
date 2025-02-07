package pera.trip_planner.model.domain;

import java.io.Serializable;
import java.time.LocalTime;

public class ActivityInstance implements Serializable {
    private Activity activity;
    private LocalTime time;

    public ActivityInstance(Activity activity, LocalTime time) {
        this.activity = activity;
        this.time = time;
    }

    public Activity getActivity() {
        return activity;
    }

    public LocalTime getTime() {
        return time;
    }
}
