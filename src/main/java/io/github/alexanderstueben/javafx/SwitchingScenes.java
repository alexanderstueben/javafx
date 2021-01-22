package io.github.alexanderstueben.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchingScenes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Label label = new Label("Welcome to the first screen!");

        Button button1 = new Button("Go to scene 2");
        Button button2 = new Button("Go back to scene 1");

        VBox layout1 = new VBox(20, label, button1);
        layout1.setPadding(new Insets(20));

        StackPane layout2 = new StackPane(button2);
        layout2.setPadding(new Insets(20));

        Scene scene1 = new Scene(layout1, 300, -1);
        Scene scene2 = new Scene(layout2, 300, -1);

        button1.setOnAction(event -> stage.setScene(scene2));
        button2.setOnAction(event -> stage.setScene(scene1));

        stage.setTitle("Switching Scenes");
        stage.setScene(scene1);
        stage.show();
    }
}
