
package BLL;

import DTO.M_Nhanvien;
import java.util.ArrayList;
import java.util.List;


public class BLL_nhanvien {
     public ArrayList<M_Nhanvien> getListNV()
    {
        return new DAL.DAOnv().getListNV();
    } 
    public boolean AddNV(M_Nhanvien n,String name){
        return new DAL.DAOnv().AddNV(n,name);
    }
    public boolean DeleteNV(int id,String name){
        if(new DAL.DAOnv().DeleteNV(id)){
            new DAL.DAO_log().addLogNV(name,"Delete",id);
            return true;
        }
        else return false;
    }
   public boolean UpdateNV(M_Nhanvien nv, String name)
    {   
        if(new DAL.DAOnv().updateNV(nv)){
            new DAL.DAO_log().addLogNV(name,"Update",nv.getId());
            return true;
        }
        else return false;
    } 

    public void ChangeStatusTrue (int ID){
       
        List<M_Nhanvien> nvList = getListNV();
        for (M_Nhanvien cl : nvList) {
        if (cl.getId() == ID) {
             cl.setStatus(true);
             new DAL.DAOnv().updateNV(cl);
            }
        }
   }
    public void ChangeStatusFalse (int ID){
       
        List<M_Nhanvien> nvList = getListNV();
        for (M_Nhanvien cl : nvList) {
        if (cl.getId() == ID) {
             cl.setStatus(false);
             new DAL.DAOnv().updateNV(cl);
            }
        }
   }
    
}
