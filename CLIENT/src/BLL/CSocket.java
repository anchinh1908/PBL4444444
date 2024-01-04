package BLL;

import DTO.M_Nhanvien;
import DTO.M_Sanpham;
import DTO.M_SanphamCT;
import java.awt.Frame;
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
    String Fullname;
    

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    private Socket Client;
    private BLL_nhanvien bllNV;
    private BLL_sanpham bllSP;
    private BLL_sanphamCt bllSPCT;
    DataInputStream in = null;
    DataOutputStream out = null;

    public boolean Login = false;
    public boolean Main = false;

    public String StatusLogin;
    public boolean TableNV = false;
    public boolean TableSP = false;
    public boolean TableSPCT = false;

    public boolean Connected = true;
    private void initializeSocket() {
        if (Client == null) {
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
    public void Connect() {
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
            
        }
    }
     // Hàm kiểm tra trạng thái client
    public boolean isClientClosed() {
        return Client == null || Client.isClosed();
    }
    // đóng kết nối 
    public void Close() {
        try {
            
            if (in != null) {
                in.close();
                System.out.println("BLL.CSocket.Close() Input" + in);
            }
            if (out != null) {
                out.close();
                System.out.println("BLL.CSocket.Close() Output" +out);
            }
            if(!isClientClosed()){
                Client.close();
                System.out.println("BLL.CSocket.Close() soc" + Client);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

///hiện tại để dùng cho client gửi username và password để server ktra 
    public void SendMess(String mess) {
        try {
            // Sử dụng DataOutputStream thay vì ObjectOutputStream
            OutputStream outputStream = Client.getOutputStream();
            out = new DataOutputStream(outputStream);

            // Gửi dữ liệu dưới dạng UTF-8 để đảm bảo đọc đúng bởi server
            out.writeUTF(mess + ":" + getUsername());
            out.flush();
            System.out.println("Đã gửi:" + mess);

        } catch (Exception e) {
            e.printStackTrace(); // In thông báo lỗi hoặc ghi log

        }
    }

    // hàm nhận chuỗi thông tin từ server gửi qua
    public void Receive(Socket Account) {
        in = null;
        try {
            while (Account.isConnected()) {
                in = new DataInputStream(Account.getInputStream());
                String message = in.readUTF(); // message : thông tin nhận đc
                System.out.println("Server đã gửi => ");
                // Xử lý tin nhắn, ví dụ: in ra console
                String[] parts = message.split(":");
                if (parts.length > 1) {

                    // login:true/false : đây kết kiểm tra tài khoản đăng nhập đúng hay sai bên server trả về
                    if (parts[0].equals("Login")) {
                        HandleLogin(parts[1]);

                        // Table:NV:....
                    } else if (parts[0].equals("Registration")) {
                        HandleRegistration(parts[1]);
                    } else if (parts[0].equals("Table")) {
                        HandleData(parts[1] + ":" + parts[2]);

                    } else if (parts[0].equals("Obj_Is_Changing")) {
                        HandObj_Is_Changing(parts[1] + ":" + parts[2] + ":" + parts[3]);

                    } else if (parts[0].equals("StopChange")) {
                        HandleStopChange(parts[1] + ":" + parts[2]);
                    }
                }

            }
        } catch (IOException e) {
                e.printStackTrace();
        } 
        finally{
            Close();
                JOptionPane.showMessageDialog(null, "Server không hoạt động", "", JOptionPane.DEFAULT_OPTION);
                Connected = false;
        }
    }

    private void HandleLogin(String result) {
        System.out.println("BLL.CSocket.HandleLogin()" + result);
        if (result.contains("true")) {
            String[] parts = result.split("/");
            setFullname(parts[1]);
            Login = true;
            StatusLogin = "true";
        } else if (result.equals("falsebyBlock")) {
            Login = true;
            StatusLogin = "falsebyBlock";
        }else if(result.equals("falsebyIsUsing")){
            Login = true;
            StatusLogin = "falsebyIsUsing";
        }
        else {
            Login = true;
            StatusLogin = "false";
        }
    }

    private void HandleRegistration(String result) {
        if (result.equals("true")) {
            JOptionPane.showMessageDialog(null, "Đăng ký thành công", "", JOptionPane.DEFAULT_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại", "", JOptionPane.DEFAULT_OPTION);
        }
    }

    private void HandleData(String DataStr) {
        String[] parts = DataStr.split(":");
        if (parts[0].equals("NV")) {
            List<M_Nhanvien> nv = convertStringToList(parts[0], parts[1]);
            bllNV.receiveAndStoreData(nv);
            Main = true;
            TableNV = true;
            // list nhân viên
        } else if (parts[0].equals("SP")) {
            List<M_Sanpham> sp = convertStringToList(parts[0], parts[1]);
            bllSP.receiveAndStoreData(sp);
            Main = true;
            TableSP = true;
            // list san pham
        } else if (parts[0].equals("CTSP")) {
            List<M_SanphamCT> spct = convertStringToList(parts[0], parts[1]);
            bllSPCT.receiveAndStoreData(spct);
            Main = true;
            TableSPCT = true;
            TableSP = true;
            // list san pham
        }
    }

    private void HandObj_Is_Changing(String string) {
        String[] parts = string.split(":");
        if (parts[0].equals("NV")) {
            bllNV.ChangeStatusFalse(Integer.parseInt(parts[1]), parts[2]);
            Main = true;
            TableNV = true;
        }
        if (parts[0].equals("SP")) {
            bllSP.ChangeStatusFalse(Integer.parseInt(parts[1]), parts[2]);
            Main = true;
            TableSP = true;
        }
        if (parts[0].equals("SPCT")) {
            bllSPCT.ChangeStatusFalse(Integer.parseInt(parts[1]), parts[2]);
            Main = true;
            TableSPCT = true;
        }
    }

    private void HandleStopChange(String string) {
        String[] parts = string.split(":");
        if (parts[0].equals("NV")) {
            bllNV.ChangeStatusTrue(Integer.parseInt(parts[1]));
            Main = true;
            TableNV = true;
        }
        if (parts[0].equals("SP")) {
            bllSP.ChangeStatusTrue(Integer.parseInt(parts[1]));
            Main = true;
            TableSP = true;
        }
        if (parts[0].equals("SPCT")) {
            bllSPCT.ChangeStatusTrue(Integer.parseInt(parts[1]));
            Main = true;
            TableSPCT = true;
        }
    }

    private static List convertStringToList(String nameTable, String ObjStrings) {
        List List = new ArrayList<>();
        if (nameTable.equals("NV")) {
            String[] nvString = ObjStrings.split("\n");
            for (String str : nvString) {
                M_Nhanvien nv = M_Nhanvien.fromString(str);
                if (nv != null) {
                    List.add(nv);
                }
            }
        } else if (nameTable.equals("SP")) {
            String[] spString = ObjStrings.split("\n");
            for (String str : spString) {
                M_Sanpham sp = M_Sanpham.fromString(str);
                if (sp != null) {
                    List.add(sp);
                }
            }
        } else if (nameTable.equals("CTSP")) {
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
