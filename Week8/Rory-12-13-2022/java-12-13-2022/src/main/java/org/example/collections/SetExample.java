package org.example.collections;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // With sets, cannot have duplicates, insertion order is not necessarily maintained
        Set<String> movies = new TreeSet<>();
        movies.add("Star Wars");
        movies.add("Jurassic Park");
        movies.add("Spider-man 2");
        movies.add("Spider-man 2");
        System.out.println("Size of set: " + movies.size());
        // add a bunch of dummy movies:
        for(int i = 0; i < 1001; i ++) {
            movies.add("Dummy movie " + i);
        }

        Iterator<String> itr = movies.iterator();
        int counter = 0;
        while(itr.hasNext() && counter < 10) {
            System.out.println(itr.next());
            counter ++;
        }

        // with list, can have duplicates, insertion order is maintained
        List<String> food = new ArrayList<>();
        food.add("banana");
        food.add("pizza");
        food.add("burger");
        food.add("apples");
        food.add("apples");
        for(int i = 0; i < food.size(); i ++) {
            System.out.println(food.get(i));
        }

        // Maps:
        Map<String, String> capitals = new HashMap<>();
        capitals.put("New York", "Albany");
        capitals.put("Florida", "Tallahassee");
        capitals.put("Ohio", "Columbus");
        capitals.put("Maryland", "Annapolis");
        capitals.put("Oregon", "Eugene");

        System.out.println();
        System.out.println(capitals.get("New York"));
        System.out.println(capitals.keySet());
        System.out.println(capitals.values());
        // These 2 produce similar output with slightly different syntax:
        System.out.println(capitals.entrySet());
        System.out.println(capitals);
  }

}
