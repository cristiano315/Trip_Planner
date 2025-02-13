package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.bean.AddActivityInstanceToDayBean;
import pera.trip_planner.controller.bean.AddDayToNewTripBean;
import pera.trip_planner.controller.bean.CreateNewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.model.dao.*;
import pera.trip_planner.model.domain.*;

public class CreateTripController implements Controller {
    GraphicCreateTripController graphicController;
    TripDao tripDao;
    TripDayDao tripDayDao;
    ActivityInstanceDao activityInstanceDao;
    private static CreateTripController instance;

    @Override
    public void start(){
        graphicController.createTrip();
    }

    public static CreateTripController getInstance(){
        if (instance == null){
            instance = new CreateTripController();
            instance.graphicController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicCreateTripController();
            DaoFactory daoFactory = DaoFactory.getInstance();
            instance.tripDao = daoFactory.getTripDao();
            instance.tripDayDao = daoFactory.getTripDayDao();
            instance.activityInstanceDao = daoFactory.getActivityInstanceDao();
        }
        return instance;
    }

    public void createNewTrip(CreateNewTripBean bean){
        //trip must not already exist
        Trip trip = tripDao.load(bean.getTripName());
        if(trip != null){
            throw new IllegalArgumentException("Trip already exists");
        }

        trip = tripDao.create(bean.getTripName());
        trip.setCountry(bean.getTripCountry());
        trip.setStartDate(bean.getTripStartDate());
        trip.setEndDate(bean.getTripEndDate());
        graphicController.addDays(trip, bean.getTripDuration());
        //fare con addDays, i come parametro locale(statico) e la duration controllata a ogni store che alla fine chiama store trip
    }

    public void addDayToNewTrip(Trip trip, AddDayToNewTripBean bean){

        TripDay tripDay = tripDayDao.create(bean.getDate());
        tripDay.setCity(bean.getCity());
        tripDay.setDayType(bean.getDayType());
        graphicController.addActivityInstanceList(trip, tripDay);
    }

    public void addActivityInstanceToDay(TripDay tripDay, AddActivityInstanceToDayBean bean){

        ActivityInstance activityInstance = activityInstanceDao.create(bean.getDate());
        activityInstance.setActivity(bean.getActivity());
        tripDay.addActivityInstance(activityInstance);
        activityInstanceDao.store(activityInstance);
    }

    public void saveToAccount(Trip trip){
        User user;
        user = LoginController.getInstance().retrieveUser();
        if(user == null){
            LoginController.getInstance().start();
            user = LoginController.getInstance().retrieveUser();
        }
        //user must have the correct role
        if(user.getRole() != Role.USER){
            throw new IllegalArgumentException("Wrong user role");
        }
        user.addEntity(trip);
        trip.registerToAccount();
        DaoFactory.getInstance().getUserDao().store(user);
    }

    public void storeTrip(Trip trip){
        tripDao.store(trip);
        graphicController.done(trip);
    }

    public void storeTripDay(Trip trip, TripDay day){
        trip.addTripDay(day);
        tripDayDao.store(day);
    }

}
