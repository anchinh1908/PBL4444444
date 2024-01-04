
package View;

import DTO.M_Log;
import javax.swing.DefaultListModel;

public class FrameLog extends javax.swing.JFrame {
    DefaultListModel ModelListLog = new DefaultListModel();
    public FrameLog() {
        initComponents();
    }
    public FrameLog(M_Log log) {
        initComponents();
        this.setLocationRelativeTo(null);
        txtname.setText(log.getPerformerName());
        txtNameTable.setText(log.getTableName());
        txtAction.setText(log.getActionType());
        txtTime.setText(log.getChangeTime()+"");
        ShowRecord(log);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtNameTable = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtAction = new javax.swing.JTextField();
        btncancle = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListLog = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true), "Record's infor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(54, 33, 89))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(54, 33, 89));
        jLabel38.setText("Editor");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 38));

        txtname.setEditable(false);
        txtname.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 270, 38));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(54, 33, 89));
        jLabel39.setText("Table's name");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 117, 38));

        txtNameTable.setEditable(false);
        txtNameTable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtNameTable.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtNameTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 270, 38));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(54, 33, 89));
        jLabel37.setText("Action");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 80, 38));

        txtAction.setEditable(false);
        txtAction.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtAction.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 270, 38));

        btncancle.setBackground(new java.awt.Color(54, 33, 89));
        btncancle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btncancle.setForeground(new java.awt.Color(255, 255, 255));
        btncancle.setText("EXIT");
        btncancle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btncancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancleActionPerformed(evt);
            }
        });
        jPanel1.add(btncancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 400, 60));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(54, 33, 89));
        jLabel40.setText("Time");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 50, 38));

        txtTime.setEditable(false);
        txtTime.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTime.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 270, 38));

        ListLog.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));
        ListLog.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ListLog.setForeground(new java.awt.Color(54, 33, 89));
        jScrollPane1.setViewportView(ListLog);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 390, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void ShowRecord(M_Log log){
            System.out.println("ShowRecord"+log.getActionType());
        ModelListLog.clear();
        if (log.getActionType().equals("Update")){
            String[] parts = log.getRecord().split("-->");
            ModelListLog.addElement("=====Trước cập nhật=====");
            SetElement(log.getTableName(), parts[0]);
            ModelListLog.addElement("=====Sau cập nhật=====");
            SetElement(log.getTableName(), parts[1]);
        }else {
            SetElement(log.getTableName(), log.getRecord());
        }
        ListLog.setModel(ModelListLog);
    }

    
    private void SetElement(String nameTable, String Record){
        if(nameTable.equals("nhân viên")){
            String[] parts = Record.split("_");
            for (String part : parts) {
                String[] keyValue = part.split("/");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();
                    switch (key) {
                        case "TenNV":
                            ModelListLog.addElement("Tên nhân viên: "+value);
                            break;
                        case "CV":
                            ModelListLog.addElement("Chức vụ    : "+value);
                            break;
                        case "NgaySinh":
                            ModelListLog.addElement("Ngày Sinh  : "+value);
                            break;
                        case "GT":
                            ModelListLog.addElement("Giới tính  : "+value);
                            break;
                        case "DiaChi":
                            ModelListLog.addElement("Dịa chỉ    : "+value);
                            break;
                        case "Email":
                            ModelListLog.addElement("Email      : "+value);
                            break;
                        case "Luong":
                            ModelListLog.addElement("Lương      : "+value);
                            break;
                        // Thêm các trường khác nếu có
                    }
                }
            } 
        }
        else if(nameTable.equals("sản phẩm")){
            String[] parts=Record.split("_");
            for(String part : parts){
                String[] keyValue=part.split("/");
                if(keyValue.length == 2){
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();
                    switch (key) { 
                        case "TenSP":
                            ModelListLog.addElement("Tên sản phẩm: "+value);
                            break;
                        case "TenLoai":
                            ModelListLog.addElement("Tên loại    : "+value);
                            break;
                        case "Maloai":
                            ModelListLog.addElement("Mã Loại     : "+value);
                            break;
                        case "SoLuong":
                            ModelListLog.addElement("Số Lượng    : "+value);
                            break;
                        case "Gia":
                            ModelListLog.addElement("Giá         : "+value);
                            break;              
                    }
                }
            }

        }
        else {
             String[] parts=Record.split("_");
            for(String part : parts){
            String[] keyValue=part.split("/");
            if(keyValue.length == 2){
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                switch (key) { 
                    case "TenLoai":
                            ModelListLog.addElement("Tên loại   : "+value);
                        break;
                    case "Mota":
                            ModelListLog.addElement("Mô tả      : "+value);
                        break;
                    }
                }
            }
        }
    }
    
    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void btncancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancleActionPerformed
        dispose();
    }//GEN-LAST:event_btncancleActionPerformed

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameLog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListLog;
    private javax.swing.JButton btncancle;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAction;
    private javax.swing.JTextField txtNameTable;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
