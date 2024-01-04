
package BLL;

import DTO.M_Nhanvien;
import DTO.M_SanphamCT;
import DTO.M_cbbspct;
import java.util.ArrayList;
import java.util.List;


public class BLL_sanphamCt {
        
    CSocket soc;

    public BLL_sanphamCt() {
    }

    public BLL_sanphamCt(CSocket soc) {
        this.soc = soc;
    }

    
    public void receiveAndStoreData(List<M_SanphamCT> receivedList) {
        new DAL.DAOspCT().receiveAndStoreData(receivedList);
    }
    public List<M_SanphamCT> getListSPCT(){
        return new DAL.DAOspCT().getListSPCT();
    }    
    public void addSPCT(M_SanphamCT spct){
        String spctStr=spct.toString();
        if(soc!=null){
            soc.SendMess("ADD:CTSP:"+spctStr);
        }
        else{
            System.out.println("Controller.DAOspCT.addSPCT()");
        }
   }
    public void deleteSPCT(int maloai){
       if (soc != null ){
            soc.SendMess("DEL:CTSP:"+maloai);
       }
       else{
           System.out.println("Controller.DAOspCT.deleteSP()");    
       }

   } 
    public void updateSPCT(M_SanphamCT spct){
        String spctStr = spct.toString();
       if(soc!=null){
           soc.SendMess("EDIT:CTSP:"+spctStr);
       }
       else{
           System.out.println("Controller.DAOspCT.updateSPCT()");
       }
    }
    public List<M_cbbspct> getListcbb(){
        List<M_cbbspct> Listcbb = new ArrayList();
        for(M_SanphamCT spct : new DAL.DAOspCT().getListSPCT()){
            M_cbbspct cbb = new M_cbbspct();
            cbb.setId(spct.getMaloai());
            cbb.setTenloai(spct.getTenloai());
            Listcbb.add(cbb);
        }
         return Listcbb;
    } 
    public List<M_SanphamCT> searchByTenloai (String tenloai){   
        List<M_SanphamCT> ctList = getListSPCT();
        List<M_SanphamCT> result = new ArrayList<>();

    for (M_SanphamCT ct : ctList) {
        if (ct.getTenloai().contains(tenloai)) {
            result.add(ct);
        }
    }
    return result;
   }
    
    public void ChangeStatusTrue (int ID){
       
        List<M_SanphamCT> spList = getListSPCT();
        for (M_SanphamCT sp : spList) {
        if (sp.getMaloai()== ID) {
             sp.setStatus("editable");
            }
        }
   }
    public void ChangeStatusFalse (int ID,String name){
       
        List<M_SanphamCT> spList = getListSPCT();
        for (M_SanphamCT sp : spList) {
        if (sp.getMaloai()== ID) {
             sp.setStatus(name);
            }
        }
   }
}
