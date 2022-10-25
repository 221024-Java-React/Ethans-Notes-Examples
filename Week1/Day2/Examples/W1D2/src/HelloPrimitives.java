
public class HelloPrimitives {
	
	public static void main(String args[]) {
		
		//Use two slashes to make a comment
		
		//Create a byte variable
		//Our variables have a type in this case a byte
		//Our variables have a name, in this case littleByte
		//Our variabes have an assignment, in this case = 127
		byte littleByte = 127;
		
		//In java, we cannot use commas to separate numbers, but we can use underscores
		short shortStuff = 32_767;
		
		int bitBiggerInt = 76_546_678;
		
		//Java will automatically try to convert long to integers, so you must give the long number
		// a literal suffix L
		long bigBoi = 123456789L;
		
		//Java also converts floats to doubles so you have to use a suffix as well
		float floatingPoint = 3.14159f;
		
		double biggerFloatingPoint = 45.234;
		
		//To create a sigle character you HAVE to use single quotes
		char payRespect = 'f';
		
		boolean yesOrNo = false;
		
		/*
		 * System is a class that is provided within the java.lang package, we dont' need to include this to use it
		 * The System class includes several useful methods that can be invoked for our uses
		 * Including the out class, which allows us to output values to things like the terminal
		 */
		
		System.out.println("Hello this is our second java class");
		System.out.println("We can print the variables from above");
		System.out.println("byte: " + littleByte);
		System.out.println("short: " + shortStuff);
		System.out.println("int: " + bitBiggerInt);
		System.out.println("long: " + bigBoi);
		System.out.println("float: " + floatingPoint);
		System.out.println("double: " + biggerFloatingPoint);
		System.out.println("Press F to pay respect");
		System.out.println(payRespect);
		System.out.println("boolean: " + yesOrNo);
		
		//Primitive widening and narrowing
		//Widening, this is safe for basically every primitive
		short widen = 20000;
		int widen2 = widen;
		System.out.println(widen2);
		
		//Narrowing
		int narrowMe = 50000;
		short narrowing = (short) narrowMe;
		System.out.println(narrowing);
		
	}

}
