package pera.trip_planner.model.domain;

import pera.trip_planner.model.domain.entity_lists.EntityList;

import java.io.Serializable;


public abstract class GeneralUser<L extends EntityList<E>, E> implements Serializable {
    private String username;
    private String password;
    private Role role;
    protected L userList;

    protected GeneralUser(String username) {
        this.username = username;
    }

    protected GeneralUser() {}

    public String getUsername() {
        return username;
    }

    public Boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public  L getUserList(){
        return userList;
    }
    public void addEntity(E entity){
        userList.addEntity(entity);
    }
}
