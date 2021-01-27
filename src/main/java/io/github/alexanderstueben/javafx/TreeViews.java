package io.github.alexanderstueben.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViews extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        TreeItem<String> fruits = new TreeItem<>("Fruits");
        fruits.getChildren().add(new TreeItem<>("Apple"));
        fruits.getChildren().add(new TreeItem<>("Banana"));
        fruits.getChildren().add(new TreeItem<>("Orange"));
        fruits.setExpanded(true);

        TreeItem<String> vegetables = new TreeItem<>("Vegetables");
        vegetables.getChildren().add(new TreeItem<>("Potato"));
        vegetables.getChildren().add(new TreeItem<>("Tomato"));
        vegetables.setExpanded(true);

        TreeItem<String> root = new TreeItem<>("Fruits & Vegetables");
        root.getChildren().add(fruits);
        root.getChildren().add(vegetables);
        root.setExpanded(true);

        TreeView<String> tree = new TreeView<>(root);
        tree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println(newValue.getValue());
            }
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(tree);

        Scene scene = new Scene(layout, 300, 250);

        stage.setTitle("Tree Views");
        stage.setScene(scene);
        stage.show();
    }
}
