package pera.trip_planner.controller.graphic_controller.text_graphic_controller;

import pera.trip_planner.controller.bean.AddActivityInstanceToDayBean;
import pera.trip_planner.controller.bean.AddDayToNewTripBean;
import pera.trip_planner.controller.bean.CreateNewTripBean;
import pera.trip_planner.controller.bean.ViewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.controller.logic_controller.CreateTripController;
import pera.trip_planner.controller.logic_controller.LoginController;
import pera.trip_planner.controller.logic_controller.ShowTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.*;
import pera.trip_planner.view.text.TextGraphicCreateTripControllerView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TextGraphicCreateTripController implements GraphicCreateTripController {
    private TextGraphicCreateTripControllerView view = new TextGraphicCreateTripControllerView();
    private CreateTripController controller = CreateTripController.getInstance();

    @Override
    public void createTrip() {
        String name;
        String countryName;
        LocalDate startDate;
        LocalDate endDate;
        long duration;

        name = view.getString("Insert name for trip: ");
        view.showCountries();
        while(true){
            countryName = view.getString("Insert country for trip " + name + ": ");
            Country country = DaoFactory.getInstance().getCountryDao().load(countryName);
            if(country == null){
                view.showMessage("Country not found, try again");
            } else{
                break;
            }
        }
        startDate = view.getDate("Insert start date for trip " + name);
        endDate = view.getDate("Insert end date for trip " + name);
        if(startDate.isAfter(endDate)){
            LocalDate temp = startDate;
            startDate = endDate;
            endDate = temp;
        }
        duration = ChronoUnit.DAYS.between(startDate, endDate);
        CreateNewTripBean bean = new CreateNewTripBean(countryName, startDate, endDate, name, duration);
        controller.createNewTrip(bean);
    }

    @Override
    public void addDays(Trip trip, long duration){
        DayOfWeek dayType;
        String cityName;
        LocalDate currentDate;
        for(int i = 0; i < duration; i++) {
            currentDate = trip.getStartDate().plusDays(i);
            dayType = currentDate.getDayOfWeek();
            view.showCities(trip.getCountry());
            while (true) {
                cityName = view.getString("Insert city for day " + currentDate.toString() + ": ");
                City city = trip.getCountry().getCities().getEntityByName(cityName);
                if (city == null) {
                    view.showMessage("City not found, try again");
                } else {
                    break;
                }
            }
            AddDayToNewTripBean bean = new AddDayToNewTripBean(dayType, cityName, currentDate);
            controller.addDayToNewTrip(trip, bean);
        }
        controller.storeTrip(trip);
    }

    @Override
    public void addActivityInstanceList(Trip trip, TripDay day) {
        boolean choice = true;
        Activity activity;
        LocalDateTime activityDateTime;

        while(choice){
            activity = getActivity(day);
            while(true){
                activityDateTime = view.getDateTime(day.getDate(), "Insert the time for the selected activity");
                LocalTime time = activityDateTime.toLocalTime();
                DayInfo info = activity.getDayInfo(day.getDate().getDayOfWeek());
                if(info != null){
                    if(time.isBefore(info.getOpenTime()) || time.isAfter(info.getCloseTime())){
                        view.showMessage("Activity is closed during that time, enter a valid one");
                    }
                } else {
                    break;
                }
            }
            AddActivityInstanceToDayBean bean = new AddActivityInstanceToDayBean(activity.getName(), activityDateTime);
            controller.addActivityInstanceToDay(day, bean);
            choice = view.getBooleanChoice("Do you want to add more activities?");
        }
        controller.storeTripDay(trip, day);
    }

    private Activity getActivity(TripDay day) {
        Activity activity;
        while(true){
            view.showActivities(day.getCity());
            String activityName = view.getString("Insert the activity you want to add to day " + day.getDate().toString() + ": ");
            activity = day.getCity().getActivities().getEntityByName(activityName);
            if(activity == null){
                view.showMessage("Activity not found, try again");
            } else{
                break;
            }
        }
        return activity;
    }

    @Override
    public void done(Trip trip) {
        if(!trip.isRegistered()){
            boolean choice = view.getBooleanChoice("Trip succesfully created and saved, would you like to visualize it?");
            if(choice){
                ShowTripController showTripController = ShowTripController.getInstance();
                showTripController.viewTrip(new ViewTripBean(trip.getName()));
            }
            choice = view.getBooleanChoice("Do you want to add the trip to your account?");
            if(choice){
                controller.saveToAccount(trip);
                controller.finishSavingToAccount(trip, LoginController.getInstance().retrieveUser());
                view.showMessage("Done");
            }
        }
    }
}