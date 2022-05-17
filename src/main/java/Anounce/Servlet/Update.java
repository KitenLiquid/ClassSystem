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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		// TODO Auto-generated method stub
		LinkedList  <Anou>list=(LinkedList<Anou>)request.getSession().getAttribute("ListA");
		Anou an=list.get(Integer.valueOf(request.getParameter("No")));
		String name=request.getParameter("newName");
		if(name!=null)
		an.setName(name);
		String cont=request.getParameter("newContent");
		if(cont!=null)
		an.setContent(cont);
		try {
			AnnounDao Ad=new AnnounDao(an);
			System.out.print(an.getContent()+an.getName()+an.getNo()+"aaaa");
			Ad.Update();
			Ad.closed();
			request.getRequestDispatcher("AnounServlet").forward(request, response);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
