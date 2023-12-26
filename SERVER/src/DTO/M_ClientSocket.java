
package DTO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class M_ClientSocket implements Runnable{
    Socket socket;
    String username;
    DataInputStream input;
    DataOutputStream output;
//    boolean isLogin;

    public M_ClientSocket(Socket socket) {
        try {
            this.socket = socket;
            this.input = new DataInputStream(socket.getInputStream());
            this.output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DataInputStream getInput() {
        return input;
    }

    public void setInput(DataInputStream input) {
        this.input = input;
    }

    public DataOutputStream getOutput() {
        return output;
    }

    public void setOutput(DataOutputStream output) {
        this.output = output;
    }
    
    @Override
    public void run(){
    };
    
    public void Close() {
        try {
            input.close();
            output.close();
            socket.close();   
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public String ReceiveUP() throws IOException {
        String receivedData = input.readUTF();
        return receivedData;
    }
    public void SendMess(String message){
        try {
            output.writeUTF(message);
            output.flush();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void SendDATA(String nameTable,ArrayList List)
    { 
        try{
            String DataString = convertListToString(nameTable, List);
            if(nameTable == "nhanvien"){
                output.writeUTF("Table:NV:"+DataString);
                output.flush();
//                System.out.println("DTO.M_ClientSocket.SendDATA() : "+"Table:NV:"+DataString);
            }else if(nameTable == "sanpham"){
                output.writeUTF("Table:SP:"+DataString);
                output.flush(); 
//                System.out.println("DTO.M_ClientSocket.SendDATA() : "+"Table:SP:"+DataString);
            }else if(nameTable == "ctsp"){
                output.writeUTF("Table:CTSP:"+DataString);
                output.flush();
//                System.out.println("DTO.M_ClientSocket.SendDATA() : "+"Table:CTSP:"+DataString);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
            
     private static String convertListToString(String nameTable,List list) {
            StringBuilder stringBuilder = new StringBuilder();
                if(nameTable == "nhanvien"){
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
      

}
