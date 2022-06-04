package JNDIutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JNDIUtils {	 
    private static Connection conn=null;	//�����ݿ�����ӣ�
     
    //��������
    public static Connection getConnection() throws Exception {
    	//1����ʼ��Context(���Ʋ���������)
    	Context ctx = new InitialContext();    	
    	//2��ͨ��JNDI�����ҵ�DataSource,�����ƽ��ж�λjava:comp/env�Ǳ���ӵ�,���������DataSource��
    	DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mysql");    	
    	//3��ͨ��DataSourceȡ��һ������
    	conn = ds.getConnection();
  
        return conn;
    }
    
    //�ͷ���Դ
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