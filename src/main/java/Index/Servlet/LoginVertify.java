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
 * Servlet implementation class LoginVertify
 */
@WebServlet("/LoginVertify")
public class LoginVertify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginVertify() {
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
		try {
			LoginDao Tool=new LoginDao();
			User user=new User();
			user.setName(request.getParameter("name"));
			user.setPassword(request.getParameter("password"));
			boolean a[]=Tool.WhetherLogin(user);
			if(!a[0]) {
				request.getSession().setAttribute("Wrong", "’Àªß≤ª¥Ê‘⁄");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				System.out.print("name");
			}
			else {
				if(a[1]) {
					request.getSession().setAttribute("User", user);
					request.getRequestDispatcher("/Index/Index.jsp").forward(request, response);
				}
				else {
					request.getSession().setAttribute("Wrong", "√‹¬Î¥ÌŒÛ");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
					System.out.print("password");
				}
			}
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
