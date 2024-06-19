package utopia.controller;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utopia.util.DBConnection;

public class searchServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet searchServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchServlet at " + request.getContextPath() + "</h1>");
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
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String ic = request.getParameter("cust_ic");
        
        try {
            con = DBConnection.createConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM UTOPIA.\"BOOKING\" WHERE \"CUST_IC\" = " + ic;
            rs = stmt.executeQuery(sql);
            
            while(rs.next()) 
            {
                rs.getString("name");
                rs.getString("email");
                rs.getString("phone_no");
                rs.getString("cust_ic");
                rs.getString("type");
                rs.getString("num_of_ticket");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
