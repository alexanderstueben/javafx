package io.github.alexanderstueben.javafx.share;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(250);

        Label label = new Label(message);

        Button confirmButton = new Button("Yes");
        confirmButton.setOnAction(event -> {
            answer = true;
            stage.close();
        });

        Button declineButton = new Button("No");
        declineButton.setOnAction(event -> {
            answer = false;
            stage.close();
        });

        VBox layout = new VBox(10, label, confirmButton, declineButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(layout);
        stage.setScene(scene);

        stage.showAndWait();

        return answer;
    }
}
