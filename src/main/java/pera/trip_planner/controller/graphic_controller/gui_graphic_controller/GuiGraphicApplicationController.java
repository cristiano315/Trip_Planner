package pera.trip_planner.controller.graphic_controller.gui_graphic_controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pera.trip_planner.Main;
import pera.trip_planner.controller.graphic_controller.GraphicApplicationController;
import pera.trip_planner.controller.logic_controller.ApplicationController;


import java.io.IOException;

public class GuiGraphicApplicationController extends Application implements GraphicApplicationController {
    @Override
    public void showMenu() {
        launch();
    }

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("demoSelector"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }


    public void setDemo(ActionEvent actionEvent) {
        ApplicationController.setPersistencyMode("In Memory"); //in memoria
        runApplication();
    }

    public void setFull(ActionEvent actionEvent) {
        ApplicationController.setPersistencyMode("File System");
        runApplication();
    }

    public void runApplication(){
        try{
            setRoot("mainMenu");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
