/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import BLL.BLL_sanpham;
import BLL.BLL_sanphamCt;
import BLL.CSocket;
import DTO.M_Sanpham;
import DTO.M_cbbspct;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;


public class frameSanPham extends javax.swing.JFrame {

    private BLL.BLL_sanpham BLLsp; 
    private int ID = 0;
    private CSocket soc;

    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public frameSanPham() throws HeadlessException {
        initComponents();
        setLocationRelativeTo(null);
    }
    public frameSanPham( CSocket soc) {
        this.soc = soc;
        this.BLLsp = new BLL_sanpham(soc);
        initComponents();
        setLocationRelativeTo(null);
        setComboboxLoai();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }
        });
    }
    public frameSanPham(M_Sanpham sp, CSocket soc) {
        this.soc = soc;
        this.BLLsp = new BLL_sanpham(soc);
        initComponents();
        setLocationRelativeTo(null);
        setComboboxLoai();
        ID = sp.getMasp();
        txtMasp2.setText(sp.getMasp()+"");
        txtMasp2.setEditable(false);
        txtTensp2.setText(sp.getTensp());
        comboboxLoai2.setSelectedItem(sp.getTenloai());
        txtSoluong2.setText(sp.getSoluong()+"");
        txtGia2.setText(sp.getGia()+"");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelThongtinnhanvien = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btncancle = new javax.swing.JButton();
        txtMasp2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtTensp2 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        comboboxLoai2 = new javax.swing.JComboBox<>();
        txtSoluong2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtGia2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelThongtinnhanvien.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThongtinnhanvien.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true), "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(54, 33, 89))); // NOI18N
        jPanelThongtinnhanvien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanelThongtinnhanvien.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 130, 50));

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
        jPanelThongtinnhanvien.add(btncancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 130, 50));

        txtMasp2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMasp2.setToolTipText("");
        txtMasp2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtMasp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 213, 32));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(54, 33, 89));
        jLabel29.setText("Mã sản phẩm");
        jPanelThongtinnhanvien.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 106, 32));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(54, 33, 89));
        jLabel28.setText("Tên sản phẩm");
        jPanelThongtinnhanvien.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 32));

        txtTensp2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTensp2.setToolTipText("");
        txtTensp2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtTensp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 213, 32));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(54, 33, 89));
        jLabel32.setText("Tên loại");
        jPanelThongtinnhanvien.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 106, 36));

        comboboxLoai2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        comboboxLoai2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));
        jPanelThongtinnhanvien.add(comboboxLoai2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 210, 36));

        txtSoluong2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtSoluong2.setToolTipText("");
        txtSoluong2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtSoluong2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 220, 30));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(54, 33, 89));
        jLabel30.setText("Số lượng");
        jPanelThongtinnhanvien.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 110, 30));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(54, 33, 89));
        jLabel31.setText("Giá");
        jPanelThongtinnhanvien.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 110, 30));

        txtGia2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtGia2.setToolTipText("");
        txtGia2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtGia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 220, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelThongtinnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelThongtinnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // trg hợp add
        if (ID==0){
            M_Sanpham sp = new M_Sanpham();

            if(txtMasp2.getText()!=null && txtTensp2.getText()!=null && comboboxLoai2.getSelectedItem()!=null
                && txtSoluong2.getText()!=null  && txtGia2.getText()!=null){
                sp.setTensp(txtTensp2.getText());
                sp.setMasp(Integer.parseInt(txtMasp2.getText()));
                sp.setMaloai(((M_cbbspct) comboboxLoai2.getSelectedItem()).getId());
                sp.setSoluong(Integer.parseInt(txtSoluong2.getText()));
                sp.setGia(Integer.parseInt(txtGia2.getText()));
            }
            else{
                JOptionPane.showMessageDialog(this, "Ban can nhap day du thong tin");
            }
            BLLsp.addSP(sp);
            dispose();
        }else{
            // trg hợp update là sẽ có ID
            M_Sanpham sp = new M_Sanpham();

            if(txtMasp2.getText()!=null && txtTensp2.getText()!=null && comboboxLoai2.getSelectedItem()!=null
                && txtSoluong2.getText()!=null  && txtGia2.getText()!=null){
                sp.setTensp(txtTensp2.getText());
                sp.setMasp(Integer.parseInt(txtMasp2.getText()));
                sp.setMaloai(((M_cbbspct) comboboxLoai2.getSelectedItem()).getId());
                sp.setSoluong(Integer.parseInt(txtSoluong2.getText()));
                sp.setGia(Integer.parseInt(txtGia2.getText()));              
                sp.setStatus(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Ban can nhap day du thong tin");
            }
            BLLsp.UpdateSP(sp);
            soc.SendMess("StopChange:SP:"+ID);
            dispose();
        }

    }//GEN-LAST:event_btnOKActionPerformed

    private void btncancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancleActionPerformed
        if(ID!=0){
            soc.SendMess("StopChange:SP:"+ID);
        }dispose();
    }//GEN-LAST:event_btncancleActionPerformed

    
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
            java.util.logging.Logger.getLogger(frameSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btncancle;
    private javax.swing.JComboBox<M_cbbspct> comboboxLoai2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanelThongtinnhanvien;
    private javax.swing.JTextField txtGia2;
    private javax.swing.JTextField txtMasp2;
    private javax.swing.JTextField txtSoluong2;
    private javax.swing.JTextField txtTensp2;
    // End of variables declaration//GEN-END:variables

    public void setComboboxLoai() {
       List<M_cbbspct>  List = new BLL_sanphamCt().getListcbb();
       for (M_cbbspct item : List){
           comboboxLoai2.addItem(item);
       }
    }  
    private void closeFrame() {
        if(ID!=0){
            soc.SendMess("StopChange:SP:"+ID);
        }
        dispose(); 
    }
}
