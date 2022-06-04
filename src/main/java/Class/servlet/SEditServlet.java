package Class.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.bean.Student;
import Class.service.classService;
import Class.service.classServiceImpl;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/SEditServlet")
public class SEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SEditServlet() {
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
		try {
			//1. 接收id
			int ClassNumber = Integer.parseInt(request.getParameter("ClassNumber"));
			int Number = Integer.parseInt(request.getParameter("Number"));
			//2. 查询学生数据
			classService service = new classServiceImpl();
			Student Student = service.SqueryByNumber(ClassNumber, Number);
			
			//3. 显示数据
			//存数据
			request.setAttribute("Student", Student);
			//跳转
			request.getRequestDispatcher("/Index/Class/Supdate.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
