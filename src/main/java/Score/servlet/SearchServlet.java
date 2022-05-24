package Score.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Score.bean.Score;
import Score.service.ScoreService;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Score=request.getParameter("Score");
		String Number=request.getParameter("Number");
		String ClassNumber=request.getParameter("ClassNumber");
		String ClassName=request.getParameter("ClassName");
		Score stu1 = new Score(Score,Number,ClassNumber,ClassName);
		
		ScoreService service=new ScoreService();
		if(service.add(stu1)!=null)
		{
			System.out.println(Score);
			System.out.println(Number);
			System.out.println(ClassNumber);
			System.out.println(ClassName);
			request.getSession().setAttribute("stu1",stu1);  //将查询结果写入session域对象
        	RequestDispatcher rd=request.getRequestDispatcher("/Score/show.jsp");
			rd.forward(request, response);

		}
		else
		{
			response.getWriter().write("<h3>该课程号已存在，请重新输入。</h3>");
			System.out.println("111111");
        	response.setHeader("refresh", "3;url=/Score/input.jsp");
        	System.out.println("222222");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
