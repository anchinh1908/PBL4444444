
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
        M_SanphamCT spct = searchByID(mact);
        if(new DAL.DAOspCT().DeleteSPCT(mact)){
            new DAL.DAO_log().addLogSPCT(name,"Delete",spct.toString());
            return true;
        }
        else return false;
    }
    public boolean UpdateSPCT(M_SanphamCT spct2,String name)
    {   
        M_SanphamCT spct1 = searchByID(spct2.getMaloai());
        if(new DAL.DAOspCT().updateSPCT(spct2)){
            new DAL.DAO_log().addLogSPCT(name,"Update",spct1.toString()+"-->"+spct2.toString());
            return true;
        }
        else return false;
    }
    public M_SanphamCT searchByID (int ID){   
        List<M_SanphamCT> ctList = getListSPCT();
        M_SanphamCT result = null;

        for (M_SanphamCT ct : ctList) {
            if (ct.getMaloai()==ID) {
                result = ct;
            }
        }
        return result;
   }
    public void ChangeStatusTrue (int ID,String name){
       
        List<M_SanphamCT> spList = getListSPCT();
        for (M_SanphamCT sp : spList) {
        if (sp.getMaloai()== ID) {
             sp.setStatus("editable");
            new DAL.DAOspCT().updateSPCT(sp);
            }
        }
   }
    public void ChangeStatusFalse (int ID,String fullname){
       
        List<M_SanphamCT> spList = getListSPCT();
        for (M_SanphamCT sp : spList) {
        if (sp.getMaloai()== ID) {
             sp.setStatus(fullname);
             new DAL.DAOspCT().updateSPCT(sp);
            }
        }
   }
}
