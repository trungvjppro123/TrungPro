package trung;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.Date;
/**
 *
 * @author Jonan
 */
public class CustomeTableSV extends AbstractTableModel{
    String[] tenCot = {"Mã Sinh Vien", "Ten SV","Lop","Khoa","NgaySinh","GioiTinh"};
    Class[] kieuDuLieu = {String.class, String.class,String.class,int.class,Date.class,boolean.class};
    
    ArrayList<SV> ds = new ArrayList<>();

    public CustomeTableSV() {
    }
    
    public CustomeTableSV(ArrayList<SV> ds) {
        this.ds = ds;
    }

    @Override
    public int getRowCount() {
        return ds.size();
    }

    @Override
    public int getColumnCount() {
        return tenCot.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return ds.get(rowIndex).getMaSv();
            case 1: return ds.get(rowIndex).getTenSv();
             case 2: return ds.get(rowIndex).getLop();
              case 3: return ds.get(rowIndex).getKhoa();
               case 4: return ds.get(rowIndex).getNgaySinh();
               case 5: return ds.get(rowIndex).getgioiTinh();
            default: return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return kieuDuLieu[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return tenCot[column];
    }
     
}
