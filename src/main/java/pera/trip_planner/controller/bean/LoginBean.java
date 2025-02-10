package pera.trip_planner.controller.bean;

import pera.trip_planner.model.domain.Role;

public class LoginBean {
    private final String username;
    private final String password;
    private final Role role;

    public LoginBean(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
