
package BLL;

import DTO.M_Nhanvien;
import DTO.M_Sanpham;
import DTO.M_SanphamCT;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CSocket {
    String Username;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    private  Socket Client;
    private BLL_nhanvien bllNV ;
    private BLL_sanpham bllSP;
    private BLL_sanphamCt bllSPCT;
    
    public boolean Login = false;   
    public boolean Main = false;
    
    
    public String StatusLogin ;
    public boolean TableNV = false;
    public boolean TableSP = false;
    public boolean TableSPCT = false;

    private  void initializeSocket(){
        if(Client == null){
            Connect();
            bllNV = new BLL_nhanvien();
            bllSP = new BLL_sanpham();
            bllSPCT = new BLL_sanphamCt();
        }
    }
    
    
    public CSocket() {
        initializeSocket();
    }
        
// kết nối cổng 
    public void Connect()
    {
        try {
        Client = new Socket("localhost", 1234);
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
     
///hiện tại để dùng cho client gửi username và password để server ktra 
    public void SendMess(String mess){
        try {
            // Sử dụng DataOutputStream thay vì ObjectOutputStream
            OutputStream outputStream = Client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outputStream);
            
            // Gửi dữ liệu dưới dạng UTF-8 để đảm bảo đọc đúng bởi server
            out.writeUTF(mess+":"+getUsername());
            out.flush();
            System.out.println("Đã gửi:" + mess);

        } catch (Exception e) {
            e.printStackTrace(); // In thông báo lỗi hoặc ghi log

        }
    }
    
    
 // hàm nhận chuỗi thông tin từ server gửi qua
       public void Receive(Socket Account){
            DataInputStream in = null ;
        try {

            while (Account.isConnected()) {
                // Đọc tin nhắn từ client
                // Sử dụng DataInputStream để đọc dữ liệu từ client
                in = new DataInputStream(Account.getInputStream());
                String message = in.readUTF(); // message : thông tin nhận đc
                System.out.println("Server gửi: "+message);
                // Xử lý tin nhắn, ví dụ: in ra console
                String[] parts = message.split(":");
                if (parts.length > 1) {
                    // login:true/false : đây kết kiểm tra tài khoản đăng nhập đúng hay sai bên server trả về
                    if (parts [0].equals("Login")){
                        if(parts[1].equals("true")){
                            Login = true;
                            StatusLogin = "true";
                        }else if(parts[1].equals("falsebyBlock"))
                        {
                            Login = true;
                            StatusLogin = "falsebyBlock";
                        }
                        else{
                            Login = true;
                            StatusLogin = "false";
                        }
                    // Table:NV:....
                    }else if(parts [0].equals("Table")){ 
                        if(parts[1].equals("NV")){
                            List<M_Nhanvien> nv = convertStringToList(parts[1],parts[2]);
                            bllNV.receiveAndStoreData(nv); 
                            Main= true;
                            TableNV = true;
                            // list nhân viên
                        }
                        else if(parts[1].equals("SP")){
                            List<M_Sanpham> sp = convertStringToList(parts[1],parts[2]);
                            bllSP.receiveAndStoreData(sp); 
                            Main= true;
                            TableSP = true;
                            // list san pham
                        }
                        else if(parts[1].equals("CTSP")){
                            List<M_SanphamCT> spct = convertStringToList(parts[1],parts[2]);
                            bllSPCT.receiveAndStoreData(spct); 
                            Main= true;
                            TableSPCT = true;
                            // list san pham
                        }
                    }else if(parts[0].equals("Obj_Is_Changing")){
                        if(parts[1].equals("NV")){
                            bllNV.ChangeStatusFalse(Integer.parseInt(parts[2]));
                        }if(parts[1].equals("SP")){
                            bllSP.ChangeStatusFalse(Integer.parseInt(parts[2]));
                        }if(parts[1].equals("SPCT")){
                            bllSPCT.ChangeStatusFalse(Integer.parseInt(parts[2]));
                        }
                    }else if(parts [0].equals("StopChange")){
                        if(parts[1].equals("NV")){
                            bllNV.ChangeStatusTrue(Integer.parseInt(parts[2]));
                        }if(parts[1].equals("SP")){
                            bllSP.ChangeStatusTrue(Integer.parseInt(parts[2]));
                        }if(parts[1].equals("SPCT")){
                            bllSPCT.ChangeStatusTrue(Integer.parseInt(parts[2]));
                        }
                    }
                } 

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
       
    private static List convertStringToList(String nameTable,String ObjStrings) {
        List List = new ArrayList<>();
        if(nameTable.equals("NV")){
            String[] nvString = ObjStrings.split("\n");
            for (String str : nvString) {
                M_Nhanvien nv = M_Nhanvien.fromString(str);
                if (nv != null) {
                    List.add(nv);
                }
            }
        }
        else if (nameTable.equals("SP")){
            String[] spString = ObjStrings.split("\n");
            for (String str : spString) {
                M_Sanpham sp = M_Sanpham.fromString(str);
                if (sp != null) {
                    List.add(sp);
                }
            }
        }
        else if (nameTable.equals("CTSP")){
            String[] spctString = ObjStrings.split("\n");
            for (String str : spctString) {
                M_SanphamCT spct = M_SanphamCT.fromString(str);
                if (spct != null) {
                    List.add(spct);
                }
            }
        }
        return List;
    }
}
