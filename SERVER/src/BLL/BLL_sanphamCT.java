
package BLL;

import DTO.M_SanphamCT;
import java.util.ArrayList;
import java.util.List;


public class BLL_sanphamCT {
    public ArrayList<M_SanphamCT> getListSPCT()
    {
        return new DAL.DAOspCT().getListSPCT();
    } 

    public boolean  AddSPCT(M_SanphamCT s,String name){
        return new DAL.DAOspCT().AddSPCT(s,name);
    }
    public boolean DeleteSPCT(int mact,String name){
        if(new DAL.DAOspCT().DeleteSPCT(mact)){
            new DAL.DAO_log().addLogSPCT(name,"Delete",mact);
            return true;
        }
        else return false;
    }
    public boolean UpdateSPCT(M_SanphamCT spct,String name)
    {   
        if(new DAL.DAOspCT().updateSPCT(spct)){
            new DAL.DAO_log().addLogSPCT(name,"Update",spct.getMaloai());
            return true;
        }
        else return false;
    }
    public void ChangeStatusTrue (int ID){
       
        List<M_SanphamCT> spList = getListSPCT();
        for (M_SanphamCT sp : spList) {
        if (sp.getMaloai()== ID) {
             sp.setStatus(true);
            new DAL.DAOspCT().updateSPCT(sp);
            }
        }
   }
    public void ChangeStatusFalse (int ID){
       
        List<M_SanphamCT> spList = getListSPCT();
        for (M_SanphamCT sp : spList) {
        if (sp.getMaloai()== ID) {
             sp.setStatus(false);
             new DAL.DAOspCT().updateSPCT(sp);
            }
        }
   }
}
