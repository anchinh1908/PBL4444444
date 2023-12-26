/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.M_Client;
import DTO.M_DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
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
        String sql = "SELECT * FROM client ";
        try{
            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                M_Client c =new M_Client();
                c.setID(rs.getInt("id"));
                c.setUsername(rs.getString("username"));
                c.setPassword(rs.getString("password"));
                c.setBlock(rs.getString("block"));
                list.add(c);
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "loi "+e);}
        return list;
    }
    public String CheckLogin(String u, String p){
        String b="false";
        try{
            String query="select username,password,block from client where username='"+u+"' AND password='"+p+"' ";
            Statement st=M_DBconnect.con.createStatement();
            ResultSet rs=st.executeQuery(query);

            if(rs.next()){
                String bl = rs.getString("block");
                if(bl==null){
                    b="true";
                }
                else b="falsebyBlock";
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,""+ e);
        }
        return b;
    }
    public boolean Block(M_Client client){
            try {
                String query;

                if (client.getBlock() == null) {
                    query = "UPDATE client SET block ='X' WHERE id = ?";
                } else {
                    query = "UPDATE client SET block = null WHERE id = ?";
                }

                try (PreparedStatement preparedStatement = M_DBconnect.con.prepareStatement(query)) {
                    preparedStatement.setInt(1, client.getID());
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
