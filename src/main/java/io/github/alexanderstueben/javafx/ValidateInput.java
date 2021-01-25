package io.github.alexanderstueben.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ValidateInput extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        TextField ageInput = new TextField();
        ageInput.setPromptText("Age");

        Button button = new Button("Click me!");
        button.setOnAction(event -> isInt(ageInput));

        VBox layout = new VBox(10, ageInput, button);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, -1);

        stage.setTitle("Validate Input");
        stage.setScene(scene);
        stage.show();
    }

    private boolean isInt(TextField input) {
        try {
            int age =  Integer.parseInt(input.getText());
            System.out.println("User is: " + age);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error " + input.getText() + " is not a number");
            return false;
        }
    }
}
