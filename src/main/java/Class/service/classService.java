package Class.service;

import java.sql.SQLException;
import java.util.List;

import Class.bean.PageBean;
import Class.bean.Student;
import Class.bean.classaa;
import Class.bean.classxx;

public interface classService {
	public int findCount()throws SQLException ;
	public int SfindCount()throws SQLException ;
	PageBean<classxx> queryAll(int currentPage)  throws SQLException ;

    	classxx queryByNumber(int ClassNumber)  throws SQLException ;

	PageBean<classxx> search(String ClassName, String TName,int currentPage)  throws SQLException ;	
	
	void update(classxx Class)throws SQLException ;
	public classaa insert(classaa class1);

	public classaa insert1(classaa class1);

	public void delete(int number);
	
	public void delete1(int number);

	PageBean<Student> SqueryAll(int currentPage)  throws SQLException ;

	Student SqueryByNumber(int ClassNumber,int Number)  throws SQLException ;

	PageBean<Student> Ssearch(String ClassName , String Name,String Sex,int currentPage)  throws SQLException ;	
	
	void Supdate(Student stu)throws SQLException ;
	public Student insert2(Student student1) ;
	public Student insert3(Student student1);
	public void delete3(int number,int ClassNumber);

}