package Score.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Score.bean.ScoreBean;
import Score.service.ScoreService;


/**
 * Servlet implementation class ClassListServlet
 */
@WebServlet("/SListServlet2")
public class SListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SListServlet() {
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
		
			//1. 鏌ヨ鍑烘潵鎵�鏈夌殑瀛︾敓
			ScoreService service = new ScoreService();
			List<ScoreBean> Slist = service.SqueryAll();
			
			//2. 鍏堟妸鏁版嵁瀛樺偍鍒颁綔鐢ㄥ煙涓�
			request.setAttribute("Slist2", Slist);
			//3. 璺宠浆椤甸潰
			request.getRequestDispatcher("/Index/Score/Index.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
