package pera.trip_planner.view.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicCreateTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.Activity;
import pera.trip_planner.model.domain.City;
import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.TripDay;
import pera.trip_planner.model.domain.entity_lists.ActivityList;
import pera.trip_planner.model.domain.entity_lists.CityList;
import pera.trip_planner.model.domain.entity_lists.CountryList;

import java.time.LocalDate;

public class GuiGraphicCreateTripControllerView extends GenericGuiGraphicView {
    private final GuiGraphicCreateTripController controller = GuiGraphicCreateTripController.getInstance();
    private static final String GUI_ERROR = "Error in create trip gui";
    private static Country currentCountry;
    private static LocalDate currentDate;
    private static TripDay currentTripDay;
    @FXML
    private ListView<String> countryListView;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private Label selectCityLabel;
    @FXML
    private ListView<String> cityListView;
    @FXML
    private ListView<String> activitiesListView;
    @FXML
    private Label addActivitiesLabel;
    @FXML
    private Slider hourSlider;
    @FXML
    private Slider minutesSlider;

    public void start(){
        setScene("view/createTripAddName", GUI_ERROR);
    }

    @FXML
    public void initialize(){
        if(countryListView != null){
            initializeCountryList();
        }
        if(selectCityLabel != null && cityListView != null){
            initializeCityLabel();
            initializeCityList();
        }
        if(addActivitiesLabel != null && activitiesListView != null){
            initializeActivitiesLabel();
            initializeActivitiesList();
        }
    }

    private void initializeCityLabel() {
        selectCityLabel.setText("Select city\nDay: " + currentDate.toString());
    }

    private void initializeActivitiesLabel() {
        addActivitiesLabel.setText("Add activities to day: " + currentDate.toString() + "\nCity: " + currentTripDay.getCity().getName());
    }

    private void initializeCityList() {
        CityList cities = currentCountry.getCities();
        cities.sort();
        for(City c : cities.getList()){
            cityListView.getItems().add(c.getName());
        }
        cityListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    String tripCity = cityListView.getSelectionModel().getSelectedItem();
                    controller.setDayCity(tripCity);
                    controller.addNewDay();
                }
            }
        });
    }

    public void initializeCountryList(){
        CountryList countries = DaoFactory.getInstance().getCountryDao().countryList();
        countries.sort();
        for(Country c : countries.getList()){
            countryListView.getItems().add(c.countryName());
        }
        countryListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    String tripCountry = countryListView.getSelectionModel().getSelectedItem();
                    controller.setTripCountry(tripCountry);
                    setScene("view/createTripSelectDates", GUI_ERROR);
                }
            }
        });
    }

    private void initializeActivitiesList() {
        ActivityList activities = currentTripDay.getCity().getActivities();
        activities.sort();
        for(Activity a : activities.getList()){
            activitiesListView.getItems().add(a.getName());
        }
    }

    public void getTripName(ActionEvent actionEvent) {
        TextField tf = (TextField) actionEvent.getSource();
        String tripName = tf.getText();
        if (tripName == null || tripName.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Insert a valid trip name");
            a.show();
        } else{
            controller.setTripName(tripName);
            setScene("view/createTripSelectCountry", GUI_ERROR);
        }
    }

    public void setDates(){
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
            controller.setTripDates(tripStartDate, tripEndDate);
            controller.createNewTrip();
        }
    }

    public void showCities(Country country, LocalDate date) {
        setCurrentDateCountry(country, date);
        setScene("view/createTripSelectCity", GUI_ERROR);
    }

    public void showActivities(TripDay day){
        setCurrentDay(day);
        setScene("view/createTripAddActivities", GUI_ERROR);
    }

    private static void setCurrentDay(TripDay day) {
        currentTripDay = day;
    }

    public static void setCurrentDateCountry(Country country, LocalDate date){
        currentCountry = country;
        currentDate = date;
    }

    public void addActivity(){
        if(activitiesListView.getSelectionModel().getSelectedItem() == null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select one activity");
            a.show();
        } else{
            String activityName = activitiesListView.getSelectionModel().getSelectedItem();
            int hour = (int) hourSlider.getValue();
            int minutes = (int) minutesSlider.getValue();
            controller.addNewActivity(currentTripDay, activityName, hour, minutes);
        }
    }

    public void activityClosed() {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Activity is closed during that time, enter a valid one");
        a.show();
    }

    public void saveDay(){
        controller.storeDay(currentTripDay);
        controller.addDay();
    }

}
