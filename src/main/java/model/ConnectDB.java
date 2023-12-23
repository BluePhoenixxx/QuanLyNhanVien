/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**sS
 *
 * @author ADMIN
 */
public class ConnectDB {    
    public static Connection ketNoi(){
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyNhanVien;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String pass = "123456";        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Thành công");
        }
        catch (Exception e) {
            System.err.println("Lôi" + e);
        } finally {
        }
        
        return  conn;
        
    }
    
}
