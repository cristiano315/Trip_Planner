package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.bean.AddDaysToNewTripBean;
import pera.trip_planner.controller.bean.CreateNewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.dao.TripDao;
import pera.trip_planner.model.domain.Trip;

import java.util.List;

public class CreateTripController implements Controller {
    GraphicCreateTripController graphicController;
    TripDao tripDao = DaoFactory.getInstance().getTripDao();

    @Override
    public void start(){
        graphicController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicCreateTripController();
        graphicController.createTrip();
        //step: creazione nuovo trip, lista paesi(controller grafico), paese scelto, aggiunta al trip, si ripassa al controller grafico etc
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
        tripDao.store(trip);
        graphicController.addDays();
    }

    public void addDaysToNewTrip(List<AddDaysToNewTripBean> beans){

    }


}
