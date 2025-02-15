package pera.trip_planner.view.gui;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicShowTripController;
import pera.trip_planner.controller.logic_controller.CreateTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.ActivityInstance;
import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;
import pera.trip_planner.model.domain.User;
import pera.trip_planner.model.domain.entity_lists.ActivityInstanceList;
import pera.trip_planner.model.domain.entity_lists.TripList;

import java.util.ArrayList;
import java.util.Optional;

public class GuiGraphicShowTripControllerView extends GenericGuiGraphicView{
    private final GuiGraphicShowTripController controller = GuiGraphicShowTripController.getInstance();
    private final String ERROR_MESSAGE = "Error in showTrip GUI";
    private static User user;
    protected static Trip currentTrip;
    protected static TripDay currentTripDay;
    @FXML
    protected ListView<String> tripListView;
    @FXML
    protected Label tripNameLabel;
    @FXML
    protected Label countryNameLabel;
    @FXML
    protected Label startDateLabel;
    @FXML
    protected Label endDateLabel;
    @FXML
    protected Label tripNameDaysLabel;
    @FXML
    protected Label dayInfoLabel;
    @FXML
    protected ListView<String> activitiesListView;


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

    public void initializeTripInfoLabels() {
        tripNameLabel.setText(currentTrip.getName());
        countryNameLabel.setText("Country: " + currentTrip.getCountry().getName());
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
                    callControllerViewTrip(tripName);
                }
            }
        });
    }

    public void callControllerViewTrip(String tripName) {
        controller.viewTrip(tripName);
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

    public void showLoginChoice() {
        Alert loginAlert = new Alert(Alert.AlertType.CONFIRMATION);
        loginAlert.setContentText("Do you want to login?");
        loginAlert.setTitle("Login");
        Optional<ButtonType> choice = loginAlert.showAndWait();
        if(choice.get() == ButtonType.OK){
            controller.startLogin();
        } else{
            controller.showTripList(null);
        }
    }

    public void newTrip(){
        CreateTripController.getInstance().start();
    }
}
