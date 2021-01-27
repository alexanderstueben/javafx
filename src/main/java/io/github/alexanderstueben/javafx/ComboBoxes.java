package io.github.alexanderstueben.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Good Will Hunting", "St. Vincent", "Blackhat");
        comboBox.setEditable(true);
        comboBox.setOnAction(event -> System.out.println("User selected: " + comboBox.getValue()));


        Button button = new Button("Submit");
        button.setOnAction(event -> printMovie(comboBox));

        VBox layout = new VBox(10, comboBox, button);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, -1);

        stage.setTitle("Combo Boxes");
        stage.setScene(scene);
        stage.show();
    }

    private void printMovie(ComboBox<String> comboBox) {
        System.out.println(comboBox.getValue());
    }
}
