package application;


public class Pizza implements java.io.Serializable{
	/**
	 * enumeration for the three sizes of pizza
	 *
	 */
	public enum Size {Small, Medium, Large};
	/**
	 * enumeration for the three different levels of cheese
	 *
	 */
	public enum Cheese {Single, Double, Triple};
	/**
	 * enumeration for if there are toppings or not
	 *
	 */
	public enum Topping {None, Single};
	
	private Size size;
	private boolean vegetarian;
	private Cheese cheese;
	private Topping pineapple;
	private Topping greenPepper;
	private Topping ham;
	
	/**
	 * Complete Constructor
	 * 
	 * @param size(Pizza.Size Enum) size of the pizza
	 * @param vegetarian (boolean) vegetarian or not
	 * @param cheese(Pizza.Cheese Enum) the amount of cheese on the pizza
	 * @param pineapple(Pizza.Topping Enum) amount of pineapple on the pizza
	 * @param greenPepper(Pizza.Topping Enum) amount of green peppers on the pizza
	 * @param ham(Pizza.Topping Enum) amount of ham on the pizza
	 * @throws IllegalPizza (thrown if enum values are null or if the pizza is vegetarian and contains ham)
	 */
	public Pizza(Size size, boolean vegetarian, Cheese cheese, Topping pineapple, Topping greenPepper, Topping ham) throws IllegalPizza {
		this.size= size;
		this.vegetarian = vegetarian;
		this.cheese = cheese;
		this.pineapple = pineapple;
		this.greenPepper = greenPepper;
		this.ham = ham;
		
		if(vegetarian && ham == Topping.Single) {
			throw new IllegalPizza("Vegetarian pizzas cannot contain ham");
		}
		if (size == null || cheese == null || pineapple == null || greenPepper == null || ham == null) {
			throw new IllegalPizza("size or toppings cannot be null");
		}
	}
	
	/**
	 * Constructor for non vegetarian pizza
	 * 
	 * @param size(Pizza.Size Enum) size of the pizza
	 * @param cheese(Pizza.Cheese Enum) the amount of cheese on the pizza
	 * @param pineapple(Pizza.Topping Enum) amount of pineapple on the pizza
	 * @param greenPepper(Pizza.Topping Enum) amount of green peppers on the pizza
	 * @param ham(Pizza.Topping Enum) amount of ham on the pizza
	 * @throws IllegalPizza(thrown if enum values are null)
	 */
	public Pizza(Size size, Cheese cheese, Topping pineapple, Topping greenPepper, Topping ham) throws IllegalPizza {
		this(size, false, cheese, pineapple, greenPepper, ham);
	}
	
	/**
	 * Constructor for a small pizza with cheese and ham
	 * 
	 * @throws IllegalPizza(thrown if enum values are null)
	 */
	public Pizza() throws IllegalPizza {
		this(Size.Small, false, Cheese.Single, Topping.None, Topping.None, Topping.Single);
	}
	
	/**
	 * Calculates the cost of a pizza depending on the size and number of toppings
	 * 
	 * @return returns the cost of the pizza
	 */
	public double getCost() {
		double cost = 0.0;
		int numExtraToppings = 0;
		
		//adds to the cost based on the pizzas size and number of toppings
		switch(size) {
		case Small : cost = 7.0; break;
		case Medium : cost = 9.0; break;
		case Large : cost = 11.0; break;
		}
		
		if (cheese == Cheese.Double) {
			numExtraToppings += 1;
		}
		else if (cheese == Cheese.Triple) {
			numExtraToppings += 2;
		}
		
		if (pineapple == Topping.Single) {
			numExtraToppings += 1;
		}
		
		if (greenPepper == Topping.Single) {
			numExtraToppings += 1;
		}
		
		if (ham == Topping.Single) {
			numExtraToppings += 1;
		}
		
		cost += numExtraToppings * 1.5;
		return cost;
	}
	
	/**
	 * Turns information about the pizza into a string
	 * 
	 * @return a String containing information about the pizza
	 */
	public String toString() {
		String result = "";
		result += size.name();
		result += " ";
		if(vegetarian) {
			result += "vegetarian ";
		}
		result += "pizza, ";
		result += cheese.name();
		result += " cheese";
		if(pineapple == Topping.Single) {
			result += ", pineapple";
		}
		if(greenPepper == Topping.Single) {
			result += ", green pepper";
		}
		if(ham == Topping.Single) {
			result += ", ham";
		}
		result += ". ";
		result += "Cost: $";
		result += String.format("%.2f", getCost());
		result += " each.";
		
		return result;
	}
	
	/**
	 * @param another pizza
	 * 
	 * @return true or false depending on if the pizzas are the same
	 */
	public boolean equals(Object other) {
		if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        
        Pizza otherPizza = (Pizza)other;
        
		return size == otherPizza.size && 
			   vegetarian == otherPizza.vegetarian &&
			   cheese == otherPizza.cheese &&
			   pineapple == otherPizza.pineapple &&
			   greenPepper == otherPizza.greenPepper &&
			   ham == otherPizza.ham;
	}
	
	/**
	 * clones a pizza
	 * 
	 * @return a clone of your pizza
	 */
	public Pizza clone() {
		try {
			return new Pizza(size, vegetarian, cheese, pineapple, greenPepper, ham);
		} catch (IllegalPizza e) {
			return null;
		}
	}
}
