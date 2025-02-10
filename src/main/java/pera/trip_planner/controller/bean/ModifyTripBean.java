package pera.trip_planner.controller.bean;

import pera.trip_planner.model.domain.Country;

import java.time.LocalDate;

public class ModifyTripBean {
    private final String newName;
    private final Country newCountry;
    private final LocalDate newStartDate;
    private final LocalDate newEndDate;

    public ModifyTripBean(String newName, Country newCountry, LocalDate newStartDate, LocalDate newEndDate) {
        this.newName = newName;
        this.newCountry = newCountry;
        this.newStartDate = newStartDate;
        this.newEndDate = newEndDate;
    }

    public String getNewName() {
        return newName;
    }
    public Country getNewCountry() {
        return newCountry;
    }
    public LocalDate getNewStartDate() {
        return newStartDate;
    }
    public LocalDate getNewEndDate() {
        return newEndDate;
    }
}
