package com.example.modulefive;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollBarColor extends Application {
    @Override
    public void start(Stage primaryStage) {

//      Red
        ScrollBar sbRed = new ScrollBar();

        sbRed.setOrientation(Orientation.HORIZONTAL);
        sbRed.setMax(1.0);
        sbRed.setValue(0.0);
 //      Green

        ScrollBar sbGreen = new ScrollBar();
        sbGreen.setOrientation(Orientation.HORIZONTAL);
        sbGreen.setMax(1.0);
        sbGreen.setValue(0.0);

//      Blue
        ScrollBar sbBlue = new ScrollBar();
        sbBlue.setOrientation(Orientation.HORIZONTAL);
        sbBlue.setMax(1.0);
        sbBlue.setValue(0.0);


//        Opacity
        ScrollBar sbOpacity = new ScrollBar();
        sbOpacity.setOrientation(Orientation.HORIZONTAL);
        sbOpacity.setMax(1.0);
        sbOpacity.setValue(1.0);



        Text showColors = new Text(20, 50, "Show Colors");

        // Create a pane to hold the text
        Pane paneForText = new Pane();
        paneForText.getChildren().add(showColors);

        // Create a border pane to hold text and scroll bars
        BorderPane pane = new BorderPane();
        pane.setTop(showColors);
        pane.setCenter(paneForText);

        // Create a vertical box to hold the scroll bars
        VBox vBox = new VBox(20, sbRed, sbGreen, sbBlue, sbOpacity);
        pane.setCenter(vBox);



        // event listener
        sbRed.valueProperty().addListener(ov -> colorChange(showColors, sbRed, sbGreen, sbBlue, sbOpacity));
        sbGreen.valueProperty().addListener(ov -> colorChange(showColors, sbRed, sbGreen, sbBlue, sbOpacity));
        sbBlue.valueProperty().addListener(ov -> colorChange(showColors, sbRed, sbGreen, sbBlue, sbOpacity));
        sbOpacity.valueProperty().addListener(ov -> colorChange(showColors, sbRed, sbGreen, sbBlue, sbOpacity));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("ScrollBarColor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Update the text color based on the scroll bar values
    private void colorChange(Text text, ScrollBar sbRed, ScrollBar sbGreen, ScrollBar sbBlue, ScrollBar sbOpacity) {
        Color color = Color.color(sbRed.getValue(), sbGreen.getValue(), sbBlue.getValue(), sbOpacity.getValue());
        text.setFill(color);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
