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
    private static final String WRONG_ROLE_ERROR = "Wrong role";

    protected LoginController(){}

    public static LoginController getInstance() {
        if(instance == null){
            instance = new LoginController();
            instance.graphicController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicLoginController();
        }
        return instance;
    }

    @Override
    public void start() throws InvalidUsageException{
        if(user == null){
            graphicController.selection();
        } else {
            throw new InvalidUsageException("User already logged in");
        }
    }

    public User retrieveUser(){
        return (User) user;
    }

    public CityCouncilUser retrieveCityCouncilUser(){
        return (CityCouncilUser) user;
    }

    public ActivityManagerUser retrieveActivityManagerUser(){
        return (ActivityManagerUser) user;
    }

    public void login(LoginBean bean){

        getGeneralUserDao(bean.getRole());
        GeneralUser<?,?> tempUser = generalUserDao.load(bean.getUsername());
        //user must not be null
        if(tempUser == null){
            throw new IllegalArgumentException("User not found");
        }
        //password must be correct
        if(!Boolean.TRUE.equals(tempUser.checkPassword(bean.getPassword()))){
            throw new IllegalArgumentException("Wrong password");
        }
        //role must be correct
        if(tempUser.getRole() != bean.getRole()){
            throw new IllegalArgumentException(WRONG_ROLE_ERROR);
        }

        this.user = tempUser;
    }

    public void register(LoginBean bean){
        getGeneralUserDao(bean.getRole());
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
            throw new IllegalArgumentException(WRONG_ROLE_ERROR);
        }
    }

    public void getGeneralUserDao(Role role){
        if(role == Role.USER){
            this.generalUserDao = DaoFactory.getInstance().getUserDao();
        } else if (role == Role.CITY_COUNCIL){
            this.generalUserDao = DaoFactory.getInstance().getCityCouncilUserDao();
        } else if (role == Role.ACTIVITY_MANAGER){
            this.generalUserDao = DaoFactory.getInstance().getActivityManagerUserDao();
        } else{
            throw new IllegalArgumentException(WRONG_ROLE_ERROR);
        }
    }
}
