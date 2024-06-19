<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="utopia.util.DBConnection"%>

<%
    String ic = request.getParameter("cust_ic");
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Booking</title>
    </head>
    <body>
        <h1>Search Booking</h1>
        <hr><br>
        
        <table cellpadding="5" cellspacing="5" border="1">
            <tr>
                <td>Cust_ID</td>
                <td>Name</td>
                <td>Email</td>
                <td>Phone Num.</td>
                <td>Cust_IC</td>
                <td>Type</td>
                <td>Num. Of Tickets</td>
                <td>Total Price</td>
                <td colspan="2">Action</td>
            </tr>
            <%
                try {
                    con = DBConnection.createConnection();
                    stmt = con.createStatement();
                    String sql = "SELECT * FROM BOOKING WHERE CUST_IC = '" + ic + "'";
                    rs = stmt.executeQuery(sql);
                    
                    while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getInt("CUST_ID")%></td>
                <td><%=rs.getString("name")%></td>
                <td><%=rs.getString("email")%></td>
                <td><%=rs.getString("phone_no")%></td>
                <td><%=rs.getString("cust_ic")%></td>
                <td><%=rs.getString("type")%></td>
                <td><%=rs.getInt("num_of_ticket")%></td>
                <td><%=rs.getDouble("total_price")%></td>
                <td><a href="delete.jsp?ic=<%=rs.getInt("cust_id")%>"><button type="button">Delete</button></a></td>
                <td><a href="updateForm.jsp?ic=<%=rs.getInt("cust_id")%>"><button type="button">Update</button></a></td>
            </tr>
            <%
                } 
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </table>
        
        <br><a href="Search.html">Search</a>
    </body>
</html>
