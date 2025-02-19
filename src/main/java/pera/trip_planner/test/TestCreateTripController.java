package pera.trip_planner.test;

import org.testng.annotations.Test;
import pera.trip_planner.controller.bean.AddActivityInstanceToDayBean;
import pera.trip_planner.controller.logic_controller.CreateTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.dao.GraphicProvider;
import pera.trip_planner.model.dao.PersistenceProvider;
import pera.trip_planner.model.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestCreateTripController { //cristiano pera
    @Test
    public void testFinishSavingToAccount(){
        GraphicControllerFactory.setGraphicProvider(GraphicProvider.TEXT);
        DaoFactory.setPersistenceProvider(PersistenceProvider.IN_MEMORY);
        CreateTripController controller = CreateTripController.getInstance();

        Trip testTrip = DaoFactory.getInstance().getTripDao().create("testTrip");

        User testUser = DaoFactory.getInstance().getUserDao().create("testUser");
        testUser.setRole(Role.USER);

        controller.finishSavingToAccount(testTrip, testUser);

        assertTrue(testTrip.isRegistered());
        assertEquals(testUser.getUserList().getList().get(0).getName(), "testTrip");
        assertTrue(testUser.getUserList().getList().get(0).isRegistered());
    }

    @Test
    public void testAddActivityInstanceToDay(){
        GraphicControllerFactory.setGraphicProvider(GraphicProvider.TEXT);
        DaoFactory.setPersistenceProvider(PersistenceProvider.IN_MEMORY);
        CreateTripController controller = CreateTripController.getInstance();

        TripDay day = DaoFactory.getInstance().getTripDayDao().create(LocalDate.of(2022, 2, 2));

        Activity activity1 = DaoFactory.getInstance().getActivityDao().create("activity");

        LocalDateTime time = LocalDateTime.of(LocalDate.of(2022, 2, 2), LocalTime.of(10, 10));

        controller.addActivityInstanceToDay(day, new AddActivityInstanceToDayBean(activity1.getName(), time));

        assertEquals(day.getActivityInstanceList().getList().get(0).getActivity().getName(), "activity");
        assertEquals(day.getActivityInstanceList().getList().get(0).getDateTime(), LocalDateTime.of(LocalDate.of(2022, 2, 2), LocalTime.of(10, 10)));
    }
}
