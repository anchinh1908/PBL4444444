
package DAL;

import DTO.M_DBconnect;
import DTO.M_Log;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DAO_log {
        public static void main(String[] args){
        M_DBconnect.loadConnection();
    }
    // Hàm lấy danh sách log từ database
    public ArrayList<M_Log> getListLog() {
        ArrayList<M_Log> list = new ArrayList<>();
        String sql = "SELECT * FROM data_change_log";
        try {
            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                M_Log log = new M_Log();
                log.setLogID(rs.getInt("log_id"));
                log.setPerformerName(rs.getString("performer_name"));
                log.setActionType(rs.getString("action_type"));
                log.setTableName(rs.getString("table_name"));
                log.setRecord(rs.getString("record"));
                String dateStr = rs.getString("change_time");
                SimpleDateFormat datefm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                log.setChangeTime(datefm.parse(dateStr));
                list.add(log);
            }
        } catch (SQLException | ParseException e) {
        }
        return list;
    }

    // Hàm thêm một bản ghi log mới vào database
    public boolean addLogNV(String name, String action ,String Record) {
        String sql = "INSERT INTO data_change_log VALUES (null,?,?,?,?,?)";

        try {
            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, action);
            ps.setString(3, "nhân viên");
            ps.setString(4, Record);
            ps.setString(5, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            int affectedRows = ps.executeUpdate();
            if( affectedRows > 0){
                System.out.println("DAL.DAO_log.addLogNV()" + Record);
            }
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        // Hàm thêm một bản ghi log mới vào database
    public boolean addLogSP(String name, String action ,String Record) {
        String sql = "INSERT INTO data_change_log VALUES (null,?,?,?,?,?)";

        try {
            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, action);
            ps.setString(3, "sản phẩm");
            ps.setString(4, Record);
            ps.setString(5, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            int affectedRows = ps.executeUpdate();
 
            return affectedRows > 0;
        } catch (SQLException e) {
            return false;
        }
    }
            // Hàm thêm một bản ghi log mới vào database
    public boolean addLogSPCT(String name, String action ,String Record) {
        String sql = "INSERT INTO data_change_log VALUES (null,?,?,?,?,?)";

        try {
            PreparedStatement ps = M_DBconnect.con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, action);
            ps.setString(3, "Loại sản phẩm");
            ps.setString(4, Record);
            ps.setString(5, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
