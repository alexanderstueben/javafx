package io.github.alexanderstueben.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UserEventsLambda extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Button button = new Button("Click me!");
        button.setOnAction(event -> {
            System.out.println("You clicked me!");
            System.out.println("That's cool!");
        });

        StackPane layout = new StackPane(button);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, -1);

        stage.setTitle("User Events Lambda");
        stage.setScene(scene);
        stage.show();
    }
}
