package pera.trip_planner.model.domain;

import java.io.Serializable;

public class GeneralUser implements Serializable {
    private String username;
    private String password;

    public GeneralUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
