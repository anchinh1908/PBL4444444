
package View;

import BLL.BLL_sanphamCt;
import BLL.CSocket;
import DTO.M_SanphamCT;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;


public class frameSPCT extends javax.swing.JFrame {

    private BLL_sanphamCt bLL_sanphamCt ;   
    private int maloai = 0;
    private CSocket soc;
    
    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public frameSPCT() throws HeadlessException {
         initComponents();
        setLocationRelativeTo(null);
    }
    
    public frameSPCT( CSocket soc) {
        this.soc = soc;
        this.bLL_sanphamCt = new BLL_sanphamCt(soc);
        initComponents();
        setLocationRelativeTo(null);
    }
    public frameSPCT(M_SanphamCT spct, CSocket soc) {
        this.soc = soc;
        this.bLL_sanphamCt = new BLL_sanphamCt(soc);
        initComponents();
        setLocationRelativeTo(null);
        maloai = spct.getMaloai();
        txtMaloai.setText(maloai + "");
        txtMaloai.setEditable(false);
        txtTenloai.setText(spct.getTenloai());
        txtMota.setText(spct.getMota());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtMaloai = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtTenloai = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtMota = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        btncancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true), "Loại sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(54, 33, 89))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(54, 33, 89));
        jLabel38.setText("Mã loại ");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 62, 90, 38));

        txtMaloai.setEditable(false);
        txtMaloai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMaloai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMaloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaloaiActionPerformed(evt);
            }
        });
        jPanel1.add(txtMaloai, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 270, 38));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(54, 33, 89));
        jLabel39.setText("Tên loại ");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 121, 117, 38));

        txtTenloai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTenloai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtTenloai, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 270, 38));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(54, 33, 89));
        jLabel37.setText("Mô tả");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 179, 80, 38));

        txtMota.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMota.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtMota, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 270, 38));

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
        jPanel1.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 68, 120, 50));

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
        jPanel1.add(btncancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 156, 120, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // trg hợp add
        if (maloai==0){
            M_SanphamCT spct=new M_SanphamCT();

            if( txtTenloai.getText()!=null && txtMota.getText()!=null){
                spct.setTenloai(txtTenloai.getText());
                spct.setMota(txtMota.getText());
            }
            else{
                JOptionPane.showMessageDialog(this, "Cần nhập đủ thông tin!");
            }
            bLL_sanphamCt.addSPCT(spct);
            dispose();
        }else{
            //            trg hợp update là sẽ có ID
            M_SanphamCT ct = new M_SanphamCT();
            if(txtTenloai.getText()!=null && txtMota.getText()!=null){
                ct.setMaloai(maloai);
                ct.setTenloai(txtTenloai.getText());
                ct.setMota(txtMota.getText());
                ct.setStatus("editable");
            }
            else{
                JOptionPane.showMessageDialog(this, "Chua nhap day du thong tin");
            }
            bLL_sanphamCt.updateSPCT(ct);
            soc.SendMess("StopChange:SPCT:"+maloai);
            dispose();
        }
    
    }//GEN-LAST:event_btnOKActionPerformed

    private void btncancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancleActionPerformed
        if(maloai!=0){
            soc.SendMess("StopChange:SPCT:"+maloai);
        }dispose();
    }//GEN-LAST:event_btncancleActionPerformed

    private void txtMaloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaloaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaloaiActionPerformed

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
            java.util.logging.Logger.getLogger(frameSPCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameSPCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameSPCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameSPCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameSPCT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btncancle;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtMaloai;
    private javax.swing.JTextField txtMota;
    private javax.swing.JTextField txtTenloai;
    // End of variables declaration//GEN-END:variables
}
