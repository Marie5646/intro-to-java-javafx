package com.example.modulefive.finalproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class AccountGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // create account
        Account account = createSampleAccount();

        // create lable
        Label accountIdLabel = new Label("Account ID: " + account.getAccountId());
        Label coverageTierLabel = new Label("Coverage Tier: " + account.getCoverageTier());
        Label userLabel = new Label("User: " + account.getUser().getFirstName() + " " + account.getUser().getLastName());

        ListView<String> claimsListView = new ListView<>();
        for (Claim claim : account.getClaims()) {
            claimsListView.getItems().add("Claim ID: " + claim.getClaimId());
        }

        VBox layout = new VBox(10);
        layout.getChildren().addAll(accountIdLabel, coverageTierLabel, userLabel, new Label("Claims:"), claimsListView);

        // create scene
        Scene scene = new Scene(layout, 300, 250);

        // set up stage
        primaryStage.setTitle("Account Details");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Account createSampleAccount() {
        Account account = new Account();
        account.setAccountId(101);
        account.setCoverageTier("Gold");

        ArrayList<Claim> claims = new ArrayList<>();
        Claim claim1 = new Claim();
        claim1.setClaimId(1);
        claims.add(claim1);

        Claim claim2 = new Claim();
        claim2.setClaimId(2);
        claims.add(claim2);

        account.setClaims(claims);

        User user = new User();
        user.setFirstName("Asia");
        user.setLastName("Autrey");
        account.setUser(user);

        return account;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
