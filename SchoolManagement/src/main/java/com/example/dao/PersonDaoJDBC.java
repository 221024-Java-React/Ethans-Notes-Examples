package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.models.Person;
import com.example.models.PersonType;
import com.example.utils.JDBCConnectionUtil;

public class PersonDaoJDBC implements PersonDao {
	
	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();

	@Override
	public void addPerson(Person p) throws SQLException{

		//We need a connection to create a statment
		Connection connection = conUtil.getConnection();
			
		int type = p.getType().ordinal() + 1;
			
		//The actual SQL query we want to execute
		String sql = "INSERT INTO people (type, first_name, last_name, email, password) VALUES"
				+ "(" + type + ",'" + p.getFirstName() +"','" + p.getLastName() + "','" +
				p.getEmail() + "','" + p.getPassword() + "')";
		
		//Get the statement to actually make our query
		Statement statement = connection.createStatement();
			
		//Execute the SQL query
		statement.execute(sql);
	}

	@Override
	public List<Person> getAllPeople() {
		
		List<Person> pList = new ArrayList();

		try {
			
			//We need a connection to create a statment
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM people";
			
			Statement statement = connection.createStatement();
			
			//When we are returning data from a query, we need to store that data in a ResultSet
			//ResultSet will essentially return a collection of rows with your data
			ResultSet result = statement.executeQuery(sql);
			
			//We need to loop through our result set and return the list of people
			while(result.next()) {
				Person p = new Person();
				//JDBC indexes from 1
				p.setId(result.getInt(1));
				
				if(result.getInt(2) == 1) {
					p.setType(PersonType.TEACHER);
				}else {
					p.setType(PersonType.STUDENT);
				}
				
				p.setFirstName(result.getString(3));
				p.setLastName(result.getString(4));
				p.setEmail(result.getString(5));
				p.setPassword(result.getString(6));
				
				pList.add(p);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return pList;
	}

	@Override
	public Person getPersonByEmail(String email) {
		Person p = null;
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM people WHERE email='" + email + "'";
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				p = new Person();
				p.setId(result.getInt(1));
				
				if(result.getInt(2) == 1) {
					p.setType(PersonType.TEACHER);
				}else {
					p.setType(PersonType.STUDENT);
				}
				
				p.setFirstName(result.getString(3));
				p.setLastName(result.getString(4));
				p.setEmail(result.getString(5));
				p.setPassword(result.getString(6));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public void deletePerson(String email) {

		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "DELETE FROM people WHERE email='" + email + "'";
			
			Statement statement = connection.createStatement();
			
			statement.execute(sql);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePerson(Person p) {

		try {
			
			Connection connection = conUtil.getConnection();
			
			int type = p.getType().ordinal() + 1;
			
			String sql = "UPDATE people SET type ="  + type + ",first_name = '" + p.getFirstName() + 
					"', last_name ='" + p.getLastName() + "', email='" + p.getEmail() + "', password='" +
					p.getPassword() + "' WHERE id =" + p.getId();
			
			Statement statement = connection.createStatement();
			
			statement.execute(sql);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Person getPersonById(int id) {
		
		Person p = null;

		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM people WHERE id=?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				p = new Person();
				p.setId(result.getInt(1));
				
				if(result.getInt(2) == 1) {
					p.setType(PersonType.TEACHER);
				}else {
					p.setType(PersonType.STUDENT);
				}
				
				p.setFirstName(result.getString(3));
				p.setLastName(result.getString(4));
				p.setEmail(result.getString(5));
				p.setPassword(result.getString(6));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

}
