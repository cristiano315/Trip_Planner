package pera.trip_planner.controller.task;

import javafx.concurrent.Task;
import pera.trip_planner.controller.logic_controller.LoginController;
import pera.trip_planner.model.domain.User;

public class LoginTask extends Task<User> {
    @Override
    public User call() {
        LoginController loginController = LoginController.getInstance();
        User user = null;
        while(user == null){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            user = loginController.retrieveUser();
        }
        return user;
    }
}
