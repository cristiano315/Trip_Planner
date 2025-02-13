package pera.trip_planner.view.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import pera.trip_planner.exception.GuiException;

import java.io.IOException;
import java.util.Optional;

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

    public boolean showConfirmationChoice(String message, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(message);
        alert.setTitle(title);
        Optional<ButtonType> choice = alert.showAndWait();
        if(choice.get() == ButtonType.OK){
            return true;
        } else{
            return false;
        }
    }
}
