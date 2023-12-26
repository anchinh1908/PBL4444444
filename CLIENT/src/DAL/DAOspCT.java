
package DAL;

import BLL.CSocket;
import DTO.M_SanphamCT;
import java.util.ArrayList;
import java.util.List;


public class DAOspCT {
    private CSocket soc = new CSocket();
    
    private static List<M_SanphamCT> SPCTList;
    
     public DAOspCT(){
         initializeSPCTList();
     }
     private static void initializeSPCTList(){
        if(SPCTList==null)
            SPCTList=new ArrayList<>();
        }
    public void receiveAndStoreData(List<M_SanphamCT> receivedList){
        initializeSPCTList();
        SPCTList.clear();
        SPCTList.addAll(receivedList);
    }
    public List<M_SanphamCT> getListSPCT(){
        initializeSPCTList();
        return SPCTList;
    }
}
    
    
    