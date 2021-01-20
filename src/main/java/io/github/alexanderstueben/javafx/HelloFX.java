package io.github.alexanderstueben.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

    Scene scene;
    Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.stage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        Button button = new Button("Close program");
        button.setOnAction(event -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        scene = new Scene(layout, 300,250);

        this.stage.setScene(scene);
        this.stage.setTitle("Scenes");
        this.stage.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Close", "You want to exit?");
        if (answer)
            this.stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
