package com.example;

import com.example.controllers.CourseController;
import com.example.controllers.PersonController;
import com.example.dao.CourseDao;
import com.example.dao.CourseDaoJDBC;
import com.example.dao.FileIO;
import com.example.dao.PersonDao;
import com.example.dao.PersonDaoFile;
import com.example.dao.PersonDaoJDBC;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.PersonAlreadyExistsException;
import com.example.exceptions.PersonDoesNotExistException;
import com.example.models.Person;
import com.example.models.PersonType;
import com.example.services.CourseService;
import com.example.services.PersonService;

import io.javalin.Javalin;

public class SchoolManagementDriver {
	
	public static void main(String args[]) {
		
		/* Typically at the top of our main, I like to create all our daos and services and controllers */
		PersonDao pDao = new PersonDaoJDBC();
		PersonService pServ = new PersonService(pDao);
		PersonController pController = new PersonController(pServ);
		CourseDao cDao = new CourseDaoJDBC();
		CourseService cServ = new CourseService(cDao, pDao);
		CourseController cController = new CourseController(cServ);
		
		
		//Setup our javalin app and routes
		Javalin app = Javalin.create(config -> {
		    config.plugins.enableCors(cors -> {
		        cors.add(it -> {
		            it.anyHost();
		        });
		    }); 
		});
		
		//Here we would have our routes/handlers
		app.get("/hello", (ctx) -> ctx.result("Hello, we are making our first get request"));
		
		app.post("/person/register", pController.handleRegister);
		app.get("/person/", pController.handleGetAll);
		app.post("/person/login", pController.handleLogin);
		app.delete("/person/", pController.handleDelete);
		app.put("/person/", pController.handleUpdate);
		app.get("/person/session", pController.checkSession);
		app.get("/person/logout", pController.handleLogout);
		
		app.post("/course", cController.handleCreate);
		app.get("/course", cController.handleRead);
		app.put("/course", cController.handleUpdate);
		

		//We can also register handlers to deal with exceptions
		app.exception(InvalidCredentialsException.class, (e, context) -> {
			context.status(401);
			context.result("You were unable to login");
		});
		
		app.exception(PersonAlreadyExistsException.class, (e, context)-> {
			context.status(409);
			context.result("You are not able to register an account with an email which already exists");
		});
		
		//Finally we start the application
		app.start(8000);
		
		
		
		/*
		Person p = new Person("Ethan", "McGill", 11122333l, true, "email@mail.com", "password", 3.0);

		FileIO<Person> personIO = new FileIO<Person>("person.txt");
		
		personIO.writeObject(p);
		
		System.out.println(personIO.readObject());
		//The easiest way to test before we have an api setup is through the driver
		PersonDao pDao = new PersonDaoFile();
		PersonService pService = new PersonService(pDao);
		
		pService.registerPerson("Andrew", "Hint", 111223333, false, "andrew@mail.com", "password", 4.0);
		
		System.out.println(pService.login("ethan@mail.com"));
		//pDao.addPerson(new Person("Ethan", "McGill", 111223333, true, "ethan@mail.com", "password", 0));
		
		System.out.println(pDao.getAllPeople());
		*/
	}
	
	
}
