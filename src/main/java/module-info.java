module pera.trip_planner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens pera.trip_planner to javafx.fxml;
    opens pera.trip_planner.view.gui to javafx.fxml;
    exports pera.trip_planner;
    exports pera.trip_planner.controller.logic_controller;
    exports pera.trip_planner.controller.graphic_controller;
    exports pera.trip_planner.controller.graphic_controller.gui_graphic_controller;
    exports pera.trip_planner.controller.graphic_controller.text_graphic_controller;
    exports pera.trip_planner.view.gui;
}