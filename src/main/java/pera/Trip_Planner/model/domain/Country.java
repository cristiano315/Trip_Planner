package pera.Trip_Planner.model.domain;

public class Country {
    private String Name;

    public Country(String Name) {
        this.Name = Name;
    }

    public String countryName() {
        return Name;
    }
}
