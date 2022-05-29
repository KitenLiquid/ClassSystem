package Class.service;

import java.sql.SQLException;
import java.util.List;

import Class.bean.Student;
import Class.bean.classaa;
import Class.bean.classxx;

public interface classService {
	List<classxx> queryAll()  throws SQLException ;

	classxx queryByNumber(int ClassNumber)  throws SQLException ;

	List<classxx> search(String ClassName, String TName)  throws SQLException ;	
	
	void update(classxx Class)throws SQLException ;
	public classaa insert(classaa class1);

	public classaa insert1(classaa class1);

	public void delete(int number);
	
	public void delete1(int number);

	List<Student> SqueryAll()  throws SQLException ;

	Student SqueryByNumber(int ClassNumber,int Number)  throws SQLException ;

	List<Student> Ssearch(String ClassName , String Name,String Sex)  throws SQLException ;	
	
	void Supdate(Student stu)throws SQLException ;
	public Student insert2(Student student1) ;
	public Student insert3(Student student1);
	public void delete3(int number,int ClassNumber);

}