package io.github.alexanderstueben.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectionChange extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Apples", "Bananas", "Bacon", "Ham", "Meatballs");
        choiceBox.setValue("Apples");
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue));

        VBox layout = new VBox(10, choiceBox);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, -1);

        stage.setTitle("Selection Change");
        stage.setScene(scene);
        stage.show();
    }
}
