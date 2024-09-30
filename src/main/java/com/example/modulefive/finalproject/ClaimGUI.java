package com.example.modulefive.finalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClaimGUI extends Application {
    private TextField claimId;
    private TextField description;
    private TextField category;
    private TextField title;
    private TextField status;
    private TextField managerFirstName;
    private TextField managerLastName;
    private TextField customerFirstName;
    private TextField customerLastName;
    private TextArea outputArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Claim Management");

        // Create input fields
        claimId = new TextField();
        description = new TextField();
        category = new TextField();
        title = new TextField();
        status = new TextField();
        managerFirstName = new TextField();
        managerLastName = new TextField();
        customerFirstName = new TextField();
        customerLastName = new TextField();
        outputArea = new TextArea();
        outputArea.setEditable(false);

        // button to submit claim
        Button submitButton = new Button("Submit Claim");
        submitButton.setOnAction(e -> handleSubmit());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        // labels and grid setup
        grid.add(new Label("Claim ID:"), 0, 0);
        grid.add(claimId, 1, 0);
        grid.add(new Label("Description:"), 0, 1);
        grid.add(description, 1, 1);
        grid.add(new Label("Category:"), 0, 2);
        grid.add(category, 1, 2);
        grid.add(new Label("Title:"), 0, 3);
        grid.add(title, 1, 3);
        grid.add(new Label("Status:"), 0, 4);
        grid.add(status, 1, 4);
        grid.add(new Label("Manager First Name:"), 0, 5);
        grid.add(managerFirstName, 1, 5);
        grid.add(new Label("Manager Last Name:"), 0, 6);
        grid.add(managerLastName, 1, 6);
        grid.add(new Label("Customer First Name:"), 0, 7);
        grid.add(customerFirstName, 1, 7);
        grid.add(new Label("Customer Last Name:"), 0, 8);
        grid.add(customerLastName, 1, 8);
        grid.add(submitButton, 1, 9);
        grid.add(outputArea, 0, 10, 2, 1);

        // create scene
        Scene scene = new Scene(grid, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void handleSubmit() {
        if (claimId.getText().isEmpty() || description.getText().isEmpty() || category.getText().isEmpty() || title.getText().isEmpty() || status.getText().isEmpty() || managerFirstName.getText().isEmpty() || managerLastName.getText().isEmpty() || customerFirstName.getText().isEmpty() || customerLastName.getText().isEmpty()) {
            showAlert("error", "empty fields");
            return;
        }

        // claim object represented
        Claim claim = new Claim();
        claim.setClaimId(Long.parseLong(claimId.getText()));
        claim.setDescription(description.getText());
        claim.setCategory(category.getText());
        claim.setTitle(title.getText());
        claim.setDateSubmitted(new Date());
        claim.setStatus(status.getText());

        // assigned manager
        User manager = new User();
        manager.setFirstName(managerFirstName.getText());
        manager.setLastName(managerLastName.getText());
        claim.setAssignedManager(manager);

        // customer
        User customer = new User();
        customer.setFirstName(customerFirstName.getText());
        customer.setLastName(customerLastName.getText());
        claim.setCustomer(customer);


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        outputArea.setText("Claim Details:\n" +
                "Claim ID- " + claim.getClaimId() + "\n" +
                "Description- " + claim.getDescription() + "\n" +
                "Category- " + claim.getCategory() + "\n" +
                "Title- " + claim.getTitle() + "\n" +
                "Date Submitted- " + dateFormat.format(claim.getDateSubmitted()) + "\n" +
                "Status- " + claim.getStatus() + "\n" +
                "Assigned Manager- " + claim.getAssignedManager().getFirstName() + " " + claim.getAssignedManager().getLastName() + "\n" +
                "Customer- " + claim.getCustomer().getFirstName() + " " + claim.getCustomer().getLastName());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
