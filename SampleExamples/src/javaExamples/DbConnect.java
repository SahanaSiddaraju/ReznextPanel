package javaExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//Import required packages
import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.RowSet;

public class DbConnect {
	
	//JDBC driver name and database url
	static final String JDBC_Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://192.168.4.141;databaseName=Madhu";
	
	//DB credentials 
	static final String USER = "sa";
	static final String PASSWORD = "Reznext@32";
	static Properties prop;
	public static void main(String args[]) throws IOException {
    FileInputStream file=new FileInputStream("C:/Users/sahana.siddaraju/workspace/SampleExamples/src/javaExamples/Config.properties");
	prop=new Properties();
	prop.load(file);
    Connection con = null;
	Statement sta = null;
	Scanner sc = new Scanner(System.in);
	
	try {
	    	//Register JDBC driver
	    	//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	
	    	//Open a Connection 
	    	System.out.println("Connecting Database!!");
	    	con = DriverManager.getConnection(prop.getProperty("DBURL"), prop.getProperty("username"),prop.getProperty("password"));
	    	
	    	//Create a statement 
	    	System.out.println("Creating Statment");
	    	sta =con.createStatement();
	    	String sql = "create table Employee" +
	    	"(employeeid int primary key identity(1,1)," +
	    	"employeeName nvarchar(30) null,"+
	    	"DOB date)";
	    	//String col="SELECT count(*) FROM information_schema.columns WHERE table_name = 'TBLRZNRateHeader'";
	    	//ResultSet colcount=sta.executeQuery(col);
	    	//System.out.println(sta.executeQuery(col).first());
	    	//sta.executeUpdate(sql);
	    	
	    	String insert = "insert into Employee values('Anil', '1989/04/02')";
	    	//sta.executeUpdate(insert);
	    	//System.out.println("Data inserted");
	    	
	    	String FormFilling = "Create table FormFilling"+
	    						"(Name nvarchar(255),"+
	    						"Emailid nvarchar(100),"+
	    						"Country nvarchar(50),"+
	    						"State nvarchar(50),"+
	    						"City nvarchar(50),"+
	    						"MobileNumber  nvarchar(12),"+
	    						"DOB date)";
	    						
	    	//sta.executeUpdate(FormFilling);
	    	System.out.println("table created !!");
	    	
	    	System.out.println("Please enter name");
	    	String name = sc.next();
	    	
	    	System.out.println("Please enter email id for " +name);
	    	String emailid = sc.next();
	    	
	    	System.out.println("Country of "+ name);
	    	String country = sc.next();
	    	
	    	System.out.println("State of "+ name);
	    	String state = sc.next();
	    	
	    	System.out.println("City of " + name);
	    	String city = sc.next();
	    	
	    	System.out.println("Mobile number ");
	    	long mobileNumber = sc.nextLong();
	    	
	    	System.out.println("DOB of "+ name);
	    	String DOB = sc.next();
	    	
	    	
	    	String insertForm = "insert into FormFilling values("+name+", "+emailid+", "+country+","+state+", "+city+", "+mobileNumber+", "+DOB+" )";
	    	sta.executeQuery(insertForm);
	    			
	    	/*System.out.println("Enter number of names to be entered in table ");
	    	int namesNumber = sc.nextInt();
	    	
	    	System.out.println("Please enter the names to be added in the table");
	    	for(int i=0;i<namesNumber;i++){
	    		String name = sc.next();
	    		name.toUpperCase();
	    	}
	    	
	    	System.out.println("Please enter the email id to be added in the list");
	    	for(int i=0;i<namesNumber;i++){
    		String emailid = sc.next();
    		emailid.toLowerCase();
	    	}*/
	    	
	    	
	    	
	    	
	    	//Select Query option 
	    	/*while(set.next())
	    	  {
	    	   int id = set.getInt("id");
	    	   int custcode = set.getInt("custcode");
	    	   int ratetypeid = set.getInt("ratetypeid");
	    	   String rateCode = set.getString("rateCode");
	    	   System.out.println(id + " " + custcode + " "+ " " + ratetypeid + " " + rateCode);}
	    	  
	    	} */
	}
	    catch (Exception e) {
	    	e.printStackTrace();
	      
	    

	   
	}
}
}
