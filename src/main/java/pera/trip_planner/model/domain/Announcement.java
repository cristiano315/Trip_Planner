package pera.trip_planner.model.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Announcement implements Serializable {
    public String name;
    private String description;
    private LocalDate issuingDate;

    public Announcement(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void addDescription(String description) {
        this.description += description;
    }

    public LocalDate getIssuingDate() {
        return issuingDate;
    }

    public String getName() {
        return name;
    }

    public void setIssuingDate(LocalDate issuingDate) {
        this.issuingDate = issuingDate;
    }
}
