package org.example.config;

import org.example.entity.Berry;
import org.example.entity.Pokemon;

// imported from spring
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// this class is going to be a source for bean definitions
// in other words, this class will contain a method that configures how a bean should be created
@Configuration
// any methods we have in our berry config, we can use in our pokemon config class
@Import(BerryConfig.class)
// will "replace" the xml configuration
public class PokemonConfig {

    // return an object that will be registered as a bean (managed by the Application Context)
    @Bean(initMethod = "init", destroyMethod = "cleanup")
    // bean scopes:
    // singleton - single bean instance (default).
    // prototype - multiple instances, we can have state because there are multiple instances
    // So if we don't specify a scope, we're stuck with Singleton which means we're going to get
    // the same Pokemon every time (only one instance)
    @Scope("prototype")
    public Pokemon getRandomPokemon() {
        List<String> names = new ArrayList<>();
        names.add("Bulbasaur");
        names.add("Squirtle");
        names.add("Charmander");
        // helps us generate random numbers
        Random generator = new Random();
        // next int return a random number between 0 and the number minus 1
        // getting a random name from the list and storing it in the name variable:
        String name = names.get(generator.nextInt(names.size()));
        String type1 = "type1";
        String type2 = "type2";
        int level = 5;

        // recursive bean creation
        ApplicationContext contextAnnotation = new AnnotationConfigApplicationContext(PokemonConfig.class);
        Berry berry = contextAnnotation.getBean(Berry.class);

        // return a pokemon with a random species/name:
        return new Pokemon(name, name, type1, type2, level);

    }

    // Can't have this if we're importing berry config class
//    @Bean
//    Berry getBerry() {
//        return new Berry();
//    }

    // We can't have multiple bean methods that return the same type:
//    @Bean
//    public Pokemon getPokemon() {
//        return new Pokemon();
//    }
}
