
package DTO;

public class M_Sanpham {
    private int Masp;
    private String Tensp,Tenloai;
    private int Maloai, Soluong;
    private int gia;
     private boolean Status;

    public M_Sanpham(){
    }

    public M_Sanpham(int Masp, String Tensp, String Tenloai, int Maloai, int Soluong, int gia) {
        this.Masp = Masp;
        this.Tensp = Tensp;
        this.Tenloai = Tenloai;
        this.Maloai = Maloai;
        this.Soluong = Soluong;
        this.gia = gia;
    }

    public int getMasp() {
        return Masp;
    }

    public void setMasp(int Masp) {
        this.Masp = Masp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String Tensp) {
        this.Tensp = Tensp;
    }

    public String getTenloai() {
        return Tenloai;
    }

    public void setTenloai(String Tenloai) {
        this.Tenloai = Tenloai;
    }

    public int getMaloai() {
        return Maloai;
    }

    public void setMaloai(int Maloai) {
        this.Maloai = Maloai;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
@Override
    public String toString() {
        return "MaSP/"+Masp+"_TenSP/"+Tensp+"_TenLoai/" + Tenloai +"_SoLuong/" + Soluong +"_Gia/" +gia+"_Status/"+Status;
    }
    public static M_Sanpham fromString(String str){
        M_Sanpham sanpham=new M_Sanpham(); //chuyen String sanpham thanh 1 doi tuong M_sanpham
        
        String[] parts=str.split("_");
        for(String part : parts){
            String[] keyValue=part.split("/");
            if(keyValue.length == 2){
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                switch (key) { 
                    case "MaSP":
                        sanpham.setMasp(Integer.parseInt(value));
                        break;
                    case "TenSP":
                        sanpham.setTensp(value);
                        break;
                    case "TenLoai":
                        sanpham.setTenloai(value);
                        break;
                    case "Maloai":
                        sanpham.setMaloai(Integer.parseInt(value));
                        break;
                    case "SoLuong":
                        sanpham.setSoluong(Integer.parseInt(value));
                        break;
                    case "Gia":
                        sanpham.setGia(Integer.parseInt(value));
                        break;
                case "Status":
                    sanpham.setStatus(Boolean.parseBoolean(value));
                    break;                
                }
            }
        }
            return sanpham;        
    }
}