package com.example.modulefive;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class MouseEvent extends Application {
    @Override
    public void start(Stage primaryStage) {
        // initializing pane
        Pane pane = new Pane();
        Circle circle = new Circle(50, Color.WHITE);
        circle.setCenterX(100);
        circle.setCenterY(100);

        // add circle to pane
        pane.getChildren().add(circle);

        // set event
        circle.setOnMousePressed(e -> circle.setFill(Color.BLACK));
        circle.setOnMouseReleased(e -> circle.setFill(Color.WHITE));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 150);
        primaryStage.setTitle("MouseEventCircleDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
