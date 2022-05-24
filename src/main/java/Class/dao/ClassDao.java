package Class.dao;

import java.sql.SQLException;
import java.util.List;

import Class.bean.classxx;

public interface ClassDao {//接口
		public void update(classxx Class);//修改
		public classxx queryByNumber(int ClassNumber);//查询bynum
		public List<classxx> queryAll() ;//queryall
		public List<classxx> search(String ClassName , String TName)  throws SQLException;//模糊查询 
}
