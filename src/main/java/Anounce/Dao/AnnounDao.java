package Anounce.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Random;

import javax.naming.NamingException;

import Anounce.Bean.Anou;
import JNDIutil.JNDIUtils;

public class AnnounDao {
	Connection con=null;
	Anou an=null;
	public AnnounDao(Anou an) throws NamingException, SQLException {
		con=JNDIUtils.Sendcon();
		this.an=an;
	}
	public boolean Insert() throws SQLException {
		int i=0;
		String str="insert into anouncement values (?,?,?)";
		PreparedStatement presql = con.prepareStatement(str);
		Random random = new Random();
		presql.setString(1, an.getName());
		presql.setString(2, an.getContent());
		presql.setInt(3, random.nextInt(1000));
		i=presql.executeUpdate();
		if(i==0)
		return false;
		else
			return true;
	}
	public boolean Delete() throws SQLException {
		int i=0;
		String str="delete from anouncement where No=?";
		PreparedStatement presql = con.prepareStatement(str);
		presql.setInt(1, an.getNo());
		i=presql.executeUpdate();
		if(i==0)
			return false;
			else
				return true;
	}	
	public boolean Update() throws SQLException {
		int i=0,j=0;
		String str1="update anouncement set AName = ? where No = ?";
		String str2="update anouncement set Content = ? where No = ?";
		PreparedStatement presql1 = con.prepareStatement(str1);
		PreparedStatement presql2 = con.prepareStatement(str2);
		presql1.setString(1, an.getName());
		presql1.setInt(2, an.getNo());
		presql2.setString(1, an.getContent());
		presql2.setInt(2, an.getNo());
		i=presql1.executeUpdate();
		j=presql2.executeUpdate();
		if(i==0&&j==0)
			return false;
			else
				return true;
	}
	public LinkedList <Anou> Select() throws SQLException {
		LinkedList <Anou>Ac=new LinkedList<Anou>();
		String str="select * from anouncement";
		PreparedStatement presql = con.prepareStatement(str);
		ResultSet rs = presql.executeQuery();
		while(rs.next()) {
			Anou a=new Anou();
			a.setContent(rs.getString("Content"));
			a.setName(rs.getString("AName"));
			a.setNo(rs.getInt("No"));
			Ac.add(a);
		}
		return Ac;
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
