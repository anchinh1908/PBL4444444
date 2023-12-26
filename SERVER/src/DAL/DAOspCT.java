
package DAL;

import DTO.M_DBconnect;
import DTO.M_SanphamCT;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAOspCT {
    public static void main(String[] args){
        M_DBconnect.loadConnection();
    }
    public ArrayList<M_SanphamCT> getListSPCT()
    {
        ArrayList<M_SanphamCT> list=new ArrayList<>();
        String sql="SELECT * FROM ctsp";
        try{
            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                M_SanphamCT n=new M_SanphamCT();
                  n.setMaloai(rs.getInt("MaLoai"));
                  n.setTenloai(rs.getString("TenLoai"));
                  n.setMota(rs.getString("Mota"));
                  n.setStatus(rs.getBoolean("Status"));
                list.add(n);                        
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    } 

    public boolean AddSPCT(M_SanphamCT s, String name){
        String sql="insert into ctsp values(?,?,?,?)";
        try{
            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
              ps.setInt(1,s.getMaloai());
              ps.setString(2,s.getTenloai());
              ps.setString(3,s.getMota());
              ps.setString(4, "true");
            int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    // Lấy giá trị ID đã được tự động tạo
                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int newId = generatedKeys.getInt(1);
                            new DAL.DAO_log().addLogSPCT(name,"Insert",newId);
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
    public boolean DeleteSPCT(int mact){
        String sql="delete from ctsp where Maloai=?";
        try{
            PreparedStatement ps=M_DBconnect.con.prepareCall(sql);
            ps.setInt(1, mact);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean updateSPCT(M_SanphamCT spCT) {
        System.out.println("DAL.DAOspCT.updateSPCT()"+spCT.getStatus());
    String sql = "UPDATE ctsp SET Maloai = ?, Tenloai = ?, Mota = ?, Status = ? WHERE Maloai = ?;";

    try {
        PreparedStatement ps = M_DBconnect.con.prepareStatement(sql);
        ps.setInt(1, spCT.getMaloai());
        ps.setString(2, spCT.getTenloai());
        ps.setString(3, spCT.getMota());
        ps.setString(4, spCT.getStatus()? "true" : "false");
        ps.setInt(5, spCT.getMaloai());

        int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
    } catch (SQLException e) {
        return false;
    }
}
}
