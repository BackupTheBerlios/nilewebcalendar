package webcalendar.common;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnectionProvider {

	public static Connection getConnection()  {
		
		Connection conn = null;
		
		try {
			Context init = new InitialContext();
			Context ctx = (Context) init.lookup("java:comp/env");
			DataSource pool = (DataSource) ctx.lookup("jdbc/mojedatabaze");
			conn = pool.getConnection();		
		
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		
		
		return conn;		
	}
	
}
