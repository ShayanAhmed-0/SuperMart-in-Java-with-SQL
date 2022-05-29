package hello;

import java.sql.Connection;
import java.sql.DriverManager;


public class consql {
	
	static Connection con;
	public static Connection createC(){
	try{
		//load the driver
		Class.forName("com.mysql.jdbc.Driver");
		
		String user="root";
		String password="ShayanOOP";
		String url = "jdbc:mysql://localhost:3306/shayandb";
		
	con = DriverManager.getConnection(url,user,password);
	
	}catch(Exception e){
		e.printStackTrace();
	}
	return con;
	}
}
	

