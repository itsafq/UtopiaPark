<%-- 
    Document   : userLogIn
    Created on : Feb 3, 2023, 12:12:20 PM
    Author     : aafq7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
        <script>
            function validate()
            {
                var username = document.form.username.value;
                var password = document.form.password.value;
                
                if(username == null || name == "")
                {
                    alert("Please fill your username.");
                    return false;
                } else if (password == null || password == "") {
                    alert("Please enter your password.");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <%
            String errMessage = (String) request.getAttribute("errMessage");
            if(errMessage != null) {
        %>
        <p>
            <font color="red">Message:
            <ul>
                <li><%= errMessage %></li>
            </ul>
        </p>
        <%
            }
        %>
        
    <center>
        <h1>Login</h1>
        <br>
            <form action="LogInServlet" method="POST" onsubmit="return validate()">
                <table align="center">
                    <tr>
                        <td>Username </td>
                        <td><input type="text" name="username"/></td>
                    </tr>
                    <tr>
                        <td>Password </td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td><%= (request.getAttribute("errMessage") == null) ?"":request.getAttribute("errMessage")%></td>
                    </tr>
                    <td></td>
                    <td><input type="submit" value="Login" /></td>
                </table>
            </form>
    </center>
        
    </body>
</html>
