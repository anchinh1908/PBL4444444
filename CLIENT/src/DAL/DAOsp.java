package DAL;

import DTO.M_Sanpham;
import java.util.ArrayList;
import java.util.List;

public class DAOsp {
    
    private static List<M_Sanpham> SPList;

    public DAOsp() {
        initializeSPList();
    }
    private static void initializeSPList(){
        if(SPList==null){
            SPList=new ArrayList<>();
        }
    }
    public void receiveAndStoreData(List<M_Sanpham> receivedList){
        initializeSPList();
        SPList.clear();
        SPList.addAll(receivedList);
    }
    public List<M_Sanpham> getListSP(){
        initializeSPList();
        return SPList;
    }
}