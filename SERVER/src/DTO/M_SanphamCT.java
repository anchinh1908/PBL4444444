
package DTO;


public class M_SanphamCT {
    private int Maloai;
    private String Tenloai,Mota;
    private boolean Status;

   
    public M_SanphamCT(){}

    public M_SanphamCT(int Maloai, String Tenloai, String Mota) {
        this.Maloai = Maloai;
        this.Tenloai = Tenloai;
        this.Mota = Mota;
    }

    public int getMaloai() {
        return Maloai;
    }

    public void setMaloai(int Maloai) {
        this.Maloai = Maloai;
    }

    public String getTenloai() {
        return Tenloai;
    }

    public void setTenloai(String Tenloai) {
        this.Tenloai = Tenloai;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }       
    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

        @Override
    public String toString() {
        return "_MaLoai/"+Maloai+"_TenLoai/"+Tenloai+"_Mota/"+Mota+"_Status/"+Status;
    }
    public static M_SanphamCT fromString(String str){
        M_SanphamCT spct=new M_SanphamCT();
        String[] parts=str.split("_");
        for(String part : parts){
            String[] keyValue=part.split("/");
            if(keyValue.length == 2){
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                switch (key) { 
                    case "MaLoai":
                        spct.setMaloai(Integer.parseInt(value));
                        break;
                    case "TenLoai":
                        spct.setTenloai(value);
                        break;
                    case "Mota":
                        spct.setMota(value);
                        break;
                    case "Status":
                        spct.setStatus(Boolean.parseBoolean(value));
                    break;
                    }
                }
            }
        return spct;
    }
}
