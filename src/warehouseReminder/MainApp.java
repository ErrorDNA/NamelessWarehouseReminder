package warehouseReminder;

import java.io.IOException;
import java.time.LocalDate;

import warehouseReminder.model.Order;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
	
    private ObservableList<Order> orderData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        orderData.add(new Order(123456, "Тест1", LocalDate.parse("2015-02-11 00:00:00"), LocalDate.parse("2015-02-11 00:00:00"), 200, "Тест1"));
        //orderData.add(new Order(200000, "Тест2", 31/10/01, 31,10,02, 200, "Тест2" ));
        //orderData.add(new Order(500000, "Тест3", 31/10/01, 31,10,02, 200, "Тест3" ));
    }

    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<Order> getOrderData() {
        return orderData;
    }
    
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Напоминалка о необходимости уничтожения безымянных полуфабрикатов");

        initRootLayout();

        showPersonOverview();
		
	}
	
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
