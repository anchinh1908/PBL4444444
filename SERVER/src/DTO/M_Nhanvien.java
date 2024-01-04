
package DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class M_Nhanvien {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private int id;
    private String Tennv,Chucvu,Gt,Diachi,Email;
    private Date date;
    private int luong;
    private String Status;


    public M_Nhanvien(){
    }

    public M_Nhanvien(int id, String Tennv, String Chucvu, String Gt, String Diachi, String Email, Date date, int luong, String Status) {
        this.id = id;
        this.Tennv = Tennv;
        this.Chucvu = Chucvu;
        this.Gt = Gt;
        this.Diachi = Diachi;
        this.Email = Email;
        this.date = date;
        this.luong = luong;
        this.Status = Status;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTennv() {
        return Tennv;
    }

    public void setTennv(String Tennv) {
        this.Tennv = Tennv;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public void setChucvu(String Chucvu) {
        this.Chucvu = Chucvu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getGt() {
        return Gt;
    }

    public void setGt(String Gt) {
        this.Gt = Gt;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
   
    
    @Override
    public String toString() {
    return "ID/" + id + "_TenNV/" +Tennv  + "_CV/" + Chucvu+"_NgaySinh/"+sdf.format(date)+ "_GT/" + Gt + "_DiaChi/" +Diachi  + "_Email/" + Email + "_Luong/" + luong+"_Status/"+Status;
    }
    
    public static M_Nhanvien fromString(String str) {
    M_Nhanvien nhanvien = new M_Nhanvien();

    String[] parts = str.split("_");
    for (String part : parts) {
        String[] keyValue = part.split("/");
        if (keyValue.length == 2) {
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            switch (key) {
                case "ID":
                    nhanvien.setId(Integer.parseInt(value));
                    break;
                case "TenNV":
                    nhanvien.setTennv(value);
                    break;
                case "CV":
                    nhanvien.setChucvu(value);
                    break;
                case "NgaySinh":
                    try{
                        nhanvien.setDate(sdf.parse(value));
                    }catch(Exception e){
                        System.out.println("Model.M_Nhanvien.fromString()");
                    }
                    break;
                case "GT":
                    nhanvien.setGt(value);
                    break;
                case "DiaChi":
                    nhanvien.setDiachi(value);
                    break;
                case "Email":
                    nhanvien.setEmail(value);
                    break;
                case "Luong":
                    nhanvien.setLuong(Integer.parseInt(value));
                    break;
                case "Status":
                    nhanvien.setStatus(value);
                    break;
                // Thêm các trường khác nếu có
            }
        }
    }

    return nhanvien;
}
}
