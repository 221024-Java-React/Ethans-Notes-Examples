package encapsulation;

//With encapsulation we want to hide states and behaviors of classes, to do so we use access modifiers to determine, what can be seen where in the project
//We also have non-access modifiers
//An encapsulated class will have all states private, and only the needed behaviors accessible
public class Person {

    // public means that we can access this property from anywhere
    // This variable is in the Instance Scope
    public int age = 24;

    // protected means we are capable of accessing this property within the package
    // and sub-classes (we will review inheritance later)
    // This variable is in the Instance Scope
    protected String firstName = "Ethan";

    // default (or no keyword) means that we can access this property from within
    // the same package only
    // This variable is in the Instance Scope
    String lastName = "McGill";

    // private means that this property is only accessible from this class, we want
    // to use this keyword to encapsulate our objects states within the class
    // This variable is in the Instance Scope
    private String email = "ethan.mcgill@revature.com";

    // The static keyword makes the property statically scoped, or essentially
    // making it belong to the class itself. Every object instance created from this
    // class type will share the same exact value
    // This variable is in the Class/Static scope because of the static keyword
    private static String company = "revature";

    // The final keyword makes it so we cannot reassign a value to a property once
    // its been set. Essentially making the property constant
    // This variable is in the Instance Scope
    private final int id = 1;

    // We will be seeing other non-access modifier keywords as we go on in training

    // Method scope applies to variables that are inside of method blocks
    // You cannot use these variables outside of the method
    protected void printName() {
        // This variable is Method scope
        String fullName = firstName + lastName;

        if (company.equals("revature")) {
            // Any variable declared inside of a block of code such as an if, for loop,
            // while loop etc, is considered a block scope, and cannot be used outside of
            // that specific block of code
            String title = "Trainer";
            System.out.println(fullName + " is a " + title + " at " + company);
        }

        // If we tried to access title from the method we will get a compilation error
        // System.out.println(title);

    }

    // If we try to access fullName outside of the method block we will get a
    // compilation error
    // String name = fullName;

    // Encapsulated classes should use mutators to access and set the private
    // variables, we call these getters and setters

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getCompany() {
        return company;
    }

    public static void setCompany(String company) {
        Person.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "My name is " + this.getFirstName();
    }

    //If we override the .equals() method, we are also expected to override the .hashCode() method

    @Override
    public int hashCode() {
        return (int) id * name.hashCode() * email.hashCode();
    }

    @Override
    public boolean equals(Object o){
        //If the same object in memory is passed
        if(this == o) return true;
        //If the object passed into the method is null
        if(o == null) return false;
        //If the objects are not instances of the same class
        if(this.getClass() != o.getClass()) return false;

        //Cass the object to a person, it should be safe at this point
        Person comp = (Person) o;

        return comp.getId() == this.getId();
    }

}
