package org.example.exceptions;

public class UncheckedExepetionsExample {
    public static void main(String[] args) {
        int[] numbers = {1,2,3};
        try {
            // divide by 0, should throw an arithmetic exception
            int x = 4/1;
            System.out.println(x);
            // trying to access index 6 should throw an index out of bounds exception:
            System.out.println(numbers[2]);
        } catch(ArithmeticException arithmeticException) {
            System.out.println("Some arithmetic exception happened, maybe divide by 0?");
        } catch(IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Index out of bounds, last element: " + numbers[numbers.length-1]);
        } finally {
            System.out.println("This will print no matter what.");
        }
        // because IndexOutOfBoundsException is checked at run time, we don't need to declare a throws clause
        // only for checked exception
        int y = 4/0;
    }
}
