package Score.service;

import java.sql.SQLException;
import java.util.List;

import Score.bean.ScoreBean;
import Score.dao.ScoreDao;

public class ScoreService {
	public ScoreBean add(ScoreBean user)
	{
		ScoreDao dao=new ScoreDao();
		return dao.add(user);
	}
	public ScoreBean add1(ScoreBean user)
	{
		ScoreDao dao=new ScoreDao();
		return dao.add1(user);
	}
	public void delete(int ClassNumber)
	{
		ScoreDao dao=new ScoreDao();
		dao.delete(ClassNumber);
	}
	public void delete1(int ClassNumber)
	{
		ScoreDao dao=new ScoreDao();
		dao.delete1(ClassNumber);
	}
	
	public void Supdate(ScoreBean stu)
	{
		ScoreDao dao=new ScoreDao();
		dao.Supdate(stu);
	}
	
	public ScoreBean SqueryByNumber(int ClassNumber)
	{
		ScoreDao dao=new ScoreDao();
		return dao.SqueryByNumber(ClassNumber);
	}
	
	public List<ScoreBean> SqueryAll() throws SQLException
	{
		ScoreDao dao=new ScoreDao();
		return dao.SqueryAll();
	}
	
	public List<ScoreBean> Ssearch(String ClassName,int Number) throws SQLException
	{
		ScoreDao dao=new ScoreDao();
		return dao.Ssearch(ClassName,Number);
	}
}
