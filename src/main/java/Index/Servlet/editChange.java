package Index.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Index.Bean.User;
import Index.Dao.LoginDao;

/**
 * Servlet implementation class editChange
 */
@WebServlet("/editChange")
public class editChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=new User();
		user.setAge(Integer.valueOf(request.getParameter("age")));
		user.setIndex(request.getParameter("id"));
		user.setEg(request.getParameter("eg"));
		user.setPassword(request.getParameter("ps"));
		user.setSi(request.getParameter("si"));
		user.setName(request.getParameter("acount"));
		try {
			LoginDao u1=new LoginDao();
			request.getSession().setAttribute("User", user);
			u1.Update(user);
			u1.closed();
			request.getRequestDispatcher("/Index/Index.jsp").forward(request, response);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
