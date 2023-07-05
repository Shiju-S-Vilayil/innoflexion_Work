package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.Person;

public class UserDao 
{
	public static Connection con;

	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
        
		return con;
		
	}
	//Creation Table person 
	
	public static void createTable()
	{
		try
		{
            System.out.println("Creating table...");
           Statement stmt = con.createStatement();
            String createTableSql = "CREATE TABLE Persons ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "first_name VARCHAR(50),"
                    + "last_name VARCHAR(50),"
                    + "address VARCHAR(100),"
                    + "city VARCHAR(50),"
                    + "state VARCHAR(50),"
                    + "country VARCHAR(50))";
            stmt.executeUpdate(createTableSql);
            System.out.println("Table created successfully!");
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
	//InsertData into Person Table
	public static void save(Person person)
	{
		try 
		{
			 Statement stmt = con.createStatement();
		     String insertSql = "INSERT INTO Persons (first_name, last_name, address, city, state, country) "
                     + "VALUES ('" + person.getFirst_name() + "', '" + person.getLast_name() + "', '" + person.getAddress() + "', '" + person.getCity() + "', '" + person.getState() + "', '" + person.getCountry() + "')";
             int i=stmt.executeUpdate(insertSql);
           if(i==1)
           {
        	   System.out.println("Person data Created");
           }
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
       
	}
	
	//View data From database
	public static void viewData()
	{
		try 
		{
			 Statement stmt = con.createStatement();
		
			 System.out.println("Selecting inserted rows...");
	            String selectSql = "SELECT * FROM Persons";
	            ResultSet resultSet = stmt.executeQuery(selectSql);
	            while (resultSet.next()) 
	            {
	                int id = resultSet.getInt("id");
	                String firstName = resultSet.getString("first_name");
	                String lastName = resultSet.getString("last_name");
	                String address = resultSet.getString("address");
	                String city = resultSet.getString("city");
	                String state = resultSet.getString("state");
	                String country = resultSet.getString("country");
	                System.out.println("------------------------------------------------------------------------------");
	                System.out.println("ID: " + id);
	                System.out.println("First Name: " + firstName);
	                System.out.println("Last Name: " + lastName);
	                System.out.println("Address: " + address);
	                System.out.println("City: " + city);
	                System.out.println("State: " + state);
	                System.out.println("Country: " + country);
	                System.out.println();
	                System.out.println("------------------------------------------------------------------------------");

	            }
		} 
		catch (Exception e) 
		{
		System.out.println(e);
		}
	}
    // Query to list the count of inserted rows
	public static void countRows()
	{
		try 
		{
            System.out.println("------------------------------------------------------------------------------");

			Statement stmt=con.createStatement();
			 System.out.println("Listing the count of inserted rows...");
	            String countSql = "SELECT COUNT(*) AS count FROM Persons";
	            ResultSet countResultSet = stmt.executeQuery(countSql);
	            if (countResultSet.next()) 
	            {
	                int count = countResultSet.getInt("count");
	                System.out.println("Count of inserted rows: " + count);
	            }
                System.out.println("------------------------------------------------------------------------------");

		} 
		catch (Exception e) 
		{
		
		}
	}
	
	
}
