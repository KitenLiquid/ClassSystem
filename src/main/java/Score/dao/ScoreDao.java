package Score.dao; //增删方法

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import JNDIutil.JNDIUtils;
import Score.bean.ScoreBean;
public class ScoreDao{
	ResultSet rs = null;
	ScoreBean existUser = null;	//登录用户
    Connection conn = null;
    PreparedStatement stmt = null;
    Statement stmt2 = null;
    PreparedStatement stmt3 = null;
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
    
	public void Supdate(ScoreBean stu) {
		try {
			conn= JNDIUtils.getConnection();
			String sql="update score set Score=?,Number=? where ClassNumber=?";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, stu.getScore());
			stmt.setInt(2, stu.getNumber());
			stmt.setInt(3, stu.getClassNumber());
			stmt.executeUpdate();
			String sql2="update class set ClassName=?,APnumber=? where ClassNumber=?";
			stmt3=conn.prepareStatement(sql2);
			stmt3.setString(1, stu.getClassName());
			stmt3.setInt(2, stu.getAPnumber());
			stmt3.setInt(3, stu.getClassNumber());
			stmt3.executeUpdate();
					
		} catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	public ScoreBean SqueryByNumber(int ClassNumber) {
		System.out.println(ClassNumber);
        try {
            //JNDI DataSource数据源方式
            conn = JNDIUtils.getConnection();
            //将sql发送给数据库进行编译
            String sql = "select score.Score,score.Number,score.ClassNumber,class.ClassName,Class.APnumber From score,class where score.ClassNumber=class.ClassNumber and score.ClassNumber=?";
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setInt(1, ClassNumber);
            //执行sql
            rs = stmt.executeQuery();
            if (rs.next()) {
            	ScoreBean stu = new ScoreBean();
                stu.setScore(rs.getInt("Score"));
                stu.setNumber(rs.getInt("Number"));
                stu.setClassNumber(rs.getInt("ClassNumber"));
                stu.setClassName(rs.getString("ClassName"));
                stu.setAPnumber(rs.getInt("APnumber"));
                return stu;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

	
	public List<ScoreBean> SqueryAll() throws SQLException {
		List<ScoreBean> stu=new ArrayList<ScoreBean>();
		try {
			conn = JNDIUtils.getConnection();
			String sql = "select student.Name,score.Score,score.Number,score.ClassNumber,class.ClassName,class.APnumber From score,class,student where score.ClassNumber=class.ClassNumber and student.Number=score.Number";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ScoreBean student = new ScoreBean();
				 student.setName(rs.getString("Name"));
				 student.setScore(rs.getInt("Score"));
	             student.setNumber(rs.getInt("Number"));
	             student.setClassNumber(rs.getInt("ClassNumber"));
	             student.setClassName(rs.getString("ClassName"));
	             student.setAPnumber(rs.getInt("APnumber"));
				 stu.add(student);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}

	public List<ScoreBean> Ssearch(String ClassName, int Number) throws SQLException {
		System.out.println(1);
		List<ScoreBean> stu=new ArrayList<ScoreBean>();	
		String sql = "select student.Name,score.Score,score.Number,score.ClassNumber,class.ClassName,class.APnumber From score,class,student where score.ClassNumber=class.ClassNumber and student.Number=score.Number and 1=1";
		if (ClassName != null && !("".equals(ClassName))) {
			sql = sql + " and ClassName like '%" + ClassName + "%'";
		}
		
		if (Number!= 0) {
			sql = sql + " and score.Number = " + Number + "";
		}
		
		try {
			
			System.out.println("4");
			conn = JNDIUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println("3");
				ScoreBean student = new ScoreBean();
				student.setName(rs.getString("Name"));
				student.setScore(rs.getInt("Score"));
	            student.setNumber(rs.getInt("Number"));
	            student.setClassNumber(rs.getInt("ClassNumber"));
	            student.setClassName(rs.getString("ClassName"));
	            student.setAPnumber(rs.getInt("APnumber"));
	            stu.add(student);
	            
			}
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}
}

