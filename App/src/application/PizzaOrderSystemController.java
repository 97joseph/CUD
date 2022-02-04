package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

//This is the controller class which controls how actions work
public class PizzaOrderSystemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton toggleSmall;

    @FXML
    private ToggleGroup toggleSize;

    @FXML
    private RadioButton toggleMedium;

    @FXML
    private RadioButton toggleLarge;

    @FXML
    private CheckBox checkVegetarian;

    @FXML
    private CheckBox checkPineapple;

    @FXML
    private CheckBox checkHam;

    @FXML
    private CheckBox checkGreenPepper;

    @FXML
    private RadioButton toggleSingle;

    @FXML
    private ToggleGroup toggleCheese;

    @FXML
    private RadioButton toggleDouble;

    @FXML
    private RadioButton toggleTriple;

    @FXML
    private TextField textPizzaPrice;

    @FXML
    private Button buttonSave;

    @FXML
    private Spinner<?> spinnerQuantity;

    @FXML
    private TextField textLineItemCost;

    @FXML
    private TextArea textAreaOrderSummary;

    @FXML
    private TextField textTotalCost;
    
    private double totalOrderCost = 0;

    @FXML
    void onConfigurePizza(ActionEvent event) {
    	Pizza pizza = configurePizza();
    	LineItem lineItem = configureLineItem((int)spinnerQuantity.getValue(), pizza);
    }
    
    //Changes the order summary and total order cost when you press save
    @FXML
    void onSave(ActionEvent event) {
    	Pizza pizza = configurePizza();
    	LineItem lineItem = configureLineItem((int)spinnerQuantity.getValue(), pizza);
    	textAreaOrderSummary.appendText(lineItem.toString() + "\n");
    	totalOrderCost += lineItem.getCost();
    	textTotalCost.setText(String.format("%.2f", totalOrderCost));
    }

    //Disables the ham checkbox if the vegetarian checknox is selected
    @FXML
    void onToggleVegetarian(ActionEvent event) {
    	if (checkVegetarian.isSelected()) {
    		checkHam.setSelected(false);
    		checkHam.setDisable(true);
    	}
    	else {
    		checkHam.setDisable(false);
    	}
    	Pizza pizza = configurePizza();
    	LineItem lineItem = configureLineItem((int)spinnerQuantity.getValue(), pizza);
    }

    @FXML
    void initialize() {
        assert toggleSmall != null : "fx:id=\"toggleSmall\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert toggleSize != null : "fx:id=\"toggleSize\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert toggleMedium != null : "fx:id=\"toggleMedium\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert toggleLarge != null : "fx:id=\"toggleLarge\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert checkVegetarian != null : "fx:id=\"checkVegetarian\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert checkPineapple != null : "fx:id=\"checkPineapple\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert checkHam != null : "fx:id=\"checkHam\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert checkGreenPepper != null : "fx:id=\"checkGreenPepper\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert toggleSingle != null : "fx:id=\"toggleSingle\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert toggleCheese != null : "fx:id=\"toggleCheese\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert toggleDouble != null : "fx:id=\"toggleDouble\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert toggleTriple != null : "fx:id=\"toggleTriple\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert textPizzaPrice != null : "fx:id=\"textPizzaPrice\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert buttonSave != null : "fx:id=\"buttonSave\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert spinnerQuantity != null : "fx:id=\"spinnerQuantity\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert textLineItemCost != null : "fx:id=\"textLineItemCost\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert textAreaOrderSummary != null : "fx:id=\"textAreaOrderSummary\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        assert textTotalCost != null : "fx:id=\"textTotalCost\" was not injected: check your FXML file 'PizzaOrderSystem.fxml'.";
        
        //changes the line item cost based on the quantity selected
        spinnerQuantity.valueProperty().addListener((obs, oldValue, newValue) -> {
        	Pizza pizza = configurePizza();
        	LineItem lineItem = configureLineItem((int)newValue, pizza);
			textLineItemCost.setText(String.format("%.2f", lineItem.getCost()));
        });
    }
    
    //Builds a pizza object based on selected configurations and finds the cost of that pizza.
    private Pizza configurePizza() {
    	Pizza pizza = null;
    	try {
    		Pizza.Topping greenPepper = checkGreenPepper.isSelected() ? Pizza.Topping.Single : Pizza.Topping.None;
    		Pizza.Topping pineapple = checkPineapple.isSelected() ? Pizza.Topping.Single : Pizza.Topping.None;
    		Pizza.Topping ham = checkHam.isSelected() ? Pizza.Topping.Single : Pizza.Topping.None;
    		
    		//checks if vegetarian is selected
    		Boolean vegetarian = false;
    		if (checkVegetarian.isSelected())
    			vegetarian = true;
    		
    		//checks if small, medium or large is selected
    		Pizza.Size size = Pizza.Size.Small;
    		if (toggleMedium.isSelected())
    			size = Pizza.Size.Medium;
    		else if (toggleLarge.isSelected()) 
    			size = Pizza.Size.Large;
    		
    		//checks if single double or triple cheese is selected
    		Pizza.Cheese cheese = Pizza.Cheese.Single;
    		if (toggleDouble.isSelected())
    			cheese = Pizza.Cheese.Double;
    		else if (toggleTriple.isSelected())
    			cheese = Pizza.Cheese.Triple;
   		
			pizza = new Pizza(size, vegetarian, cheese, pineapple, greenPepper, ham);
			textPizzaPrice.setText(Double.toString(pizza.getCost()));
    	} catch (IllegalPizza e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    	
    	return pizza;
    }
    
    //Finds to cost of a line item based on the pizza and numordered
    private LineItem configureLineItem(int numOrdered, Pizza pizza) {
    	LineItem lineItem = null;
    	try {
			lineItem = new LineItem(numOrdered, pizza);
			textLineItemCost.setText(String.format("%.2f", lineItem.getCost()));
		} catch (IllegalPizza e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineItem;

    }
}
