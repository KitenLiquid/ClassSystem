package Score.service;

import Score.bean.Score;
import Score.dao.ScoreDao;

public class ScoreService {
	public Score add(Score user)
	{
		ScoreDao dao=new ScoreDao();
		return dao.add(user);
	}
//	public Score delete(Score s)
//	{
//		ScoreDao dao=new ScoreDao();
//		return dao.delete(s);
//	}
}
