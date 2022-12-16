package org.example.entity;

public class HelloWorld {
    // simple class, only contains one attribute
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your message: " + this.message);
    }
}
