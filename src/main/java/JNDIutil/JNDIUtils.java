package JNDIutil;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JNDIUtils {
	static Connection conn=null;
	public static Connection Sendcon() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
		conn = ds.getConnection();
		return conn;
	}
	public static void destroy(Connection conn) throws SQLException {
		conn.close();
	}
}
