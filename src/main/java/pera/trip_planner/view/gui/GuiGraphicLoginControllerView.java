package pera.trip_planner.view.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicLoginController;

public class GuiGraphicLoginControllerView extends GenericGuiGraphicView{
    private final GuiGraphicLoginController controller = GuiGraphicLoginController.getInstance();
    private final String ERROR_MESSAGE = "Error in loading graphic login gui";
    private static boolean register = false;
    @FXML
    private Label titleLabel;
    @FXML
    private TextField usernameBox;
    @FXML
    private PasswordField passwordBox;
    @FXML
    private Button loginButton;
    @FXML
    private ChoiceBox<String> roleSelector;

    public void selection(){
        String[] choices = {"Login", "Register"};
        ChoiceDialog<String> choiceDialog = new ChoiceDialog<>(choices[1], choices);
        choiceDialog.setContentText("Do you want to login or register?");
        choiceDialog.showAndWait();
        controller.readSelection(choiceDialog.getSelectedItem());
    }

    public void register(){
        setRegister(true);
        setScene("view/loginInterface", ERROR_MESSAGE);
    }

    public void initialize(){
        roleSelector.getItems().addAll("User", "City council", "Activity manager");
        if(register){
            initializeRegister();
        }
    }

    private void initializeRegister() {
        titleLabel.setText("REGISTER");
        loginButton.setText("Register");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeRegister();
            }
        });
    }

    public void login(){
        setRegister(true);
        setScene("view/loginInterface", ERROR_MESSAGE);
    }

    public void executeLogin(){
        String username = usernameBox.getText();
        String password = passwordBox.getText();
        String role = roleSelector.getSelectionModel().getSelectedItem();
        if(username.isEmpty() || password.isEmpty()){
            showAlert("Insert valid username/password");
        } else if (role.isEmpty()){
            showAlert("Select a role");
        } else {
            controller.executeLogin(username, password, role);
        }
    }

    public void executeRegister(){
        String username = usernameBox.getText();
        String password = passwordBox.getText();
        String role = roleSelector.getSelectionModel().getSelectedItem();
        if(username.isEmpty() || password.isEmpty()){
            showAlert("Insert valid username/password");
        } else if (role == null){
            showAlert("Select a role");
        } else {
            controller.executeRegister(username, password, role);
        }
    }

    public static void setRegister(boolean value){
        register = value;
    }
}
