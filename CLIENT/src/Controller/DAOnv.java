
package Controller;
import ConnectSocket.CSocket;
import Model.M_Nhanvien;

public class DAOnv {
    private CSocket soc = new CSocket();
    public DAOnv() {
    }
    
   public void addNV(M_Nhanvien nv){
       String nvStr = nv.toString();
       if (soc != null ){
            soc.SendMess("ADD:NV:"+nvStr);
       }
       else{
           System.out.println("Controller.DAOnv.addNV()");}
       
   }
   public void deleteNV(M_Nhanvien nv){
       int nvId = nv.getId();    
       if (soc != null ){
            soc.SendMess("DEL:"+nvId);
       }
       else{
           System.out.println("Controller.DAOnv.deleteNV()");}
       
   }
   public void updateNV(M_Nhanvien nv){
       String nvStr = nv.toString2();
       int nvId = nv.getId();
       if(soc!=null){
           soc.SendMess("EDIT:"+nvId+"ID: "+nvStr);
       }
       else{
           System.out.println(".DAOnv.updateNV()");
       }
   }
}
