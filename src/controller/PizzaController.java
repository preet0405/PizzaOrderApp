package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.PizzaOrder;
import dao.PizzaOrderDAO;

public class PizzaController {

    @FXML private TextField tfName;
    @FXML private TextField tfMobile;
    @FXML private ComboBox<String> cbSize;
    @FXML private Spinner<Integer> spToppings;
    @FXML private TableView<PizzaOrder> ordersTable;
    @FXML private TableColumn<PizzaOrder, Integer> colId;
    @FXML private TableColumn<PizzaOrder, String> colName;
    @FXML private TableColumn<PizzaOrder, String> colMobile;
    @FXML private TableColumn<PizzaOrder, String> colSize;
    @FXML private TableColumn<PizzaOrder, Integer> colToppings;
    @FXML private TableColumn<PizzaOrder, Double> colTotal;

    private ObservableList<PizzaOrder> orders = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cbSize.getItems().addAll("S", "M", "L", "XL");
        cbSize.getSelectionModel().selectFirst();
        spToppings.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));

        colId.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getId()).asObject());
        colName.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCustomerName()));
        colMobile.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getMobileNumber()));
        colSize.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getPizzaSize()));
        colToppings.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getNumberOfToppings()).asObject());
        colTotal.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getTotalBill()).asObject());

        ordersTable.setItems(orders);
        loadOrders();
    }

    @FXML
    private void handleAddOrder() {
        String name = tfName.getText().trim();
        String mobile = tfMobile.getText().trim();
        String size = cbSize.getValue();
        int toppings = spToppings.getValue();
        double total = calculateBill(size, toppings);

        if (name.isEmpty() || mobile.isEmpty()) {
            showAlert("Name and Mobile cannot be empty!");
            return;
        }

        PizzaOrder order = new PizzaOrder(0, name, mobile, size, toppings, total);
        PizzaOrderDAO.saveOrder(order);
        showAlert("Order saved!");

        loadOrders();
        clearFields();
    }

    private void loadOrders() {
        orders.setAll(PizzaOrderDAO.getAllOrders());
    }

    private void clearFields() {
        tfName.clear();
        tfMobile.clear();
        cbSize.getSelectionModel().selectFirst();
        spToppings.getValueFactory().setValue(0);
    }

    private double calculateBill(String size, int toppings) {
        double base = 0;
        switch (size) {
            case "S": base = 8; break;
            case "M": base = 10; break;
            case "L": base = 12; break;
            case "XL": base = 15; break;
        }
        return base + toppings * 1.5;
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}


