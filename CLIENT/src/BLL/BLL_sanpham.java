package BLL;

import DTO.M_Sanpham;
import java.util.ArrayList;
import java.util.List;


public class BLL_sanpham {
    
    CSocket soc;

    public BLL_sanpham() {
    }

    public BLL_sanpham(CSocket soc) {
        this.soc = soc;
    }

    public void receiveAndStoreData(List<M_Sanpham> receivedList) {
        new DAL.DAOsp().receiveAndStoreData(receivedList);
    }
    public List<M_Sanpham> getListSP(){
        return new DAL.DAOsp().getListSP();
    }    
    public void addSP(M_Sanpham sp){
         String spStr=sp.toString();
        if(soc!=null){
            soc.SendMess("ADD:SP:"+spStr);
        }
        else{
            System.out.println("Controller.DAOsp.addSP()");
        }
   }
    public void deleteSP(int masp){
           
       if (soc != null ){
            soc.SendMess("DEL:SP:"+masp);
       }
       else{
           System.out.println("Controller.DAOsp.deleteSP()");    
       }
   }
    public void UpdateSP(M_Sanpham sp){
         String spStr = sp.toString();
       if(soc!=null){
           soc.SendMess("EDIT:SP:"+spStr);
       }
       else{
           System.out.println(".DAOsp.updateSP()");
       }
    }
    public List<M_Sanpham> searchByName (String name){
       
        List<M_Sanpham> spList = getListSP();
        List<M_Sanpham> result = new ArrayList<>();

        for (M_Sanpham cl : spList) {
            if (cl.getTensp().contains(name)) {
                result.add(cl);
            }
        }
           return result;
   }
    public void ChangeStatusTrue (int ID){
       
        List<M_Sanpham> spList = getListSP();
        for (M_Sanpham sp : spList) {
        if (sp.getMasp() == ID) {
             sp.setStatus(true);
            }
        }
   }
    public void ChangeStatusFalse (int ID){
       
        List<M_Sanpham> spList = getListSP();
        for (M_Sanpham sp : spList) {
        if (sp.getMasp()== ID) {
             sp.setStatus(false);
            }
        }
   }
}    
     