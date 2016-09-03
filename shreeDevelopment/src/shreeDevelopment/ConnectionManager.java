package shreeDevelopment;

import java.sql.*;
//import java.util.*;

public class ConnectionManager 
{
	static Connection con;
    static String url;
          
    public static Connection getConnection()
    {
      
       try
       {
          String url = "jdbc:odbc:" + "Microsoft"; 
          // assuming "DataSource" is your DataSource name

          Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
          
          try
          {            	
             con = DriverManager.getConnection(url,"devre","kHUSHI2002");                
          }
          
          catch (SQLException ex)
          {
             ex.printStackTrace();
          }
       }

       catch(ClassNotFoundException e)
       {
          System.out.println(e);
       }

    return con;
}
}
