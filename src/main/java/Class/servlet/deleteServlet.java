package Class.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.bean.classaa;
import Class.service.classService;
import Class.service.classServiceImpl;

@WebServlet(name="deleteServlet",urlPatterns={"/deleteServlet"})
public class deleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("ClassNumber");
        int ClassNumber=Integer.parseInt(number);
        classService service = new classServiceImpl();
        service.delete(ClassNumber);
        service.delete1(ClassNumber);
        req.getRequestDispatcher("ClassListServlet").forward(req,resp);
    }
}
