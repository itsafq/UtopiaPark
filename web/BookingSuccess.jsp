<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="utopia.util.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String id = request.getParameter("CUST_ID");
    String ic = request.getParameter("cust_ic");

    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking : Utopia : Amusement Park</title>
    </head>
    <body>
        
        
            <form method="POST" action="search.jsp">
                <table align="center">
                <tr>
                    <td><input type="text" name="cust_ic" placeholder="Search IC..."></td>
                    <td><button type="submit" name="search">Search</button></td>
                </tr>
                </table>
            </form>
            <table align="center" cellpadding="5" cellspacing="5" border="1">
                <tr>
                    <td>Cust_ID</td>
                    <td>Name</td>
                    <td>Email</td>
                    <td>Phone Num.</td>
                    <td>Cust_IC</td>
                    <td>Type</td>
                    <td>Num. Of Tickets</td>
                    <td></td>
                    <td></td>
                </tr>
                <%
                    try {
                        connection = DBConnection.createConnection();
                        statement = connection.createStatement();
                        String sql = "SELECT * FROM UTOPIA.\"BOOKING\" WHERE cust_ic = '" + ic + "'";
                        
                        resultset = statement.executeQuery(sql);
                        while(resultset.next()) {
                %>
                
                    <tr>
                        <td><%=resultset.getString("CUST_ID")%></td>
                        <td><%=resultset.getString("name")%></td>
                        <td><%=resultset.getString("email")%></td>
                        <td><%=resultset.getString("phone_no")%></td>
                        <td><%=resultset.getString("cust_ic")%></td>
                        <td><%=resultset.getString("type")%></td>
                        <td><%=resultset.getString("num_of_ticket")%></td>
                        <td><a href="delete.jsp?id=<%=resultset.getString("CUST_ID")%>"><button type="button" class="delete">Delete</button></a></td>
                        <td><a href="updateForm.jsp?id=<%=resultset.getString("CUST_ID")%>"><button type="button" class="update">Update</button></a></td>
                    </tr>
                
                    <%
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
            </table>
        <br>
        <center><a href="index.html">Home</a></center>
    </body>
</html>
