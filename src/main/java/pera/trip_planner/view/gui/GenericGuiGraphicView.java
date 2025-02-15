package pera.trip_planner.view.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import pera.trip_planner.exception.GuiException;

import java.io.IOException;
import java.util.Optional;

public abstract class GenericGuiGraphicView {
    protected void setScene(String fxml, String error){
        try{
            GuiGraphicApplicationControllerView.setRoot(fxml);
        } catch (IOException e) {
            throw new GuiException(error);
        }
    }

    public void showAlert(String message){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(message);
        a.showAndWait();
    }

    public boolean showConfirmationChoice(String message, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(message);
        alert.setTitle(title);
        Optional<ButtonType> choice = alert.showAndWait();
        return choice.isPresent() && choice.get() == ButtonType.OK;
    }

    public String getString(String message, String title){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setContentText(message);
        Optional<String> result = dialog.showAndWait();
        while(result.isEmpty() || result.get().isEmpty()){
            result = dialog.showAndWait();
        }
        return result.get();
    }
}
