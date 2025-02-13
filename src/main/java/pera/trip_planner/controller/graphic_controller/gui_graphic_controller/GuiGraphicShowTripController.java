package pera.trip_planner.controller.graphic_controller.gui_graphic_controller;

import pera.trip_planner.controller.bean.ViewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.GraphicShowTripController;
import pera.trip_planner.controller.logic_controller.ShowTripController;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;
import pera.trip_planner.model.domain.User;
import pera.trip_planner.view.gui.GuiGraphicShowTripControllerView;

public class GuiGraphicShowTripController implements GraphicShowTripController {
    private static GuiGraphicShowTripController instance;
    private GuiGraphicShowTripControllerView view;
    private ShowTripController controller = ShowTripController.getInstance();

    private GuiGraphicShowTripController(){}

    public static GuiGraphicShowTripController getInstance(){
        if(instance == null){
            instance = new GuiGraphicShowTripController();
            instance.view = new GuiGraphicShowTripControllerView();
        }
        return instance;
    }

    @Override
    public void showTripList(User user) {
        view.showTripList(user);
    }

    @Override
    public void showTripInfo(Trip trip) {
        view.showTripInfo(trip);
    }

    @Override
    public void showTripDayInfo(Trip trip, TripDay day) {
        view.showTripDayInfo(trip, day);
    }

    @Override
    public void login() {
        view.showAlert("Would you like to login?");
        showTripList(null);
    }

    public void viewTrip(String tripName) {
        controller.viewTrip(new ViewTripBean(tripName));
    }

    public void viewFirstDay(Trip currentTrip) {
        controller.showTripDay(currentTrip, currentTrip.getTripDays().getEntityByName(currentTrip.getStartDate().toString()));
    }

    public void changeDay(int choice, TripDay day, Trip trip) {
        if(choice == 1){
            if(day.getDate().plusDays(1).isEqual(trip.getEndDate())){
                view.showAlert("Choice invalid: day not in trip");
            } else {
                controller.showTripDay(trip, trip.getTripDays().getEntityByName(day.getDate().plusDays(1).toString()));
            }
        } else if(choice == -1){
            if(day.getDate().minusDays(1).isBefore(trip.getStartDate())){
                view.showAlert("Choice invalid: day not in trip");
            } else {
                controller.showTripDay(trip, trip.getTripDays().getEntityByName(day.getDate().minusDays(1).toString()));
            }
        } else {
            throw new IllegalArgumentException("choice invalid");
        }
    }

    public void quit() {
        GraphicApplicationController newController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicApplicationController();
        newController.runApplication();
    }
}
