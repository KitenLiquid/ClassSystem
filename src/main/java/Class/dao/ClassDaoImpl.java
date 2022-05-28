package Class.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Class.bean.classxx;
import JNDIutil.JNDIUtils;






public class ClassDaoImpl implements ClassDao{
	Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    PreparedStatement stmt2=null;

	@Override
	public void update(classxx Class) {
		try {
			conn= JNDIUtils.getConnection();
			String sql="update class set ClassName=?,APnumber=? where ClassNumber=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, Class.getClassName());
			stmt.setInt(2, Class.getAPnumber());
			stmt.setInt(3, Class.getClassNumber());
			stmt.executeUpdate();
			String sql2="update teacher set TName=?,PhoneNumber=? where ClassNumber=?";
			stmt2=conn.prepareStatement(sql2);
			stmt2.setString(1, Class.getTName());
			stmt2.setInt(2, Class.getPhoneNumber());
			stmt2.setInt(3, Class.getClassNumber());
			stmt2.executeUpdate();
					
		} catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public classxx queryByNumber(int ClassNumber) {
		System.out.println(ClassNumber);
        try {
            //JNDI DataSource数据源方式
            conn = JNDIUtils.getConnection();
            //将sql发送给数据库进行编译
            String sql = "SELECT class.ClassName,class.ClassNumber,class.APnumber,teacher.TName,teacher.PhoneNumber FROM class,teacher where class.ClassNumber=teacher.ClassNumber and class.ClassNumber=?";
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setInt(1, ClassNumber);
            //执行sql
            rs = stmt.executeQuery();
            if (rs.next()) {
                classxx classxx = new classxx();
                classxx.setClassName(rs.getString("ClassName"));
                classxx.setAPnumber(rs.getInt("APnumber"));
                classxx.setClassNumber(rs.getInt("ClassNumber"));
                classxx.setTName(rs.getString("TName"));
                classxx.setPhoneNumber(rs.getInt("PhoneNumber"));
                return classxx;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	@Override
	public List<classxx> queryAll()  throws SQLException {
		List<classxx> classxx=new ArrayList<classxx>();
		try {
			conn = JNDIUtils.getConnection();
			String sql = "SELECT class.ClassName,class.ClassNumber,class.APnumber,teacher.TName,teacher.PhoneNumber FROM class,teacher where class.ClassNumber=teacher.ClassNumber";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				classxx classx = new classxx();
				classx.setClassName(rs.getString("ClassName"));
                classx.setAPnumber(rs.getInt("APnumber"));
                classx.setClassNumber(rs.getInt("ClassNumber"));
                classx.setTName(rs.getString("TName"));
                classx.setPhoneNumber(rs.getInt("PhoneNumber"));
                classxx.add(classx);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classxx;
	}

	@Override
	public List<classxx> search(String ClassName, String TName) throws SQLException {
		List<classxx> classxx=new ArrayList<classxx>();	
		String sql = "SELECT class.ClassName,class.ClassNumber,class.APnumber,teacher.TName,teacher.PhoneNumber FROM class,teacher where class.ClassNumber=teacher.ClassNumber and 1=1";
		if (ClassName != null && !"".equals(ClassName)) {
			sql = sql + " and ClassName like '%" + ClassName + "%'";
		}

		if (TName != null && !"".equals(TName)) {
			sql = sql + " and TName like '%" + TName + "%'";
		}
		try {
			
			System.out.println(TName);
			conn = JNDIUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				classxx classx = new classxx();
				classx.setClassName(rs.getString("ClassName"));
                classx.setAPnumber(rs.getInt("APnumber"));
                classx.setClassNumber(rs.getInt("ClassNumber"));
                classx.setTName(rs.getString("TName"));
                classx.setPhoneNumber(rs.getInt("PhoneNumber"));
                classxx.add(classx);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classxx;
	}
	

	


}
