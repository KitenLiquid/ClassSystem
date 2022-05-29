package Class.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.bean.Student;
import Class.service.classService;
import Class.service.classServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/SUpdateServlet")
public class SUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		try {
			//1. 获取客户端提交上来的数据
			int Number = Integer.parseInt(request.getParameter("Number"));
			int ClassNumber = Integer.parseInt(request.getParameter("ClassNumber"));
			String Name = request.getParameter("Name");
			String Sex = request.getParameter("Sex");
			int Age = Integer.parseInt(request.getParameter("Age"));
			//2. 添加到数据库
			Student Stu = new Student(ClassNumber,Name,Number,Sex,Age);
			
			//2. 更新数据库数据
			classService service = new classServiceImpl();
			service.Supdate(Stu);
			
			//3. 跳转界面
			request.getRequestDispatcher("SListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

