
package ConnectSocket;

import Controler.DAOnv;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import View.Home;
import java.io.DataInputStream;
import Model.*;
import java.io.ObjectInputStream;

public class SVSocket {
    public List<M_Client> clientList;
    public List<Clients> ClientOnline;
    public ServerSocket server ;
    
    
    private int port;
    DefaultListModel modelList;
    
    private Home homeframe;
    //THÊM
    private DAOnv daonv;
    private ArrayList<Socket> listNV;
    
    
    public void setHomeFrame(Home homeFrame) {
        this.homeframe = homeFrame;
    }
    
    public SVSocket() {
        port = 7777;
        ClientOnline = new ArrayList<>();

        //thiếu  clientlist lấy danh sách client từ csdl
        
        daonv=new DAOnv();
        listNV=new ArrayList<>();
        Connect();
        
        while(true){
            try {
                Socket s= server.accept();
                listNV.add(s);
                executeNV(s);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
                    
                    System.out.println("chấp nhận 1 kết nối từ client");
                    
                    // ????????????????????????????????
//                    if (homeframe != null) {
//                        homeframe.updateListModel("Client đã kết nối");
//                    }
                    //////
                    
                    Clients client = new Clients(clientSocket, "Name");
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
    //////THÊM
    public M_Nhanvien receiveNV(Socket s){
        M_Nhanvien nv=null;
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            nv=(M_Nhanvien)ois.readObject(); //nhan nhan vien tu client
        } catch (Exception e) {
            System.err.println("Đã nhận được dữ liệu");
            e.printStackTrace();
        }
        return nv;
        
    }
    public void sendResult(String res){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(listNV.get(listNV.size()-1).getOutputStream());
            oos.writeObject(res);
        } catch (Exception e) {
            System.err.println("gui cho client that bai");
            e.printStackTrace();
        }
    }
    public void executeNV(Socket s){
        try {
            M_Nhanvien nv=receiveNV(s); //nhận bảng ghi
            if(daonv.AddNV(nv)){
                sendResult("OK");
                System.out.println("Success"); 
                
            }
            else{
                sendResult("Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
    
    
    
    // nhận username và password từ client
    public void ReceiveUP(Clients client){
//        try {
//        InputStream inputStream = client.getInputStream();
//        while (true) {
//            // Đọc markerData
//            byte[] markerData = new byte[6];
//            int bytesRead = inputStream.read(markerData);
//            
//            if (bytesRead != -1) {
//                String marker = new String(markerData, StandardCharsets.UTF_8);
//                
//                if (marker.equals("TEXT:")) {
//                    // Xử lý thông điệp văn bản
//                    byte[] textData = new byte[40];
//                    bytesRead = inputStream.read(textData);
//                    String message = new String(textData, StandardCharsets.UTF_8).trim();
//
//                    // Thực hiện xử lý thông điệp văn bản, ví dụ: cập nhật giao diện
//                    if (homeframe != null) {
//                        homeframe.updateListModel("Client: " + message + " đã kết nối");
//                    }
//                }
//            }
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
        DataInputStream in = null ;
        try {
            // Sử dụng DataInputStream để đọc dữ liệu từ client
            in = new DataInputStream(client.getSocket().getInputStream());

            while (client.getSocket().isConnected()) {
                // Đọc tin nhắn từ client
                String message = in.readUTF();
                
                
                

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
    
   
//            
//    // chuyển  obj thàng mảng
//       public byte[] serialize(Object obj) throws IOException {
//        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
//        objectStream.writeObject(obj);
//        objectStream.flush();
//        byte[] byteArray = byteStream.toByteArray();
//        objectStream.close();
//        byteStream.close();
//        return byteArray;
//    }
//    private byte[] serialize(DefaultTableModel dtm) throws IOException{
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(baos);
//        oos.writeObject(dtm);
//        oos.flush();
//        return baos.toByteArray();
//    }
//       //chuyển mảng thàng Obj
//    public Object Deserialization(byte[] data) {
//         try {
//            ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
//            ObjectInputStream objectStream = new ObjectInputStream(byteStream);
//            Object obj = objectStream.readObject();
//            objectStream.close();
//            byteStream.close();
//            return obj; // Trả về đối tượng sau khi phân giải ngược
//             
//         }catch(IOException| ClassNotFoundException e){
//            e.printStackTrace();
//            return null;            
//         }
//        }
//    
       
public void Close()
    {
        try{
            server.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
//    public void SendDATA(Socket client,DefaultTableModel dtm)
//    {
//        if(client != null){
//           try{
//               ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
//               out.writeObject(serialize(dtm));
//               out.flush();
//               
//           }catch(IOException e)
//           {
//               e.printStackTrace();
//           }
//        }
//    }
    public void SendMess(Socket client, String mess){
        if(client != null){
           try{
               ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
               out.writeObject(mess);
               out.flush();
               
           }catch(IOException e)
           {
               e.printStackTrace();
           }
        }
    }
    
    ////////ADD////////////
    public static void main(String[] args) {
        System.out.println("Server is running");
        new SVSocket();
    }
  
    
}
