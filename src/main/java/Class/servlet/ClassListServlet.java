package Class.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Class.bean.PageBean;
import Class.bean.classxx;
import Class.service.classService;
import Class.service.classServiceImpl;

/**
 * Servlet implementation class ClassListServlet
 */
@WebServlet("/ClassListServlet")
public class ClassListServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassListServlet() {
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
			int currentPage;

			if (request.getParameter("currentPage") == null){
			    currentPage = 1;
			}else {
			    /*获取当前页*/
			    currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			
			classService service = new classServiceImpl();
			PageBean pageBean = service.queryAll(currentPage);
			List<classxx> list=(List<classxx>)pageBean.getList();
			//2. 先把数据存储到作用域中
			request.setAttribute("pageBean",pageBean);
			request.setAttribute("list", list);
			//3. 跳转页面
			request.getRequestDispatcher("/Index/Class/list.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
