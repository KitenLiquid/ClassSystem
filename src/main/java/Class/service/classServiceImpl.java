package Class.service;

import java.sql.SQLException;
import java.util.List;

import Class.bean.PageBean;
import Class.bean.Student;
import Class.bean.classaa;
import Class.bean.classxx;
import Class.dao.ClassDao;
import Class.dao.ClassDaoImpl;

public class classServiceImpl implements classService{

	@Override
	public PageBean<classxx> queryAll(int currentPage) throws SQLException {
		//封装分页的该页数据
				 PageBean<classxx> pageBean = new PageBean<classxx>();
				
				int pageSize = ClassDao.PAGE_SIZE ;
				pageBean.setCurrentPage(currentPage); //设置当前页
				pageBean.setPageSize(pageSize); //设置每页显示多少记录
				
				ClassDao dao = new ClassDaoImpl() ;
				List<classxx> list =dao.queryAll(currentPage);
				pageBean.setList(list); //设置这一页的学生数据
				
				//总的记录数， 总的页数。
				int count = dao.findCount();
				pageBean.setTotalSize(count); //设置总的记录数
				pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //总页数
				return pageBean;
	}

	@Override
	public classxx queryByNumber(int ClassNumber) throws SQLException {
		ClassDao dao =new ClassDaoImpl();
		return dao.queryByNumber(ClassNumber);
	}

	@Override
	public PageBean<classxx> search(String ClassName, String TName,int currentPage) throws SQLException {
		//封装分页的该页数据
		PageBean<classxx> pageBean = new PageBean<classxx>();
		
		int pageSize = ClassDao.PAGE_SIZE ;
		pageBean.setCurrentPage(currentPage); //设置当前页
		pageBean.setPageSize(pageSize); //设置每页显示多少记录
		
		
		ClassDao dao = new ClassDaoImpl() ;
		List<classxx> list =dao.search(ClassName, TName, currentPage);
		pageBean.setList(list); //设置这一页的学生数据
		System.out.println("list!!!!!!!!!!!!!!!!!!!!!!!!!"+list.size());
		//总的记录数， 总的页数。
		int count = dao.findCount();
		System.out.println("count"+count);
		pageBean.setTotalSize(count); //设置总的记录数
		pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //总页数
		return pageBean;
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

	@Override
	public PageBean<Student> SqueryAll(int currentPage) throws SQLException {
		//封装分页的该页数据
		 PageBean<Student> pageBean = new PageBean<Student>();
		
		int pageSize = ClassDao.PAGE_SIZE ;
		pageBean.setCurrentPage(currentPage); //设置当前页
		pageBean.setPageSize(pageSize); //设置每页显示多少记录
		
		ClassDao dao = new ClassDaoImpl() ;
		List<Student> list =dao.SqueryAll(currentPage);
		pageBean.setList(list); //设置这一页的学生数据
		
		//总的记录数， 总的页数。
		int count = dao.SfindCount();
		pageBean.setTotalSize(count); //设置总的记录数
		pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //总页数
		return pageBean;
	}

	@Override
	public Student SqueryByNumber(int ClassNumber, int Number) throws SQLException {
		ClassDao dao =new ClassDaoImpl();
		return dao.SqueryByNumber(ClassNumber, Number);
	}

	@Override
	public PageBean<Student> Ssearch(String ClassName, String Name, String Sex,int currentPage) throws SQLException {
PageBean<Student> pageBean = new PageBean<Student>();
		
		int pageSize = ClassDao.PAGE_SIZE ;
		pageBean.setCurrentPage(currentPage); //设置当前页
		pageBean.setPageSize(pageSize); //设置每页显示多少记录
		
		
		ClassDao dao = new ClassDaoImpl() ;
		List<Student> list =dao.Ssearch(ClassName, Name, Sex, currentPage);
		pageBean.setList(list); //设置这一页的学生数据
		System.out.println("list"+list.size());
		//总的记录数， 总的页数。
		int count = dao.SfindCount();
		System.out.println("count"+count);
		pageBean.setTotalSize(count); //设置总的记录数
		pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //总页数
		return pageBean;
	}

	@Override
	public void Supdate(Student stu) throws SQLException {
		ClassDao dao =new ClassDaoImpl();
		dao.Supdate(stu);
		
	}

	@Override
	public Student insert2(Student student1) {
		ClassDao dao =new ClassDaoImpl();
		return dao.insert2(student1);
	}

	@Override
	public Student insert3(Student student1) {
		ClassDao dao =new ClassDaoImpl();
		return dao.insert3(student1);
	}

	@Override
	public void delete3(int number, int ClassNumber) {
		ClassDao dao =new ClassDaoImpl();
		dao.delete3(number, ClassNumber);
		
	}

	@Override
	public int findCount() throws SQLException {
		ClassDao dao =new ClassDaoImpl();
		return dao.findCount();
	}

	@Override
	public int SfindCount() throws SQLException {
		ClassDao dao =new ClassDaoImpl();
		return dao.SfindCount();
	}


}
