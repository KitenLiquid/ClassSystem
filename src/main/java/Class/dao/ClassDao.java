package Class.dao;

import java.sql.SQLException;
import java.util.List;

import Class.bean.classxx;

public interface ClassDao {//�ӿ�
		public void update(classxx Class);//�޸�
		public classxx queryByNumber(int ClassNumber);//��ѯbynum
		public List<classxx> queryAll() ;//queryall
		public List<classxx> search(String ClassName , String TName)  throws SQLException;//ģ����ѯ 
}
