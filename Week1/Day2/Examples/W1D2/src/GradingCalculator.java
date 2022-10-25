
import java.util.Scanner;

public class GradingCalculator {

	
	public static void main(String args[]) {
		
		//Scanner will scan for input, the constructor will tell it where to look for input
		//System.in says to look for input from the console/terminal
		Scanner input = new Scanner(System.in);
		
		//While we are not done, lets take in grades from the console
		boolean running = true;
		while(running) {
			//Lets check for the next grade
			//input a decimal, then hit enter
			System.out.print("Please enter the score: ");
			double score = input.nextDouble();
			//Prevent any funky business, so the nextDouble doesn't get confused when you hit enter
			input.nextLine();
			System.out.println();
			
			//Lets grade the assignment
			if(score >= 90) {
				System.out.println("A");
			}
			else if(score >= 80) {
				System.out.println("B");
			}
			else if(score >= 70) {
				System.out.println("C");
			}
			else if(score >= 60) {
				System.out.println("D");
			}
			else {
				System.out.println("F");
			}
			
			System.out.println("Are you complete with grading? (Y/N)");
			String complete = input.nextLine();
			
			running = complete.equals("Y") ? false : true;
			
		}
		
		System.out.println("Thank you for grading");
		
		input.close();
	}

}
