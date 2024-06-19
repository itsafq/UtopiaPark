package utopia.controller;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utopia.util.DBConnection;

public class UpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("cust_id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone_no = request.getParameter("phone_no");
        String ic = request.getParameter("cust_ic");
        String type = request.getParameter("type");
        int num_ticket = Integer.parseInt(request.getParameter("num_ticket"));
        
       
            Connection con = null;
            PreparedStatement pstmt = null;
            try {
                con = DBConnection.createConnection();
                String sql = "UPDATE BOOKING SET NAME = ?, EMAIL = ?, PHONE_NO = ?, CUST_IC = ?, TYPE = ?, NUM_OF_TICKET = ? WHERE CUST_ID = ?";
                pstmt = con.prepareStatement(sql);
                
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, phone_no);
                pstmt.setString(4, ic);
                pstmt.setString(5, type);
                pstmt.setInt(6, num_ticket);
                pstmt.setInt(7, id);
                
                pstmt.executeUpdate();

                    System.out.println("Booking Updated Successfully.");
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);

            } catch(SQLException ex) {
                request.setAttribute("error",ex);
                System.out.println(ex);
            }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
