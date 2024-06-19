/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utopia.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aafq7
 */
public class DBConnection {
    public static Connection createConnection() {
        
        Connection con = null;
        String url = "jdbc:derby://localhost:1527/utopia";
        String username = "utopia";
        String password = "123";
        System.out.println("Connected");
        try {
            try {
                String driver = "org.apache.derby.jdbc.ClientDriver";
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url, username, password);//attempting to connect to database
            System.out.println("Connecting to " + con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
}
