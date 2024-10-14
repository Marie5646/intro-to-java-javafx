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
    private TextArea outputArea;
    private Claim claim;



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Claim Management");

        outputArea = new TextArea();
        outputArea.setEditable(false);

        // initializing a claim for test
        Claim testClaim = createTestClaim();

        // setting claim details
        displayClaimDetails(testClaim);

        // setting up layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.add(outputArea, 0, 0);

        // initializing scene
        Scene scene = new Scene(grid, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Claim createTestClaim() {
        Claim claim = new Claim();
        claim.setClaimId(1234L);
        claim.setDescription("Car T-boned another car. Major injuries reported.");
        claim.setCategory("Auto");
        claim.setTitle("Possibly Totaled Vehicle");
        claim.setDateSubmitted(new Date());
        claim.setStatus("Pending");

        // assigning a manager to my claim
        User manager = new User();
        manager.setFirstName("Tina");
        manager.setLastName("Willis");
        claim.setAssignedManager(manager);

        // assigning myself as a customer
        User customer = new User();
        customer.setFirstName("Asia");
        customer.setLastName("Autrey");
        claim.setCustomer(customer);

        return claim;
    }
    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    private void displayClaimDetails(Claim claim) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        outputArea.setText("Claim Details:\n" +
                "Claim ID " + claim.getClaimId() + "\n" +
                "Description " + claim.getDescription() + "\n" +
                "Category " + claim.getCategory() + "\n" +
                "Title " + claim.getTitle() + "\n" +
                "Date Submitted " + dateFormat.format(claim.getDateSubmitted()) + "\n" +
                "Status " + claim.getStatus() + "\n" +
                "Assigned Manager " + claim.getAssignedManager().getFirstName() + " " + claim.getAssignedManager().getLastName() + "\n" +
                "Customer " + claim.getCustomer().getFirstName() + " " + claim.getCustomer().getLastName());
    }

    public static void main(String[] args) {
        launch(args);
    }


}
