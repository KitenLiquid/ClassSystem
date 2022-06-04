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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/SUpdateServlet2")
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
			//1. 鑾峰彇瀹㈡埛绔彁浜や笂鏉ョ殑鏁版嵁
			int Number = Integer.parseInt(request.getParameter("Number"));
			int ClassNumber = Integer.parseInt(request.getParameter("ClassNumber"));
			String ClassName = request.getParameter("ClassName");
			int Score=Integer.parseInt(request.getParameter("Score"));
			int APnumber = Integer.parseInt(request.getParameter("APnumber"));
			//2. 娣诲姞鍒版暟鎹簱
			ScoreBean Stu = new ScoreBean(Score,Number,ClassNumber,ClassName,APnumber);
			
			//2. 鏇存柊鏁版嵁搴撴暟鎹�
			ScoreService service = new ScoreService();
			service.Supdate(Stu);
			
			//3. 璺宠浆鐣岄潰
			request.getRequestDispatcher("SListServlet2").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}