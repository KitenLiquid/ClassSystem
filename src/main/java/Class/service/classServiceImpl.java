package Class.service;

import java.sql.SQLException;
import java.util.List;

import Class.bean.classxx;
import Class.dao.ClassDao;
import Class.dao.ClassDaoImpl;

public class classServiceImpl implements classService{

	@Override
	public List<classxx> queryAll() throws SQLException {
		ClassDao dao =new ClassDaoImpl();
		return dao.queryAll();
	}

	@Override
	public classxx queryByNumber(int ClassNumber) throws SQLException {
		ClassDao dao =new ClassDaoImpl();
		return dao.queryByNumber(ClassNumber);
	}

	@Override
	public List<classxx> search(String ClassName, String TName) throws SQLException {
		return new ClassDaoImpl().search(ClassName, TName);
	}

	@Override
	public void update(classxx Class) throws SQLException {
		ClassDao dao =new ClassDaoImpl();
		dao.update(Class);
		
	}

}
