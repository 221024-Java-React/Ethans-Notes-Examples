# Create a new package in your Labs project called `lab11`

# Create a class called `Person` and paste the following code:

```java
public class Person{
    private String first;
    private String last;
    private int age;
    
    public Person(String first, String last, int age){
        this.first = first;
        this.last = last;
        this.age = age;
    }

    public getFirst(){
        return first;
    }

    public setFirst(String first){
        this.first = first;
    }

    public getLast(){
        return last;
    }

    public void setLast(String last){
        this.last = last;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
```

# Create another class called `Lab11` and complete the following logic:

## 1. Create a public method called `nameList` which returns a List of Strings
- The method should take in a List of Person objects from above
- The method should loop through the list of Person objects and add their First names to a new list
- Return the List of first names

## 2. Create a public method called `iteratorFun` which returns a Person
- The method should take in a List of Person objects
- Create an iterator from the List of Person objects passed into the List
- Loop through the list with the iterator, and keep track of the oldest person
- Return the oldest Person

# Create a main method in the Lab11 class and test the methods you just created

## Once complete, commit and push the completed Lab files to your remote repository on GitHub