package Score.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Score.bean.ScoreBean;
import Score.service.ScoreService;


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
			//2. 查询学生数据
			ScoreService service = new ScoreService();
			ScoreBean Stu = service.SqueryByNumber(ClassNumber);
			
			//3. 显示数据
			//存数据
			request.setAttribute("Stu",Stu);
			//跳转
			request.getRequestDispatcher("/Index/Score/Supdate.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
