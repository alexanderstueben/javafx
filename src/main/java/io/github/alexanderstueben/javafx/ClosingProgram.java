package io.github.alexanderstueben.javafx;

import io.github.alexanderstueben.javafx.share.ConfirmBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClosingProgram extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Button button = new Button("Close program");
        button.setOnAction(event -> closeProgram(stage));

        StackPane layout = new StackPane(button);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, -1);

        stage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram(stage);
        });
        stage.setTitle("Closing Program");
        stage.setScene(scene);
        stage.show();
    }

    private void closeProgram(Stage stage) {
        boolean answer = ConfirmBox.display("Close", "Do you really want to exit?");
        if (answer)
            stage.close();
    }
}
