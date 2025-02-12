package pera.trip_planner.view.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicCreateTripController;
import pera.trip_planner.model.domain.Country;

import java.time.LocalDate;

public class GuiGraphicCreateTripControllerView extends GenericGuiGraphicView {
    private final GuiGraphicCreateTripController controller = GuiGraphicCreateTripController.getInstance();
    private static final String GUI_ERROR = "Error in crate trip gui";
    @FXML
    private ListView<String> countryListView;

    private String tripName;
    private Country tripCountry;
    private LocalDate tripStartDate;
    private LocalDate tripEndDate;
    private long duration;

    public void start(){
        setScene("view/createTripAddName", GUI_ERROR);
    }

    @FXML
    public void initialize(){
        if(countryListView != null){
            countryListView.getItems().add("ciao");
            countryListView.getItems().add("lol");
        }
    }

    public void getTripName(ActionEvent actionEvent) {
        TextField tf = (TextField) actionEvent.getSource();
        tripName = tf.getText();
        if (tripName == null || tripName.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Insert a valid trip name");
            a.show();
        } else{
            controller.setTripName(tripName);
            setScene("view/createTripSelectCountry", GUI_ERROR);
        }
    }
}
