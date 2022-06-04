package Score.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Score.service.ScoreService;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ClassNumber=Integer.valueOf(request.getParameter("ClassNumber"));
        ScoreService service = new ScoreService();
        service.delete(ClassNumber);
        service.delete1(ClassNumber);
//        response.getWriter().write("<h3>删除成功</h3>");
        RequestDispatcher rd=request.getRequestDispatcher("SListServlet");
        rd.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
