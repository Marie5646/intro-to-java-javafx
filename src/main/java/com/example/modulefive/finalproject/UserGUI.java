package com.example.modulefive.finalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UserGUI extends Application {
    private TextField email;
    private PasswordField passwordInput;
    private Button login;
    private Label passwordLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Login");

        // initializing  fields for user info
        email = new TextField();
        passwordInput = new PasswordField();
        passwordLabel = new Label("Password: ****");
        login = new Button("Login");

        // action set for login button
        login.setOnAction(e -> handleLogin(primaryStage));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.add(new Label("Email:"), 0, 0);
        grid.add(email, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(passwordInput, 1, 1);
        grid.add(login, 1, 3);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleLogin(Stage primaryStage) {

        //setting user info for login
        User user = new User();
        user.setFirstName("Asia");
        user.setLastName("Autrey");
        user.setEmail("asia.autrey@gmail.com");
        user.setPassword("password123");

        // validating if info entered for login matches set user info
        if (user.getEmail().equals(email.getText()) && user.getPassword().equals(passwordInput.getText())) {
            showAlert("Logged in", "Welcome " + user.getFirstName() + "!");
            navigateToAccount(primaryStage);
        } else {
            showAlert("Uh oh", "Password or Username incorrect! Try again.");
        }
    }

    private void navigateToAccount(Stage primaryStage) {
        // initializing instance of account gui to naviagte when successfully logged in
        AccountGUI accountGUI = new AccountGUI();

        // display account stage
        Stage accountStage = new Stage();
        accountGUI.start(accountStage);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
