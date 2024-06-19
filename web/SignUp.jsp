<%-- 
    Document   : SignUp
    Created on : Feb 3, 2023, 12:06:39 PM
    Author     : aafq7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up Page</title>
        <script>
            function validate()
            {
                var name = document.form.name.value;
                var email = document.form.email.value;
                var username = document.form.username.value;
                var password = document.form.password.value;
                var conpassword = document.form.conpassword.value;
                var phone_no = document.form.phone_no.value;
                
                if (name == null || name == "")
                {
                    alert("Please fill your name.");
                    return false;
                } else if (email == null || email == "") {
                    alert("Please fill you email.");
                    return false;
                } else if ( username == null || username == "") {
                    alert("Please fill your username.");
                    return false;
                } else if ( password.length < 6) {
                    alert("Password must be atleast 6 characters long.");
                    return false;
                } else if ( password != conpassword) {
                    alert("Confirm password should match with the pasword.");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <h1 align="center">Sign Up</h1>
        <form name="form" action="SignUpServlet" method="POST" onsubmit="return validate()">
            <table align ="center">
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>Phone No.</td>
                    <td><input type="text" name="phone_no"/></td>
                </tr>
                <%--<tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="conpassword"/></td>
                </tr>--%>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td><%= (request.getAttribute("errMessage") == null) ?"":request.getAttribute("errMessage")%></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Sign Up"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
