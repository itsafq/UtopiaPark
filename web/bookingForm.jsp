<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="utopia.controller.bookingFormServlet" %>
<%@page import="utopia.bean.BookingBean" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sql:setDataSource var="myDatasource"
driver="org.apache.derby.jdbc.ClientDriver"
url="jdbc:derby://localhost:1527/utopia" user="utopia"
password="123"/>

<%
    String[] type = {"Child", "Student", "Adult", "Senior Citizen"};
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Utopia : Booking Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body> 
        <jsp:useBean id="BookingBean" class="utopia.bean.BookingBean">
            <jsp:setProperty name="BookingBean" property="name"/>
            <jsp:setProperty name="BookingBean" property="email"/>
            <jsp:setProperty name="BookingBean" property="phone_no"/>
            <jsp:setProperty name="BookingBean" property="cust_ic"/>
            <jsp:setProperty name="BookingBean" property="num_ticket"/>
            <jsp:setProperty name="BookingBean" property="type"/>
        </jsp:useBean>
        
        <h1 align="center">Buy Tickets</h1>
        <%
            List errorMsgs = (List) request.getAttribute("errorMsgs");
            if(errorMsgs != null) {
        %>
        <p>
            <font color='red'>Please correct the following errors:
            <ul>
                <%
                    Iterator items = errorMsgs.iterator();
                    while(items.hasNext()) {
                        String message = (String) items.next();
                %>
                <li><%-- Message --%></li>
                <%
                    }
                %>
            </ul>
        </p>
        <% } %>
        <form action="bookingFormServlet" method="POST">
            <table align="center">
                <tbody>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email"/></td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><input type="text" name="phone_no" /></td>
                    </tr>
                    <tr>
                        <td>Identification No.</td>
                        <td><input type="text" name="cust_ic"/></td>
                    </tr>
                    <tr>
                        <td>Num. of Tickets</td>
                        <td><input type="number" name="num_ticket"/></td>
                    </tr>
                    <%
                        String types = request.getParameter("type");
                    %>
                    <tr>
                        <td>Type</td>
                        <td><select name="type" value="Select type">
                                <%
                                    for(int i=0; i<type.length; i++)
                                    {
                                        String type_item = type[i];
                                %>
                                <option value="<%= type_item %>">
                                <%
                                    if(type_item.equals(type)) {
                                        out.print("Selected");
                                    }
                                %>
                                <%= type_item %></option>
                                <% } %>
                            </select></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="typeform" value="booking"/></td>
                        <td><input type="submit" value="Book"/></td>
                </tr>
            </table>
        </form>
                            
    </body>
</html>
