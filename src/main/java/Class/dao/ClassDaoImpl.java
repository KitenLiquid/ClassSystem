package Class.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Class.bean.Student;
import Class.bean.classaa;
import Class.bean.classxx;
import JNDIutil.JNDIUtils;






public class ClassDaoImpl implements ClassDao{
	 Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    PreparedStatement stmt2=null;
    Statement stmt3=null;
	@Override
	public void update(classxx Class) {
		try {
			conn= JNDIUtils.getConnection();
			String sql="update class set ClassName=?,APnumber=? where ClassNumber=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, Class.getClassName());
			stmt.setInt(2, Class.getAPnumber());
			stmt.setInt(3, Class.getClassNumber());
			stmt.executeUpdate();
			String sql2="update teacher set TName=?,PhoneNumber=? where ClassNumber=?";
			stmt2=conn.prepareStatement(sql2);
			stmt2.setString(1, Class.getTName());
			stmt2.setInt(2, Class.getPhoneNumber());
			stmt2.setInt(3, Class.getClassNumber());
			stmt2.executeUpdate();
			stmt2.close();
					
		} catch (Exception e) {
            e.printStackTrace();
        }
		JNDIUtils.release(rs, stmt, conn);
	}

	@Override
	public classxx queryByNumber(int ClassNumber) {
		System.out.println(ClassNumber);
        try {
            //JNDI DataSource鏁版嵁婧愭柟寮�
            conn = JNDIUtils.getConnection();
            //灏唖ql鍙戦�佺粰鏁版嵁搴撹繘琛岀紪璇�
            String sql = "SELECT class.ClassName,class.ClassNumber,class.APnumber,teacher.TName,teacher.PhoneNumber FROM class,teacher where class.ClassNumber=teacher.ClassNumber and class.ClassNumber=?";
            stmt = conn.prepareStatement(sql);
            //璁剧疆鍙傛暟
            stmt.setInt(1, ClassNumber);
            //鎵цsql
            rs = stmt.executeQuery();
            if (rs.next()) {
                classxx classxx = new classxx();
                classxx.setClassName(rs.getString("ClassName"));
                classxx.setAPnumber(rs.getInt("APnumber"));
                classxx.setClassNumber(rs.getInt("ClassNumber"));
                classxx.setTName(rs.getString("TName"));
                classxx.setPhoneNumber(rs.getInt("PhoneNumber"));
                return classxx;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JNDIUtils.release(rs, stmt, conn);
        return null;
	}
	
	@Override
	public List<classxx> queryAll(int currentPage)  throws SQLException {
		List<classxx> classxx=new ArrayList<classxx>();
		try {
			conn = JNDIUtils.getConnection();
			String sql = "SELECT class.ClassName,class.ClassNumber,class.APnumber,teacher.TName,teacher.PhoneNumber FROM class,teacher where class.ClassNumber=teacher.ClassNumber limit ? offset ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, PAGE_SIZE);
			stmt.setInt(2, (currentPage-1)*PAGE_SIZE);
			rs = stmt.executeQuery();
			while(rs.next()) {
				classxx classx = new classxx();
				classx.setClassName(rs.getString("ClassName"));
                classx.setAPnumber(rs.getInt("APnumber"));
                classx.setClassNumber(rs.getInt("ClassNumber"));
                classx.setTName(rs.getString("TName"));
                classx.setPhoneNumber(rs.getInt("PhoneNumber"));
                classxx.add(classx);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JNDIUtils.release(rs, stmt, conn);
		return classxx;
	}

	@Override
	public List<classxx> search(String ClassName, String TName,int currentPage) throws SQLException {
		List<classxx> classxx=new ArrayList<classxx>();	
		String sql = "SELECT class.ClassName,class.ClassNumber,class.APnumber,teacher.TName,teacher.PhoneNumber FROM class,teacher where class.ClassNumber=teacher.ClassNumber and 1=1";
		if (ClassName != null && !"".equals(ClassName)) {
			sql = sql + " and ClassName like '%" + ClassName + "%'";
		}

		if (TName != null && !"".equals(TName)) {
			sql = sql + " and TName like '%" + TName + "%'";
		}
		sql=sql+" limit "+(currentPage-1)*PAGE_SIZE+","+PAGE_SIZE;
		try {
			
			System.out.println(TName);
			conn = JNDIUtils.getConnection();

			stmt = conn.prepareStatement(sql);
		
			rs = stmt.executeQuery();
			while(rs.next()) {
				classxx classx = new classxx();
				classx.setClassName(rs.getString("ClassName"));
                classx.setAPnumber(rs.getInt("APnumber"));
                classx.setClassNumber(rs.getInt("ClassNumber"));
                classx.setTName(rs.getString("TName"));
                classx.setPhoneNumber(rs.getInt("PhoneNumber"));
                classxx.add(classx);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JNDIUtils.release(rs, stmt, conn);
		return classxx;
	}

	public classaa insert(classaa class1) {
		classaa existUser = null;
        try {
			conn = JNDIUtils.getConnection();
            String sql = "select * from class where ClassName=?"; //鏁版嵁搴撶紪璇戞椂
            stmt = conn.prepareStatement(sql);	//灏唖ql鍙戦�佺粰鏁版嵁搴撹繘琛岀紪璇�
            
            //璁剧疆sql鍙傛暟
            String name=class1.getClassName();
            int number=class1.getClassNumber();
            int AP=class1.getAPnumber();
            stmt.setString(1, class1.getClassName());	//浼犲叆鏁版嵁鍊硷紝涓嶄細浣滀负鍏抽敭瀛� --闃叉娉ㄥ叆           
            rs = stmt.executeQuery();			//鎵цsql                             
            if(rs.next()) {
            	System.out.println("璇ヨ绋嬪凡缁忓瓨鍦紝璇烽噸鏂拌緭鍏ワ紒");      
            }
            else {//璇剧▼涓嶅瓨鍦�
				//娣诲姞璇剧▼锛屽啓鍏ユ暟鎹簱
            	stmt3=conn.createStatement();
            	sql="insert into class(ClassName,ClassNumber,APnumber) values('"+name+"','"+number+"','"+AP+"')";
            	int row=stmt3.executeUpdate(sql);
            	System.out.println("a"); 
            	existUser=new classaa(name,number,AP);    
            	stmt3.close();
			}
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
        
        System.out.println(existUser);    
        JNDIUtils.release(rs, stmt, conn);
        return existUser;

	}

	@Override
	public classaa insert1(classaa teacher) {
		classaa existUser = null;
		try {   
			    conn = JNDIUtils.getConnection();
	            String sql = "select * from  teacher  where ClassNumber=?";
	            stmt = conn.prepareStatement(sql);
	            String TName=teacher.getTName();
			    int ClassNumber=teacher.getClassNumber();
			    int PhoneNumber=teacher.getPhoneNumber();
	            //璁剧疆鍙傛暟
	            stmt.setInt(1, ClassNumber);
	            //鎵цsql
	            rs = stmt.executeQuery();
	            if(rs.next()) {
	            	
	            	System.out.println("璇ヨ绋嬭�佸笀宸插瓨鍦�");
	            }
	            else {
	            	stmt3=conn.createStatement();
	            	sql="insert into teacher(ClassNumber,PhoneNumber,TName) values('"+ClassNumber+"','"+PhoneNumber+"','"+TName+"')";
	            	int row=stmt3.executeUpdate(sql);
	            	System.out.println("k"); 
	            	existUser=new classaa(PhoneNumber,TName); 
	            	stmt3.close();
	            }
			    
			
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		 System.out.println(existUser);  
		 JNDIUtils.release(rs, stmt, conn);
	     return existUser;

	}

	@Override
	public void delete(int number) {
		try {
            //JNDI DataSource鏁版嵁婧愭柟寮�
            conn = JNDIUtils.getConnection();
            //灏唖ql鍙戦�佺粰鏁版嵁搴撹繘琛岀紪璇�
            String sql = "select * from  class  where ClassNumber=?";
            stmt = conn.prepareStatement(sql);
            //璁剧疆鍙傛暟
            stmt.setInt(1, number);
            //鎵цsql
            rs = stmt.executeQuery();
            if (rs.next()) {    
                //瀛樺湪璇剧▼锛屽垹闄�
                stmt3=conn.createStatement();
            	sql="delete from class where ClassNumber='"+number+"'";
            	stmt3.executeUpdate(sql);
            	System.out.println("b"); 
            	stmt3.close();
               
            }else {
            	System.out.println("璇剧▼涓嶅瓨鍦ㄦ垨宸插垹闄�");
            }
        } catch (Exception e) {
            e.printStackTrace();
     
    }
		JNDIUtils.release(rs, stmt, conn);
		
	}

	@Override
	public void delete1(int number) {
		try {
            //JNDI DataSource鏁版嵁婧愭柟寮�
            conn = JNDIUtils.getConnection();
            //灏唖ql鍙戦�佺粰鏁版嵁搴撹繘琛岀紪璇�
            String sql = "select * from  teacher  where ClassNumber=?";
            stmt = conn.prepareStatement(sql);
            //璁剧疆鍙傛暟
            stmt.setInt(1, number);
            //鎵цsql
            rs = stmt.executeQuery();
            if (rs.next()) {    
                //瀛樺湪璇剧▼锛屽垹闄�
                stmt3=conn.createStatement();
            	sql="delete from teacher where ClassNumber='"+number+"'";
            	stmt3.executeUpdate(sql);
            	System.out.println("m"); 
            	stmt3.close();
               
            }else {
            	System.out.println("璇ヨ绋嬭�佸笀涓嶅瓨鍦ㄦ垨宸插垹闄�");
            }
        } catch (Exception e) {
            e.printStackTrace();
     
    }
		JNDIUtils.release(rs, stmt, conn);
		
	}

	@Override
	public void Supdate(Student stu) {
		try {
			conn= JNDIUtils.getConnection();
			String sql="update student set Name=?,Sex=?,Age=? where Number=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, stu.getName());
			stmt.setString(2, stu.getSex());
			stmt.setInt(3, stu.getAge());
			stmt.setInt(4, stu.getNumber());
			stmt.executeUpdate();
			String sql2="update stuclass set ClassNumber=? where Number=?";
			stmt2=conn.prepareStatement(sql2);
			stmt2.setInt(1, stu.getClassNumber());
			stmt2.setInt(2, stu.getNumber());
			stmt2.executeUpdate();
			stmt2.close();
					
		} catch (Exception e) {
            e.printStackTrace();
        }
		JNDIUtils.release(rs, stmt, conn);
	}

	@Override
	public Student SqueryByNumber(int ClassNumber,int Number) {
		System.out.println(Number);
        try {
            //JNDI DataSource鏁版嵁婧愭柟寮�
            conn = JNDIUtils.getConnection();
            //灏唖ql鍙戦�佺粰鏁版嵁搴撹繘琛岀紪璇�
            String sql = "select class.ClassNumber,ClassName,Name,student.Number,Sex,Age From class,student,stuclass where class.ClassNumber=stuclass.ClassNumber and stuclass.Number=student.Number and stuclass.Number=? and stuclass.ClassNumber=?";
            stmt = conn.prepareStatement(sql);
            //璁剧疆鍙傛暟
            stmt.setInt(1, Number);
            stmt.setInt(2, ClassNumber);
            //鎵цsql
            rs = stmt.executeQuery();
            if (rs.next()) {
                Student stu = new Student();
                stu.setClassName(rs.getString("ClassName"));
                stu.setClassNumber(rs.getInt("ClassNumber"));
                stu.setAge(rs.getInt("Age"));
                stu.setSex(rs.getString("Sex"));
                stu.setName(rs.getString("Name"));
                stu.setNumber(rs.getInt("Number"));
                return stu;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JNDIUtils.release(rs, stmt, conn);
        return null;
	}

	@Override
	public List<Student> SqueryAll(int currentPage) throws SQLException {
		List<Student> stu=new ArrayList<Student>();
		try {
			conn = JNDIUtils.getConnection();
			String sql = "select class.ClassNumber,ClassName,Name,student.Number,Sex,Age From class,student,stuclass where class.ClassNumber=stuclass.ClassNumber and stuclass.Number=student.Number limit ? offset ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, PAGE_SIZE);
			stmt.setInt(2, (currentPage-1)*PAGE_SIZE);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setClassName(rs.getString("ClassName"));
				student.setClassNumber(rs.getInt("ClassNumber"));
				student.setAge(rs.getInt("Age"));
				student.setSex(rs.getString("Sex"));
				student.setName(rs.getString("Name"));
				student.setNumber(rs.getInt("Number"));
				stu.add(student);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JNDIUtils.release(rs, stmt, conn);
		return stu;
	}

	@Override
	public List<Student> Ssearch(String ClassName, String Name, String Sex,int currentPage) throws SQLException {
		List<Student> stu=new ArrayList<Student>();	
		String sql = "select class.ClassNumber,ClassName,Name,student.Number,Sex,Age From class,student,stuclass where class.ClassNumber=stuclass.ClassNumber and stuclass.Number=student.Number and 1=1";
		if (ClassName != null && !"".equals(ClassName)) {
			sql = sql + " and ClassName like '%" + ClassName + "%'";
		}

		if (Name != null && !"".equals(Name)) {
			sql = sql + " and Name like '%" + Name + "%'";
		}
		if (Sex != null && !"".equals(Sex)) {
			sql = sql + " and Sex like '%" + Sex + "%'";
		}
		sql=sql+" limit "+(currentPage-1)*PAGE_SIZE+","+PAGE_SIZE;
		try {
			
			System.out.println(Name);
			conn = JNDIUtils.getConnection();
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setClassName(rs.getString("ClassName"));
				student.setClassNumber(rs.getInt("ClassNumber"));
				student.setAge(rs.getInt("Age"));
				student.setSex(rs.getString("Sex"));
				student.setName(rs.getString("Name"));
				student.setNumber(rs.getInt("Number"));
				stu.add(student);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JNDIUtils.release(rs, stmt, conn);
		return stu;
	}

	@Override
	public Student insert2(Student student) {
		Student existUser = null;
        try {
			conn = JNDIUtils.getConnection();
            String sql = "select * from student where Name=?"; //鏁版嵁搴撶紪璇戞椂
            stmt = conn.prepareStatement(sql);	//灏唖ql鍙戦�佺粰鏁版嵁搴撹繘琛岀紪璇�
            
            //璁剧疆sql鍙傛暟
            String Name=student.getName();
            int Number=student.getNumber();
            int Age=student.getAge();
            String Sex=student.getSex();
            stmt.setString(1, student.getName());	//浼犲叆鏁版嵁鍊硷紝涓嶄細浣滀负鍏抽敭瀛� --闃叉娉ㄥ叆           
            rs = stmt.executeQuery();			//鎵цsql                             
            if(rs.next()) {
            	System.out.println("璇ュ鐢熷凡缁忓瓨鍦紝璇烽噸鏂拌緭鍏ワ紒");      
            }
            else {//瀛︾敓涓嶅瓨鍦�
				//娣诲姞瀛︾敓锛屽啓鍏ユ暟鎹簱
            	stmt3=conn.createStatement();
            	sql="insert into student(Name,Number,Sex,Age) values('"+Name+"','"+Number+"','"+Sex+"','"+Age+"')";
            	int row=stmt3.executeUpdate(sql);
            	System.out.println("p"); 
            	existUser=new Student(Name,Number);    
            	stmt3.close();
			}
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
        
        System.out.println(existUser);    
        JNDIUtils.release(rs, stmt, conn);
        return existUser;

	}

	@Override
	public Student insert3(Student student) {
		Student existUser = null;
		try {   
			    int Number=student.getNumber();
			    int ClassNumber=student.getClassNumber();
			  //JNDI DataSource数据源方式
	            conn = JNDIUtils.getConnection();
	            //将sql发送给数据库进行编译
	            String sql = "select * from  stuclass  where Number=? and ClassNumber=?";
	            stmt = conn.prepareStatement(sql);
	            //设置参数
	            stmt.setInt(1, Number);
	            stmt.setInt(2, ClassNumber);
	            //执行sql
	            rs = stmt.executeQuery();
	            if(rs.next()) {
	            	System.out.println("该学号课程已经存在，请重新输入！");      
	            }
	            else {
	            stmt3=conn.createStatement();
	            sql="insert into stuclass(Number,ClassNumber) values('"+Number+"','"+ClassNumber+"')";
	            int row=stmt3.executeUpdate(sql);
	            System.out.println("q"); 
	            existUser=new Student(Number,ClassNumber); 
	            stmt3.close();
	            }
			
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		 System.out.println(existUser);   
		 JNDIUtils.release(rs, stmt, conn);
	     return existUser;

	}

	@Override
	public void delete3(int number, int ClassNumber) {
		// TODO Auto-generated method stub
				try {
		            //JNDI DataSource鏁版嵁婧愭柟寮�
		            conn = JNDIUtils.getConnection();
		            //灏唖ql鍙戦�佺粰鏁版嵁搴撹繘琛岀紪璇�
		            String sql = "select * from  stuclass  where Number=?";
		            stmt = conn.prepareStatement(sql);
		            //璁剧疆鍙傛暟
		            stmt.setInt(1, number);
		            //鎵цsql
		            rs = stmt.executeQuery();
		            if (rs.next()) {    
		                //瀛樺湪瀛﹀彿璇剧▼鍙凤紝鍒犻櫎
		                stmt3=conn.createStatement();
		            	sql="delete from stuclass where Number='"+number+"'and ClassNumber='"+ClassNumber+"'";
		            	stmt3.executeUpdate(sql);
		            	System.out.println("c"); 
		            	stmt3.close();
		               
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		    }
				JNDIUtils.release(rs, stmt, conn);
	}

	@Override
	public int findCount() throws SQLException {
		try {
            //JNDI DataSource鏁版嵁婧愭柟寮�
            conn = JNDIUtils.getConnection();
            //灏唖ql鍙戦�佺粰鏁版嵁搴撹繘琛岀紪璇�
            String sql = "select count(*) FROM class,teacher where class.ClassNumber=teacher.ClassNumber"; 
            stmt = conn.prepareStatement(sql);
            //鎵цsql
            rs = stmt.executeQuery();
           rs.next();
           int result =rs.getInt(1);
           return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
		JNDIUtils.release(rs, stmt, conn);
		return 0;
		
	}

	@Override
	public int SfindCount() throws SQLException {
		try {
            //JNDI DataSource鏁版嵁婧愭柟寮�
            conn = JNDIUtils.getConnection();
            //灏唖ql鍙戦�佺粰鏁版嵁搴撹繘琛岀紪璇�
            String sql = "select count(*) From class,student,stuclass where class.ClassNumber=stuclass.ClassNumber and stuclass.Number=student.Number"; 
            stmt = conn.prepareStatement(sql);
            //鎵цsql
            rs = stmt.executeQuery();
           rs.next();
           int result =rs.getInt(1);
           return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
		JNDIUtils.release(rs, stmt, conn);
		return 0;
	}


	

	


}
