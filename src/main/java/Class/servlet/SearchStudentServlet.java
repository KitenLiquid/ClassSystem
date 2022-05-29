package Class.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.bean.Student;
import Class.service.classService;
import Class.service.classServiceImpl;

/**
 * Servlet implementation class SearchClassServlet
 */
@WebServlet("/SearchStudentServlet")

public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudentServlet() {
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
			String ClassName=  request.getParameter("ClassName");
			String Name=  request.getParameter("Name");
			String Sex=  request.getParameter("Sex");
			//2. 找service去查询
			classService service = new classServiceImpl();
			List<Student> Slist = service.Ssearch(ClassName, Name, Sex);
			
			System.out.println("list的大小是："+Slist.size());
			for (Student Student : Slist) {
				System.out.println("Name="+Name);
			}
			
			request.setAttribute("Slist", Slist);
			
			//3. 跳转界面。列表界面
			request.getRequestDispatcher("/Index/Class/Slist.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
