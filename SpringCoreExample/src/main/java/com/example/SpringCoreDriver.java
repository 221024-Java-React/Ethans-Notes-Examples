package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.models.Account;
import com.example.models.AccountType;
import com.example.models.Transaction;
import com.example.models.TransactionType;
import com.example.models.User;
import com.example.repository.UserRepository;
import com.example.repository.UserRepositoryImpl;
import com.example.service.AccountService;
import com.example.service.TransactionService;
import com.example.service.UserService;

public class SpringCoreDriver {
	
	/*
	 * The purpose of Spring and the Spring Framework is to help us manage, and write more maintainable
	 * and loosely code
	 * - We just saw and spoke about how dependencies can span accross hundreds if not 1000s of classes making code hard to maintain
	 * - What if we cant to change the object, or type of that object
	 * 		- JPEG file handling class
	 * 		- PNG  file handling class
	 * 		- ...
	 * 
	 * With spring, we can add only what need, if you just want the dependency management you can get away with just core and beans
	 * 	- Core provides the IOC
	 * 	- Beans provides the injection
	 * 
	 * If you want to support cross cutting concerns you can add AOP
	 * If you want turn your java code into a web server, you can add MVC
	 * 
	 * What Spring Does, (Spring beans and core) is flip the dependency management on its on head
	 * - Springs primary goal is to help with dependencies between classes by using inversion of control
	 * 	- You give the need to manage the class instances inside of other classes to spring
	 * 	- Instead of creating instances of classes manually, we instead ask spring to do it for us, using its version of IOC
	 * 
	 * IOC: giving up control of certain parts of our code to some other entity to acheive loose coupling
	 * 	- The specific part we are giving up is managing dependencies
	 * 	- Spring will create instances of all the classes that other classes depend on (we do have to tell spring what these classes are)
	 * 		- Spring provide each class that depends on another class with the instance that it needs, either through a setter method
	 * 			or a constructor
	 * 	- Spring "Injects" the dependency a class needs through Dependency Injection
	 * 
	 * Previously we talked about wouldn't it be nice if we had a central location/repo for the instances of classses we need
	 * to share around our application
	 * 	- Well good thing is such place called the Inversion of Control Container
	 * 		- Build this container using either XML or java classes
	 * 	- IOC Containers in Spring are called the BeanFactory and ApplicationContext
	 * 		- BeanFactory is the outdated and most simple version of the IOC Container
	 * 		- ApplicationContext is the modern feature rich child of the BeanFactory
	 * 			- Has all the features of the BeanFactory plus some
	 *	- IOC container holds the references to all the objects Spring is managing
	 *	- The objects that Spring is managing are called Beans
	 * 
	 */
	
	public static void main(String args[]) {
		//We have to load in the application context via the file
		//The application context, holds all the references to the different beans that spring manages for us
		//So far, we have told spring to manage the UserRepository class and the AccountRepository Class
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*
		//When we want the instance of a bean that spring manages will we use the application context
		UserRepository uRepo = appContext.getBean("UserRepoBean", UserRepositoryImpl.class);
		
		uRepo.createUser(new User());
		
		UserService uServ = appContext.getBean("UserServiceBean", UserService.class);
		uServ.saveUser(1, "Ethan", "McGill", "ethan.mcgill@mail.com", "password");
		
		AccountService aServ = appContext.getBean("AccountServiceBean", AccountService.class);
		User u = new User(1, "Ethan", "McGill", "ethan.mcgill@mail.com", "password", new ArrayList<Account>());
		
		aServ.saveAccount(1000234577541234l, u, AccountType.CHECKING);
		*/
		
		User u = new User(1, "Ethan", "McGill", "ethan.mcgill@mail.com", "password", new ArrayList<Account>());
		TransactionService tServ = appContext.getBean("TransactionServiceBean", TransactionService.class);
		Account to = new Account(1000234577541234l, u, AccountType.CHECKING, 0.0, new ArrayList<Transaction>());
		tServ.saveTransaction(TransactionType.DEPOSIT, to , null, 100.0);
		
		
	}

}
