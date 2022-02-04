import java.util.Scanner;

public class PizzaApplication {

    // Price of pizza
    public static double pizzaPrice;
    // name of pizza
    public static String pizzaName;
    // size of pizza
    public static String pizzaSize;
    // type of crust
    public static String pizzaCrust;
    // veg or nonveg pizza
    public static String vegOrNonVeg;
    // toppings
    public static String pizzaToppings;
    // coustomization
    public static String customization;
    // just a literal
    public static String stack;
    // method to check availability of pizza

    private static String pizzaAvailability(String name) {
        if (name.equalsIgnoreCase("Delux Veggie") || name.equalsIgnoreCase("Veg Extravaganza")
                || name.equalsIgnoreCase("Idli Tandoori Paneer") || name.equalsIgnoreCase("Farmhouse")
                || name.equalsIgnoreCase("Peppy Paneer") || name.equalsIgnoreCase("Mexican Green Wave"))
            return "Your Selected Pizza is Available for order.";
        else
            return "we are Sorry its unavailable.Try again";

    }

    // method for getting final price for options
    private static void pizzaPriceBill(String pizzaName, String pizzaSize, String pizzaCrust, double toppingPrice) {// local
                                                                                                                    // variable
                                                                                                                    // for
                                                                                                                    // getting
                                                                                                                    // price
                                                                                                                    // of
                                                                                                                    // different
                                                                                                                    // pizza
                                                                                                                    // and
                                                                                                                    // size
        double pizzaTypeSizePrice = 0;
        // local variable for crust
        double crustCost = 0;
        // total price of pizza
        double totalPrice = 0;
        // conditional statements for getting price of type of pizza and size
        if (pizzaName.equalsIgnoreCase("Delux Veggie") && pizzaSize.equals("S")) {
            pizzaTypeSizePrice = 235;

        }
        if (pizzaName.equalsIgnoreCase("Delux Veggie") && pizzaSize.equals("M")) {
            pizzaTypeSizePrice = 450;

        }
        if (pizzaName.equalsIgnoreCase("Delux Veggie") && pizzaSize.equals("L")) {
            pizzaTypeSizePrice = 695;

        }
        if (pizzaName.equalsIgnoreCase("Veg Extravaganza") && pizzaSize.equals("S")) {
            pizzaTypeSizePrice = 235;

        }
        if (pizzaName.equalsIgnoreCase("Veg Extravaganza") && pizzaSize.equals("M")) {
            pizzaTypeSizePrice = 450;

        }
        if (pizzaName.equalsIgnoreCase("Veg Extravaganza") && pizzaSize.equals("L")) {
            pizzaTypeSizePrice = 695;

        }
        if (pizzaName.equalsIgnoreCase("Idli Tandoori Paneer") && pizzaSize.equals("S")) {
            pizzaTypeSizePrice = 235;

        }
        if (pizzaName.equalsIgnoreCase("Idli Tandoori Paneer") && pizzaSize.equals("M")) {
            pizzaTypeSizePrice = 450;

        }
        if (pizzaName.equalsIgnoreCase("Idli Tandoori Paneer") && pizzaSize.equals("L")) {
            pizzaTypeSizePrice = 695;

        }
        if (pizzaName.equalsIgnoreCase("Farmhouse") && pizzaSize.equals("S")) {
            pizzaTypeSizePrice = 215;

        }
        if (pizzaName.equalsIgnoreCase("Farmhouse") && pizzaSize.equals("M")) {
            pizzaTypeSizePrice = 395;

        }
        if (pizzaName.equalsIgnoreCase("Farmhouse") && pizzaSize.equals("L")) {
            pizzaTypeSizePrice = 595;

        }
        if (pizzaName.equalsIgnoreCase("Peppy Paneer") && pizzaSize.equals("S")) {
            pizzaTypeSizePrice = 335;

        }
        if (pizzaName.equalsIgnoreCase("Peppy Paneer") && pizzaSize.equals("M")) {
            pizzaTypeSizePrice = 335;

        }
        if (pizzaName.equalsIgnoreCase("Peppy Paneer") && pizzaSize.equals("L")) {
            pizzaTypeSizePrice = 335;

        }
        if (pizzaName.equalsIgnoreCase("Mexican Green Wave") && pizzaSize.equals("S")) {
            pizzaTypeSizePrice = 215;

        }
        if (pizzaName.equalsIgnoreCase("Mexican Green Wave") && pizzaSize.equals("M")) {
            pizzaTypeSizePrice = 395;

        }
        if (pizzaName.equalsIgnoreCase("Mexican Green Wave") && pizzaSize.equals("L")) {
            pizzaTypeSizePrice = 595;
        }
        // conditional statements for chosing crust price
        if (pizzaCrust.equalsIgnoreCase("new hand tosted")) {
            crustCost = 215;
        }
        if (pizzaCrust.equalsIgnoreCase("cheese brust")) {
            crustCost = 215;
        }
        if (pizzaCrust.equalsIgnoreCase("classic hand tosted")) {
            crustCost = 215;
        }
        if (pizzaCrust.equalsIgnoreCase("fresh pain pizza")) {
            crustCost = 215;
        }
        if (pizzaCrust.equalsIgnoreCase("wheat thin crust")) {
            crustCost = 215;
        }
        totalPrice = crustCost + pizzaTypeSizePrice + toppingPrice;
        System.out.println("Price of pizza" + totalPrice);

    }

