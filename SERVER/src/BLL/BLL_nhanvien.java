
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
        System.out.println("BLL.BLL_nhanvien.AddNV()" + n.getTennv());
        return new DAL.DAOnv().AddNV(n,name);
    }
    public boolean DeleteNV(int id,String name){
        M_Nhanvien nv = searchByID(id);
        if(new DAL.DAOnv().DeleteNV(id)){
            new DAL.DAO_log().addLogNV(name,"Delete",nv.toString());
            return true;
        }
        else return false;
    }
   public boolean UpdateNV(M_Nhanvien nv2, String name)
    {   
        M_Nhanvien nv1 = searchByID(nv2.getId());
        System.out.println("BLL.BLL_nhanvien.UpdateNV()");
        if (new DAL.DAOnv().updateNV(nv2)) {
            new DAL.DAO_log().addLogNV(name, "Update", nv1.toString() + "-->" +nv2.toString());
            return true;
        }
        else return false;
    } 
      public M_Nhanvien searchByID (int ID){
       
            List<M_Nhanvien> nvList = getListNV();
            M_Nhanvien result = null;

        for (M_Nhanvien cl : nvList) {
            if (cl.getId()==ID) {
              result = cl ;
            }
        }
           return result;
       }
    public void ChangeStatusTrue (int ID, String name){
       
        List<M_Nhanvien> nvList = getListNV();
        for (M_Nhanvien cl : nvList) {
        if (cl.getId() == ID) {
             cl.setStatus("editable");
             new DAL.DAOnv().updateNV(cl);
            }
        }
   }
    public void ChangeStatusFalse (int ID,String fullname){
       
        List<M_Nhanvien> nvList = getListNV();
        for (M_Nhanvien cl : nvList) {
        if (cl.getId() == ID) {
             cl.setStatus(fullname);
             new DAL.DAOnv().updateNV(cl);
            }
        }
   }
    
}
