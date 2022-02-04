package application;

import java.io.Serializable;


public class LineItem implements Comparable<LineItem>, Serializable{
	private static final long serialVersionUID = 419242292485131336L;
	private int numOrdered;
	private final Pizza pizza;
	
	/**
	 * constructor for an order
	 * 
	 * @param numOrdered(number of pizzas ordered)
	 * @param pizza(a pizza)
	 * @throws IllegalPizza(throws exception if pizza is null or number of pizzas ordered is not between 1 and 100)
	 */
	public LineItem(int numOrdered, Pizza pizza) throws IllegalPizza {
		this.numOrdered = numOrdered;
		this.pizza = pizza;
		
		if (pizza == null) {
			throw new IllegalPizza("pizza cannot be null");
		}
		if (numOrdered < 1 || numOrdered > 100) {
			throw new IllegalPizza("number of pizzas ordered must be between 1 and 100");
		}
	}
	
	/**
	 * Constructor for an order of 1 pizza
	 * 
	 * @param pizza(a pizza)
	 * @throws IllegalPizza(throws exception if pizza is null or number of pizzas ordered is not between 1 and 100)
	 */
	public LineItem(Pizza pizza) throws IllegalPizza {
		this(1, pizza);
	}
	
	/**
	 * Accessor method
	 * 
	 * @return A pizza
	 */
	public Pizza getPizza() {
		return pizza;
	}
	
	/**
	 * Accessor method
	 * 
	 * @return The number of pizzas ordered
	 */
	public int getNumber() {
		return numOrdered;
	}
	
	/**
	 * This function sets the the number of pizzas ordered
	 * 
	 * @param number (the number of pizzas ordered)
	 * @throws IllegalPizza (throws exeption if number of pizzas ordered is not between 1 and 100)
	 */
	public void setNumber(int number) throws IllegalPizza {		
		if (number < 1 || number > 100) {
			throw new IllegalPizza("number of pizzas ordered must be between 1 and 100");
		}
		numOrdered = number;
	}
	
	/**
	 * This function calculates the cost of an order
	 * 
	 * @return the cost of an order as a double
	 */
	public double getCost() {
		double cost = pizza.getCost() * numOrdered;
		
		if (numOrdered >= 10 && numOrdered <= 20) {
			cost *= 0.9; //10 percent discount
		}
		else if (numOrdered > 20) {
			cost *= 0.85; //20 percent discount
		}
		return cost;
	}
	
	/**
	 * This function returns a String that contains information about the order
	 * 
	 * @return The order information as a String
	 */
	public String toString() {
		String result = "";
		if (numOrdered < 10) {
			result += " ";
		}
		result += numOrdered;
		result += " ";
		result += pizza.toString();
		return result;
	}
	
	/**
	 * This function compares the prices of orders
	 * 
	 * @param otherOrder(another order whose cost is being compared to the current order
	 * @return a number based on if the other order is the same cost, more expensive or less expensive than the current order.
	 */
	public int compareTo(LineItem otherOrder) {
		double costDifference = getCost() - otherOrder.getCost();
		
		
		if (costDifference < 0.0) {
			return 1; //if the other cost is greater than the cost of this order
		}
		else if (costDifference < 1.0) {
			return 0; //if the difference in cost is less than a dollar
		}
		else {
			return -1; //if the other cost is less than this order
		}
	}
}



