package Class.service;

import java.sql.SQLException;
import java.util.List;

import Class.bean.classxx;

public interface classService {
	/**
	 * 查询所有课程
	 * @return  List<Student>
	 */
	List<classxx> queryAll()  throws SQLException ;
	
	/**
	 * 根据ClassNumber查询单个对象
	 * @return
	 * @throws SQLException
	 */
	classxx queryByNumber(int ClassNumber)  throws SQLException ;
	
	/**
	 * 模糊查询
	 * @return 集合
	 * @throws SQLException
	 */
	List<classxx> search(String ClassName, String TName)  throws SQLException ;	
	/**
	 * 更新学生信息
	 * @param student 需要更新的学生数据
	 * @throws SQLException
	 */
	void update(classxx Class)throws SQLException ;
}