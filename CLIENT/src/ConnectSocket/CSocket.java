
package ConnectSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import Model.M_Nhanvien;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
//////////CLIENT///////////

public class CSocket {
    private Socket soc;
    private Clients account;
    public CSocket() {
        //Connect();
//        onlineList = new ArrayList<>();

    }
        
    // kết nối cổng  
    public void Connect()
    {
        try { //mở kết nối
        soc = new Socket("localhost", 7777);
        
       // soc.setReceiveBufferSize(16384);
        // Bắt đầu kết nối thành công
        
       account = new Clients( soc, "MyName");
        
        // Tạo luồng lắng nghe dữ liệu từ server
        Thread listenThread = new Thread(() -> {
            // đưa hàm nhận dữ liệu
            ReceiveUP(account);
        });
        listenThread.setDaemon(true);
        listenThread.start();
    } catch (UnknownHostException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi kết nối", "Lỗi", JOptionPane.WARNING_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi kết nối", "Lỗi", JOptionPane.WARNING_MESSAGE);
    }
    }
    
    // đóng kết nối 
    public void Close(){
        try{
            soc.close();
        }catch(IOException ex){
            ex.printStackTrace();
            }
    }
    public void SendMess(String mess){
        try {
            // Sử dụng DataOutputStream thay vì ObjectOutputStream
            OutputStream outputStream = soc.getOutputStream();
            DataOutputStream out = new DataOutputStream(outputStream);
            
            // Gửi dữ liệu dưới dạng UTF-8 để đảm bảo đọc đúng bởi server
            out.writeUTF(mess);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace(); // In thông báo lỗi hoặc ghi log

        }
    }
    
    
       public void ReceiveUP(Clients account){

        DataInputStream in = null ;
        try {
            // Sử dụng DataInputStream để đọc dữ liệu từ client
            in = new DataInputStream(account.getSocket().getInputStream());

            while (account.getSocket().isConnected()) {
                // Đọc tin nhắn từ client
                String message = in.readUTF();

                // Xử lý tin nhắn, ví dụ: in ra console
                if (message.equals("LoginOk")) {
                //xử lý login thành công
                }else{
                    // hiện thông báo và nhập lại
                    
                }

                // Thực hiện xử lý thông điệp theo nhu cầu của bạn
            }
        } catch (IOException e) {
            e.printStackTrace(); // In thông báo lỗi hoặc ghi log
        } finally {
            // Close resources when the client disconnects
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
    }
    }
       /////////////TEST//////////
       
       //hàm gửi nhân viên
       public void sendEmployee(M_Nhanvien nv){
           try {
            ObjectOutputStream oos=new ObjectOutputStream(soc.getOutputStream());
            oos.writeObject(nv); //gui nhan vien sang Server
               
           } catch (Exception e) {
               e.printStackTrace();
           }           
       }       
       public String getResult(){
        String res="";
        try {
            ObjectInputStream ois=new ObjectInputStream(soc.getInputStream());
            res=(String)ois.readObject(); //nhan thong diep "Success" or "Failed"
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
       
}
               
               
               
               
               
               
               
               
    