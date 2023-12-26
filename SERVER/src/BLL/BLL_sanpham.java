
package BLL;

import DTO.M_Sanpham;
import java.util.ArrayList;
import java.util.List;


public class BLL_sanpham {
    public ArrayList<M_Sanpham> getListSP()
    {
        return new DAL.DAOsp().getListSP();
    } 
    public boolean AddSP(M_Sanpham s,String name){
         return new DAL.DAOsp().AddSP(s,name);
    }
    public boolean DeleteSP(int Masp,String name){
        if(new DAL.DAOsp().DeleteSP(Masp)){
            new DAL.DAO_log().addLogSP(name,"Delete",Masp);
            return true;
        }
        else return false;
    }
    public boolean UpdateSP(M_Sanpham sp,String name)
    {   
        if(new DAL.DAOsp().updateSP(sp)){
            new DAL.DAO_log().addLogSP(name,"Update",sp.getMasp());
            return true;
        }
        else return false;
    } 
    public void ChangeStatusTrue (int ID){
       
        List<M_Sanpham> spList = getListSP();
        for (M_Sanpham sp : spList) {
        if (sp.getMasp() == ID) {
             sp.setStatus(true);
            new DAL.DAOsp().updateSP(sp);
            }
        }
   }
    public void ChangeStatusFalse (int ID){
       
        List<M_Sanpham> spList = getListSP();
        for (M_Sanpham sp : spList) {
        if (sp.getMasp()== ID) {
             sp.setStatus(false);
            new DAL.DAOsp().updateSP(sp);
            }
        }
   }
}
