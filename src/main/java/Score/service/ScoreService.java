package Score.service;

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
}
