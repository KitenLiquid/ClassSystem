package Score.dao; //增删方法

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import JNDIutil.JNDIUtils;
import Score.bean.ScoreBean;

public class ScoreDao{
	ResultSet rs = null;
	ScoreBean existUser = null;	//登录用户
    Connection conn = null;
    PreparedStatement stmt = null;
    Statement stmt2 = null;
	public ScoreBean add(ScoreBean user) 
	{ //登录   
        try {//JDBC查询
        	int Score=user.getScore();
        	int Number=user.getNumber();
        	int ClassNumber=user.getClassNumber();
            conn = JNDIUtils.getConnection();
            String sql = "select * from score where Number=?";//数据库编译时
            stmt = conn.prepareStatement(sql);	//将sql发送给数据库进行编译
            
            
            //设置sql参数
            stmt.setInt(1, Number);	//传入数据值，不会作为关键字 --防止注入      
            rs = stmt.executeQuery();			//执行sqlssss
            //如果登陆成功，rs将只有一条记录            
            if(rs.next()) 
            {
                System.out.println("已有该学号");
            }
            else
            {
            	stmt2=conn.createStatement();
            	sql="insert into score values('"+Score+"','"+Number+"','"+ClassNumber+"')";
            	@SuppressWarnings("unused")
				int ok=stmt2.executeUpdate(sql);
            	existUser=new ScoreBean(Score,Number,ClassNumber);
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
	public ScoreBean add1(ScoreBean user) 
	{
		//登录   
        try {//JDBC查询
        	int ClassNumber=user.getClassNumber();
        	String ClassName=user.getClassName();
        	int APnumber=user.getAPnumber();
            conn = JNDIUtils.getConnection();
            String sql = "select * from class where ClassNumber=?";//数据库编译时
            stmt = conn.prepareStatement(sql);	//将sql发送给数据库进行编译
            
            
            //设置sql参数
            stmt.setInt(1, ClassNumber);	//传入数据值，不会作为关键字 --防止注入      
            rs = stmt.executeQuery();			//执行sqlssss
            //如果登陆成功，rs将只有一条记录            
            if(rs.next()) 
            {
                System.out.println("已有该课程号");
            }
            else
            {
            	stmt2=conn.createStatement();
            	sql="insert into class values('"+ClassName+"','"+ClassNumber+"','"+APnumber+"')";
            	@SuppressWarnings("unused")
				int ok=stmt2.executeUpdate(sql);
            	existUser=new ScoreBean("ClassName",ClassNumber,APnumber);
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
	
	public void delete(int number) 
	{ //登录   
        try {//JDBC查询
//        	int ClassNumber=user.getClassNumber();
            conn = JNDIUtils.getConnection();
            String sql = "select * from score where ClassNumber=?";//数据库编译时
            stmt = conn.prepareStatement(sql);	//将sql发送给数据库进行编译
            
            
            //设置sql参数
            stmt.setInt(1, number);	//传入数据值，不会作为关键字 --防止注入      
            rs = stmt.executeQuery();			//执行sqlssss
            //如果登陆成功，rs将只有一条记录            
            if(rs.next()) 
            {
                System.out.println("可删除");
                stmt2=conn.createStatement();
                sql = "delete from score where ClassNumber='"+number+"'";
				stmt2.executeUpdate(sql);
            }
            else
            {
            	 System.out.println("课程已不存在或已删除");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
	
	public void delete1(int number) 
	{
		try {//JDBC查询
//        	int ClassNumber=user.getClassNumber();
            conn = JNDIUtils.getConnection();
            String sql = "select * from class where ClassNumber=?";//数据库编译时
            stmt = conn.prepareStatement(sql);	//将sql发送给数据库进行编译
            
            
            //设置sql参数
            stmt.setInt(1, number);	//传入数据值，不会作为关键字 --防止注入      
            rs = stmt.executeQuery();			//执行sqlssss
            //如果登陆成功，rs将只有一条记录            
            if(rs.next()) 
            {
                System.out.println("可删除");
                stmt2=conn.createStatement();
                sql = "delete from class where ClassNumber='"+number+"'";
				stmt2.executeUpdate(sql);
            }
            else
            {
            	System.out.println("课程已不存在或已删除");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
}
