package pera.trip_planner.controller.task;

import javafx.concurrent.Task;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicCreateTripController;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicShowTripController;

public class CreateTripTask extends Task<Boolean> {
    @Override
    public Boolean call() {
        GuiGraphicCreateTripController controller = GuiGraphicCreateTripController.getInstance();
        boolean done = true;
        while(done) {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            done = controller.isRunning();
        }
        return done;
    }
}
