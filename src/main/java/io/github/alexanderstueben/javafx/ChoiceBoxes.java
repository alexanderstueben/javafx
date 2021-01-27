package io.github.alexanderstueben.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Choice Box");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Apples", "Bananas", "Bacon", "Ham", "Meatballs");
        choiceBox.setValue("Apples");

        Button button = new Button("Click Me!");
        button.setOnAction(event -> System.out.println(choiceBox.getValue()));

        VBox layout = new VBox(10, choiceBox, button);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 250, -1);

        stage.setScene(scene);
        stage.show();
    }
}
