
package DAL;

import DTO.M_Client;
import DTO.M_DBconnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAOclient {
    
   public static void main(String[] args){
        M_DBconnect.loadConnection();
    }
   
    public ArrayList<M_Client> getListClients(){
        M_DBconnect.loadConnection();
        ArrayList<M_Client> list = new ArrayList<>();
        String sql = "SELECT username,fullname,status FROM clients ";
        try{
            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                M_Client c =new M_Client();
                c.setFullname(rs.getString("fullname"));
                c.setUsername(rs.getString("username"));
                c.setStatus(rs.getString("status"));
                list.add(c);
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "loi "+e);}
        return list;
    }
        public boolean addClient(M_Client client) {
        String sql = "INSERT INTO clients (username, password, fullname, status) VALUES (?, ?, ?, null)";

        try {
            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getUsername());
            ps.setString(2, client.getPassword());
            ps.setString(3, client.getFullname());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                return true;
            } else {
                System.out.println("Thêm mới đối tượng không thành công1.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Thêm mới đối tượng không thành công2.");
            return false;
        }
    }

  
    public String CheckLogin(String u, String p){
        String b="false";// trả về nếu tài khoản không tồn tại
        try{
            String query="select username,fullname,password,status from clients where username='"+u+"' AND password='"+p+"' ";
            Statement st=M_DBconnect.con.createStatement();
            ResultSet rs=st.executeQuery(query);

            if(rs.next()){
                String bl = rs.getString("status");
                String name = rs.getString("fullname");
                if(bl==null){ 
                    b="true/"+name;// trả về null nếu tài khoản tồn tại và có thể đăng nhập
                }
                else if(bl.equals("online")){
                    b="falsebyIsUsing";// tài khoản đang sử dụng
                }else b="falsebyBlock";// tài khoản đã khóa
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,""+ e);
        }
        System.out.println("DAL.DAOclient.CheckLogin()" + b);
        return b;
    }
    public boolean CheckUsername(String u){
        boolean b=false;
        try{
            String query="select username from clients where username='"+u+"' ";
            Statement st=M_DBconnect.con.createStatement();
            ResultSet rs=st.executeQuery(query);

            if(rs.next()){
                b=true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,""+ e);
        }
        return b;
    }
    public boolean Status(String Username, String status){
            try {
                String query;

                if (status.equals("block")) {
                    query = "UPDATE clients SET status ='block' WHERE username = ?";
                } else if(status.equals("online")){
                    query = "UPDATE clients SET status = 'online' WHERE username = ?";
                } else {
                    query = "UPDATE clients SET status = null WHERE username = ?";
                }
              

                try (PreparedStatement preparedStatement = M_DBconnect.con.prepareStatement(query)) {
                    preparedStatement.setString(1, Username);
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } catch (SQLException e) {
                    System.out.println("Lỗi tại DAOClient Block" + e);
                    return false;
            }   

    }
    
}
