package org.example.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionExample {
    // throws is a more of a warning that tells us this method contains code that could throw an exception
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("text.txt");
        try {
            Scanner scanner = new Scanner(file);
            System.out.println(scanner.nextLine());
        } catch(FileNotFoundException e) {
            // write our custom behavior for what happens when the exception is thrown
            System.out.println("The file was not found.");
            // throw is the act of throwing an exception
            throw new RuntimeException();
        }
        System.out.println(read(file));
    }

    // because this method throws the FileNotFoundException, we do have to declare it
    // in the main method
    // Switching to a try/catch block would alleviate this need
    public static String read(File file) throws FileNotFoundException{
        Scanner scanner = new Scanner(file);
        return scanner.nextLine();

    }
}
