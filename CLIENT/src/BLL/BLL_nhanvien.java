
package BLL;

import DTO.M_Nhanvien;
import java.util.ArrayList;
import java.util.List;

public class BLL_nhanvien {
    
    CSocket soc;
    
    public BLL_nhanvien() {
    }
    
    public BLL_nhanvien(CSocket soc) {
        this.soc = soc;
    }

    public void receiveAndStoreData(List<M_Nhanvien> receivedList) {
        new DAL.DAOnv().receiveAndStoreData(receivedList);
    }
    public List<M_Nhanvien> getListNV(){
        return new DAL.DAOnv().getListNV();
    }
    public void addNV(M_Nhanvien nv){
        String nvStr = nv.toString();
        if (soc != null ){
            soc.SendMess("ADD:NV:"+nvStr);
        }
        else{
            System.out.println("Controller.DAOnv.addNV()");}
   }
   public void deleteNV(int nvid){
        if (soc != null ){
            soc.SendMess("DEL:NV:"+nvid);
       }
       else{
           System.out.println("Controller.DAOnv.deleteNV()");}
       
   }
   public void updateNV(M_Nhanvien nv){
        String nvStr = nv.toString();
        if(soc!=null){
           soc.SendMess("EDIT:NV:"+nvStr);
        }
        else{
           System.out.println(".DAOnv.updateNV()");
        }
   }
   public List<M_Nhanvien> searchByName (String name){
       
        List<M_Nhanvien> nvList = getListNV();
        List<M_Nhanvien> result = new ArrayList<>();

    for (M_Nhanvien cl : nvList) {
        if (cl.getTennv().contains(name)) {
            result.add(cl);
        }
    }
       return result;
   }
    public void ChangeStatusFalse (int ID){
       
        List<M_Nhanvien> nvList = getListNV();
        for (M_Nhanvien cl : nvList) {
        if (cl.getId() == ID) {
            cl.setStatus(false);
            }
        }
   }
        public void ChangeStatusTrue (int ID){
       
        List<M_Nhanvien> nvList = getListNV();
        for (M_Nhanvien cl : nvList) {
        if (cl.getId() == ID) {
            cl.setStatus(true);
            }
        }
   }
}
