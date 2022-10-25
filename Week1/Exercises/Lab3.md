# Create a new class called `Lab3` and complete the following logic:

## Use only methods provided by the String class to complete the methods below

## 1. Create a public method called `replaceAllSpaces` which returns a String
- The method should take in one String as a paramater
- Replace all the spaces in the String passas as the parameter with dashes "-"
- Return the string with the dashes

## 2. Create a public method called `containsWord` which returns a boolean
- The method should take in two Strings as parameters
    - The first String is the input word
    - The second String is the word you are searching for
- Inside of the method use String methods to normalize the input String to all lowercase
- Then return true/false depending on if the the input contains the second String passed into the method

## 3. Create a public method called `splitPhoneNumber` which returns a String array
- The method should take in String which will be a phone number formatted like so `111-222-3333`
- Take the phone number string, and split it at each dash "-"
- Store and return each of the split sections of the String in an array
    - Example: `"111-222-3333"` -> `[111,222,3333]`

# Create a main method in the `Lab3` class and test your methods from above inside of the main method

## Once complete, commit and push the completed Lab files to your remote repository on GitHub