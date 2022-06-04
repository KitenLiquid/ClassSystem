package JNDIutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JNDIUtils {	 
    private static Connection conn=null;	//与数据库的连接；
     
    //建立连接
    public static Connection getConnection() throws Exception {
    	//1、初始化Context(名称查找上下文)
    	Context ctx = new InitialContext();    	
    	//2、通过JNDI名称找到DataSource,对名称进行定位java:comp/env是必须加的,后面跟的是DataSource名
    	DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mysql");    	
    	//3、通过DataSource取得一个连接
    	conn = ds.getConnection();
  
        return conn;
    }
    
    //释放资源
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }

        release(stmt, conn);
    }
    
    public static void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}