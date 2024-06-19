<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="utopia.util.DBConnection"%>

<%
    int id = Integer.parseInt(request.getParameter("ic"));
    Connection con = DBConnection.createConnection();    
    Statement stmt = null;
    ResultSet rs = null;
%>
<%
            String name = "";
            String email = "";
            String phone_no = "";
            String cust_ic = "";
            String type = "";
            int num_ticket = 0;
            String sql = "SELECT * FROM BOOKING WHERE CUST_ID = "+ id;
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                id = rs.getInt("CUST_ID");
                name = rs.getString("NAME");
                email = rs.getString("EMAIL");
                phone_no = rs.getString("PHONE_NO");
                cust_ic = rs.getString("CUST_IC");
                type = rs.getString("TYPE");
                num_ticket = rs.getInt("NUM_OF_TICKET");
            }
            con.close();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Update Booking</h1>

        <form method="POST" action="UpdateServlet">
            <table>
                <tr>
                    <td><input type="hidden" name="cust_id" value="<%=id%>"</td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="<%=name%>"</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="<%=email%>"</td>
                </tr>
                <tr>
                    <td>Phone No.</td>
                    <td><input type="text" name="phone_no" value="<%=phone_no%>"</td>
                </tr>
                <tr>
                    <td>IC</td>
                    <td><input type="text" name="cust_ic" value="<%=cust_ic%>"</td>
                </tr>
                <tr>
                    <td>Type</td>
                    <td><input type="text" name="type" value="<%=type%>"</td>
                </tr>
                <tr>
                    <td>Num. of Ticket</td>
                    <td><input type="number" name="num_ticket" value="<%=num_ticket %>"</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                    <td></td>
                </tr>
            </table>
        </form>
                
    </body>
</html>
