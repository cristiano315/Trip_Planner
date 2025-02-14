package pera.trip_planner.controller.logic_controller;

import javafx.concurrent.Task;
import pera.trip_planner.controller.task.LoginTask;
import pera.trip_planner.controller.bean.ViewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicShowTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.dao.TripDao;
import pera.trip_planner.model.domain.*;

public class ShowTripController implements Controller {
    private static ShowTripController instance;
    private GraphicShowTripController graphicController;
    private TripDao tripDao;

    public static ShowTripController getInstance() {
        if (instance == null) {
            instance = new ShowTripController();
            instance.graphicController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicShowTripController();
            instance.tripDao = DaoFactory.getInstance().getTripDao();
        }
        return instance;
    }

    @Override
    public void start(){
        User user;
        user = LoginController.getInstance().retrieveUser();
        if(user == null || user.getRole() != Role.USER){
            graphicController.login();
        } else{
            graphicController.showTripList(user);
        }
    }

    public void viewTrip(ViewTripBean bean){
        Trip trip = tripDao.load(bean.getTripname());
        graphicController.showTripInfo(trip);
    }

    public void showTripDay(Trip trip, TripDay day){
        graphicController.showTripDayInfo(trip, day);
    }

    public void login(){
        LoginController loginController = LoginController.getInstance();
        User user = LoginController.getInstance().retrieveUser();
        if(user == null){
            loginController.start();
            Task<User> task = new LoginTask();
            task.setOnSucceeded(e -> {
                User result = task.getValue();
                finishLogin(result);
            });
            new Thread(task).start();
        } else {
            finishLogin(user);
        }
    }

    public void finishLogin(User user){
        if(user.getRole() != Role.USER){
            throw new IllegalArgumentException("Invalid user");
        }
        graphicController.showTripList(user);
    }
}
