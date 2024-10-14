package com.example.modulefive.finalproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;

public class AccountGUI extends Application {
    private TextField firstName;
    private TextField lastName;
    private TextField email;
    private ListView<String> claimsList;

    @Override
    public void start(Stage primaryStage) {
        // initializing account
        Account account = createSampleAccount();

        // initializing label
        Label accountIdLabel = new Label("Account ID  " + account.getAccountId());
        Label coverageTierLabel = new Label("Coverage Tier  " + account.getCoverageTier());
        Label userLabel = new Label("User  " + account.getUser().getFirstName() + " " + account.getUser().getLastName());

        // initializing text fields
        firstName = new TextField(account.getUser().getFirstName());
        lastName = new TextField(account.getUser().getLastName());
        email = new TextField(account.getUser().getEmail());

        // creating listview
        claimsList = new ListView<>();
        for (Claim claim : account.getClaims()) {
            claimsList.getItems().add("Claim ID " + claim.getClaimId() + " - " + claim.getTitle() + " (" + claim.getStatus() + ")");
        }

        claimsList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                int selectedIndex = claimsList.getSelectionModel().getSelectedIndex();
                Claim selectedClaim = account.getClaims().get(selectedIndex);
                navigateToClaimGUI(selectedClaim);
            }
        });

        Button updateButton = new Button("Update User Info");
        updateButton.setOnAction(e -> handleUpdateUserInfo(account));

        // setting up layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(accountIdLabel, coverageTierLabel, userLabel,
                new Label("First Name "), firstName,
                new Label("Last Name "), lastName,
                new Label("Email "), email,
                updateButton,
                new Label("Claims "), claimsList);

        Scene scene = new Scene(layout, 400, 400);

        primaryStage.setTitle("Account Details");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    //initializing the navigation to claimgui
    private void navigateToClaimGUI(Claim claim) {
        ClaimGUI claimGUI = new ClaimGUI();
        claimGUI.setClaim(claim);
        Stage claimStage = new Stage();
        claimGUI.start(claimStage);
    }



    private void handleUpdateUserInfo(Account account) {
        User user = account.getUser();
        // setting user info
        user.setFirstName(firstName.getText());
        user.setLastName(lastName.getText());
        user.setEmail(email.getText());
        showAlert("Information updated", "User information successfully updated.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Account createSampleAccount() {
        Account account = new Account();
        account.setAccountId(101);
        account.setCoverageTier("Gold");

        //setting an arraylist for claims to be added to
        ArrayList<Claim> claims = new ArrayList<>();
        //initializing claim1

        Claim claim1 = new Claim();
        claim1.setClaimId(1);
        claim1.setDescription("Traffic light intersection accident, minor injuries");
        claim1.setCategory("Auto");
        claim1.setTitle("Car Intersection Accident");
        claim1.setDateSubmitted(new Date());
        claim1.setStatus("Pending");
        claims.add(claim1);

        //initializing claim2

        Claim claim2 = new Claim();
        claim2.setClaimId(2);
        claim2.setDescription("Hit & run incident while parked.");
        claim2.setCategory("Auto");
        claim2.setTitle("Hit & run");
        claim2.setDateSubmitted(new Date());
        claim2.setStatus("Approved");
        claims.add(claim2);

        //initializing claim3

        Claim claim3 = new Claim();
        claim3.setClaimId(3);
        claim3.setDescription("Minor damage from a rear-end collision.");
        claim3.setCategory("Auto");
        claim3.setTitle("rear end collision");
        claim3.setDateSubmitted(new Date());
        claim3.setStatus("Denied");
        claims.add(claim3);

        account.setClaims(claims);

        //initializing myself as a user
        User user = new User();
        user.setFirstName("Asia");
        user.setLastName("Autrey");
        user.setEmail("asia.autrey@gmail.com");
        account.setUser(user);

        return account;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
