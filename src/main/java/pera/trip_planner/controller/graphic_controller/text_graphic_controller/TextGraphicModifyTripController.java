package pera.trip_planner.controller.graphic_controller.text_graphic_controller;

import pera.trip_planner.controller.bean.AddActivityInstanceToDayBean;
import pera.trip_planner.controller.bean.AddDayToNewTripBean;
import pera.trip_planner.controller.bean.ModifyTripBean;
import pera.trip_planner.controller.bean.ViewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicModifyTripController;
import pera.trip_planner.controller.logic_controller.ModifyTripController;
import pera.trip_planner.controller.logic_controller.ShowTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.*;
import pera.trip_planner.view.TextGraphicModifyTripControllerView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TextGraphicModifyTripController implements GraphicModifyTripController {
    private ModifyTripController controller = ModifyTripController.getInstance();
    private TextGraphicModifyTripControllerView view = new TextGraphicModifyTripControllerView();
    private String illegalChoiceError = "Illegal choice";

    @Override
    public void showTripList(User user) {
        view.showAvailableTrips(user);
        while(true){
            String trip = view.getString("Select a trip to visualize: ");
            if(DaoFactory.getInstance().getTripDao().load(trip) != null) {
                controller.modifyTrip(new ViewTripBean(trip));
                break;
            } else{
                System.out.println("Insert a valid trip");
            }
        }
    }

    @Override
    public void modifyTripInfo(Trip trip) {
        view.showTripInfo(trip);
        int choice = view.getTripInfoChoice();
        switch(choice){
            case 1: //name
                String name = view.getString("Enter new name: ");
                controller.modifyName(trip, new ModifyTripBean(name, null, null, null));
                break;
            case 2: //country
                Country country;
                view.showCountries();
                while(true){
                    String countryName = view.getString("Insert new country: ");
                    country = DaoFactory.getInstance().getCountryDao().load(countryName);
                    if(country == null){
                        System.out.println("Country not found, try again");
                    } else{
                        break;
                    }
                }
                controller.modifyCountry(trip, new ModifyTripBean(null, country, null, null));
                break;
            case 3: //dates
                LocalDate startDate = view.getDate("Insert new start date");
                LocalDate endDate = view.getDate("Insert new end date");
                if(startDate.isAfter(endDate)){
                    LocalDate temp = startDate;
                    startDate = endDate;
                    endDate = temp;
                }
                controller.modifyDates(trip, new ModifyTripBean(null, null, startDate, endDate));
                break;
            case 4: //days
                selectTripDay(trip, trip.getTripDays().getEntityByName(trip.getStartDate().toString()));
                break;
            default:
                throw new IllegalArgumentException(illegalChoiceError);
        }

    }

    @Override
    public void login() {
        boolean choice = view.getBooleanChoice("Would you like to log in?");
        if(choice){
            controller.login();
        } else{
            showTripList(null);
        }
    }

    @Override
    public void done(Trip trip) {
        boolean choice = view.getBooleanChoice("Trip succesfully modified and saved, would you like to visualize it?");
        if(choice){
            ShowTripController showTripController = ShowTripController.getInstance();
            showTripController.viewTrip(new ViewTripBean(trip.getName()));
        }
    }

    @Override
    public void selectTripDay(Trip trip, TripDay day) {
        view.showDayInfo(day);
        for(ActivityInstance a : day.getActivityInstanceList().getList()){
            view.showActivityInstance(a);
        }
        boolean running = true;
        while(running){
            int choice = view.getDayChoice();
            switch(choice){
                case 0:
                    running = false;
                    break;
                case 1:
                    if(day.getDate().plusDays(1).isEqual(trip.getEndDate())){
                        System.out.println("Choice invalid: day not in trip");
                    } else {
                        selectTripDay(trip, trip.getTripDays().getEntityByName(day.getDate().plusDays(1).toString()));
                        running = false;
                    }
                    break;
                case -1:
                    if(day.getDate().minusDays(1).isBefore(trip.getStartDate())){
                        System.out.println("Choice invalid: day not in trip");
                    } else {
                        selectTripDay(trip, trip.getTripDays().getEntityByName(day.getDate().minusDays(1).toString()));
                        running = false;
                    }
                    break;
                case 2:
                    modifyTripDay(trip, day);
                    System.out.println("Day modified successfully");
                    break;
                default:
                    throw new IllegalArgumentException(illegalChoiceError);
            }
        }
    }

    @Override
    public void modifyTripDay(Trip trip, TripDay day) {
        int choice = view.getDayModificationChoice();
        if(choice == 1){ //city
            City city;
            view.showCities(trip.getCountry());
            while(true){
                String cityName = view.getString("Insert new city: ");
                city = trip.getCountry().getCities().getEntityByName(cityName);
                if(city == null){
                    System.out.println("City not found, try again");
                } else{
                    break;
                }
            }
            controller.modifyDayCity(day, new AddDayToNewTripBean(null, city, null));
        } else if (choice == 2){
            showAndModifyActivities(day);
        }
    }

    public void showAndModifyActivities(TripDay day){
        System.out.println("Current activities: ");
        System.out.println(day.getActivityInstanceList().toString());
        Activity activity;
        LocalDateTime activityDateTime;
        while(true){
            int choice = view.getActivitiesChoice();
            if(choice == 1){ //delete
                while(true){
                    String activityName = view.getString("Insert the activity you want to delete: ");
                    activity = day.getCity().getActivities().getEntityByName(activityName);
                    if(activity == null){
                        System.out.println("Activity not found, try again");
                    } else{
                        break;
                    }
                }
                controller.removeActivity(day, new AddActivityInstanceToDayBean(activity, null));
            } else if(choice == 2){ //add
                while(true){
                    view.showActivities(day.getCity());
                    String activityName = view.getString("Insert the activity you want to add: ");
                    activity = day.getCity().getActivities().getEntityByName(activityName);
                    if(activity == null){
                        System.out.println("Activity not found, try again");
                    } else{
                        break;
                    }
                }
                while(true){
                    activityDateTime = view.getDateTime(day.getDate(), "Insert the time for the selected activity");
                    LocalTime time = activityDateTime.toLocalTime();
                    DayInfo info = activity.getDayInfo(day.getDate().getDayOfWeek());
                    if(info != null){
                        if(time.isBefore(info.getOpenTime()) || time.isAfter(info.getCloseTime())){
                            System.out.println("Activity is closed during that time, enter a valid one");
                        }
                    } else {
                        break;
                    }
                }

                controller.addActivity(day, new AddActivityInstanceToDayBean(activity, activityDateTime));
            } else if(choice == 0){ //back
                break;
            } else {
                throw new IllegalArgumentException(illegalChoiceError);
            }
        }
    }
}
