package warehouseReminder.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * Model class for a Order
 * @author Andrey Privezentsev
 */

public class Order {
	
	private final IntegerProperty orderNumber;
	private final StringProperty orderName;
	private final ObjectProperty<LocalDate> addDate;
	private final ObjectProperty<LocalDate> dellDate;
	private final IntegerProperty orderDefectCount;
	private final StringProperty orderNote;


    /**
     * Default constructor.
     */
    public Order() {
        this(null, null);
    }
    
    /**
     * Constructor with some initial data.
     * 
     * @param orderNumber
     * @param orderName
     * @param addDate
     * @param dellDate
     * @param orderDefectCount
     * @param orderNote
     */
    public Order(Integer orderNumber, String orderName, LocalDate addDate, 
    		LocalDate dellDate, Integer orderDefectCount, String orderNote) {
        this.orderNumber = new SimpleIntegerProperty(orderNumber);
        this.orderName = new SimpleStringProperty(orderName);
        this.addDate = new SimpleObjectProperty<LocalDate>(addDate);
        this.dellDate = new SimpleObjectProperty<LocalDate>(dellDate);
        this.orderDefectCount = new SimpleIntegerProperty(orderDefectCount);
        this.orderNote = new SimpleStringProperty(orderNote);
    }
    
    public Integer getOrderNumber() {
        return orderNumber.get();
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber.set(orderNumber);
    }

    public IntegerProperty orderNumberProperty() {
        return orderNumber;
    }
    
    public String getOrderName() {
        return orderName.get();
    }

    public void setOrderName(String orderName) {
        this.orderName.set(orderName);
    }

    public StringProperty orderNameProperty() {
        return orderName;
    }

}
