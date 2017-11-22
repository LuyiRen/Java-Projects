package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

import java.awt.*;

public class Exercise15_02 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //create a pane
        BorderPane pane = new BorderPane();
        //create rectangle
        Rectangle r1 = new Rectangle(25, 10, 60, 30);
        r1.setStroke(Color.BLACK);
        r1.setFill(Color.WHITE);

        //add button
        HBox hBox = new HBox();
        Button button = new Button("Rotate");
        button.setOnAction(e ->{
            Rotate rotate = new Rotate();
            rotate.setAngle(15);
            rotate.setPivotX(25);
            rotate.setPivotY(5);
            r1.getTransforms().add(rotate);
        });
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(button);


        //add rectangle 1 to pane
        pane.setCenter(r1);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("Exercise 15_02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
