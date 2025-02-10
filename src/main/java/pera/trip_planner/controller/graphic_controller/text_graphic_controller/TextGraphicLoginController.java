package pera.trip_planner.controller.graphic_controller.text_graphic_controller;

import pera.trip_planner.controller.bean.LoginBean;
import pera.trip_planner.controller.graphic_controller.GraphicLoginController;
import pera.trip_planner.controller.logic_controller.LoginController;
import pera.trip_planner.model.domain.Role;
import pera.trip_planner.view.TextGraphicLoginControllerView;

public class TextGraphicLoginController implements GraphicLoginController {
    private TextGraphicLoginControllerView view = new TextGraphicLoginControllerView();
    private LoginController controller = LoginController.getInstance();

    @Override
    public void selection() {
        int choice = view.getChoice();
        if(choice == 1) { //login
            login();
        } else if(choice == 2) {
            register();
        } else{
            throw new IllegalArgumentException("Illegal selection");
        }
    }

    public void login() {
        String username = view.getString("Insert username: ");
        String password = view.getString("Insert password: ");
        Role role = view.getRole();
        controller.login(new LoginBean(username, password, role));
    }

    public void register() {
        String username = view.getString("Insert username: ");
        String password = view.getString("Insert password: ");
        Role role = view.getRole();
        controller.register(new LoginBean(username, password, role));
    }
}
