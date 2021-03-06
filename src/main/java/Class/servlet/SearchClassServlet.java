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
 * Servlet implementation class SearchClassServlet
 */
@WebServlet("/SearchClassServlet")

public class SearchClassServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchClassServlet() {
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
			String TName=  request.getParameter("TName");
			int currentPage;

			if (request.getParameter("currentPage") == null){
			    currentPage = 1;
			}else {
			    /*获取当前页*/
			    currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			//2. 找service去查询
			classService service = new classServiceImpl();
			PageBean<classxx> pageBean = service.search(ClassName, TName, currentPage);
			List<classxx> list=(List<classxx>)pageBean.getList();
			System.out.println("list的大小是："+list.size());
			System.out.println("currentPage："+currentPage);
			System.out.println("TotalPage："+pageBean.getTotalPage());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("list", list);
			
			//3. 跳转界面。列表界面
			request.getRequestDispatcher("/Index/Class/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
