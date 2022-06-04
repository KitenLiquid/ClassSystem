package Class.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;

import Class.bean.classaa;
import Class.service.classService;
import Class.service.classServiceImpl;
@WebServlet("/classServlet")
public class classServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
    
    public classServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        String ClassName = request.getParameter("ClassName");
        String Number = request.getParameter("ClassNumber");
        String AP=request.getParameter("APnumber");
        String TName=request.getParameter("TName");
        String Phone=request.getParameter("PhoneNumber");
        int ClassNumber=Integer.parseInt(Number);
        int APnumber=Integer.parseInt(AP);
        int PhoneNumber=Integer.parseInt(Phone);
        classaa class1 = new classaa();
        class1.setClassName(ClassName);
        class1.setClassNumber(ClassNumber);
        class1.setAPnumber(APnumber);
        class1.setTName(TName);
        class1.setPhoneNumber(PhoneNumber);
        classService service = new classServiceImpl();
        classaa stu=new classaa();
        classaa stu1=new classaa();
        stu=service.insert(class1);
        stu1=service.insert1(class1);
		PrintWriter out=response.getWriter();
		if(stu !=null && stu1!=null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("class1", class1);
			request.getRequestDispatcher("ClassListServlet").include(request, response);
	    }else {
	    	request.setAttribute("message", "课程已存在");
	    	request.getRequestDispatcher("/Index/Class/insert.jsp").forward(request, response);
		}
}

}
