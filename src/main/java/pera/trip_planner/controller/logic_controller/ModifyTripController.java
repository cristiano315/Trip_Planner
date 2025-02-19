package pera.trip_planner.controller.logic_controller;

import javafx.concurrent.Task;
import pera.trip_planner.controller.bean.AddActivityInstanceToDayBean;
import pera.trip_planner.controller.bean.AddDayToNewTripBean;
import pera.trip_planner.controller.bean.ModifyTripBean;
import pera.trip_planner.controller.bean.ViewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.controller.graphic_controller.GraphicModifyTripController;
import pera.trip_planner.controller.task.CreateTripTask;
import pera.trip_planner.exception.InvalidUsageException;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.dao.TripDao;
import pera.trip_planner.model.domain.*;

import java.time.temporal.ChronoUnit;

public class ModifyTripController implements Controller {
    private static ModifyTripController instance;
    private GraphicModifyTripController graphicController;

    protected  ModifyTripController() {}

    public static ModifyTripController getInstance() {
        if (instance == null) {
            instance = new ModifyTripController();
            instance.graphicController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicModifyTripController();
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

    public void login(){
        LoginController loginController = LoginController.getInstance();
        loginController.start();
    }

    public void finishLogin(User user) {
        if(user == null || user.getRole() != Role.USER){
            throw new IllegalArgumentException("Invalid user");
        }
        graphicController.showTripList(user);
    }

    public void modifyTrip(ViewTripBean bean){
        TripDao dao = DaoFactory.getInstance().getTripDao();
        Trip trip = dao.load(bean.tripname);
        dao.delete(bean.tripname);
        graphicController.modifyTripInfo(trip);
    }

    public void modifyName(Trip trip, ModifyTripBean bean) {
        trip.setName(bean.getNewName());
    }

    public void modifyCountry(Trip trip, ModifyTripBean bean) {
        trip.setCountry(DaoFactory.getInstance().getCountryDao().load(bean.getNewCountry()));
        trip.resetDaysList();
        GraphicCreateTripController graphicCreateTripController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicCreateTripController();
        long duration = ChronoUnit.DAYS.between(trip.getStartDate(), trip.getEndDate());
        graphicCreateTripController.addDays(trip, duration);
        Task<Boolean> task = new CreateTripTask();
        task.setOnSucceeded(e -> {
            storeTrip(trip);
        });
        new Thread(task).start();
    }

    public void modifyDates(Trip trip, ModifyTripBean bean) {
        trip.setStartDate(bean.getNewStartDate());
        trip.setEndDate(bean.getNewEndDate());
        trip.resetDaysList();
        GraphicCreateTripController graphicCreateTripController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicCreateTripController();
        long duration = ChronoUnit.DAYS.between(trip.getStartDate(), trip.getEndDate());
        graphicCreateTripController.addDays(trip, duration);
        Task<Boolean> task = new CreateTripTask();
        task.setOnSucceeded(e -> {
            storeTrip(trip);
        });
        new Thread(task).start();
    }

    public void modifyDayCity(Trip trip, TripDay day, AddDayToNewTripBean bean) {
        day.setCity(trip.getCountry().getCities().getEntityByName(bean.getCity()));
        day.resetActivityInstanceList();
        GraphicCreateTripController graphicCreateTripController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicCreateTripController();
        graphicCreateTripController.addActivityInstanceList(trip, day);
    }

    public void removeActivity(TripDay day, AddActivityInstanceToDayBean bean) {
        //check activity is contained
        if(!day.getActivityInstanceList().contains(bean.getActivity())){
            throw new IllegalArgumentException("Activity not present");
        }
        day.getActivityInstanceList().removeEntity(bean.getActivity());
    }


    public void addActivity(TripDay day, AddActivityInstanceToDayBean bean) {
        ActivityInstance activityInstance = DaoFactory.getInstance().getActivityInstanceDao().create(bean.getDate());
        activityInstance.setActivity(DaoFactory.getInstance().getActivityDao().load(bean.getActivity()));
        day.getActivityInstanceList().addEntity(activityInstance);
    }

    public void storeTrip(Trip trip) {
        DaoFactory.getInstance().getTripDao().store(trip);
        graphicController.done(trip);
    }
}
