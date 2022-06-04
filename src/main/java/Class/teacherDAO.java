package Class;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import JNDIutil.JNDIUtils;

public class teacherDAO {
	Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Statement stmt2=null;
    public void insert1(Teacher teacher) throws NamingException { 
    	try {   
		    String TName=teacher.getTName();
		    String ClassNumber=teacher.getClassNumber();
		    String PhoneNumber=teacher.getPhoneNumber();
		  //JNDI DataSource数据源方式
            conn = JNDIUtils.Sendcon();            //将sql发送给数据库进行编译
            String sql = "select * from  teacher  where Tname=?";
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1, TName);
            //执行sql
            rs = stmt.executeQuery();
            int w=1;
            String name;
            while(rs.next()){   	
                name=rs.getString("Tname");
            }
            if(w==1) {
            	sql ="insert into teacher values (?,?,?) "; 	
			    PreparedStatement sql2 = conn.prepareStatement(sql);
				sql2.setString(1,TName);
                sql2.setInt(2,Integer.valueOf(ClassNumber));
                sql2.setInt(3,Integer.valueOf(PhoneNumber));
                sql2.executeUpdate();
            }
		    
		
	} catch (SQLException e) {
		System.out.println(e.toString());
		// TODO: handle exception
	}
	}


}
