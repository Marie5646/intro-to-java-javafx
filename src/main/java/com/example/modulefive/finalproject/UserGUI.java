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

        // input fields for user info
        email = new TextField();
        passwordInput = new PasswordField();
        passwordLabel = new Label("Password: ****");
        login = new Button("Login");

        // login action
        login.setOnAction(e -> handleLogin());

        // grid layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        // labels and input fields to rid
        grid.add(new Label("Email:"), 0, 0);
        grid.add(email, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(passwordInput, 1, 1);
        grid.add(login, 1, 3);

        // scene creation
        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleRevealPassword() {
        // show password label
        passwordLabel.setText("Password: " + passwordInput.getText());
    }

    private void handleLogin() {
        // user info for login
        User user = new User();
        user.setFirstName("asia");
        user.setLastName("autrey");
        user.setEmail("asia.autrey@gmail.com");
        user.setPassword("password123");

        // login validation
        if (user.getEmail().equals(email.getText()) && user.getPassword().equals(passwordInput.getText())) {
            showAlert("Logged in", "Welcome " + user.getFirstName() + "!");
        } else {
            showAlert("Uh oh", "Wrong combination of password and username.");
        }
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
