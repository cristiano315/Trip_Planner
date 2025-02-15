package pera.trip_planner.controller.graphic_controller.gui_graphic_controller;

import pera.trip_planner.controller.bean.LoginBean;
import pera.trip_planner.controller.graphic_controller.GraphicLoginController;
import pera.trip_planner.controller.logic_controller.LoginController;
import pera.trip_planner.model.domain.Role;
import pera.trip_planner.view.gui.GuiGraphicLoginControllerView;

public class GuiGraphicLoginController implements GraphicLoginController {
    private static GuiGraphicLoginController instance;
    private GuiGraphicLoginControllerView view;
    private LoginController controller = LoginController.getInstance();
    private static final String NOT_VALID_MESSAGE = "Selection not valid";

    protected GuiGraphicLoginController(){}

    public static GuiGraphicLoginController getInstance(){
        if(instance == null){
            instance = new GuiGraphicLoginController();
            instance.view = new GuiGraphicLoginControllerView();
        }
        return instance;
    }

    @Override
    public void selection() {
        view.selection();
    }

    public void readSelection(String choice){
        if (choice.equals("Login")){
            login();
        } else if(choice.equals("Register")){
            register();
        } else{
            throw new IllegalArgumentException(NOT_VALID_MESSAGE);
        }
    }

    public void register(){
        view.register();
    }

    public void login(){
        view.login();
    }

    public void executeLogin(String username, String password, String role) {
        Role beanRole;
        if(role.equals("User")){
            beanRole = Role.USER;
        } else if (role.equals("City council")){
            beanRole = Role.CITY_COUNCIL;
        } else if (role.equals("Activity manager")){
            beanRole = Role.ACTIVITY_MANAGER;
        } else {
            throw new IllegalArgumentException(NOT_VALID_MESSAGE);
        }
        controller.login(new LoginBean(username, password, beanRole));
    }

    public void executeRegister(String username, String password, String role) {
        Role beanRole;
        if(role.equals("User")){
            beanRole = Role.USER;
        } else if (role.equals("City council")){
            beanRole = Role.CITY_COUNCIL;
        } else if (role.equals("Activity manager")){
            beanRole = Role.ACTIVITY_MANAGER;
        } else {
            throw new IllegalArgumentException(NOT_VALID_MESSAGE);
        }
        controller.register(new LoginBean(username, password, beanRole));
    }
}
