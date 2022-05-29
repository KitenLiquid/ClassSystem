package Class.dao;

import java.sql.SQLException;
import java.util.List;

import Class.bean.Student;
import Class.bean.classaa;
import Class.bean.classxx;

public interface ClassDao {//接口
		public void update(classxx Class);//修改
		public classxx queryByNumber(int ClassNumber);//查询bynum
		public List<classxx> queryAll() throws SQLException ;//queryall
		public List<classxx> search(String ClassName , String TName)  throws SQLException;//模糊查询
		public classaa insert(classaa class1);
		public classaa insert1(classaa teacher);
		public void delete(int number);
		public void delete1(int number);
		public void Supdate(Student stu);//修改
		public Student SqueryByNumber(int ClassNumber,int Number);//查询bynum
		public List<Student> SqueryAll() throws SQLException ;//queryall
		public List<Student> Ssearch(String ClassName , String Name,String Sex)  throws SQLException;//模糊查询
		public Student insert2(Student student);
		public Student insert3(Student student);
		public void delete3(int number,int ClassNumber);
}
