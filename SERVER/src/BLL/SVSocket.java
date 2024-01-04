package BLL;

import DAL.DAOclient;
import DTO.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SVSocket {

    public List<M_ClientSocket> ClientOnline;
    public ServerSocket server;
    private final int port;
    public DAOclient C_Client;
    public BLL_nhanvien bll_NV = new BLL_nhanvien();
    public BLL_sanpham bll_SP = new BLL_sanpham();
    public BLL_sanphamCT bll_CTSP = new BLL_sanphamCT();

    public boolean Modelclient = false;

    public boolean TableNV = false;
    public boolean TableSP = false;
    public boolean TableSPCT = false;
    public boolean TableClient = false;
    public boolean TableLog = false;
    public String StatusStr = null;

    public SVSocket() {
        port = 1234;
        ClientOnline = new ArrayList<>();
        Connect();
    }

    private void Connect() {
        try {
            // mở kết nối trên cổng port=1234
            server = new ServerSocket(port, 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // tạo luồng lắng nghe chấp nhận kết nối  
        Thread listenThread = new Thread(() -> {
            try {
                while (true) {
                    // khi 1 client kết nối đến thì chấp nhận  và tạo 1 luồng mới để nhận thông tin từ client đó 
                    Socket clientSocket = server.accept();
                    M_ClientSocket client = new M_ClientSocket(clientSocket) {
                        @Override
                        public void run() {
                            try {
                                while (this.getSocket().isConnected()) {
                                    String receivedData = this.ReceiveUP();
                                    HandleReceivedData(receivedData, this);
                                }
                            } catch (Exception e) {
                                
                                if (this.getUsername() != null) {
                                    // cập nhật trạng trái giao diện
                                    ClientOnline.remove(this);
                                    Modelclient = true;
                                    new DAOclient().Status(this.getUsername(), "");
                                    TableClient = true;
                                }
                                this.Close();
                            }
                        }
                    };
                    Thread receiveThread = new Thread(client);
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
    public void HandleReceivedData(String message, M_ClientSocket client) {

        System.out.println("BLL.SVSocket.HandleReceivedData()" + message);
        String[] parts = message.split(":");
        if (parts.length > 1) {
            if (parts[0].equals("Login")) {
                HandleLogin(client, parts[1]);
            } else if (parts[0].equals("Registration")) {
                HandleRegistration(client, parts[1]);
            } else if (parts[0].equals("ADD")) {
                HandleAddObj(parts[1] + ":" + parts[2] + ":" + parts[3]);
            } else if (parts[0].equals("DEL")) {
                HandleDelObj(parts[1] + ":" + parts[2] + ":" + parts[3]);
            } else if (parts[0].equals("EDIT")) {
                HandleEditObj(parts[1] + ":" + parts[2] + ":" + parts[3]);
            } else if (parts[0].equals("Obj_Is_Changing")) {
                HandleObj_Is_Changing(parts[1] + ":" + parts[2] + ":" + parts[3]);
            } else if (parts[0].equals("StopChange")) {
                HandleStopChange(parts[1] + ":" + parts[2] + ":" + parts[3]);
            }
        }

    }

    private void HandleLogin(M_ClientSocket client, String UserAndPass) {
        String[] credentials = UserAndPass.split(",");
        String Username = credentials[0];
        String Password = credentials[1];

        // gọi hàm check login ở DAOClient
        C_Client = new DAOclient();
        String result = C_Client.CheckLogin(Username, Password);
        if (result.contains("true")) {

            client.setUsername(Username);
            //tìm client trong dang sách đổi trạng thái Status
            ClientOnline.add(client); // Thêm client vào danh sách online
            C_Client.Status(client.getUsername(), "online");
            client.SendDATA("nhanvien", bll_NV.getListNV()); // lấy list từ csdl 
            client.SendDATA("ctsp", bll_CTSP.getListSPCT());
            client.SendDATA("sanpham", bll_SP.getListSP());
            client.SendMess("Login:" + result);
            TableClient = true;
            // cập nhật trạng trái giao diện
            Modelclient = true;
        } else if (result.equals("falsebyBlock")) {
            client.SendMess("Login:falsebyBlock");
        } else if (result.equals("falsebyIsUsing")) {
            client.SendMess("Login:falsebyIsUsing");
        } else {
            client.SendMess("Login:false");
        }
    }

    private void HandleRegistration(M_ClientSocket client, String infor)//+username +","+ password+","+ fullname
    {
        String[] credentials = infor.split(",");
        String Username = credentials[0];
        String Password = credentials[1];
        String Fullname = credentials[2];
        C_Client = new DAOclient();
        boolean result = C_Client.CheckUsername(Username);
        if (result) {

            client.SendMess("Registration:false");

        } else {
            M_Client Account = new M_Client(Username, Password, Fullname);
            if (C_Client.addClient(Account)) {
                client.SendMess("Registration:true");
                TableClient = true;
            } else {
                client.SendMess("Registration:false");
            }
        }

    }

    private void HandleAddObj(String mess) {
        System.out.println("BLL.SVSocket.HandleAddObj()");
        String[] parts = mess.split(":");
        // chưa mần xong cập nhật bảng
        if (parts[0].equals("NV")) {
            System.out.println(parts[1]);
            M_Nhanvien nv = convertStringToNhanVien(parts[1]);
            boolean i = bll_NV.AddNV(nv, parts[2]);
            TableNV = true;
            TableLog = true;
            sendAllClients("nhanvien", bll_NV.getListNV());
        } else if (parts[0].equals("SP")) {
            System.out.println(parts[1]);
            M_Sanpham sp = convertStringToSanPham(parts[1]);
            boolean i2 = bll_SP.AddSP(sp, parts[2]);
            TableSP = true;
            TableLog = true;
            sendAllClients("sanpham", bll_SP.getListSP());
        } else if (parts[0].equals("CTSP")) {
            System.out.println(parts[1]);
            M_SanphamCT spct = convertStringToSanPhamCT(parts[1]);
            boolean i3 = bll_CTSP.AddSPCT(spct, parts[2]);
            TableSPCT = true;
            TableLog = true;
            sendAllClients("ctsp", bll_CTSP.getListSPCT());

        }
    }

    private void HandleDelObj(String mess) {
        System.out.println("BLL.SVSocket.HandleDelObj()");
        String[] parts = mess.split(":");
        if (parts[0].equals("NV")) {
            bll_NV.DeleteNV(Integer.parseInt(parts[1]), parts[2]);
            TableNV = true;
            TableLog = true;
            sendAllClients("nhanvien", bll_NV.getListNV());
        } else if (parts[0].equals("SP")) {
            bll_SP.DeleteSP(Integer.parseInt(parts[1]), parts[2]);
            sendAllClients("sanpham", bll_SP.getListSP());
            TableSP = true;
            TableLog = true;
        } else if (parts[0].equals("CTSP")) {
            bll_CTSP.DeleteSPCT(Integer.parseInt(parts[1]), parts[2]);
            TableSPCT = true;
            TableLog = true;
            sendAllClients("ctsp", bll_CTSP.getListSPCT());
            sendAllClients("sanpham", bll_SP.getListSP());
        }
    }

    private void HandleEditObj(String mess) {
        String[] parts = mess.split(":");
        System.out.println("BLL.SVSocket.HandleEditObj()" + mess);
        // chưa mần xong cập nhật bảng
        if (parts[0].equals("NV")) {
            M_Nhanvien nv = convertStringToNhanVien(parts[1]);
            bll_NV.UpdateNV(nv, parts[2]);
            TableNV = true;
            TableLog = true;
            sendAllClients("nhanvien", bll_NV.getListNV());
        } else if (parts[0].equals("SP")) {
            M_Sanpham sp = convertStringToSanPham(parts[1]);
            bll_SP.UpdateSP(sp, parts[2]);
            TableSP = true;
            TableLog = true;
            sendAllClients("sanpham", bll_SP.getListSP());
        } else if (parts[0].equals("CTSP")) {
            M_SanphamCT spct = convertStringToSanPhamCT(parts[1]);
            bll_CTSP.UpdateSPCT(spct, parts[2]);
            TableSPCT = true;
            TableSP = true;
            TableLog = true;
            sendAllClients("ctsp", bll_CTSP.getListSPCT());
            sendAllClients("sanpham", bll_SP.getListSP());

        }
    }

    private void HandleObj_Is_Changing(String mess) {
        System.out.println("BLL.SVSocket.HandleObj_Is_Changing()");
        String[] parts = mess.split(":");
        String fullname = new BLL_Client().SearchByUserName(parts[2]).getFullname();
        if (parts[0].equals("NV")) {
            bll_NV.ChangeStatusFalse(Integer.parseInt(parts[1]), fullname);
            System.out.println("BLL.SVSocket.HandleObj_Is_Changing()==>ChangeStatusFalse");
        }
        if (parts[0].equals("SP")) {
            bll_SP.ChangeStatusFalse(Integer.parseInt(parts[1]), fullname);
            System.out.println("BLL.SVSocket.HandleObjSP_Is_Changing()==>ChangeStatusFalse");
        }
        if (parts[0].equals("SPCT")) {
            bll_CTSP.ChangeStatusFalse(Integer.parseInt(parts[1]), fullname);
            System.out.println("BLL.SVSocket.HandleObjSPCT_Is_Changing()==>ChangeStatusFalse");
        }
        for (M_ClientSocket client : ClientOnline) {
            if (!client.equals(null)) {
                if (!client.getUsername().equals(parts[2])) {
                    client.SendMess("Obj_Is_Changing:" + parts[0] + ":" + parts[1] + ":" + fullname);// Obj_Is_Changing:tableName:ID
                    System.out.println("Gui cho Clien: " + client.getUsername());
                } else {
                    System.out.println("Không cho Clien: " + client.getUsername());
                }
            }
        }
    }

    private void HandleStopChange(String mess) { // nhận khi client chọn cập nhật hoặc không StopChange:NV:ID:Username
        System.out.println("BLL.SVSocket.HandleStopChange()" + mess);
        String[] parts = mess.split(":");

        if (parts[0].equals("NV")) {
            bll_NV.ChangeStatusTrue(Integer.parseInt(parts[1]), parts[2]);
            System.out.println("BLL.SVSocket.HandleObjSP_Is_Changing()==>ChangeStatusTrue");
        }
        if (parts[0].equals("SP")) {
            bll_SP.ChangeStatusTrue(Integer.parseInt(parts[1]), parts[2]);
            System.out.println("BLL.SVSocket.HandleObjSP_Is_Changing()==>ChangeStatusTrue");
        }
        if (parts[0].equals("SPCT")) {
            bll_CTSP.ChangeStatusTrue(Integer.parseInt(parts[1]), parts[2]);
            System.out.println("BLL.SVSocket.HandleObjSP_Is_Changing()==>ChangeStatusTrue");
        }
        for (M_ClientSocket client : ClientOnline) {
            if (!client.equals(null)) {

                client.SendMess("StopChange:" + parts[0] + ":" + parts[1]);// StopChange:tableName:ID
                System.out.println("Gui cho Clien: " + client.getUsername());

            }
        }
    }

    public void Close() {
        try {
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendAllClients(String nameTable, ArrayList List) {
        for (M_ClientSocket client : ClientOnline) {
            if (!client.equals(null)) {
                client.SendDATA(nameTable, List);
                System.out.println("Gui cho Clien: " + client.getUsername());
            }
        }
    }

    private static M_Nhanvien convertStringToNhanVien(String nvString) {
        M_Nhanvien nv = M_Nhanvien.fromString(nvString);
        return nv;
    }

    private static M_Sanpham convertStringToSanPham(String spString) {
        M_Sanpham sp = M_Sanpham.fromString(spString);
        return sp;
    }

    private static M_SanphamCT convertStringToSanPhamCT(String spctString) {
        M_SanphamCT sp = M_SanphamCT.fromString(spctString);
        return sp;
    }
}
