package Anounce.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Anounce.Bean.Anou;
import Anounce.Dao.AnnounDao;

/**
 * Servlet implementation class AnounServlet
 */
@WebServlet("/AnounServlet")
public class AnounServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnounServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Anou an=new Anou();
			AnnounDao Ad=new AnnounDao(an);
			LinkedList <Anou> list=Ad.Select();
			if(list.size()!=0) {
				list=Ad.Select();
			}
			else {
				list=null;
			}
			Ad.closed();
			request.getSession().setAttribute("ListA", list);
			request.getRequestDispatcher("/Index/Anounce/Anounce.jsp").forward(request, response);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
