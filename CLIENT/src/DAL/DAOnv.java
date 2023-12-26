package DAL;

import BLL.CSocket;
import DTO.M_Nhanvien;
import java.util.ArrayList;
import java.util.List;

public class DAOnv {
    
    private static List<M_Nhanvien> NVList;

    public DAOnv() {
        initializeNVList();
    }
    
     // Hàm khởi tạo lười biếng
    private static void initializeNVList() {
        if (NVList == null) {
            NVList = new ArrayList<>();
        }
    }

    // Hàm cập nhật List từ server 
    public void receiveAndStoreData(List<M_Nhanvien> receivedList) {
        initializeNVList(); // Đảm bảo NVList đã được khởi tạo
        NVList.clear(); // Xóa dữ liệu cũ (nếu có)
        NVList.addAll(receivedList); // Thêm dữ liệu mới
    }
 
    public List<M_Nhanvien> getListNV(){
        initializeNVList(); // Đảm bảo NVList đã được khởi tạo
        return NVList;
    }  
}
