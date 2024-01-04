
package BLL;

import DTO.M_Client;
import java.util.ArrayList;
import javax.swing.JOptionPane;


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
        if(client.getStatus()== null){
                // Hiển thị hộp thoại với lựa chọn "Yes" hoặc "No"
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Bạn có khóa cho tài khoản này?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION
            );
            // Xử lý kết quả lựa chọn
            if (result == JOptionPane.YES_OPTION) {
                System.out.println("Bạn đã chọn Yes");
                status = new DAL.DAOclient().Status(client.getUsername(),"block");
            } else if (result == JOptionPane.NO_OPTION) status=true;
            else status=true;
        }else if(client.getStatus().equals("online")){
            JOptionPane.showMessageDialog(null, "Tài khoản đang sử dụng");
            status=true;
        }
        else{
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Bạn có muốn mở  khóa tài khoản này?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION
            );
            // Xử lý kết quả lựa chọn
            if (result == JOptionPane.YES_OPTION) {
                System.out.println("Bạn đã chọn Yes");
                status = new DAL.DAOclient().Status(client.getUsername(),"");
            } else if (result == JOptionPane.NO_OPTION)status=true;
            else status=true;
        }
        return status;
    }
      public M_Client SearchByUserName(String Username){
        M_Client result = null;
        for(M_Client cl:getListClients()){
            if(cl.getUsername().equals(Username)) result = cl;
        }
        return result;
    }
        
}
