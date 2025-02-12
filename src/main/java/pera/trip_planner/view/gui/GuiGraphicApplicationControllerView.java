package pera.trip_planner.view.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pera.trip_planner.Main;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicApplicationController;
import pera.trip_planner.controller.logic_controller.ApplicationController;

import java.io.IOException;

public class GuiGraphicApplicationControllerView extends Application {
    private static Scene scene;
    private final GuiGraphicApplicationController controller = GuiGraphicApplicationController.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        Platform.setImplicitExit(true);
        stage.setOnCloseRequest((ae) -> {
            Platform.exit();
            System.exit(0);
        });
        scene = new Scene(loadFXML("view/demoSelector"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void setDemo() {
        ApplicationController.setPersistencyMode("In Memory");
        controller.runApplication();
    }

    public void setFull() {
        ApplicationController.setPersistencyMode("File System");
        controller.runApplication();
    }

    public void runCreateTrip() {
        controller.selectCase(1);
    }

    public void runModifyTrip() {
        controller.selectCase(2);
    }

    public void runShowTrip() {
        controller.selectCase(3);
    }

    public void runAddReview() {
        controller.selectCase(4);
    }

    public void runViewInfo() {
        controller.selectCase(5);
    }

    public void runModifyCity() {
        controller.selectCase(6);
    }

    public void runAddActivity() {
        controller.selectCase(7);
    }

    public void runAddAnnouncement() {
        controller.selectCase(8);
    }

    public void quit() {
        controller.selectCase(9);
    }

    public void launchGui() {
        launch();
    }
}
