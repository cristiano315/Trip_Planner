package pera.trip_planner.model.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ActivityInstance implements Serializable {
    private Activity activity;
    private LocalDateTime dateTime;

    public ActivityInstance(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ActivityInstance(Activity activity, LocalDateTime dateTime) {
        this.activity = activity;
        this.dateTime = dateTime;
    }

    public ActivityInstance() {}

    public Activity getActivity() {
        return activity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
