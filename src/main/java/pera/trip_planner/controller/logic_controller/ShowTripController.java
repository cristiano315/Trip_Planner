package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.bean.ViewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicShowTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.dao.TripDao;
import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;

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
        graphicController.showTripList();
    }

    public void viewTrip(ViewTripBean bean){
        Trip trip = tripDao.load(bean.getTripname());
        graphicController.showTripInfo(trip);
    }

    public void showTripDay(Trip trip, TripDay day){
        graphicController.showTripDayInfo(trip, day);
    }
}
