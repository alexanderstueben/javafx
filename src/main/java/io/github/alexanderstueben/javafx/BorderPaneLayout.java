package io.github.alexanderstueben.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneLayout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Button buttonA = new Button("A");
        Button buttonB = new Button("B");
        Button buttonC = new Button("C");
        Button buttonD = new Button("D");
        Button buttonE = new Button("E");
        Button buttonF = new Button("F");

        HBox topMenu = new HBox(buttonA, buttonB, buttonC);

        VBox leftMenu = new VBox(buttonD, buttonE, buttonF);

        javafx.scene.layout.BorderPane layout = new javafx.scene.layout.BorderPane();
        layout.setTop(topMenu);
        layout.setLeft(leftMenu);

        Scene scene = new Scene(layout, 300, -1);

        stage.setTitle("Border Pane Layout");
        stage.setScene(scene);
        stage.show();
    }
}
