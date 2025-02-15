package pera.trip_planner.controller.graphic_controller.gui_graphic_controller;

import javafx.concurrent.Task;
import pera.trip_planner.controller.bean.AddActivityInstanceToDayBean;
import pera.trip_planner.controller.bean.ModifyTripBean;
import pera.trip_planner.controller.bean.ViewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.GraphicModifyTripController;
import pera.trip_planner.controller.logic_controller.ModifyTripController;
import pera.trip_planner.controller.logic_controller.ShowTripController;
import pera.trip_planner.controller.task.LoginTask;
import pera.trip_planner.controller.task.ShowTripTask;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.domain.*;
import pera.trip_planner.view.gui.GuiGraphicModifyTripControllerView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class GuiGraphicModifyTripController implements GraphicModifyTripController {
    private static GuiGraphicModifyTripController instance;
    private GuiGraphicModifyTripControllerView view;
    private ModifyTripController controller = ModifyTripController.getInstance();
    private Trip currentTrip;
    private TripDay currentDay;

    private GuiGraphicModifyTripController() {}

    public static GuiGraphicModifyTripController getInstance() {
        if (instance == null) {
            instance = new GuiGraphicModifyTripController();
            instance.view = new GuiGraphicModifyTripControllerView();
        }
        return instance;
    }

    @Override
    public void login() {
        boolean choice = view.showConfirmationChoice("Would you like to log in?", "Login");
        if(choice){
            controller.login();
            Task<User> task = new LoginTask();
            task.setOnSucceeded(e -> {
                User result = task.getValue();
                controller.finishLogin(result);
            });
            new Thread(task).start();
        } else{
            showTripList(null);
        }
    }

    @Override
    public void showTripList(User user) {
        view.showTripList(user);
    }

    @Override
    public void modifyTripInfo(Trip trip) {
        currentTrip = trip;
        view.showTripInfo(trip);
    }

    @Override
    public void done(Trip trip) {
        boolean choice = view.showConfirmationChoice("Trip successfully modified and saved, would you like to visualize it?", "Done");
        if(choice){
            ShowTripController showTripController = ShowTripController.getInstance();
            GuiGraphicShowTripController.getInstance().setRunning();
            showTripController.viewTrip(new ViewTripBean(trip.getName()));
            Task<Boolean> task = new ShowTripTask();
            task.setOnSucceeded(e -> {
                endCase();
            });
            new Thread(task).start();
        } else{
            endCase();
        }
    }

    @Override
    public void selectTripDay(Trip trip, TripDay day) {
        currentDay = day;
        view.showDayInfo(day);
    }

    public void modifyTrip(String tripName) {
        controller.modifyTrip(new ViewTripBean(tripName));
    }

    public void modifyName(String newName) {
        controller.modifyName(currentTrip, new ModifyTripBean(newName, null, null, null));
        view.showAlert("Trip name changed successfully");
        controller.storeTrip(currentTrip);
    }

    public void modifyTripCountry(String tripCountry) {
        Country country = DaoFactory.getInstance().getCountryDao().load(tripCountry);
        if(country == null){
            throw new IllegalArgumentException("Invalid country");
        } else{
            controller.modifyCountry(currentTrip, new ModifyTripBean(null, country, null, null));
        }
    }

    public void endCase(){
        GraphicControllerFactory.getGraphicControllerFactory().getGraphicApplicationController().runApplication();
    }

    public void modifyTripDates(LocalDate tripStartDate, LocalDate tripEndDate) {
        if(tripStartDate == null || tripEndDate == null){
            throw new IllegalArgumentException("Invalid trip start/end date");
        }
        if(tripStartDate.isAfter(tripEndDate)){
            LocalDate temp = tripStartDate;
            tripStartDate = tripEndDate;
            tripEndDate = temp;
        }
        controller.modifyDates(currentTrip, new ModifyTripBean(null, null, tripStartDate, tripEndDate));
    }

    public void changeDay(int choice, TripDay day, Trip trip) {
        TripDay newDay;
        if(choice == 1){
            if(day.getDate().plusDays(1).isEqual(trip.getEndDate())){
                view.showAlert("Choice invalid: day not in trip");
            } else {
                newDay = trip.getTripDays().getEntityByName(day.getDate().plusDays(1).toString());
                currentDay = newDay;
                view.showDayInfo(newDay);
            }
        } else if(choice == -1){
            if(day.getDate().minusDays(1).isBefore(trip.getStartDate())){
                view.showAlert("Choice invalid: day not in trip");
            } else {
                newDay = trip.getTripDays().getEntityByName(day.getDate().minusDays(1).toString());
                currentDay = newDay;
                view.showDayInfo(newDay);
            }
        } else {
            throw new IllegalArgumentException("choice invalid");
        }
    }

    public void storeTrip(){
        controller.storeTrip(currentTrip);
    }

    public void removeActivity(String activityName) {
        Activity activity = currentDay.getCity().getActivities().getEntityByName(activityName);
        if(activity == null){
            throw new IllegalArgumentException("Invalid activity");
        }
        controller.removeActivity(currentDay, new AddActivityInstanceToDayBean(activity, null));
        view.showAlert("Activity succesfully removed");
        view.showDayInfo(currentDay);
    }

    public void addActivity(TripDay currentTripDay, String activityName, int hour, int minutes) {
        Activity activity = currentTripDay.getCity().getActivities().getEntityByName(activityName);
        if(activity == null) {
            throw new IllegalArgumentException("Invalid activity");
        }
        LocalDateTime activityDateTime = LocalDateTime.of(currentTripDay.getDate(), LocalTime.of(hour, minutes));
        LocalTime time = activityDateTime.toLocalTime();
        DayInfo info = activity.getDayInfo(currentTripDay.getDate().getDayOfWeek());
        if(info != null && time.isBefore(info.getOpenTime()) || time.isAfter(Objects.requireNonNull(info).getCloseTime())) {
            view.showAlert("Activity is closed during that time, enter a valid one");
            return;
        }
        controller.addActivity(currentTripDay, new AddActivityInstanceToDayBean(activity, activityDateTime));
        view.showAlert("Activity added successfully");
        view.showDayInfo(currentDay);
    }
}
