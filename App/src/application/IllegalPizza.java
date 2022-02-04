package application;



public class IllegalPizza extends Exception {
	/**
	 * gives an exception message
	 * 
	 * @param message (the message passed)
	 */
	public IllegalPizza(String message) {
		super(message);
	}
}
