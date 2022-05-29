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
					
		} catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public classxx queryByNumber(int ClassNumber) {
		System.out.println(ClassNumber);
        try {
            //JNDI DataSource����Դ��ʽ
            conn = JNDIUtils.getConnection();
            //��sql���͸����ݿ���б���
            String sql = "SELECT class.ClassName,class.ClassNumber,class.APnumber,teacher.TName,teacher.PhoneNumber FROM class,teacher where class.ClassNumber=teacher.ClassNumber and class.ClassNumber=?";
            stmt = conn.prepareStatement(sql);
            //���ò���
            stmt.setInt(1, ClassNumber);
            //ִ��sql
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
        return null;
	}
	
	@Override
	public List<classxx> queryAll()  throws SQLException {
		List<classxx> classxx=new ArrayList<classxx>();
		try {
			conn = JNDIUtils.getConnection();
			String sql = "SELECT class.ClassName,class.ClassNumber,class.APnumber,teacher.TName,teacher.PhoneNumber FROM class,teacher where class.ClassNumber=teacher.ClassNumber";
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
		return classxx;
	}

	@Override
	public List<classxx> search(String ClassName, String TName) throws SQLException {
		List<classxx> classxx=new ArrayList<classxx>();	
		String sql = "SELECT class.ClassName,class.ClassNumber,class.APnumber,teacher.TName,teacher.PhoneNumber FROM class,teacher where class.ClassNumber=teacher.ClassNumber and 1=1";
		if (ClassName != null && !"".equals(ClassName)) {
			sql = sql + " and ClassName like '%" + ClassName + "%'";
		}

		if (TName != null && !"".equals(TName)) {
			sql = sql + " and TName like '%" + TName + "%'";
		}
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
		return classxx;
	}

	public classaa insert(classaa class1) {
		classaa existUser = null;
        try {
			conn = JNDIUtils.getConnection();
            String sql = "select * from class where ClassName=?"; //���ݿ����ʱ
            stmt = conn.prepareStatement(sql);	//��sql���͸����ݿ���б���
            
            //����sql����
            String name=class1.getClassName();
            int number=class1.getClassNumber();
            int AP=class1.getAPnumber();
            stmt.setString(1, class1.getClassName());	//��������ֵ��������Ϊ�ؼ��� --��ֹע��           
            rs = stmt.executeQuery();			//ִ��sql                             
            if(rs.next()) {
            	System.out.println("�ÿγ��Ѿ����ڣ����������룡");      
            }
            else {//�γ̲�����
				//��ӿγ̣�д�����ݿ�
            	stmt3=conn.createStatement();
            	sql="insert into class(ClassName,ClassNumber,APnumber) values('"+name+"','"+number+"','"+AP+"')";
            	int row=stmt3.executeUpdate(sql);
            	System.out.println("a"); 
            	existUser=new classaa(name,number,AP);     	
			}
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
        
        System.out.println(existUser);    
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
	            //���ò���
	            stmt.setInt(1, ClassNumber);
	            //ִ��sql
	            rs = stmt.executeQuery();
	            if(rs.next()) {
	            	
	            	System.out.println("�ÿγ���ʦ�Ѵ���");
	            }
	            else {
	            	stmt3=conn.createStatement();
	            	sql="insert into teacher(ClassNumber,PhoneNumber,TName) values('"+ClassNumber+"','"+PhoneNumber+"','"+TName+"')";
	            	int row=stmt3.executeUpdate(sql);
	            	System.out.println("k"); 
	            	existUser=new classaa(PhoneNumber,TName); 
	            }
			    
			
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		 System.out.println(existUser);    
	     return existUser;

	}

	@Override
	public void delete(int number) {
		try {
            //JNDI DataSource����Դ��ʽ
            conn = JNDIUtils.getConnection();
            //��sql���͸����ݿ���б���
            String sql = "select * from  class  where ClassNumber=?";
            stmt = conn.prepareStatement(sql);
            //���ò���
            stmt.setInt(1, number);
            //ִ��sql
            rs = stmt.executeQuery();
            if (rs.next()) {    
                //���ڿγ̣�ɾ��
                stmt3=conn.createStatement();
            	sql="delete from class where ClassNumber='"+number+"'";
            	stmt3.executeUpdate(sql);
            	System.out.println("b"); 
               
            }else {
            	System.out.println("�γ̲����ڻ���ɾ��");
            }
        } catch (Exception e) {
            e.printStackTrace();
     
    }

		
	}

	@Override
	public void delete1(int number) {
		try {
            //JNDI DataSource����Դ��ʽ
            conn = JNDIUtils.getConnection();
            //��sql���͸����ݿ���б���
            String sql = "select * from  teacher  where ClassNumber=?";
            stmt = conn.prepareStatement(sql);
            //���ò���
            stmt.setInt(1, number);
            //ִ��sql
            rs = stmt.executeQuery();
            if (rs.next()) {    
                //���ڿγ̣�ɾ��
                stmt3=conn.createStatement();
            	sql="delete from teacher where ClassNumber='"+number+"'";
            	stmt3.executeUpdate(sql);
            	System.out.println("m"); 
               
            }else {
            	System.out.println("�ÿγ���ʦ�����ڻ���ɾ��");
            }
        } catch (Exception e) {
            e.printStackTrace();
     
    }

		
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
					
		} catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Student SqueryByNumber(int ClassNumber,int Number) {
		System.out.println(Number);
        try {
            //JNDI DataSource����Դ��ʽ
            conn = JNDIUtils.getConnection();
            //��sql���͸����ݿ���б���
            String sql = "select class.ClassNumber,ClassName,Name,student.Number,Sex,Age From class,student,stuclass where class.ClassNumber=stuclass.ClassNumber and stuclass.Number=student.Number and stuclass.Number=? and stuclass.ClassNumber=?";
            stmt = conn.prepareStatement(sql);
            //���ò���
            stmt.setInt(1, Number);
            stmt.setInt(2, ClassNumber);
            //ִ��sql
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
        return null;
	}

	@Override
	public List<Student> SqueryAll() throws SQLException {
		List<Student> stu=new ArrayList<Student>();
		try {
			conn = JNDIUtils.getConnection();
			String sql = "select class.ClassNumber,ClassName,Name,student.Number,Sex,Age From class,student,stuclass where class.ClassNumber=stuclass.ClassNumber and stuclass.Number=student.Number";
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
		return stu;
	}

	@Override
	public List<Student> Ssearch(String ClassName, String Name, String Sex) throws SQLException {
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
		return stu;
	}

	@Override
	public Student insert2(Student student) {
		Student existUser = null;
        try {
			conn = JNDIUtils.getConnection();
            String sql = "select * from student where Name=?"; //���ݿ����ʱ
            stmt = conn.prepareStatement(sql);	//��sql���͸����ݿ���б���
            
            //����sql����
            String Name=student.getName();
            int Number=student.getNumber();
            int Age=student.getAge();
            String Sex=student.getSex();
            stmt.setString(1, student.getName());	//��������ֵ��������Ϊ�ؼ��� --��ֹע��           
            rs = stmt.executeQuery();			//ִ��sql                             
            if(rs.next()) {
            	System.out.println("��ѧ���Ѿ����ڣ����������룡");      
            }
            else {//ѧ��������
				//���ѧ����д�����ݿ�
            	stmt3=conn.createStatement();
            	sql="insert into student(Name,Number,Sex,Age) values('"+Name+"','"+Number+"','"+Sex+"','"+Age+"')";
            	int row=stmt3.executeUpdate(sql);
            	System.out.println("p"); 
            	existUser=new Student(Name,Number);     	
			}
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
        
        System.out.println(existUser);    
        return existUser;

	}

	@Override
	public Student insert3(Student student) {
		Student existUser = null;
		try {   
			    int Number=student.getNumber();
			    int ClassNumber=student.getClassNumber();
			  //JNDI DataSource����Դ��ʽ
	            conn = JNDIUtils.getConnection();
	            //��sql���͸����ݿ���б���
	            String sql = "select * from  stuclass  where Number=?";
	            stmt = conn.prepareStatement(sql);
	            //���ò���
	            stmt.setInt(1, Number);
	            //ִ��sql
	            rs = stmt.executeQuery();
	            stmt3=conn.createStatement();
	            sql="insert into stuclass(Number,ClassNumber) values('"+Number+"','"+ClassNumber+"')";
	            int row=stmt3.executeUpdate(sql);
	            System.out.println("q"); 
	            existUser=new Student(Number,ClassNumber); 
			
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		 System.out.println(existUser);    
	     return existUser;

	}

	@Override
	public void delete3(int number, int ClassNumber) {
		// TODO Auto-generated method stub
				try {
		            //JNDI DataSource����Դ��ʽ
		            conn = JNDIUtils.getConnection();
		            //��sql���͸����ݿ���б���
		            String sql = "select * from  stuclass  where Number=?";
		            stmt = conn.prepareStatement(sql);
		            //���ò���
		            stmt.setInt(1, number);
		            //ִ��sql
		            rs = stmt.executeQuery();
		            if (rs.next()) {    
		                //����ѧ�ſγ̺ţ�ɾ��
		                stmt3=conn.createStatement();
		            	sql="delete from stuclass where Number='"+number+"'and ClassNumber='"+ClassNumber+"'";
		            	stmt3.executeUpdate(sql);
		            	System.out.println("c"); 
		               
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		    }

	}
	

	


}
