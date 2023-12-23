/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.Vector;


/**
 *
 * @author ADMIN
 */
public class NhanVien {
    private int id;
    private String maNV,tenNV, email, diaChi, gioiTinh, SDT, tenCV;
    private String ngaySinh;

    public NhanVien(int id, String maNV, String tenNV, String email, String diaChi, String gioiTinh, String SDT, String tenCV, String ngaySinh) {
        this.id = id;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.email = email;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.tenCV = tenCV;
        this.ngaySinh = ngaySinh;
    }

    public NhanVien() {
    }

    public int getId() {
        return id;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public String getTenCV() {
        return tenCV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }



    
}
