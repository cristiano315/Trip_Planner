package pera.trip_planner.model.domain;

public enum Role {
    USER(1),
    CITY_COUNCIL(2),
    ACTIVITY_MANAGER(3);

    private final int id;

    private Role(int id) {
        this.id = id;
    }

    public static Role fromInt(int id) {
        for (Role type : values()) {
            if (type.getId() == id)
                return type;
        }
        return null;
    }

    public int getId() {
        return id;
    }
}
