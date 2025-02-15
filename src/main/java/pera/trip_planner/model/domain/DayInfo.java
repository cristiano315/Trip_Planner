package pera.trip_planner.model.domain;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class DayInfo implements Serializable {
    private DayOfWeek day;
    private LocalTime openTime = null;
    private LocalTime closeTime = null;

    public DayInfo(DayOfWeek day, LocalTime openTime, LocalTime closeTime) {
        this.day = day;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public DayInfo(){}

    public DayOfWeek getDay() {
        return day;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }
}
