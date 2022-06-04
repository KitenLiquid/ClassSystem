package Score.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Score.bean.ScoreBean;
import Score.service.ScoreService;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Score=Integer.valueOf(request.getParameter("Score"));
		int Number=Integer.valueOf(request.getParameter("Number"));
		int ClassNumber=Integer.valueOf(request.getParameter("ClassNumber"));
		String ClassName=request.getParameter("ClassName");
		String Name=request.getParameter("Name");
		int APnumber=Integer.valueOf(request.getParameter("APnumber"));
		ScoreBean stu1 = new ScoreBean(Name,Score,Number,ClassNumber,ClassName,APnumber);
		
		ScoreService service=new ScoreService();
		if(service.add(stu1)!=null&&service.add1(stu1)!=null&&service.add2(stu1)!=null)
		{
			System.out.println(Name);
			System.out.println(Score);
			System.out.println(Number);
			System.out.println(ClassNumber);
			System.out.println(ClassName);
			System.out.println(APnumber);
			request.getSession().setAttribute("stu1",stu1);  //将查询结果写入session域对象
        	RequestDispatcher rd=request.getRequestDispatcher("SListServlet");
			rd.forward(request, response);

		}
		else
		{
			response.getWriter().write("<h3>该学号已存在，请重新输入。</h3>");
			System.out.println("111111");
        	response.setHeader("refresh", "3;url=Index/Score/input.jsp");
        	System.out.println("222222");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
