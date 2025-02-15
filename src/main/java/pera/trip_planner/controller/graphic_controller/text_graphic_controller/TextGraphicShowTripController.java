package pera.trip_planner.controller.graphic_controller.text_graphic_controller;

import pera.trip_planner.controller.bean.ViewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicShowTripController;
import pera.trip_planner.controller.logic_controller.LoginController;
import pera.trip_planner.controller.logic_controller.ShowTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.ActivityInstance;
import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;
import pera.trip_planner.model.domain.User;
import pera.trip_planner.view.text.TextGraphicShowTripControllerView;

public class TextGraphicShowTripController implements GraphicShowTripController {
    private ShowTripController controller = ShowTripController.getInstance();
    private TextGraphicShowTripControllerView view = new TextGraphicShowTripControllerView();
    private static final String INVALID_CHOICE_MESSAGE = "Choice invalid: day not in trip";

    @Override
    public void showTripList(User user) {
        view.showAvailableTrips(user);
        while(true){
            String trip = view.getString("Select a trip to visualize: ");
            if(DaoFactory.getInstance().getTripDao().load(trip) != null) {
                controller.viewTrip(new ViewTripBean(trip));
                break;
            } else{
                view.showMessage("Insert a valid trip");
            }
        }
    }

    @Override
    public void showTripInfo(Trip trip) {
        view.showTripInfo(trip);
        controller.showTripDay(trip, trip.getTripDays().getEntityByName(trip.getStartDate().toString()));
    }

    @Override
    public void showTripDayInfo(Trip trip, TripDay day) {
        view.showDayInfo(day);
        for(ActivityInstance a : day.getActivityInstanceList().getList()){
            view.showActivityInstance(a);
        }
        boolean running = true;
        while(running){
            int choice = view.getChoice();
            switch(choice){
                case 0:
                    running = false;
                    break;
                case 1:
                    if(day.getDate().plusDays(1).isEqual(trip.getEndDate())){
                        view.showMessage(INVALID_CHOICE_MESSAGE);
                    } else {
                        controller.showTripDay(trip, trip.getTripDays().getEntityByName(day.getDate().plusDays(1).toString()));
                        running = false;
                    }
                    break;
                case -1:
                    if(day.getDate().minusDays(1).isBefore(trip.getStartDate())){
                        view.showMessage(INVALID_CHOICE_MESSAGE);
                    } else {
                        controller.showTripDay(trip, trip.getTripDays().getEntityByName(day.getDate().minusDays(1).toString()));
                        running = false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid choice");
            }
        }
    }

    @Override
    public void login() {
        boolean choice = view.getBooleanChoice("Would you like to log in?");
        if(choice){
            controller.login();
            controller.finishLogin(LoginController.getInstance().retrieveUser());
        } else{
            showTripList(null);
        }
    }
}
