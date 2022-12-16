package org.example;

import org.example.config.BerryConfig;
import org.example.config.PokemonConfig;
import org.example.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Non-Spring way of using our HelloWorld class:
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Spring!");
        helloWorld.getMessage();

        // Spring helps us manage our objects, and helps us with dependency injection
        // With large applications, we have a lot of classes that depend on each other.
        // Example: servlet would depend on service. Service class depends on dao/data layer. These are dependencies.
        // Spring helps us configure objects so that they the dependencies are injected at the right time and help us configure values/parameters
        // One way to do this is through XML
        // Objects that are managed by Spring are called beans
        // IOC Container -> Inversion of Control, beans, dependency injections are controlled by the container (rather than the developer)

        // configure the application context based on the xml file:
        // responsible for creating and managing beans:
        ApplicationContext contextXML = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) contextXML.getBean("helloWorld");
        obj.getMessage();

        // constructor based injection (we will configure this in the beans.xml file)
        Pokemon pokemon1 = (Pokemon) contextXML.getBean("pokemon1");
        System.out.println(pokemon1);

        // property based injection:
        // NO DEFAULT CONSTRUCTOR FOUND
        // we need a no-parameters constructor in our Pokemon class for this to work:
        Pokemon pokemon2 = (Pokemon) contextXML.getBean("pokemon2");
        System.out.println(pokemon2);

        Trainer trainer1 = (Trainer) contextXML.getBean("trainer1");
        System.out.println(trainer1);




        System.out.println("\n\n\nAnnotation-based Configuration:");
        // still using the beans.xml file
        Order order = contextXML.getBean(Order.class);
        System.out.println(order);






        System.out.println("\n\n\nJava-based Configuration:");
        // we still configure beans, but this time using a java class with annotations rather than an XMl file
        ApplicationContext contextAnnotation = new AnnotationConfigApplicationContext(PokemonConfig.class);

        // pass in the class that we want to return, we pass in the pokemon class to specify which bean we're actually getting from
        // the configuration class
        Pokemon pokemon3 = contextAnnotation.getBean(Pokemon.class);
        Pokemon pokemon4 = contextAnnotation.getBean(Pokemon.class);

        // if we have singleton scope, this will affect both pokemon:
        pokemon3.setLevel(6);



        System.out.println(pokemon3);
        System.out.println(pokemon4);


        // manually call the clean up methods:
        pokemon3.cleanup();
        pokemon4.cleanup();

        // Because we imported the berry config into the pokemon config, we can use the same annotation context:
        Berry berry = contextAnnotation.getBean(Berry.class);
        System.out.println(berry);

        return;
    }
}
