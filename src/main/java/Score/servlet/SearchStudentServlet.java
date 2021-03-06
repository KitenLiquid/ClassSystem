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
 * Servlet implementation class SearchClassServlet
 */
@WebServlet("/SearchStudentServlet2")

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
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		try {
			
			String ClassName=request.getParameter("ClassName");
			String Number1=request.getParameter("Number");
			System.out.println("2");
			int Number;
			if(Number1.equals("")||Number1==null)
			{
				Number=0;
			}
			else
			{
				Number=Integer.valueOf(Number1);
			}
			System.out.println("1");
			//2. 鎵緎ervice鍘绘煡璇�
			ScoreService service = new ScoreService(); 
			List<ScoreBean> Slist = service.Ssearch(ClassName, Number);
			
			System.out.println("list鐨勫ぇ灏忔槸锛�"+Slist.size());
			for (ScoreBean scoreBean : Slist) {
				System.out.println("ClassName="+ClassName);
			}
			
			request.setAttribute("Slist2", Slist);
			
			//3. 璺宠浆鐣岄潰銆傚垪琛ㄧ晫闈�
			request.getRequestDispatcher("/Index/Score/Index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
