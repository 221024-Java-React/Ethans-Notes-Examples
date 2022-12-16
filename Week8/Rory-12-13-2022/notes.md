## Hash Code
    - taking some data and mapping it to an integer (or other data type)
    - consistent, if we hash the same data 100 times using the same hash function, it will produce the same hash code
        - could potentially have multiple values that map to the same hash code, but a good/well-designed hash function will prevent these collisions
    ### Use Cases
        - HashMaps/HashSets
            - hash codes determine the underlying positioning of the data
    ### Passwords
        - When signing up for website, put in the phrase "apples" as password
        - a Hash function could take "apples" and turn it into "DVIRWH%#QHANGA53y543"
            - Function should be irreversible so you can't get the password from the hashed version
        - in the database, we would store the hashed password so if it was breached, the hackers wouldn't have the real password
    - Usually when a make a hash function in Java, we make some sort of combination of the hashcodes of the indidual fields
    - "god" -> 45
    - "dog" -> 45
    - When we override .equals, we are declaring what makes 2 objects equal, therefore, we should also override the hashCode method

## Exceptions
- exceptions vs errors
    - Exceptions, we as the programmer should worry about them
    - Errors, events that programmers are NOT expected to handle
- checked vs unchecked exceptions
    - Checked, compile time
        - class not found
        - file not found
        - can use Throws Clause to "warn" a method that a checked exception could occur
    - Unchecked, runtime exceptions
        - IndexOutOfBounds Exception
        - ArithmeticException
- Throw vs throws
    - Throw is a clause at the top of a method as a "warning"
    - Throws is the action of throwing the exception

## Sub-languages
- DDL - Data Definition Language
    - CREATE - create tables/databases
    - DROP - eliminate, totally get rid of a table/database/column
    - TRUNCATE - get rid of all the data in a table but keep the table itself
    - ALTER - change certain attributes of a table/column such as renaming, adding/dropping columns/constraints
- DCL - Data Control Language
    - GRANT - Give someone access/permission to do something
        - ex: inserting/deleting records
    - REVOKE - Removing access/permission to do something
        - ex: deleting records, etc.
- DML - Data Manipulating Language
    - INSERT - adding new records into our table
    - UPDATE - changing the data of a pre-existing records or records
    - DELETE - removing row(s) from the table
- DQL - Data Query Language
    - SELECT - reading data from the table
        - FROM
        - HAVING
        - GROUP BY
        - ORDER BY
        - WHERE
            - ex: where age > 18
        - LIMIT
            - ex: select * from users order by name limit 10;
        - JOIN
            - ex: select * from pets join users on pets.owner_id = users.id;
        - LIKE
            - select * from users where name LIKE 'R%';
        - Aggregate - function that acts on a group of data
            - SUM, MAX
        - Scalar - function that acts on a single value
            - uppercase, lowercase
- TCL - Transaction Control Language
    - Transaction - a series/sequence of commands
        - ex: removing money from one account and then adding money to another
    - COMMIT - officially make the transaction
    - SAVEPOINT - set a place to return to
    - ROLLBACK - returning to a previous state/commit

## Spring
- Loosely coupled application
- Family of frameworks
- Inversion of Control - Dependency Injection, passing control from programmer to the framework itself
    - Programmer can focus on business logic
- Dependency Injection - injecting beans/dependencies throughout
    - Constructor-based injection
        - need all properties upon initialization (all properties that are defined in the constructor)
    - Setter-based Injection
        - Need a no-arg constructor, can set properties after initialization
- Configurations
    - Annotation-based configuration
    - XML-based configuration
    - Java-based configuration
### Study Tips from Rory:
- Understand Spring as a whole,different frameworks
- Then, understand what different annotations do and what frameworks they fall under
### Spring Boot
- Convention over Configuration
    - Making assumptions about how our project is configured so we, as the developers don't have to worry about that
        - ex: If we configure our Spring Boot project with Spring Web, Spring Boot will automatically assume that we want a server to run, embedded server
            - With embedded server, run the program as a "regular" Java program, without setting up Tomcat configuration
        - ex: Setting up Repositories with Spring Data requires much less configuration on the programmer's part when using Spring Boot
    - Allows for rapid development
    - Opinionated - has its own opinions/ideas/conventions over how the program will run
- start.spring.io
    - online website, pick your dependencies, some meta-data and it genarates the starter project for you
- @SpringBootApplication annotation
    - @EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
    - @ComponentScan: enable @Component scan on the package where the application is located (see the best practices)
    - @Configuration: allow to register extra beans in the context or import additional configuration classes
### Annotations
    - @Component - allows Spring to automatically detect our beans
        - has stereotype annotations, give more info about the class:
            - @Service
            - @Repository
            - @Controller

## REST
- REST, RESTful design - Representational State Transfer
- Constraints
    1. Client-Server architecture
    2. Stateless
        - don't want server to maintain state
        - usually store data in a database
        - For session data, we can use cookies, JWTs, etc.
    3. Uniform Interface
        - Interface is intuitive and logical for the user to understand
        - ex: /s/a is bad because they're not descriptive
        - naming conventions
            - pluralize collections ex: cats, cats/1
            - don't want verbs, ex: cats/insert is bad
                - We have HTTP verbs to tell us the action
                - URI is location of a resource (noun)
    4. Cacheable
        - Responses cached by browser/client
        - Can mark responses as cachable vs non-cachable
        - Idempotent - get the same response every time (GET, PUT, DELETE)
        - Not Idempotent - not getting the same response every time (POST because of ids)
    5. Layered Server Architecture
        - Our service can be comprised of multiple services/layers
    6. Code on Demand (optional)
        - ex: sending a file to the back-end to be executed
- HTTP Methods
    - POST - inserting new data
    - PUT - updating an entire record
    - DELETE - deleting some data
    - GET - retreive data
    - PATCH - updating a part of some record