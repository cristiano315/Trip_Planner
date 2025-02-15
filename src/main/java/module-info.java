module pera.trip_planner {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires com.fasterxml.jackson.databind;
    requires java.sql;

    opens pera.trip_planner to javafx.fxml;
    opens pera.trip_planner.view.gui to javafx.fxml;
    opens pera.trip_planner.model.domain to com.fasterxml.jackson.databind;
    opens pera.trip_planner.model.domain.entity_lists to com.fasterxml.jackson.databind;
    exports pera.trip_planner;
    exports pera.trip_planner.controller.logic_controller;
    exports pera.trip_planner.controller.graphic_controller;
    exports pera.trip_planner.controller.graphic_controller.gui_graphic_controller;
    exports pera.trip_planner.controller.graphic_controller.text_graphic_controller;
    exports pera.trip_planner.view.gui;
    exports pera.trip_planner.controller.task;
    exports pera.trip_planner.model.domain to com.fasterxml.jackson.databind;
    exports pera.trip_planner.model.domain.entity_lists to com.fasterxml.jackson.databind;
    exports pera.trip_planner.model.dao.file_system.serializers to com.fasterxml.jackson.databind;
}