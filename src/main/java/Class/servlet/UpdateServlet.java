package Class.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.bean.classxx;
import Class.service.classService;
import Class.service.classServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
			//1. ��ȡ�ͻ����ύ����������
			int APnumber = Integer.parseInt(request.getParameter("APnumber"));
			String ClassName = request.getParameter("ClassName");
			int ClassNumber = Integer.parseInt(request.getParameter("ClassNumber"));
			//2. ��ӵ����ݿ�
			classxx Class = new classxx(ClassName,APnumber,ClassNumber);
			
			//2. �������ݿ�����
			classService service = new classServiceImpl();
			service.update(Class);
			
			//3. ��ת����
			request.getRequestDispatcher("classListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

