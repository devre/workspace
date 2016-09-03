package shreeDevelopment;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSQLServerConnection {

	public static void main(String[] args) 
	{
		Connection conn = null;
		 
        try {
       // 	Data Source=Shree365.db.12017601.hostedresource.com;Initial Catalog=Shree365;User ID=Shree365;Password=***********
            String dbURL = "jdbc:microsoft:sqlserver://HOST:1433; DatabaseName=shree365";
            String user = "devre";
            String pass = "kHUSHI2002";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

	}

}
