
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
        M_Sanpham sanpham = searchByID(Masp);
        if(new DAL.DAOsp().DeleteSP(Masp)){
            new DAL.DAO_log().addLogSP(name,"Delete",sanpham.toString());
            return true;
        }
        else return false;
    }
    public boolean UpdateSP(M_Sanpham sanpham2,String name)
    {   
       M_Sanpham sanpham1 = searchByID(sanpham2.getMasp());
       
        if(new DAL.DAOsp().updateSP(sanpham2)){
            new DAL.DAO_log().addLogSP(name,"Update",sanpham1.toString()+"-->"+sanpham2.toString());
            return true;
        }
        else return false;
    } 
    
        public M_Sanpham searchByID (int ID){
       
        List<M_Sanpham> spList = getListSP();
        M_Sanpham result = null;

        for (M_Sanpham cl : spList) {
            if (cl.getMasp() == ID) {
                result = cl;
            }
        }
           return result;
   }
    public void ChangeStatusTrue (int ID,String name){
       
        List<M_Sanpham> spList = getListSP();
        for (M_Sanpham sp : spList) {
        if (sp.getMasp() == ID) {
             sp.setStatus("editable");
            new DAL.DAOsp().updateSP(sp);
            }
        }
   }
    public void ChangeStatusFalse (int ID,String fullname){
       
        List<M_Sanpham> spList = getListSP();
        for (M_Sanpham sp : spList) {
        if (sp.getMasp()== ID) {
             sp.setStatus(fullname);
            new DAL.DAOsp().updateSP(sp);
            }
        }
   }
}
