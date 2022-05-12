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
}
