/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectSocket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import java.io.DataInputStream;
import Model.*;
import Controler.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class SVSocket {
    public List<M_Client> clientList;
    public List<Clients> ClientOnline;
    public ServerSocket server ;
    private int port;
    public boolean ModelStatus = false;    
    public boolean Modelclient = false;
    public String StatusStr = null;
    public String ClientStr = null;
    public DAOclient C_Client;
    public DAOnv C_nv = new DAOnv();
    
    
    public SVSocket() {
        port = 1234;
        ClientOnline = new ArrayList<>();
        Connect();
    }
    
    private void Connect() {
        try{ 
            // mở kết nối trên cổng port=1234
            server = new ServerSocket(port, 100);
                
        }catch(Exception e){
            e.printStackTrace();
        }
        // tạo luồng mới khi 1 client kết nối đến 
       Thread listenThread = new Thread(() -> {
            try {
                while (true/*đặt đk server đang mở*/) {
                    Socket clientSocket = server.accept(); // Chấp nhận kết nối từ client\
                    
                    // cập nhật trạng thái hiển thị lên list
                    ModelStatus = true;
                    StatusStr = "chấp nhận 1 kết nối từ client";
                    
                    
                    Clients client = new Clients(clientSocket, "Name");
                    System.out.println(client.getSocket().toString());

                    ClientOnline.add(client); // Thêm client vào danh sách

                    // Tạo luồng nhận thông tin từ client
                    Thread receiveThread = new Thread(() -> {
                        ReceiveUP(client);
                    });
                    //receiveThread.setDaemon(true);
                    receiveThread.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        listenThread.setDaemon(true);
        listenThread.start();
    }
    
    
    
    
    // nhận username và password từ client
    public void ReceiveUP(Clients client){

            DataInputStream in = null ;

        try {
            // Sử dụng DataInputStream để đọc dữ liệu từ client
            in = new DataInputStream(client.getSocket().getInputStream());

            while (client.getSocket().isConnected()) {
                // Đọc tin nhắn từ client
                String message = in.readUTF();

                // Xử lý tin nhắn, ví dụ: in ra console
                
                //Login:username,pasword
                String[] parts = message.split(":");
                if (parts.length > 1) {
                    if (parts [0].equals("Login")){
                        String UserAndPass = parts[1];// parts[1]: username,pasword
                        String[] credentials  = UserAndPass.split(",");
                        String Username = credentials[0];
                        String Password = credentials[1];
                        
                        // gọi hàm check login ở DAOClient
                        C_Client = new DAOclient();
                        if(C_Client.CheckLogin(Username, Password)){
                           SendDATA(client,"nhanvien", C_nv.getListNV()); // lấy list từ csdl 
                           SendMess(client, "Login:true");
                           client.setUsername(Username);
                            ModelStatus = true;
                            Modelclient = true;
                            StatusStr =  Username+ ": đã đăng nhập";
                            ClientStr = Username;
                        }else{ 
                           SendMess(client, "Login:false");
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
    
    // nhận từ client
//    public void Receive(Socket cSoc) throws IOException, SQLException, ClassNotFoundException
//    {
//    try {
//        while (true) {
//            
//        // Đọc dữ liệu đầu tiên từ máy khách
//        byte[] markerData = new byte[6];
//        int bytesRead = cSoc.getInputStream().read(markerData);
//
//        if (bytesRead != -1) {
//            String marker = new String(markerData, 0, bytesRead);
//            
//            // Xác định kiểu dữ liệu
//            if (marker.equals("DATA: ")) {
//                // Khởi tạo mảng byte để nhận dữ liệu
//                byte[] data = new byte[2000 * 2000];
//                cSoc.getInputStream().read(data);
//
//                // Chuyển data từ dạng byte sang dạng đối tượng
//                Object receivedObject = Deserialization(data);
//
//                if (receivedObject instanceof List<?>) {
//                    List<?> dataList = (List<?>) receivedObject;
//
//                    for (Object rowObject : dataList) {
//                        if (rowObject instanceof List<?>) {
//                            List<?> row = (List<?>) rowObject;
//
//                            if (row.get(0).toString().equals("add")) {
//                                M_Nhanvien nv=new M_Nhanvien();
//                                nv.setManv(row.get(1).toString());
//                                nv.setTennv(row.get(2).toString());
//                                nv.setChucvu(row.get(3).toString());
//                                //date
//                                String dateString = row.get(4).toString();
//    //                            nv.setDate(Date.(row.get(4).toString()));
//                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Điều chỉnh định dạng phù hợp
//                                Date date = null;
//                                try {
//                                    date = dateFormat.parse(dateString);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                                // Kiểm tra nếu date đã được khởi tạo thành công trước khi sử dụng
//                                if (date != null) {
//                                    // Sử dụng date trong logic của bạn
//                                    nv.setDate(date);
//                                } else {
//                                    // Xử lý khi có lỗi chuyển đổi
//                                    System.out.println("Lỗi chuyển đổi chuỗi thành Date.");
//                                }
//                                //
//                                nv.setGt(row.get(4).toString());
//                                nv.setDiachi(row.get(6).toString());
//                                nv.setEmail(row.get(3).toString());
//                                nv.setLuong(Integer.parseInt(row.get(6).toString()));
//                                // Thực hiện lưu trữ dữ liệu vào cơ sở dữ liệu của bạn
//                                // ...
//
//                            } else if (row.get(0).toString().equals("edit")) {
//                                M_Nhanvien nv=new M_Nhanvien();
//                                nv.setManv(row.get(1).toString());
//                                nv.setTennv(row.get(2).toString());
//                                nv.setChucvu(row.get(3).toString());
//                                //date
//                                String dateString = row.get(4).toString();
//    //                            nv.setDate(Date.(row.get(4).toString()));
//                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Điều chỉnh định dạng phù hợp
//                                Date date = null;
//                                try {
//                                    date = dateFormat.parse(dateString);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                                // Kiểm tra nếu date đã được khởi tạo thành công trước khi sử dụng
//                                if (date != null) {
//                                    // Sử dụng date trong logic của bạn
//                                    nv.setDate(date);
//                                } else {
//                                    // Xử lý khi có lỗi chuyển đổi
//                                    System.out.println("Lỗi chuyển đổi chuỗi thành Date.");
//                                }
//                                //
//                                nv.setGt(row.get(4).toString());
//                                nv.setDiachi(row.get(6).toString());
//                                nv.setEmail(row.get(3).toString());
//                                nv.setLuong(Integer.parseInt(row.get(6).toString()));
//                                // Thực hiện cập nhật dữ liệu trong cơ sở dữ liệu của bạn
//                                // ...
//
//                            } else if (row.get(0).toString().equals("delete")) {
//                                String masv = row.get(1).toString();
//
//                                // Thực hiện xóa dữ liệu trong cơ sở dữ liệu của bạn
//                                // ...
//                            }
//                        }
//                    }
//            
//                }
//            }else if (marker.equals("TEXT: ")) {
//                // Xử lý thông điệp văn bản
//                byte[] textData = new byte[20];
//                bytesRead = cSoc.getInputStream().read(textData);
//                String message = new String(textData, 6, bytesRead);
//                if (homeframe != null) {
//                       homeframe.updateListModel("Client: "+ message + "đã kết nối");
//                    }
//                
//            }
//            }
//        else{System.out.println("ConnectSocket.SVSocket.Receive()");}
//        }
//     
//    }catch (Exception e) {
//        clientList.remove(cSoc);
//        try {
//            cSoc.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//    }

       
public void Close()
    {
        try{
            server.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void SendDATA(Clients client,String nameTable,ArrayList List)
    { 
        if(client != null){
           try{
               DataOutputStream out = new DataOutputStream(client.socket.getOutputStream());
               String DataString = convertListToString(nameTable, List);
               if(nameTable == "nhanvien"){
                    out.writeUTF("Table:NV:"+DataString);
                    out.flush();
               }else if(nameTable == "sanpham"){
                    out.writeUTF("Table:SP:"+DataString);
                    out.flush(); 
               }else if(nameTable == "ctsp"){
                    out.writeUTF("Table:CTSP:"+DataString);
                    out.flush();
               }
               System.out.println("Gửi lại client thành công: \n" + DataString);
           }catch(IOException e)
           {
               e.printStackTrace();
           }
        }
    }
        private static String convertListToString(String nameTable,List list) {
            StringBuilder stringBuilder = new StringBuilder();
                if(nameTable == "nhanvien"){
                    
                    System.out.println("ConnectSocket.SVSocket.convertListToString()");
                    for (M_Nhanvien nv : (List<M_Nhanvien>) list) {
                        stringBuilder.append(nv.toString()).append("\n");
                    }
               }else if("sanpham".equals(nameTable) && !list.isEmpty()){
                    for (M_Sanpham sp : (List<M_Sanpham>) list) {
                        stringBuilder.append(sp.toString()).append("\n");
                    }
               }else if("ctsp".equals(nameTable) && !list.isEmpty()){
                    for (M_SanphamCT ctsp : (List<M_SanphamCT>) list) {
                        stringBuilder.append(ctsp.toString()).append("\n");
                    }
               }
                // Xóa dấu phẩy cuối cùng nếu có
                if (stringBuilder.length() > 0) {
                    stringBuilder.setLength(stringBuilder.length() - 1);
                }
            return stringBuilder.toString();
    }
        
        
    public void SendMess(Clients client, String mess){
        if(client != null){
           try{
               DataOutputStream out = new DataOutputStream(client.socket.getOutputStream());
               out.writeUTF(mess);
               out.flush();
               
           }catch(IOException e)
           {
               e.printStackTrace();
           }
        }
    }

    
}
