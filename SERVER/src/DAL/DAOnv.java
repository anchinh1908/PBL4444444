
package DAL;
import DTO.M_DBconnect;
import DTO.M_Nhanvien;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DAOnv {
    public static void main(String[] args){
        M_DBconnect.loadConnection();
    }
    public ArrayList<M_Nhanvien> getListNV()
    {
        ArrayList<M_Nhanvien> list=new ArrayList<>();
        String sql="SELECT * FROM nhanvien";
        try{
            PreparedStatement ps=M_DBconnect.con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                M_Nhanvien n=new M_Nhanvien();
                n.setId(rs.getInt("ID"));
                n.setTennv(rs.getString("Hoten"));
                n.setChucvu(rs.getString("Chucvu"));
                String dateStr = rs.getString("Ngaysinh");
                SimpleDateFormat datefm = new SimpleDateFormat("yyyy-MM-dd");
                n.setDate(datefm.parse(dateStr));
                n.setGt(rs.getString("Gioitinh"));
                n.setDiachi(rs.getString("Diachi"));
                n.setEmail(rs.getString("Email"));
                n.setLuong(rs.getInt("Luong"));
                n.setStatus(rs.getString("Status"));
                list.add(n);                        
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    } 
   
    public boolean AddNV(M_Nhanvien n, String name){
        
        String sql="insert into nhanvien values(null,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,n.getTennv());
            ps.setString(2,n.getChucvu());
            ps.setObject(3,n.getDate());
            ps.setString(4,n.getGt());
            ps.setString(5,n.getDiachi());
            ps.setString(6, n.getEmail());
            ps.setInt(7, n.getLuong());
            ps.setString(8,"editable");
            int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    // Lấy giá trị ID đã được tự động tạo
                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int newId = generatedKeys.getInt(1);
                            n.setId(newId);
                            new DAL.DAO_log().addLogNV(name,"Insert",n.toString());
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
            e.printStackTrace();
            return false;
        }
    }
    public boolean DeleteNV(int id){
        String sql="delete from nhanvien where Id=?";
        try{
            PreparedStatement ps=M_DBconnect.con.prepareCall(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean updateNV(M_Nhanvien n) {
        System.out.println("DAL.DAOnv.updateNV()");
    String sql = "UPDATE nhanvien SET Hoten = ?,Chucvu = ?,Ngaysinh = ?,Gioitinh = ?, Diachi = ?,Email = ?, Luong = ?, Status = ? WHERE ID = ?;";

    try {
        PreparedStatement ps = M_DBconnect.con.prepareStatement(sql);
            ps.setString(1,n.getTennv());
            ps.setString(2,n.getChucvu());
            ps.setObject(3,n.getDate());
            ps.setString(4,n.getGt());
            ps.setString(5,n.getDiachi());
            ps.setString(6, n.getEmail());
            ps.setInt(7, n.getLuong());
            ps.setString(8, n.getStatus());
            ps.setInt(9, n.getId());
        int affectedRows = ps.executeUpdate();
            return affectedRows > 0;

    } catch (SQLException e) {
        return false;
    }
}
}
