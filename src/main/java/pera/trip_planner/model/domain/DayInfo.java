package pera.trip_planner.model.domain;

import java.io.Serializable;
import java.time.LocalTime;

public class DayInfo implements Serializable {
    private DayType day;
    private LocalTime openTime = null;
    private LocalTime closeTime = null;

    public DayInfo(DayType day, LocalTime openTime, LocalTime closeTime) {
        this.day = day;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public DayType getDay() {
        return day;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }
}
