package com.example.modulefive;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class FourteenOne extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Image Grid");

       // Establish a GridPane arrangement.
        GridPane gridPane = new GridPane();

        //  Load picture data.
        Image germany = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/germany.gif")));
        ImageView Germany = new ImageView(germany);

        Image france = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/fr.gif")));
        ImageView France = new ImageView(france);

        Image america = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/flagIcon6.gif")));
        ImageView America = new ImageView(america);

        Image china = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/flagIcon2.gif")));
        ImageView China = new ImageView(china);


        // Configure image size
        int size1ImageSize = 200;
        int size2ImageSize = 400;

        Germany.setFitWidth(size1ImageSize);
        Germany.setFitHeight(size1ImageSize);
        France.setFitWidth(size1ImageSize);
        France.setFitHeight(size1ImageSize);
        China.setFitWidth(size1ImageSize);
        China.setFitHeight(size1ImageSize);
        America.setFitWidth(size2ImageSize);
        America.setFitHeight(size2ImageSize);

        //  Fill the grid pane with pictures
        gridPane.add(China, 1, 0);
        gridPane.add(America, 1, 1);
        gridPane.add(Germany, 0, 0);
        gridPane.add(France, 0, 1);

        // set a scene and incorporate the grid pane into it
        Scene scene = new Scene(gridPane, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
