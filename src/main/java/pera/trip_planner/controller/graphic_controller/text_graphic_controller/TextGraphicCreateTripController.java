package pera.trip_planner.controller.graphic_controller.text_graphic_controller;

import pera.trip_planner.controller.bean.AddActivityInstanceToDayBean;
import pera.trip_planner.controller.bean.AddDayToNewTripBean;
import pera.trip_planner.controller.bean.CreateNewTripBean;
import pera.trip_planner.controller.bean.ViewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.controller.logic_controller.Controller;
import pera.trip_planner.controller.logic_controller.CreateTripController;
import pera.trip_planner.controller.logic_controller.ShowTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.*;
import pera.trip_planner.view.TextGraphicCreateTripControllerView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TextGraphicCreateTripController implements GraphicCreateTripController {
    private TextGraphicCreateTripControllerView view = new TextGraphicCreateTripControllerView();
    private CreateTripController controller;

    @Override
    public void createTrip() {
        String name;
        Country country;
        LocalDate startDate;
        LocalDate endDate;
        long duration;

        controller = CreateTripController.getInstance();
        name = view.getString("Insert name for trip: ");
        view.showCountries();
        while(true){
            String countryName = view.getString("Insert country for trip " + name + ": ");
            country = DaoFactory.getInstance().getCountryDao().load(countryName);
            if(country == null){
                System.out.println("Country not found, try again");
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
        CreateNewTripBean bean = new CreateNewTripBean(country, startDate, endDate, name, duration);
        controller.createNewTrip(bean);
    }

    @Override
    public void addDay(Trip trip, int dayNumber){
        DayOfWeek dayType;
        City city;
        LocalDate currentDate;

        currentDate = trip.getStartDate().plusDays(dayNumber);
        dayType = currentDate.getDayOfWeek();
        view.showCities(trip.getCountry());
        while(true){
            String cityName = view.getString("Insert city for day " + currentDate.toString() + ": ");
            city = trip.getCountry().getCities().getEntityByName(cityName);
            if(city == null){
                System.out.println("City not found, try again");
            } else{
                break;
            }
        }
        AddDayToNewTripBean bean = new AddDayToNewTripBean(dayType, city, currentDate);
        controller.addDayToNewTrip(trip, bean);
    }

    @Override
    public void addActivityInstanceList(TripDay day) {
        boolean choice = true;
        Activity activity;
        LocalDateTime activityDateTime;

        while(choice){
            while(true){
                view.showActivities(day.getCity());
                String activityName = view.getString("Insert the activity you want to add to day " + day.getDate().toString() + ": ");
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
            AddActivityInstanceToDayBean bean = new AddActivityInstanceToDayBean(activity, activityDateTime);
            controller.addActivityInstanceToDay(day, bean);
            choice = view.getChoice("Do you want to add more activities?");
        }
    }

    @Override
    public void done(Trip trip) {
        boolean choice = view.getChoice("Trip succesfully created and saved, would you like to visualize it?");
        if(choice){
            ShowTripController controller = ShowTripController.getInstance();
            controller.viewTrip(new ViewTripBean(trip.getName()));
        }
    }
}