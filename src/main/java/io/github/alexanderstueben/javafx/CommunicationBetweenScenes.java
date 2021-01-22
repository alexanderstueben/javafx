package io.github.alexanderstueben.javafx;

import io.github.alexanderstueben.javafx.share.ConfirmBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CommunicationBetweenScenes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Button button = new Button("Click me!");
        button.setOnAction(event -> {
            boolean result = ConfirmBox.display("Confirm Box", "Do you want to close me?");
            System.out.println(result);
        });

        StackPane layout = new StackPane(button);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, -1);

        stage.setTitle("Communication between Scenes");
        stage.setScene(scene);
        stage.show();
    }
}
