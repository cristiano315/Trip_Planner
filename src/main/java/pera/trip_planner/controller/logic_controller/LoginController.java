package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.bean.LoginBean;
import pera.trip_planner.controller.graphic_controller.GraphicLoginController;
import pera.trip_planner.exception.InvalidUsageException;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.GeneralUserDao;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.domain.GeneralUser;

public class LoginController implements Controller {
    private static LoginController instance;
    private GraphicLoginController graphicController;
    private GeneralUser user;
    private GeneralUserDao generalUserDao;

    private LoginController(){}

    public static LoginController getInstance() {
        if(instance == null){
            instance = new LoginController();
            instance.graphicController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicLoginController();
        }
        return instance;
    }

    @Override
    public void start(){
        if(retrieveUser() == null){
            graphicController.selection();
        } else {
            throw new InvalidUsageException("User already logged in");
        }
    }

    public GeneralUser retrieveUser(){
        return user;
    }

    public void login(LoginBean bean){

        generalUserDao = DaoFactory.getInstance().getSpecificUserDao(bean.getRole());
        GeneralUser user = (GeneralUser) generalUserDao.load(bean.getUsername());
        //user must not be null
        if(user == null){
            throw new IllegalArgumentException("User not found");
        }
        //password must be correct
        if(!user.checkPassword(bean.getPassword())){
            throw new IllegalArgumentException("Wrong password");
        }
        //role must be correct
        if(user.getRole() != bean.getRole()){
            throw new IllegalArgumentException("Wrong role");
        }

        this.user = user;
    }

    public void register(LoginBean bean){
        generalUserDao = DaoFactory.getInstance().getSpecificUserDao(bean.getRole());
        GeneralUser user;
        //user must not already exist
        if(generalUserDao.load(bean.getUsername()) != null){
            throw new IllegalArgumentException("User already exists");
        }
        user = (GeneralUser) generalUserDao.create(bean.getUsername());
        user.setPassword(bean.getPassword());
        user.setRole(bean.getRole());
        this.user = user;
        generalUserDao.store(user);
    }
}
