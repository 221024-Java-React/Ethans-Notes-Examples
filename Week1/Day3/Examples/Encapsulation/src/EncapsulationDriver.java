import encapsulation.Person;

public class EncapsulationDriver extends Person {
    public static void main(String[] args) throws Exception {
        // Now we will try to access some variables of the person class outside of the
        // package, but in a subclass
        // Lets try to access some of the variables of a Person
        Person p = new Person();
        // The age is public so we can access it anywhere
        System.out.println(p.age);

        // Protected is a bit weird, but we can gain access to the protected variables
        // through a child class (more on this later)
        // If the EncapsulationDriver class was in the same package as Person, we could
        // have accessed the firstName variable straight from the person object
        EncapsulationDriver ed = new EncapsulationDriver();
        // As we can see, we have access to the firstName variable from the Person class
        System.out.println(ed.firstName);

        // We can only gain access to the default variables if the classes are in the
        // same package,
        // In this case we are not so we cannot access the variable
        // System.out.println(p.email);

        // The default is also not visible by the EncapsulationDriver object
        // System.out.println(ed.email);

        // Finally private is not visible anywhere
        // System.out.println(p.email);
        // System.out.prinltn(ed.email);
    }
}

class NotASubClass {
    // finally we will try to access a protected variable outside of the package and
    // not a subclass
    Person p = new Person();

    // String first = p.firstName;
}