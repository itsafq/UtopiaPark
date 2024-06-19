/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utopia.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utopia.bean.SignUpBean;
import utopia.util.DBConnection;

/**
 *
 * @author aafq7
 */
public class SignUpServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignUpServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        Connection con;
        PreparedStatement pstmt;
        
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone_no = request.getParameter("phone_no");
        String email = request.getParameter("email");
        
        SignUpBean signup = new SignUpBean();
        signup.setName(name);
        signup.setUsername(username);
        signup.setPassword(password);
        signup.setPhone_no(phone_no);
        signup.setEmail(email);
        
        try {
            con = DBConnection.createConnection();
            String sql = "INSERT INTO UTOPIA.\"USER\" (\"NAME\", \"USERNAME\", \"PASSWORD\", \"PHONE_NO\", \"EMAIL\") VALUES (?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql); //Making use of prepared statements to insert bunch of data
            pstmt.setString(1, name);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setString(4, phone_no);
            pstmt.setString(5, email);
            
            pstmt.executeUpdate();
            
            RequestDispatcher rd = request.getRequestDispatcher("userLogIn.jsp");
            rd.forward(request, response);
            
        } catch (Exception e) {
            System.out.println("ERROR :: " + e.getMessage());
        }
        out.close();
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
