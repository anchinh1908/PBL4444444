
package DAL;

import DTO.M_DBconnect;
import DTO.M_Sanpham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class DAOsp {
    public static void main(String[] args){
        M_DBconnect.loadConnection();
    }
    public ArrayList<M_Sanpham> getListSP()
    {
        ArrayList<M_Sanpham> list=new ArrayList<>();
        String sql="SELECT Masanpham,Tensanpham,Tenloai,ctsp.Maloai,Soluong,Gia,sanpham.Status FROM ctsp JOIN sanpham ON ctsp.Maloai = sanpham.Maloai;";
        try{
            PreparedStatement ps =M_DBconnect.con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                M_Sanpham n=new M_Sanpham();
                //n.setId(rs.getInt("ID"));
                n.setMasp(rs.getInt("Masanpham"));
                n.setTensp(rs.getString("Tensanpham"));
                n.setTenloai(rs.getString("Tenloai"));
                n.setMaloai(rs.getInt("Maloai"));
                n.setSoluong(rs.getInt("Soluong"));
                n.setGia(rs.getInt("Gia"));
                n.setStatus(rs.getString("Status"));
                list.add(n);                        
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    } 
    public boolean AddSP(M_Sanpham s, String name){
        String sql="insert into sanpham values(null,?,?,?,?,?)";
        try{
            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,s.getTensp());
            ps.setInt(2,s.getMaloai());
            ps.setInt(3,s.getSoluong());
            ps.setInt(4, (int) s.getGia());
            ps.setString(5,"editable");
            int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    // Lấy giá trị ID đã được tự động tạo
                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int newId = generatedKeys.getInt(1);
                            s.setMasp(newId);
                            new DAL.DAO_log().addLogSP(name,"Insert",s.toString());
                        } else {
                            System.out.println("Không thể lấy ID của đối tượng mới.");
                        }
                    }
                    return true;
                } else {
                    System.out.println("Thêm mới đối tượng không thành công.");
                    return false;
                }
        }catch(SQLException e){
            return false;
        }
    }
    public boolean DeleteSP(int Masp){
        String sql="delete from sanpham where Masanpham=?";
        try{
            PreparedStatement ps=M_DBconnect.con.prepareCall(sql);
            ps.setInt(1, Masp);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }catch(SQLException e){
            return false;
        }
    }
//    public boolean updateSP(M_Sanpham sp) {
//        String sql = "UPDATE sanpham SET Tensanpham = ?, Maloai = ?, Soluong = ?, Gia = ?, Status = ? WHERE Masanpham = ?;";
//
//        try {
//            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql);
//            ps.setString(1, sp.getTensp());
//            ps.setInt(2, sp.getMaloai());
//            ps.setInt(3, sp.getSoluong());
//            ps.setInt(4, sp.getGia());
//            ps.setString(5, sp.getStatus());
//            ps.setInt(6, sp.getMasp());
//            int affectedRows = ps.executeUpdate();
//            return affectedRows > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    public boolean updateSP(M_Sanpham sp) {
    String sql = "UPDATE sanpham SET Tensanpham = ?, Maloai = ?, Soluong = ?, Gia = ?, Status = ? WHERE Masanpham = ?;";

    try (PreparedStatement ps = M_DBconnect.con.prepareStatement(sql)) {
        ps.setString(1, sp.getTensp());
        ps.setInt(2, sp.getMaloai());
        ps.setInt(3, sp.getSoluong());
        ps.setInt(4, sp.getGia());
        ps.setString(5, sp.getStatus());
        ps.setInt(6, sp.getMasp());

        int affectedRows = ps.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}


