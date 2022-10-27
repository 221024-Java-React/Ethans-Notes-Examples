package encapsulation;

public class SamePackageTest {

    // Lets first take a look at what happens when trying to access variables from
    // within the same package
    // public, protected, and default can all be accessed from within the same
    // package

    Person p = new Person();

    // age is a public variable in Person
    int age = p.age;

    // firstName is a protected variable, so it can be accesed from sub classes and
    // inside of the package
    String first = p.firstName;

    // lastName is a default variable, so it can be accessed from inside of the
    // class and the package only
    String last = p.lastName;

    // Obviously private is only inside of the class
    // String email = p.email;
}
