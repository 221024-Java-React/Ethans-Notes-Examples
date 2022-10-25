
public class OpsArraysAndFlow {
	
	//Var args will act the same as the String[] would
	public static void main(String... args) {
		
		// Modulus operator
		int myRemainder = 10 % 3;
		System.out.println(myRemainder);
		
		//Prefix vs Postfix operators
		int x = 5;
		//Prefix
		int y = ++x;
		
		System.out.println(y + " " + x);
		
		//Postfix
		int z = x++;
		
		System.out.println(z + " " + x);
		
		//Ternary Operator
		String s = x > 3 ? "x is greater than three" : "x is not greater than 3";
		
		System.out.println(s);
		
		OpsArraysAndFlow op =  new OpsArraysAndFlow();
		
		//Lets test logical and bitwise operators
		int i = 0;
		boolean bool1 = true;
		boolean bool2 = false;
		boolean bool3 = false;
		
		//We want to try and compute the value of i before running the code
		bool3 = (bool2 & op.inc(i++)); //increment 1
		bool3 = (bool2 && op.inc(i++)); //bool2 == false so short circuit
		bool3 = (bool1 | op.inc(i++)); //bool1 == true but it increments
		bool3 = (bool1 || op.inc(i++));//bool2 == true so short circuit
		
		System.out.println(i);
		
		//Lets create some arrays
		//Multiple ways
		//Array that can hold up to 5 strings
		String names[] = new String[5];
		
		String[] places = {"Iowa", "Florida", "Minnesota"};
		
		int numbers[] = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		//To create a multidimensional array
		int my2dArray[][] = new int[3][3];
		
		int other2dArray[][] =
			{{1,2,3},
			 {4,5,6},
			 {7,8,9}};
		
		//To access an index inside of the array we use the brackets
		//Print out the value of the places array at index 0
		System.out.println("The place I was born " + places[0]);
		
		//Set the first index of the names array
		names[0] = "Ethan";
		names[1] = "Adrian";
		//If we try to access and index that does not exist, it spells trouble
		//names[5] = "Daniel";
		
		//Get the length of the array with the length property
		System.out.println(numbers.length);
		
		//Accessing and changing values in a 2D array are the same as a 1D
		System.out.println(other2dArray[1][1]);
		
		//To change the value
		other2dArray[0][2] = 40;
		
		System.out.println(other2dArray.length);
		System.out.println(other2dArray[0].length);
		
		/* Control flow */
		//if else and else if statements
		
		int a = 0;
		
		if(a < 0) {
			System.out.println("The number is negative");
		}
		else if(a > 0) {
			System.out.println("The number is positive");
		}else {
			System.out.println("Then number is 0");
		}
		
		//Switch Statement
		//kind of a fancy if/else block
		
		String season = "Spring";
		//Always remember your break or return statements for the switch case
		switch(season) {
			case "Summer":
				System.out.println("Lets go to the lake");
				break;
			case "Fall":
				System.out.println("Trick or treat");
				break;
			case "Winter":
				System.out.println("Its snowing");
				break;
			case "Spring":
				System.out.println("April showers bring may flowers");
				break;
			default:
				System.out.println("I did not catch that");
		}
		
		//For loops
		for(/*Three things*/ /*Looping variable*/ int j = 0; /* boolean condition */ j<numbers.length; /* increment */ j++) {
			System.out.println(numbers[j]);
		}
		
		//Enhanced for loops are just a quicker way to write a for loop
		//These only work with collections/arrays
		//For each number in the number array, do something in the block below
		for(int number : numbers) {
			System.out.println(number);
		}
		
		//Finally looping through a 2d array
		//Loop through every row
		for(int j=0; j<other2dArray.length; j++) {
			//Loop through every column of every row
			for(int k=0; k<other2dArray[j].length; k++) {
				System.out.print(other2dArray[j][k]);
			}
			System.out.println();
		}
		
		//While loop and doWhile loop
		
		int index = 10;
		
		//while loop\
		//Loops while i is smaller than 10
		//Be careful and make sure your condition will eventally be false
		while(index < 10) {
			System.out.println(index);
			index++;
		}
		
		//do while will always run at least once
		do {
			System.out.println(index);
		}while(index < 10);
		
	}
	
	boolean inc(int i) {
		return i > 0 ? true : false;
	}

}
