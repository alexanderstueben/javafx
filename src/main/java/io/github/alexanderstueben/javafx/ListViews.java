package io.github.alexanderstueben.javafx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViews extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Iron Man", "Titanic", "Contact", "Surrogates");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button button = new Button("Click me!");
        button.setOnAction(event -> buttonClicked(listView));

        VBox layout = new VBox(10, listView, button);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, 250);

        stage.setTitle("List Views");
        stage.setScene(scene);
        stage.show();
    }

    private void buttonClicked(ListView<String> listView) {
        StringBuilder message = new StringBuilder();
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for (String movie: movies) {
            message.append(movie).append("\n");
        }

        System.out.println(message);
    }
}
