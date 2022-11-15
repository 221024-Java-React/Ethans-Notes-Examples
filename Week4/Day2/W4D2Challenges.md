# Create a HTML File and a JS file for the challenges

## Link the challenges js file to the HTML file

# Complete the challenges below, test you logic by printing the results to the console

# Challenge 1: Write a function to Convert the age of someone in years to days
## Assume there are 365 days in a year

```
calcAge(65) ➞ 23725

calcAge(0) ➞ 0

calcAge(20) ➞ 7300
```

# Challenge 2: Write a function to compute the total number of points scored by a basketball team in a game
## You are counting points for a basketball game, given the amount of 2-pointers scored and 3-pointers scored, find the final points for the team and return that value.

```
points(1, 1) ➞ 5

points(7, 5) ➞ 29

points(38, 8) ➞ 100
```

# Challenge 3: Write a function to reverse an array
## Return the result

```
reverse([1, 2, 3, 4]) ➞ [4, 3, 2, 1]

reverse([9, 9, 2, 3, 4]) ➞ [4, 3, 2, 9, 9]

reverse([]) ➞ []
```

# Challenge 4: Write a function outputs the correct number of total votes
## Given an object containing counts of both upvotes and downvotes, return what vote count should be displayed. This is calculated by subtracting the number of downvotes from upvotes.

```
getVoteCount({ upvotes: 13, downvotes: 0 }) ➞ 13

getVoteCount({ upvotes: 2, downvotes: 33 }) ➞ -31

getVoteCount({ upvotes: 132, downvotes: 132 }) ➞ 0
```

# Challenge 5: Write a function which takes in a word, and returns a new word without the first character

```
newWord("apple") ➞ "pple"

newWord("cherry") ➞ "herry"

newWord("plum") ➞ "lum"
```

# Challenge 6: Write a function which converts the contents of an array into a string
## Create a function that takes an array of numbers or letters and returns a string.


```
arrayToString([1, 2, 3, 4, 5, 6]) ➞ "123456"

arrayToString(["a", "b", "c", "d", "e", "f"]) ➞ "abcdef"

arrayToString([1, 2, 3, "a", "s", "dAAAA"]) ➞ "123asdAAAA"
```

# Challenge 7: Write a function to find the index of a specified item
## Create a function that takes an array and a string as arguments and returns the index of the string.

```
findIndex(["hi", "edabit", "fgh", "abc"], "fgh") ➞ 2

findIndex(["Red", "blue", "Blue", "Green"], "blue") ➞ 1

findIndex(["a", "g", "y", "d"], "d") ➞ 3

findIndex(["Pineapple", "Orange", "Grape", "Apple"], "Pineapple") ➞ 0
```

# Challenge 8: Write a function to find the absolute value of a number
## The Math.abs() function returns the absolute value of a number. This means that it returns a number's positive value. You can think of it as the distance away from zero.
## DONT USE Math.abs()

```
absolute(-1.217197940) ➞ 1.21719794

absolute(-12.1320) ➞ 12.132
 
absolute(-544.0) ➞ 544

absolute(4666) ➞ 4666

absolute(-3.14) ➞ 3.14

absolute(250) ➞ 250
```

# Challenge 9: Write a function to calculate the 50-30-20 saving strategy

## The 50-30-20 strategy is a simple way to budget, which involves spending 50% of after-tax income on needs, 30% after tax income on wants, and 20% after-tax income on savings or paying off debt.

## Given the after-tax income as ati, what you are supposed to do is to make a function that will return an object that shows how much a person needs to spend on needs, wants, and savings.

```
fiftyThirtyTwenty(10000) ➞ { "Needs": 5000, "Wants": 3000, "Savings": 2000 }

fiftyThirtyTwenty(50000) ➞ { "Needs": 25000, "Wants": 15000, "Savings": 10000 }

fiftyThirtyTwenty(13450) ➞ { "Needs": 6725, "Wants": 4035, "Savings": 2690 }
```

# Challenge 10: Write a function which extracts information from a city object and prints a fact about the city
## Create a function that takes an object as an argument and returns a string with facts about the city. The city facts will need to be extracted from the object's three properties:
- ### name
- ### population
- ### continent

## The string should have the following format: `X has a population of Y and is situated in Z` (where X is the city name, Y is the population and Z is the continent the city is situated in).

```
cityFacts({
  name: "Paris",
  population: "2,140,526",
  continent: "Europe"
}) ➞ "Paris has a population of 2,140,526 and is situated in Europe"

cityFacts({
  name: "Tokyo",
  population: "13,929,286",
  continent: "Asia"
}) ➞ "Tokyo has a population of 13,929,286 and is situated in Asia"
```