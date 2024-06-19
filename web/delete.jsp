<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="utopia.util.DBConnection;"%>
<%
    int id = Integer.parseInt(request.getParameter("ic"));
    try {
        Connection con = DBConnection.createConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM BOOKING WHERE cust_id = " + id);
        
        out.println("Data Successfully Deleted!");
    } catch (Exception e) {
        System.out.println(e);
        e.printStackTrace();
    }
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Booking</title>
    </head>
    <body>        
        <a href="index.html"><button>Home</button></a>
    </body>
</html>
