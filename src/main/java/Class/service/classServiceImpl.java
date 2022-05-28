package Class.service;

import java.sql.SQLException;
import java.util.List;

import Class.bean.classaa;
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

	public classaa insert(classaa class1) {
		// TODO Auto-generated method stub
		ClassDao dao =new ClassDaoImpl();//增加，将classaa对象传递 DAO
	        return dao.insert(class1);
	}

	public classaa insert1(classaa class1) {
		// TODO Auto-generated method stub
		ClassDao dao =new ClassDaoImpl(); //增加，将classaa对象传递 DAO
        return dao.insert1(class1);
	}

	public void delete(int number) {
		// TODO Auto-generated method stub
		ClassDao dao =new ClassDaoImpl(); //删除
	        dao.delete(number);
	}
	
	public void delete1(int number) {
		// TODO Auto-generated method stub
		ClassDao dao =new ClassDaoImpl();//删除
	        dao.delete1(number);
	}


}
