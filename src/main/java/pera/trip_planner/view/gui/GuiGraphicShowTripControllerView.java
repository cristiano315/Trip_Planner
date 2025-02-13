package pera.trip_planner.view.gui;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicShowTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.*;
import pera.trip_planner.model.domain.entity_lists.ActivityInstanceList;
import pera.trip_planner.model.domain.entity_lists.CountryList;
import pera.trip_planner.model.domain.entity_lists.TripList;

import java.util.ArrayList;

public class GuiGraphicShowTripControllerView extends GenericGuiGraphicView{
    private final GuiGraphicShowTripController controller = GuiGraphicShowTripController.getInstance();
    private final String ERROR_MESSAGE = "Error in showTrip GUI";
    private static User user;
    private static Trip currentTrip;
    private static TripDay currentTripDay;
    @FXML
    private ListView<String> tripListView;
    @FXML
    private Label tripNameLabel;
    @FXML
    private Label countryNameLabel;
    @FXML
    private Label startDateLabel;
    @FXML
    private Label endDateLabel;
    @FXML
    private Label tripNameDaysLabel;
    @FXML
    private Label dayInfoLabel;
    @FXML
    private ListView<String> activitiesListView;


    public void showTripList(User newUser) {
        setUser(newUser);
        setScene("view/showTripSelectTrip", ERROR_MESSAGE);
    }

    public void showTripInfo(Trip trip) {
        setTrip(trip);
        setScene("view/showTripViewTripInfo", ERROR_MESSAGE);
    }

    public void showTripDayInfo(Trip trip, TripDay day) {
        setTrip(trip);
        setTripDay(day);
        setScene("view/showTripViewDay", ERROR_MESSAGE);
    }

    public void initialize() {
        if(tripListView != null) {
            initializeTripList();
        } else if (tripNameLabel != null) {
            initializeTripInfoLabels();
        } else if (tripNameDaysLabel != null) {
            initializeDaysInfoLabels();
            initializeActivitiesList();
        }
    }

    private void initializeTripInfoLabels() {
        tripNameLabel.setText(currentTrip.getName());
        countryNameLabel.setText("Country: " + currentTrip.getCountry().countryName());
        startDateLabel.setText("Start Date: " + currentTrip.getStartDate());
        endDateLabel.setText("End Date: " + currentTrip.getEndDate());
    }

    public void initializeDaysInfoLabels() {
        tripNameDaysLabel.setText(currentTrip.getName());
        dayInfoLabel.setText(currentTripDay.getDate().toString() + " - " + currentTripDay.getDayType());
    }

    public void initializeActivitiesList() {
        ActivityInstanceList activities = currentTripDay.getActivityInstanceList();
        activities.sort();
        for(ActivityInstance a : activities.getList()){
            activitiesListView.getItems().add(a.getActivity().getName() + "   " + a.getDateTime().toLocalTime().toString() + "   "  + currentTripDay.getCity().getName());
        }
    }

    public void initializeTripList(){
        TripList list = DaoFactory.getInstance().getTripDao().tripList();
        TripList availableList = new TripList();
        for(Trip trip : list.getList()){
            if (!trip.isRegistered()){
                availableList.addEntity(trip);
            }
        }
        if(user != null){
            for(Trip trip : (ArrayList<Trip>) user.getUserList().getList()){
                availableList.addEntity(trip);
            }
        }
        availableList.sort();
        for(Trip t : availableList.getList()){
            tripListView.getItems().add(t.getName());
        }
        tripListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    String tripName = tripListView.getSelectionModel().getSelectedItem();
                    controller.viewTrip(tripName);
                }
            }
        });
    }

    public void viewFirstDay(){
        controller.viewFirstDay(currentTrip);
    }

    public static void setUser(User newUser) {
        user = newUser;
    }

    public static void setTrip(Trip trip) {
        currentTrip = trip;
    }

    public static void setTripDay(TripDay newTripDay) {
        currentTripDay = newTripDay;
    }

    public void nextDay(){
        controller.changeDay(1, currentTripDay, currentTrip);
    }

    public void previousDay(){
        controller.changeDay(-1, currentTripDay, currentTrip);
    }

    public void quit(){
        controller.quit();
    }

}
