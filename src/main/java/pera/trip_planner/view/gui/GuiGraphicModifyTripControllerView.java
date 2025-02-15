package pera.trip_planner.view.gui;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicModifyTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.*;
import pera.trip_planner.model.domain.entity_lists.ActivityList;
import pera.trip_planner.model.domain.entity_lists.CountryList;

import java.time.LocalDate;

public class GuiGraphicModifyTripControllerView extends GuiGraphicShowTripControllerView {
    private final GuiGraphicModifyTripController controller = GuiGraphicModifyTripController.getInstance();
    private static final String ERROR_MESSAGE = "Error in modify trip GUI";
    @FXML
    private ListView<String> countryListView;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private ListView<String> addActivitiesListView;
    @FXML
    private Slider hourSlider;
    @FXML
    private Slider minutesSlider;


    @Override
    public void showTripList(User user) {
        setUser(user);
        setScene("view/modifyTripSelectTrip", ERROR_MESSAGE);
    }

    @Override
    public void showTripInfo(Trip trip) {
        setTrip(trip);
        setScene("view/modifyTripInfo", ERROR_MESSAGE);
    }

    @Override
    public void initialize(){
        if(tripListView != null) {
            initializeTripList();
        } else if(countryListView != null) {
            initializeCountryList();
        } else if(tripNameLabel != null){
            initializeTripInfoLabels();
        } else if(tripNameDaysLabel != null){
            initializeDaysInfoLabels();
            initializeActivitiesList();
        } else if(addActivitiesListView != null) {
            initializeSelectActivitiesList();
        }
    }

    public void initializeSelectActivitiesList(){
        ActivityList activities = currentTripDay.getCity().getActivities();
        activities.sort();
        for(Activity a : activities.getList()){
            addActivitiesListView.getItems().add(a.getName());
        }
    }

    public void initializeCountryList(){
        CountryList countries = DaoFactory.getInstance().getCountryDao().countryList();
        countries.sort();
        for(Country c : countries.getList()){
            countryListView.getItems().add(c.getName());
        }
        countryListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    String tripCountry = countryListView.getSelectionModel().getSelectedItem();
                    controller.modifyTripCountry(tripCountry);
                }
            }
        });
    }

    @Override
    public void callControllerViewTrip(String tripName) {
        controller.modifyTrip(tripName);
    }

    public void modifyName(){
        String newName = getString("Insert new name", "Change name");
        controller.modifyName(newName);
    }

    public void modifyCountry(){
        setScene("view/modifyTripSelectCountry", ERROR_MESSAGE);
    }

    public void modifyDates(){
        setScene("view/modifyTripSelectDates", ERROR_MESSAGE);
    }

    public void changeDays(){
        controller.selectTripDay(currentTrip, currentTrip.getTripDays().getEntityByName(currentTrip.getStartDate().toString()));
    }

    public void setNewDates(){
        LocalDate tripStartDate = startDatePicker.getValue();
        LocalDate tripEndDate = endDatePicker.getValue();
        if(tripStartDate == null || tripEndDate == null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Insert a valid start and end date");
            a.show();
        } else{
            if(tripStartDate.isAfter(tripEndDate)){
                LocalDate temp = tripStartDate;
                tripStartDate = tripEndDate;
                tripEndDate = temp;
            }
            controller.modifyTripDates(tripStartDate, tripEndDate);
        }
    }

    public void addActivity(){
        setScene("view/modifyTripAddActivity", ERROR_MESSAGE);
    }

    public void removeActivity(){
        String activity = addActivitiesListView.getSelectionModel().getSelectedItem();
        if(activity == null){
            showAlert("Choose an activity");
        } else{
            String activityName = activity.split(" ")[0];
            controller.removeActivity(activityName);
        }
    }

    @Override
    public void nextDay(){
        controller.changeDay(1, currentTripDay, currentTrip);
    }

    @Override
    public void previousDay(){
        controller.changeDay(-1, currentTripDay, currentTrip);
    }

    public void showDayInfo(TripDay day) {
        setTripDay(day);
        setScene("view/modifyTripDay", ERROR_MESSAGE);
    }

    public void done(){
        controller.storeTrip();
    }

    public void addActivityToDay(){
        if(addActivitiesListView.getSelectionModel().getSelectedItem() == null){
            showAlert("Choose an activity");
        } else{
            String activityName = addActivitiesListView.getSelectionModel().getSelectedItem();
            int hour = (int) hourSlider.getValue();
            int minutes = (int) minutesSlider.getValue();
            controller.addActivity(currentTripDay, activityName, hour, minutes);
        }
    }
}
