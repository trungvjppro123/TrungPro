/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung;
import java.util.Date;
/**
 *
 * @author Cuong
 */
public class SV {
    private String maSv;
    private String tenSv;
    private String lop;
    private int khoa;
    Date ngaySinh;
    private boolean gioiTinh;

    public SV() {
    }

    public SV(String maSv, String tenSv, String lop, int khoa, Date ngaySinh, boolean gioiTinh) {
        this.maSv = maSv;
        this.tenSv = tenSv;
        this.lop = lop;
        this.khoa = khoa;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

 



    
    
    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    
    
    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public boolean getgioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }



    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        return "SV{" + "maSv=" + maSv + ", tenSv=" + tenSv + ", lop=" + lop + ", khoa=" + khoa + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + '}';
    }
    
   
 
    
}
