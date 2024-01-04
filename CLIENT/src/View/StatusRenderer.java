
package View;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class StatusRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Kiểm tra giá trị của cột "Status"
        String statusValue = (String) value;

        // Nếu là trạng thái "editable"
        if ("editable".equals(statusValue)) {
            component.setBackground(table.getBackground());  // Màu sắc cho trạng thái "editable"
        } else {
            component.setBackground(Color.getHSBColor(240f/360,0.3333f,1f));  // Sử dụng màu nền mặc định cho các trạng thái khác
        }

        // Cài đặt màu văn bản
        component.setForeground(Color.BLACK);  // Có thể thay đổi màu văn bản tùy thuộc vào màu nền bạn chọn

        return component;
    }
}
