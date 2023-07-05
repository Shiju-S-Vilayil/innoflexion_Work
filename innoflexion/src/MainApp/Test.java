package MainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import Model.Person;
import Service.UserDao;

public class Test 
{


    public static void main(String[] args) 
    {
    	Person person=new Person();
    	int ch=0;
    	UserDao.getConnection();
    	UserDao.createTable();
    	Scanner sc=new Scanner(System.in);
    	do
    	{
       System.out.println("-------------------------------------------------------------------------------------------------------------------");
       System.out.println("-------------------------  1 : Insert Data  -----------------------------------------------------------------------");
       System.out.println("-------------------------  2 : View Data  -----------------------------------------------------------------------");
       System.out.println("-------------------------  3 : Data Count  -----------------------------------------------------------------------");
       System.out.println("-------------------------  4 : Exit  -----------------------------------------------------------------------");
       System.out.println("Please type an Option");
        ch=sc.nextInt();
        System.out.println("    ");
  
        System.out.println("    ");
        System.out.println("    ");  
        System.out.println("  -------------------------------------------------------------------------------------------------------  ");
        switch(ch)
        {
        case 1:
        	System.out.println("Please enter the First Name");
        	person.setFirst_name(sc.next());
        	System.out.println("Please enter the Last Name");
        	person.setLast_name(sc.next());
        	System.out.println("Please enter the Address");
        	person.setAddress(sc.next());
        	System.out.println("Please enter the City");
        	person.setCity(sc.next());
        	
        	System.out.println("Please enter the State");
        	person.setState(sc.next());
        	System.out.println("Please enter the Country");
        	person.setCountry(sc.next());
        	UserDao.getConnection();
        	UserDao.save(person);
        	break;
        	
        case 2:
        	UserDao.viewData();
        	break;
        case 3:
        	UserDao.countRows();
        	break;
        case 4:
        	System.out.println("Exit...Thanks");
        	break;
        	default:
        		System.out.println("Invalid Option...Please Try Again ");
        		break;
        }
        
    	}while(ch!=4);
       
       
    }
}
