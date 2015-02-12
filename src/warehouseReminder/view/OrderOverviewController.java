package warehouseReminder.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import warehouseReminder.MainApp;
import warehouseReminder.model.Order;

public class OrderOverviewController {
	
	@FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, Integer> orderNumberColumn;
    @FXML
    private TableColumn<Order, String> orderNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public OrderOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        orderNumberColumn.setCellValueFactory(cellData -> cellData.getValue().orderNumberProperty());
        orderNameColumn.setCellValueFactory(cellData -> cellData.getValue().orderNameProperty());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        orderTable.setItems(mainApp.getOrderData());
    }

}
