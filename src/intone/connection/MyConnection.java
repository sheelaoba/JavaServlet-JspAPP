package intone.connection;


import java.sql.Connection;
import java.sql.DriverManager;
//import java.util.Properties;


public class MyConnection {

	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			
		/*	Properties prop=new Properties();
			prop.load(new FileReader("db.properties"));
			Class.forName(prop.getProperty("driver"));
			con=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("uname"),prop.getProperty("passwd"));
			System.out.println("connection established");*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","oracle");
			if(con!=null)
				System.out.println("connection established");
			else
				System.out.println("connection denied");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("db error");
		}
		return con;
	}

}
