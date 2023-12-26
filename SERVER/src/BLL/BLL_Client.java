/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.M_Client;
import DTO.M_DBconnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class BLL_Client {
    
    public ArrayList<M_Client> getListClients(){
        return new DAL.DAOclient().getListClients()
                ;
    }
    public String CheckLogin(String u, String p){
        return new DAL.DAOclient().CheckLogin(u, p);
    }
   public ArrayList<M_Client> searchClientByUN(String name) {
    ArrayList<M_Client> clientList = getListClients();
    ArrayList<M_Client> result = new ArrayList<>();

    for (M_Client cl : clientList) {
        if (cl.getUsername().contains(name)) {
            result.add(cl);
        }
    }
    return result;
}
    public boolean Block (M_Client client){
        boolean status = false;
        if(client.getBlock() != null){
                // Hiển thị hộp thoại với lựa chọn "Yes" hoặc "No"
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Bạn có muốn mở khóa cho tài khoản này?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION
            );
            // Xử lý kết quả lựa chọn
            if (result == JOptionPane.YES_OPTION) {
                System.out.println("Bạn đã chọn Yes");
                status = new DAL.DAOclient().Block(client);
            } else if (result == JOptionPane.NO_OPTION) status=true;
            else status=true;
        }else{
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Bạn có muốn khóa tài khoản này?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION
            );
            // Xử lý kết quả lựa chọn
            if (result == JOptionPane.YES_OPTION) {
                System.out.println("Bạn đã chọn Yes");
                status = new DAL.DAOclient().Block(client);
            } else if (result == JOptionPane.NO_OPTION)status=true;
            else status=true;
        }
        return status;
    }
}
