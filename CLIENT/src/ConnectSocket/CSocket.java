
package ConnectSocket;

import Controller.DAO_ClientList;
import Model.M_Nhanvien;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CSocket {
    private  Socket Client;
    private DAO_ClientList ClientList = new DAO_ClientList();
    public boolean Timer = false;
    public boolean StatusLogin = false;
    public boolean TableNV = false;
    

    private  void initializeSocket(){
        if(Client == null){
            Connect();
        }
    }
    
    
    public CSocket() {
        initializeSocket();

    }
        
// kết nối cổng 
    public void Connect()
    {
        try {
        Client = new Socket("192.168.1.253", 1234);
        Client.setReceiveBufferSize(16384);
        // Bắt đầu kết nối thành công
        
         // Tạo luồng lắng nghe dữ liệu từ server
        Thread receiveThread = new Thread(() -> {
                    // đưa hàm nhận dữ liệu
                    Receive(Client);   
        });
        receiveThread.start();
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi kết nối", "Lỗi", JOptionPane.WARNING_MESSAGE);
    }
    }
    
    // đóng kết nối 
     public void Close(Socket client)
    {
        try{
            client.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
     
//hiện tại để dùng cho client gửi username và password để server ktra 
    public void SendMess(String mess){
        try {
            // Sử dụng DataOutputStream thay vì ObjectOutputStream
            OutputStream outputStream = Client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outputStream);
            
            // Gửi dữ liệu dưới dạng UTF-8 để đảm bảo đọc đúng bởi server
            out.writeUTF(mess);
            out.flush();
            System.out.println("Thanh cong" + Client);

        } catch (Exception e) {
            e.printStackTrace(); // In thông báo lỗi hoặc ghi log

        }
    }
    
    
 // hàm nhận chuỗi thông tin từ server gửi qua
       public void Receive(Socket Account){
            DataInputStream in = null ;
        try {
            // Sử dụng DataInputStream để đọc dữ liệu từ client
            in = new DataInputStream(Account.getInputStream());
            
            
            while (Account.isConnected()) {
                // Đọc tin nhắn từ client
                String message = in.readUTF(); // message : thông tin nhận đc

                // Xử lý tin nhắn, ví dụ: in ra console
                String[] parts = message.split(":");
                if (parts.length > 1) {
                    // login:true/false : đây kết kiểm tra tài khoản đăng nhập đúng hay sai bên server trả về
                    if (parts [0].equals("Login")){
                        if(parts[1].equals("true")){
                            Timer = true;
                            StatusLogin = true;
                        }else{
                            Timer = true;
                            StatusLogin = false;
                        }
                    // Table:NV:....
                    }else if(parts [0].equals("Table")){ 
                        if(parts[1].equals("NV")){
                            List<M_Nhanvien> nv = convertStringToList(parts[2]);
                            ClientList.receiveAndStoreData(nv); // đưa list lưu DAO_ClientList
                            TableNV = true;
                            // list nhân viên
                        }
                    }
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
       
    private static List<M_Nhanvien> convertStringToList(String nvStrings) {
        List<M_Nhanvien> nhanviens = new ArrayList<>();
        String[] nvString = nvStrings.split("\n");
        for (String str : nvString) {
            M_Nhanvien nv = M_Nhanvien.fromString(str);
            if (nv != null) {
                nhanviens.add(nv);
            }
        }
        return nhanviens;
    }
}
