package pera.trip_planner.controller.task;

import javafx.concurrent.Task;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicShowTripController;


public class ShowTripTask extends Task<Boolean> {
    @Override
    public Boolean call() {
        GuiGraphicShowTripController controller = GuiGraphicShowTripController.getInstance();
        boolean done = true;
        while(done) {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            done = controller.isRunning();
        }
        return done;
    }
}
