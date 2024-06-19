package utopia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utopia.util.DBConnection;
import utopia.bean.LoginBean;
import utopia.dao.LoginDAO;

/**
 *
 * @author aafq7
 */
public class LogInServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogInServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogInServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        LoginBean loginbean = new LoginBean(userName, password);
        
        LoginDAO loginDao = new LoginDAO();
        
        String userValidate = loginDao.authenticateUser(loginbean);
        
        if(userValidate.equals("SUCCESS")) 
        {
            request.setAttribute("username", userName);
            RequestDispatcher view = request.getRequestDispatcher("/userHome.html");
            view.forward(request, response);
        } 
        
        request.setAttribute("errMessage", userValidate);
        RequestDispatcher view = request.getRequestDispatcher("SignUp.jsp");
        view.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
