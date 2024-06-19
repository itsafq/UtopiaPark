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
import utopia.util.DBConnection;
import utopia.bean.LoginBean;

/**
 *
 * @author aafq7
 */
public class LoginDAO {
    public String authenticateUser(LoginBean loginbean) {
        String userName = loginbean.getUsername();
        String password = loginbean.getPassword();
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultset = null;
        String usernameDB = "";
        String passwordDB = "";
        
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultset = statement.executeQuery("select \"USERNAME\", \"PASSWORD\" from UTOPIA.\"USER\"");
            while(resultset.next())
            {
                usernameDB = resultset.getString("username");
                passwordDB = resultset.getString("password");
                if(userName.equals(usernameDB) && password.equals(passwordDB)) {
                    return "SUCCESS";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "<font color='red'><br>Invalid User Credentials!<br>Please Sign Up.</font>";
    }
}
