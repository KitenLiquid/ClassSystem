package Class.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;

import Class.bean.Student;
import Class.service.classService;
import Class.service.classServiceImpl;

@WebServlet(name="studentServlet",urlPatterns={"/studentServlet"})
public class studentServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
    
    public studentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String classNumber = request.getParameter("ClassNumber");
        String number=request.getParameter("Number");
        String Name=request.getParameter("Name");
        String Sex=request.getParameter("Sex");
        String age=request.getParameter("Age");
        int ClassNumber=Integer.parseInt(classNumber);
        int Number=Integer.parseInt(number);
        int Age=Integer.parseInt(age);
        Student student1 = new Student();
        student1.setClassNumber(ClassNumber);
        student1.setName(Name);
        student1.setNumber(Number);
        student1.setSex(Sex);
        student1.setAge(Age);
        classService service = new classServiceImpl();
        Student stu=new Student();
        Student stu1=new Student();
        stu=service.insert2(student1);
        stu1=service.insert3(student1);
		PrintWriter out=response.getWriter();
		if(stu !=null || stu1!=null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("student1", student1);
			request.getRequestDispatcher("SListServlet").include(request, response);
	    }else {
	    	request.setAttribute("message", "学生已存在");
	    	request.getRequestDispatcher("/Index/Class/stuinsert.jsp").forward(request, response);
	
		}
}

}
