package Index.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import Index.Bean.User;
import JNDIutil.JNDIUtils;

public class LoginDao {
	Connection con=null;
	public LoginDao() throws Exception {
		con=JNDIUtils.getConnection();
	}
	public boolean[] WhetherLogin(User user) throws SQLException {
		boolean Flag[]=new boolean[2];
		Flag[0]=false;
		Flag[1]=false;
		String str="select * from user",name,password;
		PreparedStatement preSql=con.prepareStatement(str);
		ResultSet rs = preSql.executeQuery();
		while(rs.next()) {
			name=rs.getString("Account");
			password=rs.getString("Password");
			if(user.getName().equals(name)) {
				Flag[0]=true;
				if(user.getPassword().equals(password)) {
					Flag[1]=true;
				}
				else {
					break;
				}
			}
			
		}
		return Flag;
	}
	public User getInformation(String name) throws SQLException {
		User user=new User();
		String str="select * from user where Account = ?";
		PreparedStatement preSql=con.prepareStatement(str);
		preSql.setString(1,name);
		ResultSet rs = preSql.executeQuery();
		while(rs.next()) {
			user.setAge(rs.getInt("age"));
			user.setIndex(rs.getString("oia"));
			user.setName(rs.getString("Account"));
			user.setPassword(rs.getString("Password"));
			user.setSi(rs.getString("Self-introduce"));
			user.setEg(rs.getString("Et-Gr"));
		}
		return user;
	}
	public void Update(User user) throws SQLException {
		String str="delete from user where oia = ?";
		PreparedStatement presql = con.prepareStatement(str);
		presql.setString(1, user.getIndex());
		presql.executeUpdate();
		String s="insert into user values (?,?,?,?,?,?)";
		PreparedStatement sql = con.prepareStatement(s);
		sql.setString(1, user.getName());
		sql.setString(2, user.getPassword());
		sql.setString(3, user.getIndex());
		sql.setInt(4, user.getAge());
		sql.setString(5, user.getSi());
		sql.setString(6, user.getEg());
		sql.executeUpdate();
	}
	public void closed() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
