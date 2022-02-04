# CUD

 A command line utility

Create a command line utility that will compute the price for a pizza order.

The list of pizzas will be provided as a text file. The full path to the order file will be specified as a command line argument. The order file will contain one or many lines each containing a pizza order. Each pizza is a comma-separated list starting with a size (Small, Medium, or Large) and any number of toppings (see below). A small sample of data can be found at the end of this document and a full sample file (order.txt) is attached.

To price an order of pizzas, you must start with a base price based on size of the pizza referred in the table below and add an additional cost for each topping.

|        | Base Price | Standard Toppings | Premium Toppings |
| ------ | ---------- | ----------------- | ---------------- |
| Small  | 8          | .50               | 1                |
| Medium | 10         | .75               | 1.50             |
| Large  | 12         | 1                 | 2                |

| Standard Topping | Premium Toppings |
| ---------------- | ---------------- |
| Peppers          | Sausage          |
| Onion            | Pepperoni        |
| Mushroom         |                  |
| Olives           |                  |
| Spinach          |                  |

For example, with the sample data below, the first pizza would be priced as $13 ($10 Base + $.75 x2 + $1.50) and the second pizza would be priced as $8.50 ($8 + $.50). So, the entire order would be priced at $21.50. The correct score for the attached orders.txt file is $128.00

[]()Your solution should be submitted as source files only – no compiled binaries or jar files are to be submitted. The code should be syntactically correct and compile without errors. You are encouraged to use any common open source Java libraries that you feel will help; however, you must provide a manifest of dependent libraries as one of the source files.

The solution design should allow for flexibility, extensibility, and scalability to accommodate additional future requirements. Developer should be prepared to discuss how to extend the solution to support additional requirements. Additional planned functionality include:

* The company is planning on adding additional items such as appetizers and drinks to the menu. These items have their own unique set of options and pricing.
* This order pricing feature will be added to the company's website, allowing customers to place orders directly via a REST API in addition to receiving orders via files.
* The company will allow users to submit different toppings for each half of the pizza (i.e. half Pepper and half Sausage)

Your code should be written as if it were part of a real company codebase. As such, it should be optimized for readability and maintainability. Unit test coverage is highly desirable.

Sample order file data:

Medium,Peppers,Onions,Sausage

Small,Olives

Large,Sausage

Medium,Sausage,Mushroom

Medium

Small,Olives,Pepperoni

Large

Small,Peppers,Onion,Spinach

Large,Mushroom,Pepperoni

Small,Sausage

Medium,Peppers,Mushroom,Olives

Small,Peppers,Onion,Mushroom,Olives,Spinach,Sausage,Pepperoni

Large
