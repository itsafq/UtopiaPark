/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utopia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utopia.util.DBConnection;
import utopia.bean.BookingBean;
import utopia.dao.BookingDAO;

/**
 *
 * @author aafq7
 */
public class bookingFormServlet extends HttpServlet {

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
        response.setContentType("text/html");
        

        PrintWriter out = response.getWriter();
        
        Connection con = null;
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone_no");
        String ic = request.getParameter("cust_ic");
        String type = request.getParameter("type");
        int num_ticket = Integer.parseInt(request.getParameter("num_ticket"));
        
        try {
            con = DBConnection.createConnection();
            
            BookingBean bookingbean = new BookingBean(name, email, phone, ic, type, num_ticket);
            
            String sql = "INSERT INTO BOOKING (NAME, EMAIL,PHONE_NO, CUST_IC, TYPE, NUM_OF_TICKET, TOTAL_PRICE) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            double total_price = 0;
            
            if(type.equals("Adult"))
            {
                total_price += 90;
            }
            else if(type.equals("Child"))
            {
                total_price += 40;
            }
            else if(type.equals("Student"))
            {
                total_price += 70;
            }
            else
            {
                total_price += 65;
            }
            
            total_price *= num_ticket;
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, ic);
            pstmt.setString(5, type);
            pstmt.setInt(6, num_ticket);
            pstmt.setDouble(7, total_price);
            
            pstmt.executeUpdate();
            
            RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
            rd.forward(request, response);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
