# Create a new package in your Labs project called `lab15`
## This final lab will test your knowlege of all the content we went over this week

# Add the needed dependency jars to your Lab project for:
- ### Javalin
- ### Jackson
- ### Logback

# Create a class in the lab15 package called `Address` to be used with the challenge, paste the following code:

```java
public class Address {
    
    private String addressLineOne;
    //Example (APT Number)
    private String addressLineTwo;
    private String city;
    private String state;
    private int zip;
    private String country;

    public Address(){

    }

    public Address(String lineOne, String city, String state, int zip, String country){
        this.addressLineOne = lineOne;
        this.addressLineTwo = "";
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public Address(String lineOne, String lineTwo, String city, String state, int zip, String country){
        this.addressLineOne = lineOne;
        this.addressLineTwo = lineTwo;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address [addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city=" + city
                + ", country=" + country + ", state=" + state + ", zip=" + zip + "]";
    }

}
```

# Create a class in the lab15 package called `Person` to be used with the challenge, paste the following code:

```java
public class Person {
    
    private String name;
    private int age;
    private String email;
    private long socialsecurity;
    private Address address;
    
    public Person() {
    }

    public Person(String name, int age, String email, long socialsecurity, Address address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.socialsecurity = socialsecurity;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSocialsecurity() {
        return socialsecurity;
    }

    public void setSocialsecurity(long socialsecurity) {
        this.socialsecurity = socialsecurity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", age=" + age + ", email=" + email + ", name=" + name
                + ", socialsecurity=" + socialsecurity + "]";
    }

}
```

# Challenge: Create a CRUD API for the Person Class

## Using the correct HTTP request verbs, and route naming conventions implement the following:

## 1. Create a `Lab15` class with a main method
## 2. In the main method of the Lab15 class create a Javalin app mapped to port 8080
## 3. Create a route to READ a list of all the people objects being stored in a file
## 4. Implement the handler to handle the logic of reading all of the people from a file using FileIO
## 5. Create a route to CREATE a new Person object and store it in a file
## 6. Implement the hanlder to handle the logic of create a new Person object, and store it in a file using FileIO
## 7. Create a route to UPDATE a Person object in the file of people
## 8. Implement the handler to handle the logic to find the specified person, and update that record in the file of people
## 9. Create a route to DELETE a Person object from the file of people
## 10. Implement the handler to handle the logic to find the specifed person, and delete that record from the file

## Push to your repository continually as you complete each step