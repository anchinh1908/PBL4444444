/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.M_Nhanvien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DAO_ClientList {
    private static List<M_Nhanvien> NVList;

    // Hàm khởi tạo lười biếng
    private static void initializeNVList() {
        if (NVList == null) {
            NVList = new ArrayList<>();
        }
    }

    public DAO_ClientList() {
        initializeNVList();
    }
    
    public DAO_ClientList(List<M_Nhanvien> NVList) {
        initializeNVList();
        this.NVList = NVList;
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