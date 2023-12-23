/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.ChucVuDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO {
    public List<NhanVien> getAll(){
        List<NhanVien> ls = new ArrayList<>();
        ResultSet rs = null;
        String sql  = "select NhanVien.id, NhanVien.MaNV,NhanVien.TenNV,ChucVu.TenCV, NhanVien.Email,NhanVien.SoDienThoai,NhanVien.DiaChi,NhanVien.GioiTinh,NhanVien.NgaySinh from NhanVien inner join  ChucVu on ChucVu.MaCV = NhanVien.MaCV";
        
        try {
            Connection conn = ConnectDB.ketNoi();
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt(1));
                nv.setMaNV(rs.getString(2));
                nv.setTenNV(rs.getString(3));
                nv.setTenCV(rs.getString(4));
                nv.setEmail(rs.getString(5));
                nv.setSDT(rs.getString(6));
                nv.setDiaChi(rs.getString(7 ));
                nv.setGioiTinh(rs.getString(8));
                nv.setNgaySinh(rs.getString(9));
                ls.add(nv);
            }
           
           conn.close();
           rs.close();
           ps.close();
        } catch (Exception e) {
        }
        
        return ls;
    }
    
    public void add(String maNV, String tenNV, String chucVu, String email, String sdt, String diaChi, String gioiTinh, String ngaySinh){
        String sql = "INSERT INTO NHANVIEN(MaNV,TenNV,MaCV,Email,SoDienThoai,GioiTinh,DiaChi,NgaySinh) values (?,?,(select ChucVu.MaCV from ChucVu where ChucVu.TenCV =?),?,?,?,?,?)";
        Connection conn = ConnectDB.ketNoi();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNV);
            ps.setString(2, tenNV);
            ps.setString(3, chucVu);
            ps.setString(4, email);
            ps.setString(5, sdt);
            ps.setString(6, diaChi);
            ps.setString(7, gioiTinh);
            ps.setString(8,  ngaySinh);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Loi" + e);
        }
        
    }
    
    
    public List<NhanVien> findName(String find){
        List<NhanVien> ls = new ArrayList<>();
        ResultSet rs = null;
        String sql  = "select NhanVien.id, NhanVien.MaNV,NhanVien.TenNV,ChucVu.TenCV, NhanVien.Email,NhanVien.SoDienThoai,NhanVien.DiaChi,NhanVien.GioiTinh,NhanVien.NgaySinh from NhanVien inner join  ChucVu on ChucVu.MaCV = NhanVien.MaCV where tenNV like N'%"+ find +"%'";
        
        try {
            Connection conn = ConnectDB.ketNoi();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            try {

                rs = ps.executeQuery();
            } catch (Exception e) {
                System.out.println("Loi  "+e);
            }
            
            while (rs.next()){
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt(1));
                nv.setMaNV(rs.getString(2));
                nv.setTenNV(rs.getString(3));
                nv.setTenCV(rs.getString(4));
                nv.setEmail(rs.getString(5));
                nv.setSDT(rs.getString(6));
                nv.setDiaChi(rs.getString(7 ));
                nv.setGioiTinh(rs.getString(8));
                nv.setNgaySinh(rs.getString(9));
                ls.add(nv);
            }
           
           conn.close();
           rs.close();
           ps.close();
        } catch (Exception e) {
        }
        
        return ls;
    }
   
    
    public void deleteNV(int id){
        String sql = "delete from nhanvien  where id =?";
        Connection conn = ConnectDB.ketNoi();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Loi" + e);
        }
    }
    
    public void edit(String maNV, String tenNV, String chucVu, String email, String sdt, String diaChi, String gioiTinh, String ngaySinh){
        String sql = "UPDATE [dbo].[NhanVien]\n" +
"   SET [TenNV] = ?" +
"      ,[MaCV] = ?\n" +
"      ,[Email] = ?\n" +
"      ,[SoDienThoai] = ?\n" +
"      ,[GioiTinh] =?\n" +
"      ,[DiaChi] = ?\n" +
"      ,[NgaySinh] = ?\n" +
" WHERE MaNV=?";
        Connection conn = ConnectDB.ketNoi();
        try {
            String maCV =  ChucVuDAO.getMaChucVu(chucVu);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(8, maNV);
            ps.setString(1, tenNV);
            ps.setString(2, maCV);
            ps.setString(3, email);
            ps.setString(4, sdt);
            ps.setString(5, diaChi);
            ps.setString(6, gioiTinh);
            ps.setString(7,  ngaySinh);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Loi" + e);
        }
        
    }

    
    
    private String getMaChucVu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
