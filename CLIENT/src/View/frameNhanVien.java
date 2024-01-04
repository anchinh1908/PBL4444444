
package View;

import BLL.BLL_nhanvien;
import BLL.CSocket;
import DTO.M_Nhanvien;
import javax.swing.JOptionPane;

public class frameNhanVien extends javax.swing.JFrame {

    private BLL_nhanvien BLLnv ;    
    private int ID = 0;
    private CSocket soc;
    

    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);    
    }
    
    public frameNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public frameNhanVien(CSocket soc) {
        this.soc = soc;
        this.BLLnv = new BLL_nhanvien(soc);
        initComponents();
        setLocationRelativeTo(null);
    }
    public frameNhanVien(M_Nhanvien nv, CSocket soc) {
        this.soc = soc;
        this.BLLnv = new BLL_nhanvien(soc);
        initComponents();
        setLocationRelativeTo(null);
        ID = nv.getId();
        txtTennv.setText(nv.getTennv());
        txtdiachi.setText(nv.getDiachi());
        txtchucvu.setSelectedItem(nv.getChucvu());
        txtgioitinh.setSelectedItem(nv.getGt());
        txtngaysinh.setDate(nv.getDate());
        txtemail.setText(nv.getEmail());
        txtluong.setText(nv.getLuong()+""); 
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelThongtinnhanvien = new javax.swing.JPanel();
        txtTennv = new javax.swing.JTextField();
        ten = new javax.swing.JLabel();
        cv = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        date = new javax.swing.JLabel();
        diachi = new javax.swing.JLabel();
        txtluong = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        lương = new javax.swing.JLabel();
        txtchucvu = new javax.swing.JComboBox<>();
        btnOK = new javax.swing.JButton();
        btncancle = new javax.swing.JButton();
        txtgioitinh = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtngaysinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelThongtinnhanvien.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThongtinnhanvien.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true), "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 18), new java.awt.Color(54, 33, 89))); // NOI18N
        jPanelThongtinnhanvien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTennv.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtTennv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtTennv, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 240, 30));

        ten.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ten.setForeground(new java.awt.Color(54, 33, 89));
        ten.setText("Họ và tên");
        jPanelThongtinnhanvien.add(ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 50));

        cv.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cv.setForeground(new java.awt.Color(54, 33, 89));
        cv.setText("Chức vụ");
        jPanelThongtinnhanvien.add(cv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 110, 50));

        txtdiachi.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtdiachi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtdiachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 240, 30));

        date.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        date.setForeground(new java.awt.Color(54, 33, 89));
        date.setText("Ngày sinh");
        jPanelThongtinnhanvien.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 50));

        diachi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        diachi.setForeground(new java.awt.Color(54, 33, 89));
        diachi.setText("Địa chỉ");
        jPanelThongtinnhanvien.add(diachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 110, 50));

        txtluong.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtluong.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 240, 30));

        txtemail.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtemail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 240, 30));

        email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        email.setForeground(new java.awt.Color(54, 33, 89));
        email.setText("Email");
        jPanelThongtinnhanvien.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 110, 50));

        lương.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lương.setForeground(new java.awt.Color(54, 33, 89));
        lương.setText("Lương");
        jPanelThongtinnhanvien.add(lương, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 110, 50));

        txtchucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(BH) Bán Hàng", "(BV) Bảo Vệ", "(QL) Quản Lý" }));
        txtchucvu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanelThongtinnhanvien.add(txtchucvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 240, 30));

        btnOK.setBackground(new java.awt.Color(54, 33, 89));
        btnOK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOK.setForeground(new java.awt.Color(255, 255, 255));
        btnOK.setText("OK");
        btnOK.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jPanelThongtinnhanvien.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 140, 50));

        btncancle.setBackground(new java.awt.Color(54, 33, 89));
        btncancle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btncancle.setForeground(new java.awt.Color(255, 255, 255));
        btncancle.setText("Cancel");
        btncancle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btncancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancleActionPerformed(evt);
            }
        });
        jPanelThongtinnhanvien.add(btncancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 140, 50));

        txtgioitinh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtgioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", " " }));
        txtgioitinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));
        jPanelThongtinnhanvien.add(txtgioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 240, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Giới tính");
        jPanelThongtinnhanvien.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, 30));
        jPanelThongtinnhanvien.add(txtngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 240, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelThongtinnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelThongtinnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // trg hợp add
        if (ID==0){
            M_Nhanvien nv=new M_Nhanvien();

            if( txtTennv.getText()!=null && txtdiachi.getText()!=null
                && txtluong.getText()!=null  && txtngaysinh.getDate()!=null){
                
                nv.setTennv(txtTennv.getText());
                nv.setChucvu(txtchucvu.getSelectedItem().toString());
                nv.setDate(txtngaysinh.getDate());
                nv.setGt(txtgioitinh.getSelectedItem().toString());
                nv.setDiachi(txtdiachi.getText());
                nv.setEmail(txtemail.getText());
                nv.setLuong(Integer.parseInt(txtluong.getText()));
            }
            else{
                JOptionPane.showMessageDialog(this, "Ban can nhap day du thong tin");
            }
            BLLnv.addNV(nv);
            dispose();
        }else{
//            trg hợp update là sẽ có ID 
            
           M_Nhanvien nv = new M_Nhanvien();
           if( txtTennv.getText()!=null && txtdiachi.getText()!=null
               && txtluong.getText()!=null  && txtngaysinh.getDate()!=null){
               nv.setId(ID);
               nv.setTennv(txtTennv.getText());
               nv.setChucvu(txtchucvu.getSelectedItem().toString());
               nv.setDate(txtngaysinh.getDate());
               nv.setGt(txtgioitinh.getSelectedItem().toString());
               nv.setDiachi(txtdiachi.getText());
               nv.setEmail(txtemail.getText());
               nv.setLuong(Integer.parseInt(txtluong.getText()));
               nv.setStatus("editable");
           }
           else{
               JOptionPane.showMessageDialog(this, "Chua nhap day du thong tin");
           }
           BLLnv.updateNV(nv);
           soc.SendMess("StopChange:NV:"+ID);
           dispose();
        }   
    }//GEN-LAST:event_btnOKActionPerformed

    private void btncancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancleActionPerformed
        if(ID!=0){
            soc.SendMess("StopChange:NV:"+ID);
        }
        dispose();
    }//GEN-LAST:event_btncancleActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frameNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btncancle;
    private javax.swing.JLabel cv;
    private javax.swing.JLabel date;
    private javax.swing.JLabel diachi;
    private javax.swing.JLabel email;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelThongtinnhanvien;
    private javax.swing.JLabel lương;
    private javax.swing.JLabel ten;
    private javax.swing.JTextField txtTennv;
    private javax.swing.JComboBox<String> txtchucvu;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JComboBox<String> txtgioitinh;
    private javax.swing.JTextField txtluong;
    private com.toedter.calendar.JDateChooser txtngaysinh;
    // End of variables declaration//GEN-END:variables
}
