/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung;

import java.sql.Connection;
import java.sql.Date;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author giasutinhoc.vn
 */

public class DAO {
    private Connection conn;
    public DAO(){
        try {
    String dbURL = "jdbc:sqlserver://localhost;databaseName=QUANLYTHUVIEN;user=sa;password=123456";
     conn = DriverManager.getConnection(dbURL);
    if (conn != null){
        System.out.println("connect success");
    }
   } catch (SQLException ex) {
     System.err.println("Cannot connect database, " + ex);
   }
    }
    
    public boolean addSV(SV s){
        String sql="INSERT INTO SinhVien(MaSinhVien,TenSinhVien,Lop,Khoa,NgaySinh,GioiTinh)"+"VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,s.getMaSv());
            ps.setString(2,s.getTenSv());
            ps.setString(3,s.getLop());
            ps.setInt(4,s.getKhoa());
            ps.setDate(5, new Date(s.getNgaySinh().getTime()));
            ps.setBoolean(6,s.getgioiTinh());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
                         
        }
        return false;
    }
    public ArrayList<SV> getListSV(){
        ArrayList<SV> list=new ArrayList<>();
        String sql="Select * from SinhVien";
        
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SV s=new SV();
                s.setMaSv(rs.getString("MaSinhVien"));
               s.setTenSv(rs.getString("TenSinhVien"));
               s.setLop(rs.getString("Lop"));
               s.setKhoa(rs.getInt("Khoa"));
               s.setNgaySinh(rs.getDate("NgaySinh"));
               s.setGioiTinh(rs.getBoolean("GioiTinh"));
              list.add(s);
            }
        }catch (SQLException e) {
            
             e.printStackTrace();
        }
        return list;
    }
        public boolean setSV(SV s){
       // String sql="INSERT INTO SinhVien(MaSinhVien,TenSinhVien,Lop,Khoa,NgaySinh,GioiTinh)"+"VALUES(?,?,?,?,?,?)";
      String sql="UPDATE SinhVien set TenSinhVien= ?,lop= ?,khoa=?,NgaySinh=?,GioiTinh=? where MaSinhVien= ?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            
            ps.setString(1,s.getTenSv());
            ps.setString(2,s.getLop());
            ps.setInt(3,s.getKhoa());
            ps.setDate(4, new Date(s.getNgaySinh().getTime()));
            ps.setBoolean(5,s.getgioiTinh());
            ps.setString(6,s.getMaSv());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
                         
        }
        return false;
    }
      public void xoaSV(String msv) {
            
           String getSQL = "DELETE SinhVien WHERE MaSinhVien=?";
          
        try {
      
            PreparedStatement preStmt = conn.prepareStatement(getSQL);
            preStmt.setString(1, msv);
            preStmt.executeUpdate(); 
            
        } 
        catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại", "Lỗi", JOptionPane.CANCEL_OPTION);
        }      
    }
 public static void main(String[] args) {
     new DAO();
  }
 
}