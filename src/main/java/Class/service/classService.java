package Class.service;

import java.sql.SQLException;
import java.util.List;

import Class.bean.classxx;

public interface classService {
	/**
	 * ��ѯ���пγ�
	 * @return  List<Student>
	 */
	List<classxx> queryAll()  throws SQLException ;
	
	/**
	 * ����ClassNumber��ѯ��������
	 * @return
	 * @throws SQLException
	 */
	classxx queryByNumber(int ClassNumber)  throws SQLException ;
	
	/**
	 * ģ����ѯ
	 * @return ����
	 * @throws SQLException
	 */
	List<classxx> search(String ClassName, String TName)  throws SQLException ;	
	/**
	 * ����ѧ����Ϣ
	 * @param student ��Ҫ���µ�ѧ������
	 * @throws SQLException
	 */
	void update(classxx Class)throws SQLException ;
}