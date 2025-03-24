/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang
 */
public class DBUtils {
       private static final String DB_NAME = "Fast_Food_Online";
        private static final String DB_username = "sa";
        private static final String DB_password = "12345";
        
        public static Connection getConnection() throws SQLException , ClassNotFoundException {
            Connection conn = null ;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName="+DB_NAME+";encrypt=false;trustServerCertificate=true;"; 
            conn = DriverManager.getConnection(url,DB_username,DB_password);
            return conn;
        }
        public static void main(String[] args) {
                Connection c;
            try {
                c = getConnection();
                System.out.println(c);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
