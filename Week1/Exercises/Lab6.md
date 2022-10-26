# Create a new package in your Labs project called `lab6`, inside the package do the following:

# Create an abstract class called `Customer`

## 1. Customer should have the following public properties:
- ### String name
- ### double balance
- ### String items (essentially a list of items, each item name has a space after it for parsing)
- ### double cartCost, the cost of the items in your cart

## 2. Customers should have an all-args constructor used for constructor chaining

## 3. Customer should have the following public concrete method:
- ### `addToCart` which returns void
    - takes in a String item, and double cost
    - The method should update the cartCost with the added cost
    - Append the item name to the end of the items string

## 4. Customer should have the following public abstract method:
- ### `buy` which returns void

# Create an interface called `Premium`

## 1. Premium should have the following property:
- ### String title, (you can call your premium customers whatever you like)
- (Hint) this must be set inside of the interface, and it is public final static

## 2. Premium should have the following method:
- ### `discountPrice` which returns a double
    - Should take in a double as the starting price

# Create a class called `PremiumCustomer`

## 1. PremiumCustomer should extend Customer and implement Premium

## 2. PremiumCustomer should have the following private properties
- ### int vipCard, which is their card number
- ### int years, the number of years as a premium customer

## 3. PremiumCustomer should have an all-args constructor which ALSO includes the properties from the Customer abstract class. 
- ### Use the super keyword to call the all-args constructor of the Customer abstract class

## 4. Implement the `discountPrice` method so that the premium user gets a discount of 15% on all items in their cart, and the discounted price gets returned

## 5. Implement the `buy` method to remove the items from the cart, and subtract the cartCost from the Customers balance, reset the cart cost to 0.0
- ## Use the discountPrice method to get the correct discounted cart price to subtract from the customers balance

## 6. Implement all of the getters and setters for:
- ### name, balance, cart, cartCost, vipCard, years
- Use the naming conventions we talked about during training

## 7. Override the toString method from the object class to include all properties from the abstract class, interface, and concrete class;
- name, balance, cart, cartCost, title, vipCard, years

# Create a `Lab6` class with a main method, create a PremiumCustomer object and test out its functionality

## Once complete, commit and push the completed Lab files to your remote repository on GitHub