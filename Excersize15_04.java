package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class Excersize15_04 extends Application {
    Button[] button = {new Button("Add"), new Button("Subtract"), new Button("Multiply"), new Button("Divide"), new Button("Divide again")};
    TextField number1 = new TextField();
    TextField number2 = new TextField();
    TextField answer = new TextField();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //create fields
  //create grid pane
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("First number"), 0,0);
        gridPane.add(number1, 1,0);
        gridPane.add(new Label("Second number"), 0,1);
        gridPane.add(number2, 1,1);
        gridPane.add(new Label("Answer"), 0,2);
        gridPane.add(answer, 1,2);

        //manage the buttons on the bottom
        FlowPane fp = new FlowPane();
        for(int i = 0; i< button.length; i++){
            fp.getChildren().add(button[i]);
            button[i].setOnAction(this::buttonaction);
        }

        fp.setAlignment(Pos.CENTER);
        gridPane.add(fp, 0, 3);
        Scene scene = new Scene(gridPane, 500, 200);
        primaryStage.setTitle("Excersize 15 4");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void buttonaction(ActionEvent actionEvent) {
        double one = Double.parseDouble(number1.getText());
        double two = Double.parseDouble(number2.getText());
        if(actionEvent.getSource() == button[0]){
            String temp = "" + addnumbers(one, two);
            answer.setText(temp);
        }
        if(actionEvent.getSource() == button[1]){
            String temp = "" + subtract(one, two);
            answer.setText(temp);
        }
        if(actionEvent.getSource() == button[2]){
            String temp = "" + multiply(one, two);
            answer.setText(temp);
        }
        if (actionEvent.getSource() == button[3]){
            String temp = "" + divide(one, two);
            answer.setText(temp);
        }
        if(actionEvent.getSource() == button[4]){
            double answ = Double.parseDouble(answer.getText());
            String temp = "" + divide(answ, two);
            answer.setText(temp);
        }
    }


    public double addnumbers(double one, double two){
        return one+two;
    }
    public double subtract(double one, double two){
        return one-two;
    }
    public double multiply(double one, double two){
        return one*two;
    }
    public double divide(double one, double two){
        if(two == 0){
            return -1;
        }
        return one/two;
    }

}
