# Create a new package in your Labs project called `lab7`
## We will also be referencing the `PremiumCustomer` code from lab6

# Inside the lab7 package, create a checked Exception called `OverBalanceException`
## Inlcude a parameterized and no-args constructor for the OverBalanceException

# Refactor the `PremiumCustomer` class in lab6

## 1. In the `buy` method check to see if the Customer currently has enough balance to purchase whats in their cart.
- ### If they don't have enough balance, throw a new `OverBalanceException`
- DO NOT remove the items from the cart, reset the cartCost, or subtract from the balance 

# Create a new class in the `lab7` package called `Lab7`

# 1. Include a main method in the class

# 2. Inside of the main method, create a new PremiumCustomer object, and attempt to add items and buy said items

# 3. Handle the possibility of an `OverBalanceException` with a try/catch

## Once complete, commit and push the completed Lab files to your remote repository on GitHub