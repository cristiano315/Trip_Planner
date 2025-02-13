package pera.trip_planner.view.gui;

import javafx.scene.control.Alert;
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

    public void showAlert(String message){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(message);
        a.show();
    }
}
