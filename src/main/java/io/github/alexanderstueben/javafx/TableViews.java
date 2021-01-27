package io.github.alexanderstueben.javafx;

import io.github.alexanderstueben.javafx.share.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViews extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableView<Product> table = new TableView<>(getProducts());
        table.getColumns().add(nameColumn);
        table.getColumns().add(priceColumn);
        table.getColumns().add(quantityColumn);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TextField nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        TextField priceInput = new TextField();
        priceInput.setPromptText("Price");

        TextField quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            if (nameInput.getText() != null && priceInput.getText() != null && quantityInput.getText() != null) {
                try {
                    Product product = new Product(nameInput.getText(), Double.parseDouble(priceInput.getText()), Integer.parseInt(quantityInput.getText()));
                    table.getItems().add(product);
                    nameInput.clear();
                    priceInput.clear();
                    quantityInput.clear();
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format");
                }
            }
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> table.getItems().removeAll(table.getSelectionModel().getSelectedItems()));

        HBox inputBox = new HBox(10, nameInput, priceInput, quantityInput, addButton, deleteButton);
        inputBox.setPadding(new Insets(10));

        VBox vBox = new VBox(table, inputBox);

        Scene scene = new Scene(vBox);

        stage.setTitle("Table Views");
        stage.setScene(scene);
        stage.show();
    }

    private void addProduct(String name, String price, String quantity) {

    }

    public ObservableList<Product> getProducts() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Apples", 859.00, 20));
        products.add(new Product("Bananas", 2.49, 50));
        products.add(new Product("Pears", 99.00, 74));
        products.add(new Product("Watermelons", 19.99, 12));
        products.add(new Product("Strawberries", 1.49, 120));
        return products;
    }
}
