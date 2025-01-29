module pera.TripPlanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens pera.TripPlanner to javafx.fxml;
    exports pera.TripPlanner;
    exports pera.TripPlanner.controller.graphic_controller;
    exports pera.TripPlanner.controller.logic_controller;
}
