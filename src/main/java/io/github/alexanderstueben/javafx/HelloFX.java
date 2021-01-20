package io.github.alexanderstueben.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

    Scene scene;

    @Override
    public void start(Stage stage) {
        Button button = new Button("Click me");
        button.setOnAction(event -> {
            boolean result = ConfirmBox.display("Close me", "Could you please close me?");
            System.out.println(result);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        scene = new Scene(layout, 640,360);

        stage.setScene(scene);
        stage.setTitle("Scenes");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
