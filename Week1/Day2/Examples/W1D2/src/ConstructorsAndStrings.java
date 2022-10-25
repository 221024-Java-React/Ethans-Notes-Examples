
public class ConstructorsAndStrings {
	
	String str1;
	String str2;
	
	//Constructors are special methods which instantiate a new object from the class
	//No args
	//Once we create this no args, the default will no longer be created
	ConstructorsAndStrings(){
		//The first line is always implicitly super()
		
		//We can also include the this() to call another constructor inside of this class
		this("Hello");
		
		System.out.println("We are in the no args constructor");
	}
	
	//We can make a one arg
	ConstructorsAndStrings(String arg1){
		//Continue the chain
		this(arg1, "");
		
		System.out.println("We are in the single arugment");
	}
	
	//We can consider this an all arguments constructor
	ConstructorsAndStrings(String arg1, String arg2){
		this.str1 = arg1;
		this.str2 = arg2;
		
		System.out.println("We are in the all args");
	}
	
	public static void main(String args[]) {
		//Lets see what happens when we call the no args
		ConstructorsAndStrings cas1 = new ConstructorsAndStrings();
		
		System.out.println("str1: " + cas1.str1 + " str2: " + cas1.str2);
		
		//Lets look at the string pool
		String s1 = "hi";
		
		String s2 = "hi";
		
		String s3 = new String("hi");
		
		//We use == to compare the values stores at a memory location
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		
		//String methods
		//If we wanted to check the actual string values rather than memory locations we can use .equals()
		System.out.println(s1.equals(s3));
		
		// Concatenation
		String str5 = "Hello";
		//String methods return a new string, they do not modify the original
		str5 = str5.concat(" World");
		System.out.println(str5);
		
		//Shorthand concat
		str5 = str5 + " Whats up";
		System.out.println(str5);
		
	}

}
