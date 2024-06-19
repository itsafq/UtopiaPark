/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import utopia.util.DBConnection;
import utopia.bean.BookingBean;

/**
 *
 * @author aafq7
 */
public class BookingDAO {
    public String BookingDao(BookingBean bookingbean) {
        
        String name = bookingbean.getName();
        String email = bookingbean.getEmail();
        String phone_no = bookingbean.getPhone_no();
        String cust_ic = bookingbean.getCust_ic();
        String type = bookingbean.getType();
        int numTicket = bookingbean.getNum_ticket();
        double price = bookingbean.getPrice(type);
        double totalPrice = bookingbean.getTotalPrice(type,numTicket);
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBConnection.createConnection();
            stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO UTOPIA.\"BOOKING\" (\"NAME\", \"EMAIL\",\"PHONE_NO\", \"CUST_IC\", \"TYPE\", \"NUM_OF_TICKET\", \"TOTAL_PRICE\") VALUES (?, ?, ?, ?, ?, ?, ?)");
            
            while(rs.next()) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, phone_no);
                pstmt.setString(4, cust_ic);
                pstmt.setString(5, type);
                pstmt.setInt(6, numTicket);
                pstmt.setDouble(7, price);
                
                pstmt.executeUpdate();
                return "SUCCESS";
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "Invalid Input";
    }
}
