package Class.dao;

import java.sql.SQLException;
import java.util.List;

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
}
