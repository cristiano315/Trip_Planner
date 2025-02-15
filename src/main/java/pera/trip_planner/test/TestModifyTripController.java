package pera.trip_planner.test;

import org.testng.annotations.Test;
import pera.trip_planner.controller.bean.ModifyTripBean;
import pera.trip_planner.controller.logic_controller.ModifyTripController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.dao.GraphicProvider;
import pera.trip_planner.model.dao.PersistenceProvider;
import pera.trip_planner.model.domain.Trip;

import static org.testng.Assert.assertEquals;

public class TestModifyTripController { //cristiano pera
    @Test
    public void testModifyName(){
        GraphicControllerFactory.setGraphicProvider(GraphicProvider.TEXT);
        DaoFactory.setPersistenceProvider(PersistenceProvider.IN_MEMORY);
        ModifyTripController controller = ModifyTripController.getInstance();

        Trip trip1 = DaoFactory.getInstance().getTripDao().create("tripTest");

        controller.modifyName(trip1, new ModifyTripBean("test", null, null, null));

        assertEquals(trip1.getName(), "test");
    }
}
