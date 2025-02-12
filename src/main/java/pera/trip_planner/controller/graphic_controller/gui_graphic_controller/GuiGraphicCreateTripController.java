package pera.trip_planner.controller.graphic_controller.gui_graphic_controller;

import pera.trip_planner.controller.bean.AddActivityInstanceToDayBean;
import pera.trip_planner.controller.bean.AddDayToNewTripBean;
import pera.trip_planner.controller.bean.CreateNewTripBean;
import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.controller.logic_controller.CreateTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.*;
import pera.trip_planner.view.gui.GuiGraphicCreateTripControllerView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class GuiGraphicCreateTripController implements GraphicCreateTripController {
    private CreateTripController controller = CreateTripController.getInstance();
    private static final String UNSUPPORTED_MESSAGE = "Not supported yet.";
    private static GuiGraphicCreateTripController instance;
    private GuiGraphicCreateTripControllerView view;
    //params for logic controller
    private String tripName;
    private Country tripCountry;
    private LocalDate tripStartDate;
    private LocalDate tripEndDate;
    private long duration;

    private City currentCity;
    private DayOfWeek currentDayType;
    private LocalDate currentDate;
    private Trip currentTrip;

    private TripDay currentTripDay;

    public static GuiGraphicCreateTripController getInstance() {
        if (instance == null) {
            instance = new GuiGraphicCreateTripController();
        }
        return instance;
    }

    @Override
    public void createTrip() {
        view = new GuiGraphicCreateTripControllerView();
        view.start();
    }

    @Override
    public void addDay(Trip trip, int dayNumber){
        currentDate = trip.getStartDate().plusDays(dayNumber);
        currentTrip = trip;
        currentDayType = currentDate.getDayOfWeek();
        view.showCities(trip.getCountry(), currentDate);
    }

    @Override
    public void addActivityInstanceList(TripDay day) {
        currentTripDay = day;
        view.showActivities(day);
    }

    @Override
    public void done(Trip trip) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void setTripName(String name) {
        this.tripName = name;
    }

    public void setTripCountry(String tripCountry) {
        Country country = DaoFactory.getInstance().getCountryDao().load(tripCountry);
        if(country == null) {
            throw new IllegalArgumentException("Country not found");
        }
        this.tripCountry = country;
    }


    public void setTripDates(LocalDate tripStartDate, LocalDate tripEndDate) {
        this.tripStartDate = tripStartDate;
        this.tripEndDate = tripEndDate;
        this.duration = ChronoUnit.DAYS.between(tripStartDate, tripEndDate);
    }

    public void setDayCity(String tripCity) {
        City city = tripCountry.getCities().getEntityByName(tripCity);
        if(city == null) {
            throw new IllegalArgumentException("City not found");
        }
        this.currentCity = city;
    }

    public void createNewTrip() {
        controller.createNewTrip(new CreateNewTripBean(tripCountry, tripStartDate, tripEndDate, tripName, duration));
    }

    public void addNewDay(){
        controller.addDayToNewTrip(currentTrip, new AddDayToNewTripBean(currentDayType, currentCity, currentDate));
    }

    public void addNewActivity(TripDay day, String name, int hour, int minutes) {
        Activity activity = day.getCity().getActivities().getEntityByName(name);
        if(activity == null) {
            throw new IllegalArgumentException("Activity not found");
        }
        LocalTime time = LocalTime.of(hour, minutes);
        DayInfo info = activity.getDayInfo(day.getDate().getDayOfWeek());
        if(info != null){
            if(time.isBefore(info.getOpenTime()) || time.isAfter(info.getCloseTime())){
                view.activityClosed();
            }
        } else {
            LocalDateTime dateTime = LocalDateTime.of(day.getDate(), time);
            controller.addActivityInstanceToDay(day, new AddActivityInstanceToDayBean(activity, dateTime));
        }
    }
}
