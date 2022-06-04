package Class.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.bean.Student;
import Class.service.classService;
import Class.service.classServiceImpl;

@WebServlet(name="studeleteServlet",urlPatterns={"/studeleteServlet"})
public class studeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("Number");
        String classnumber = req.getParameter("ClassNumber");
        int Number=Integer.parseInt(number);
        int ClassNumber=Integer.parseInt(classnumber);
        classService service = new classServiceImpl();
        service.delete3(Number,ClassNumber);
        req.getRequestDispatcher("SListServlet").forward(req,resp);
    }
}
