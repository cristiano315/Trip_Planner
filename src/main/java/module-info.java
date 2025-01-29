module pera.Trip_Planner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens pera.Trip_Planner to javafx.fxml;
    exports pera.Trip_Planner;
    exports pera.Trip_Planner.controller.graphic_controller;
    exports pera.Trip_Planner.controller.logic_controller;
}
