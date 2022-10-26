# Create a new package in your Labs project called `lab9`
## Inside of the lab8 package, create a class also called `Lab9` and do the following:

# Assume you will be given an array of a characters with a random length, with the goal of calculating the bonuses given out to employees at your work
## Create the method described below inside of the Lab9 class


## 1. The method should be called `calculateBonuses`
- ### It should return a new array with the bonuses
- ### It should take in an array of characters to be converted to bonuses via a parameter

## 2. Using a do while loop, loop through the parameter array of characters

## 3. Inside of the do while loop, use a switch statement to determine the amount for each bonus based on the character in the parameter array

## 4. Place the bonus number in a results array according to the following logic:

- ### Character `A` in the parameter array recieves a 5000 bonus
- ### Character `B` in the parameter array recieves a 2500 bonus
- ### Character `C` in the parameter array recieves a 1000 bonus
- ### Character `D` in the parameter array receives a 500 bonus
- ### Character `F` in the parameter array receieves a 0 bonus

# Example character and result array:

```
character array = ['A', 'A', 'C', 'F']
bonuses = [5000, 5000, 1000, 0]
```

# Create a new class called `Lab9Test` and write 2 positive and 2 negative tests using JUnit
## Run the tests, and make sure they pass before you finish

## Once complete, commit and push the completed Lab files to your remote repository on GitHu