
package DTO;


public class M_cbbspct {
    private int id;
    private String Tenloai;

    public M_cbbspct() {
    }
    public M_cbbspct(int id, String Tenloai) {
        this.id = id;
        this.Tenloai = Tenloai;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenloai() {
        return Tenloai;
    }

    public void setTenloai(String Tenloai) {
        this.Tenloai = Tenloai;
    }
    @Override
    public String toString(){
        return Tenloai;
    }
}