    public static void main(String[] args) {
        double toppingPrice = 0;
        System.out.println("...........Welcome To PizzaMania................");
        System.out.println("\"Coustomer setisfacation , our delight.\"");
        System.out.println("Best Pizza Makers in the Town Since 1983");
        System.out.println("------------------------------------------------");
        System.out.println(
                "Pizzas Catalogue : |Delux Veggie||Veg Extravaganza||Idli Tandoori Paneer||Farmhouse||Peppy Paneer||Mexican Green Wave|\n");
        System.out.println("Which Pizza would you like to order");
        Scanner sc = new Scanner(System.in);
        // takes pizza name
        pizzaName = sc.nextLine();
        // calling pizzaAvailability fuction for it its available or not
        stack = pizzaAvailability(pizzaName);
        // prints avalability or not
        System.out.println(stack);
        // if not available exicution of program will terminate
        if (stack.equals("we are Sorry its unavailable.Try again")) {
            System.exit(0);
        }
        // pizza size catalogue
        System.out.println("Enter size of pizza: |'S' for small||'M' for medium||'L'||large|");
        // user input for pizza size
        pizzaSize = sc.nextLine();
        // conditional statement to check if pizza size is valid on not
        if (pizzaSize.equals("S") || pizzaSize.equals("M") || pizzaSize.equals("L")) {

            // different types of crust
            System.out.println(
                    "Crusts available:|new hand tosted||cheese brust||fresh pain pizza||classic hand tosted||wheat thin crust");
            // inputs crust
            pizzaCrust = sc.nextLine();
            // default topping details
            System.out.println("Default Toppings:\n\n");
            System.out.println("\nDelux Vegie : onion,capsicup,grilled mushroom,corn and paneer.");
            System.out.println(
                    "\nVeg Extravaganza : black olives,capsicum,onions,grilled mushroom,corn ,tommato,jalapeno & extra cheese.");
            System.out.println(
                    "\nIdli Tandoori Paneer : It is hot, it is spicy.It is so indian.Tandoori paneer with capsicum,red pepranda and mint mayo.");
            System.out.println("\nFarmhouse : Delightful combination onion, capsicum , tommato and grilled mushroom");
            System.out.println(
                    "\nPeppy Paneer : Flavoured trio of juicy paneer , crisp capsicum with spicy red peprenka");
            System.out.println("\nMexican Green Wave :Mexican herbs sprinked on onion,capsicum,tommato,jalapeno ");
            System.out.println(
                    "\n\n If you want to change toppings you can choose from below toppings.\nYou can choose upto 3 at max.");
            System.out.println("\nVeg Toppings : @ Rs.60 each");
            System.out.println("\nVeg Toppings:|Jalapeno||Black olives||onion||Fresh tommato||Red pepranka|"
                    + "|Golden corn||crisp capsicum||paneer||Grilled masheroom||paneer tikka|");
            System.out.println("\nNon veg toppings: Rs.75 each");
            System.out.println("\nNon veg toppings:|panner barbeque chicken||peri peri chiken||grilled chiken rasher|"
                    + "|chicken sausage||chikken tikka||chicken peparoni||chicken keema");
            System.out.println("\nDo you want to change toppings or go with the defaul ones?(yes/no)");
            String temp = sc.nextLine();
            // wether you want to change toppings
            if (temp.equals("yes")) {

                System.out.println("How many toppings you want to add. At max 3.");
                int toppingsCount = sc.nextInt();
                String[] arrayToppings = new String[20];
                // for checking at max 3 toppings are there
                if (toppingsCount == 1 || toppingsCount == 2 || toppingsCount == 3) {
                    System.out.println("Enter name of toppings one by one");
                    for (int i = 0; i < toppingsCount; i++) {
                        arrayToppings[i] = sc.next();
                    }
                    // weather that topping was veg or nonveg
                    System.out.println("veg or nonveg toppings");
                    vegOrNonVeg = sc.next();
                    if (vegOrNonVeg.equals("veg")) {
                        toppingPrice = toppingsCount * 60;

                    } else {
                        toppingPrice = toppingsCount * 75;

                    }
                    // calling this method to get final price
                    pizzaPriceBill(pizzaName, pizzaSize, pizzaCrust, toppingPrice);

                }
            } else {
                pizzaPriceBill(pizzaName, pizzaSize, pizzaCrust, toppingPrice);
            }
        }
    }

}