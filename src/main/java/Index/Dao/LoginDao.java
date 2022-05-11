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
	public LoginDao() throws NamingException, SQLException {
		con=JNDIUtils.Sendcon();
	}
	public boolean[] WhetherLogin(User user) throws SQLException {
		boolean Flag[]=new boolean[2];
		String str="select * from user where Account = ?";
		String password;
		PreparedStatement preSql=con.prepareStatement(str);
		preSql.setString(1, user.getName());
		ResultSet rs = preSql.executeQuery();
		if(rs.next()!=true) {
			Flag[0]=false;
			Flag[1]=false;
		}
		else {
			Flag[0]=true;
			password=rs.getString("Password");
			if(user.getPassword().equals(password)) {
				Flag[1]=true;
			}
			else {
				Flag[1]=false;
			}
		}
		return Flag;
	}
}
