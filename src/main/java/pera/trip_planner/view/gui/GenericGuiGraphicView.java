package pera.trip_planner.view.gui;

import pera.trip_planner.exception.GuiException;

import java.io.IOException;

public abstract class GenericGuiGraphicView {
    protected void setScene(String fxml, String error){
        try{
            GuiGraphicApplicationControllerView.setRoot(fxml);
        } catch (IOException e) {
            e.printStackTrace();
            throw new GuiException(error);
        }
    }
}
