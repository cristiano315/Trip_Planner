package pera.trip_planner.controller.bean;

import java.time.LocalDate;

public class ModifyTripBean {
    private final String newName;
    private final String newCountry;
    private final LocalDate newStartDate;
    private final LocalDate newEndDate;

    public ModifyTripBean(String newName, String newCountry, LocalDate newStartDate, LocalDate newEndDate) {
        this.newName = newName;
        this.newCountry = newCountry;
        this.newStartDate = newStartDate;
        this.newEndDate = newEndDate;
    }

    public String getNewName() {
        return newName;
    }
    public String getNewCountry() {
        return newCountry;
    }
    public LocalDate getNewStartDate() {
        return newStartDate;
    }
    public LocalDate getNewEndDate() {
        return newEndDate;
    }
}
