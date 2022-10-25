
//We know the class keyword denotes a class, the Name of the class will denote the type of object we are instantiating
//Naming convention of classes is TitleCase
public class ClassAndMethods {
	
	//Classes define the states and behaviors of an object
	
	//The states are the variables stored inside of the class
	//Or properties
	int myInt = 24;
	double pi = 3.14;
	boolean isMonday = true;
	
	//Our behaviors are the methods created inside of the class
	
	//Methods can take in 0 to as many parameters as you need
	//They must return some type of data, and have a name
	//If you want to return nothing from a method, you can use the void keyword
	void printHello() {
		System.out.println("Hello");
	}
	
	//When we want to return some value from a method, we use the return keyword
	int returnMyInt() {
		return myInt;
	}
	
	//We can also change values in our class/object with a method
	void changeIsMonday(boolean monday) {
		//Use the parameter above to change the value of the property isMonday of the object
		isMonday = monday;
	}
	
	public static void main(String args[]) {
		
		//To create an instance of a class aka create a new object
		//We use the new keyword and the constructor
		ClassAndMethods cam = new ClassAndMethods();
		
		//After creating our instance of the above class, we have access to its behaviors
		//We call a method with the object.method();
		
		cam.printHello();
		
		//If some method takes in a parameter, that parameter MUST be included, otherwise you will get a
		//compilation error
		cam.changeIsMonday(false);
		System.out.println("Is today monday? " + cam.isMonday);
		
	}
	
}
