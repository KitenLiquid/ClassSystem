package Class.dao;

import java.sql.SQLException;
import java.util.List;

import Class.bean.Student;
import Class.bean.classaa;
import Class.bean.classxx;

public interface ClassDao {//�ӿ�
		public void update(classxx Class);//�޸�
		public classxx queryByNumber(int ClassNumber);//��ѯbynum
		public List<classxx> queryAll() throws SQLException ;//queryall
		public List<classxx> search(String ClassName , String TName)  throws SQLException;//ģ����ѯ
		public classaa insert(classaa class1);
		public classaa insert1(classaa teacher);
		public void delete(int number);
		public void delete1(int number);
		public void Supdate(Student stu);//�޸�
		public Student SqueryByNumber(int ClassNumber,int Number);//��ѯbynum
		public List<Student> SqueryAll() throws SQLException ;//queryall
		public List<Student> Ssearch(String ClassName , String Name,String Sex)  throws SQLException;//ģ����ѯ
		public Student insert2(Student student);
		public Student insert3(Student student);
		public void delete3(int number,int ClassNumber);
}
