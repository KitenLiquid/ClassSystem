package Score.dao; //增删方法

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import JNDIutil.JNDIUtils;
import Score.bean.Score;

public class ScoreDao{
	ResultSet rs = null;
	Score existUser = null;	//登录用户
    Connection conn = null;
    PreparedStatement stmt = null;
    Statement stmt2 = null;
	public Score add(Score user) 
	{ //登录   
        try {//JDBC查询
        	String score=user.getScore();
        	String number=user.getNumber();
        	String classnumber=user.getClassNumber();
        	String classname=user.getClassName();
            conn = JNDIUtils.getConnection();
            String sql = "select * from score where classnumber=?";//数据库编译时
            stmt = conn.prepareStatement(sql);	//将sql发送给数据库进行编译
            
            //设置sql参数
            stmt.setString(1, classnumber);	//传入数据值，不会作为关键字 --防止注入      
            rs = stmt.executeQuery();			//执行sql
                                    
            //如果登陆成功，rs将只有一条记录            
            if(rs.next()) 
            {
                System.out.println("已有该课程号");
            }
            else
            {
            	stmt2=conn.createStatement();
            	sql="insert into score values('"+score+"','"+number+"','"+classnumber+"')";
            	int ok=stmt2.executeUpdate(sql);
            	sql="INSERT INTO class (ClassName) values('" + classname + "');";
            	ok=stmt2.executeUpdate(sql);
            	existUser=new Score("score","number","classnumber","classname");
            	stmt2.close();
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        System.out.println(existUser);    
        JNDIUtils.release(rs, stmt, conn);
        return existUser;
    }

	public void delete(Score s) 
	{
		
		
	}
}
