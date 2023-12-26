
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

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(54, 33, 89));
        jLabel38.setText("Mã loại ");

        txtMaloai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMaloai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(54, 33, 89));
        jLabel39.setText("Tên loại ");

        txtTenloai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTenloai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(54, 33, 89));
        jLabel37.setText("Mô tả");

        txtMota.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(txtMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenloai, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenloai, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncancle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // trg hợp add
        if (maloai==0){
            M_SanphamCT spct=new M_SanphamCT();

            if(txtMaloai.getText()!=null && txtTenloai.getText()!=null && txtMota.getText()!=null){
                spct.setMaloai(Integer.parseInt(txtMaloai.getText()));
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
                ct.setStatus(true);
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
