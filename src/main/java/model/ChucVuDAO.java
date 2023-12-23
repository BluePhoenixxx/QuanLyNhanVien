/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author ADMIN
 */
public class ChucVuDAO {

    public static String getMaChucVu(String ma ) {
        List<ChucVu> ls = new ArrayList<>();
        ls  = getAll();
        for (ChucVu l : ls) {
            if (l.getTenCV().equals(ma)){
                return l.getMaCV();
            }
                
        }
        return "";
    }
    public static List<ChucVu> getAll(){
        List<ChucVu> ls = new ArrayList<>();
        ResultSet rs = null;
        String sql = "Select * from ChucVu";
        
        try {
            Connection conn = ConnectDB.ketNoi();
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()){
                ChucVu cv = new ChucVu();
                cv.setMaCV(rs.getString(1));
                cv.setTenCV(rs.getString(2));
                ls.add(cv);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Loi" + e);
        } finally {
            
        }
                
        return ls;
    }
    

}
