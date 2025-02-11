package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.bean.LoginBean;
import pera.trip_planner.controller.graphic_controller.GraphicLoginController;
import pera.trip_planner.exception.InvalidUsageException;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.GeneralUserDao;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.domain.*;

public class LoginController implements Controller {
    private static LoginController instance;
    private GraphicLoginController graphicController;
    private GeneralUser<?, ?> user;
    private GeneralUserDao<?> generalUserDao;

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

    public GeneralUser<?,?> retrieveUser(){
        return user;
    }

    public void login(LoginBean bean){

        generalUserDao = DaoFactory.getInstance().getSpecificUserDao(bean.getRole());
        GeneralUser<?,?> tempUser = generalUserDao.load(bean.getUsername());
        //user must not be null
        if(tempUser == null){
            throw new IllegalArgumentException("User not found");
        }
        //password must be correct
        if(!tempUser.checkPassword(bean.getPassword())){
            throw new IllegalArgumentException("Wrong password");
        }
        //role must be correct
        if(tempUser.getRole() != bean.getRole()){
            throw new IllegalArgumentException("Wrong role");
        }

        this.user = tempUser;
    }

    public void register(LoginBean bean){
        generalUserDao = DaoFactory.getInstance().getSpecificUserDao(bean.getRole());
        GeneralUser<?,?> tempUser;
        //user must not already exist
        if(generalUserDao.load(bean.getUsername()) != null){
            throw new IllegalArgumentException("User already exists");
        }
        tempUser = generalUserDao.create(bean.getUsername());
        tempUser.setPassword(bean.getPassword());
        tempUser.setRole(bean.getRole());
        this.user = tempUser;
        if(tempUser.getRole() == Role.USER){
            DaoFactory.getInstance().getUserDao().store((User) tempUser);
        } else if (tempUser.getRole() == Role.CITY_COUNCIL){
            DaoFactory.getInstance().getCityCouncilUserDao().store((CityCouncilUser) tempUser);
        } else if (tempUser.getRole() == Role.ACTIVITY_MANAGER){
            DaoFactory.getInstance().getActivityManagerUserDao().store((ActivityManagerUser) tempUser);
        } else{
            throw new IllegalArgumentException("Wrong role");
        }
    }
}
