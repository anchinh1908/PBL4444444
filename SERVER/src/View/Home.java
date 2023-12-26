package View;

import BLL.*;
import DTO.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Home extends javax.swing.JFrame {

    private List<M_Nhanvien> nhanvien;
    private List<M_Client> clients;
    private List<M_Sanpham> sanpham;
    private List<M_SanphamCT> sanphamCT;

    private int selectedIndex;

    private DefaultTableModel ModelTBClient;
    private DefaultTableModel ModelTBNV;
    private DefaultTableModel ModelTBSP;
    private DefaultTableModel ModelTBSPCT;
    private DefaultTableModel ModelTBLog;

    public SVSocket sv;

    private DefaultListModel modelList;
    private Timer timer;

    public Home() {
        M_DBconnect.loadConnection();
        initComponents();
        modelList = new DefaultListModel();
        this.Show();

        ModelTBClient = (DefaultTableModel) TableClient.getModel();
        ModelTBNV = (DefaultTableModel) TableNV.getModel();
        ModelTBLog = (DefaultTableModel) TableLog.getModel();
        showTableClient(new BLL_Client().getListClients());
        showTableLog(new BLL_Log().getListLog());

        modelList = new DefaultListModel();
    }

    public void Show() {
        btnShowNV.setVisible(false);
        btnShowSP.setVisible(false);

        panelContainer.setVisible(true);
        panelListEmployee.setVisible(false);
        panelStatusClient.setVisible(true);
        panelListProduct.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        iconHome = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnDATA = new javax.swing.JButton();
        txtPort = new javax.swing.JTextField();
        btnCLIENT = new javax.swing.JButton();
        btnShowNV = new javax.swing.JButton();
        btnShowSP = new javax.swing.JButton();
        panelContainer = new javax.swing.JPanel();
        panelListEmployee = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableNV = new javax.swing.JTable();
        jPanelThongtinnhanvien = new javax.swing.JPanel();
        mã = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        ten = new javax.swing.JLabel();
        gioitinh = new javax.swing.JLabel();
        cv = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        date = new javax.swing.JLabel();
        diachi = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        lương = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        cbbChucvu = new javax.swing.JComboBox<>();
        jDate = new com.toedter.calendar.JDateChooser();
        panelStatusClient = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListClient = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableClient = new javax.swing.JTable();
        txtSearchClient = new javax.swing.JTextField();
        btnSearchClient = new javax.swing.JButton();
        btnBlock = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableLog = new javax.swing.JTable();
        panelListProduct = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableSPCT = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableSP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnStart.setBackground(new java.awt.Color(54, 33, 89));
        btnStart.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 255, 255));
        btnStart.setText("Start");
        btnStart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jPanel2.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 90, 40));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PORT:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 70, 60));

        iconHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_image/home.png"))); // NOI18N
        jPanel2.add(iconHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 120));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 330, 20));

        btnDATA.setBackground(new java.awt.Color(204, 204, 255));
        btnDATA.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        btnDATA.setForeground(new java.awt.Color(54, 33, 89));
        btnDATA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_image/customer.png"))); // NOI18N
        btnDATA.setText("DATA");
        btnDATA.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 2, new java.awt.Color(255, 255, 255)));
        btnDATA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDATAActionPerformed(evt);
            }
        });
        jPanel2.add(btnDATA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 330, 100));

        txtPort.setBackground(new java.awt.Color(54, 33, 89));
        txtPort.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        txtPort.setForeground(new java.awt.Color(255, 255, 255));
        txtPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPort.setText("1234");
        txtPort.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 100, 30));

        btnCLIENT.setBackground(new java.awt.Color(204, 204, 255));
        btnCLIENT.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        btnCLIENT.setForeground(new java.awt.Color(54, 33, 89));
        btnCLIENT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_image/customer.png"))); // NOI18N
        btnCLIENT.setText("CLIENTS");
        btnCLIENT.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 2, new java.awt.Color(255, 255, 255)));
        btnCLIENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLIENTActionPerformed(evt);
            }
        });
        jPanel2.add(btnCLIENT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 330, 100));

        btnShowNV.setBackground(new java.awt.Color(54, 33, 89));
        btnShowNV.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnShowNV.setForeground(new java.awt.Color(255, 255, 255));
        btnShowNV.setText("Nhân viên");
        btnShowNV.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), null));
        btnShowNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowNVActionPerformed(evt);
            }
        });
        jPanel2.add(btnShowNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 330, 60));

        btnShowSP.setBackground(new java.awt.Color(54, 33, 89));
        btnShowSP.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnShowSP.setForeground(new java.awt.Color(255, 255, 255));
        btnShowSP.setText("Sản phẩm");
        btnShowSP.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), null));
        btnShowSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowSPActionPerformed(evt);
            }
        });
        jPanel2.add(btnShowSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 330, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 820));

        panelContainer.setBackground(new java.awt.Color(204, 204, 255));
        panelContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelListEmployee.setBackground(new java.awt.Color(204, 204, 255));
        panelListEmployee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableNV.setForeground(new java.awt.Color(54, 33, 89));
        TableNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã NV", "Họ và tên", "Chức vụ", "Ngày sinh", "Giới tính", "Địa chỉ", "Email", "Lương"
            }
        ));
        TableNV.setGridColor(new java.awt.Color(204, 204, 255));
        TableNV.setSelectionBackground(new java.awt.Color(204, 204, 255));
        TableNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableNV);
        if (TableNV.getColumnModel().getColumnCount() > 0) {
            TableNV.getColumnModel().getColumn(0).setPreferredWidth(15);
            TableNV.getColumnModel().getColumn(1).setPreferredWidth(30);
            TableNV.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableNV.getColumnModel().getColumn(3).setPreferredWidth(70);
            TableNV.getColumnModel().getColumn(4).setPreferredWidth(50);
            TableNV.getColumnModel().getColumn(6).setPreferredWidth(50);
            TableNV.getColumnModel().getColumn(7).setPreferredWidth(100);
            TableNV.getColumnModel().getColumn(8).setPreferredWidth(30);
        }

        panelListEmployee.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 1090, 560));

        jPanelThongtinnhanvien.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThongtinnhanvien.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true), "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 18), new java.awt.Color(54, 33, 89))); // NOI18N
        jPanelThongtinnhanvien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mã.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mã.setForeground(new java.awt.Color(54, 33, 89));
        mã.setText("Mã nhân viên:");
        jPanelThongtinnhanvien.add(mã, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 50));

        txtMa.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtMa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 210, 30));

        txtTen.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtTen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 210, 30));

        ten.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ten.setForeground(new java.awt.Color(54, 33, 89));
        ten.setText("Họ và tên");
        jPanelThongtinnhanvien.add(ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 110, 50));

        gioitinh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        gioitinh.setForeground(new java.awt.Color(54, 33, 89));
        gioitinh.setText("Giới tính");
        jPanelThongtinnhanvien.add(gioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 110, 50));

        cv.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cv.setForeground(new java.awt.Color(54, 33, 89));
        cv.setText("Chức vụ");
        jPanelThongtinnhanvien.add(cv, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 110, 50));

        txtDiachi.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtDiachi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtDiachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 210, 30));

        date.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        date.setForeground(new java.awt.Color(54, 33, 89));
        date.setText("Ngày sinh");
        jPanelThongtinnhanvien.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 110, 50));

        diachi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        diachi.setForeground(new java.awt.Color(54, 33, 89));
        diachi.setText("Địa chỉ");
        jPanelThongtinnhanvien.add(diachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 110, 50));

        txtLuong.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtLuong.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 210, 30));

        txtEmail.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanelThongtinnhanvien.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 210, 30));

        email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        email.setForeground(new java.awt.Color(54, 33, 89));
        email.setText("Email");
        jPanelThongtinnhanvien.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 110, 50));

        lương.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lương.setForeground(new java.awt.Color(54, 33, 89));
        lương.setText("Lương");
        jPanelThongtinnhanvien.add(lương, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 110, 50));

        rdNam.setText("Nam");
        jPanelThongtinnhanvien.add(rdNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        rdNu.setText("Nữ");
        jPanelThongtinnhanvien.add(rdNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        cbbChucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(BH) Bán Hàng", "(BV) Bảo Vệ", "(QL) Quản Lý" }));
        cbbChucvu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanelThongtinnhanvien.add(cbbChucvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 210, 30));
        jPanelThongtinnhanvien.add(jDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 210, 40));

        panelListEmployee.add(jPanelThongtinnhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1090, 230));

        panelContainer.add(panelListEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 820));

        panelStatusClient.setBackground(new java.awt.Color(255, 255, 255));
        panelStatusClient.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListClient.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true), "Danh sách online", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(54, 33, 89))); // NOI18N
        jScrollPane4.setViewportView(ListClient);

        panelStatusClient.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 250, 310));

        TableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Username", "Block"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(TableClient);
        if (TableClient.getColumnModel().getColumnCount() > 0) {
            TableClient.getColumnModel().getColumn(0).setPreferredWidth(10);
            TableClient.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        panelStatusClient.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 790, 240));

        txtSearchClient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));
        txtSearchClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchClientActionPerformed(evt);
            }
        });
        panelStatusClient.add(txtSearchClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 40));

        btnSearchClient.setBackground(new java.awt.Color(54, 33, 89));
        btnSearchClient.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSearchClient.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchClient.setText("Search");
        btnSearchClient.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnSearchClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchClientActionPerformed(evt);
            }
        });
        panelStatusClient.add(btnSearchClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 90, 40));

        btnBlock.setBackground(new java.awt.Color(54, 33, 89));
        btnBlock.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBlock.setForeground(new java.awt.Color(255, 255, 255));
        btnBlock.setText("Block");
        btnBlock.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlockActionPerformed(evt);
            }
        });
        panelStatusClient.add(btnBlock, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 100, 40));

        TableLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Người chỉnh sửa", "Bảng", "Hành động", "Mã bản ghi", "Thời gian"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TableLog);
        if (TableLog.getColumnModel().getColumnCount() > 0) {
            TableLog.getColumnModel().getColumn(0).setPreferredWidth(10);
            TableLog.getColumnModel().getColumn(3).setPreferredWidth(150);
            TableLog.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        panelStatusClient.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 1060, 460));

        panelContainer.add(panelStatusClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 820));

        panelListProduct.setBackground(new java.awt.Color(204, 204, 255));

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true), "Dữ liệu bảng chi tiết sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(54, 33, 89))); // NOI18N

        TableSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã loại", "Tên loại", "Mô tả"
            }
        ));
        jScrollPane6.setViewportView(TableSPCT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi tiết sản phẩm", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true), "Dữ liệu bảng thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(54, 33, 89))); // NOI18N

        TableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Tên loại", "Số lượng ", "Giá"
            }
        ));
        TableSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSPMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TableSP);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jTabbedPane1.addTab("Thông tin sản phẩm", jPanel4);

        javax.swing.GroupLayout panelListProductLayout = new javax.swing.GroupLayout(panelListProduct);
        panelListProduct.setLayout(panelListProductLayout);
        panelListProductLayout.setHorizontalGroup(
            panelListProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        panelListProductLayout.setVerticalGroup(
            panelListProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListProductLayout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        panelContainer.add(panelListProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 820));

        jPanel1.add(panelContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 1110, 820));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 //Kết nối socket

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        modelList.addElement("Server connecting ...");
        ListClient.setModel(modelList);
        try {
            sv = new SVSocket();

            modelList.addElement("Server has successfully connected");
            ListClient.setModel(modelList);
        } catch (Exception e) {
        }
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (sv.Modelclient) {
                    sv.Modelclient = false;
                    updateListModelClient(sv.ClientStr);
                }
                if (sv.TableNV) {
                    sv.TableNV = false;
                    showTableNV();
                }
                if (sv.TableSP) {
                    sv.TableSP = false;
                    showTableSP();
                }
                if (sv.TableSPCT) {
                    sv.TableSPCT = false;
                    showTableSPCT();
                }
                if (sv.TableClient){
                    sv.TableClient = false;
                    showTableClient(clients);
                }
            }
        });// Bắt đầu timer
        timer.start();
        btnStart.setEnabled(false);
    }//GEN-LAST:event_btnStartActionPerformed

//Menu Button
    private void btnDATAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDATAActionPerformed
        // TODO add your handling code here:
        btnShowSP.setVisible(true);
        btnShowNV.setVisible(true);

        //btnStatusClient.setVisible(false);
    }//GEN-LAST:event_btnDATAActionPerformed

    private void btnCLIENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLIENTActionPerformed
        // TODO add your handling code here:
//        btnStatusClient.setVisible(true);
//        btnShowNV.setVisible(false);
//        btnShowSP.setVisible(false);
        panelStatusClient.setVisible(true);
        panelListEmployee.setVisible(false);
        panelListProduct.setVisible(false);
        //đưa dữ liệu lên bảng
        this.setLocationRelativeTo(null);
//      model = (DefaultTableModel)TableClient.getModel();
        showTableClient(new BLL_Client().getListClients());
        showTableLog(new BLL_Log().getListLog());
    }//GEN-LAST:event_btnCLIENTActionPerformed

    private void btnShowNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowNVActionPerformed

        // hiện panelData
        panelStatusClient.setVisible(false);
        panelListEmployee.setVisible(true);
        panelListProduct.setVisible(false);
        //đưa dữ liệu lên bảng
        this.setLocationRelativeTo(null);
        ModelTBNV = (DefaultTableModel) TableNV.getModel();
        showTableNV();
    }//GEN-LAST:event_btnShowNVActionPerformed

    private void btnShowSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowSPActionPerformed
        panelStatusClient.setVisible(false);
        panelListProduct.setVisible(true);
        panelListEmployee.setVisible(false);
        //  panelListEmployee.setVisible(false);
        this.setLocationRelativeTo(null);
        ModelTBSP = (DefaultTableModel) TableSP.getModel();
        showTableSP();
        ModelTBSPCT = (DefaultTableModel) TableSPCT.getModel();
        showTableSPCT();
    }//GEN-LAST:event_btnShowSPActionPerformed


    private void TableNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableNVMouseClicked

        selectedIndex = TableNV.getSelectedRow();
        M_Nhanvien nv = nhanvien.get(selectedIndex);
        txtMa.setText(nv.getManv());
        txtTen.setText(nv.getTennv());
        cbbChucvu.setSelectedItem(nv.getChucvu());
        jDate.setDate(nv.getDate());
        if (nv.getGt() == "Nam") {
            rdNam.setSelected(true);
            rdNu.setSelected(false);
        } else {
            rdNu.setSelected(true);
            rdNam.setSelected(false);
        }
        txtDiachi.setText(nv.getDiachi());
        txtEmail.setText(nv.getEmail());
        txtLuong.setText(Integer.toString(nv.getLuong()));

    }//GEN-LAST:event_TableNVMouseClicked

    private void TableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSPMouseClicked
//        selectedIndexSP=TableSP.getSelectedRow();
//        M_Sanpham sp=sanpham.get(selectedIndexSP);

    }//GEN-LAST:event_TableSPMouseClicked

    private void txtSearchClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchClientActionPerformed

    private void btnSearchClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchClientActionPerformed
        if (!txtSearchClient.getText().isBlank()) {
            ArrayList<M_Client> ClientS = new BLL_Client().searchClientByUN(txtSearchClient.getText());
            if (ClientS != null) {
                showTableClient(ClientS);
            }
        } else {
            showTableClient(new BLL_Client().getListClients());
            JOptionPane.showMessageDialog(null, "Mời nhập Username");
        }
    }//GEN-LAST:event_btnSearchClientActionPerformed

    private void btnBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlockActionPerformed
        // TODO add your handling code here:
        clients = new BLL_Client().getListClients();
        int selectedIndex = TableClient.getSelectedRow();
        M_Client cl = clients.get(selectedIndex);
        boolean rs = new BLL_Client().Block(cl);
        if (rs) {
            showTableClient(new BLL_Client().getListClients());
        } else {
            JOptionPane.showMessageDialog(null, "Không thực hiện được");
        }
    }//GEN-LAST:event_btnBlockActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                M_DBconnect.loadConnection();
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListClient;
    private javax.swing.JTable TableClient;
    private javax.swing.JTable TableLog;
    private javax.swing.JTable TableNV;
    private javax.swing.JTable TableSP;
    private javax.swing.JTable TableSPCT;
    private javax.swing.JButton btnBlock;
    private javax.swing.JButton btnCLIENT;
    private javax.swing.JButton btnDATA;
    private javax.swing.JButton btnSearchClient;
    private javax.swing.JButton btnShowNV;
    private javax.swing.JButton btnShowSP;
    private javax.swing.JButton btnStart;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChucvu;
    private javax.swing.JLabel cv;
    private javax.swing.JLabel date;
    private javax.swing.JLabel diachi;
    private javax.swing.JLabel email;
    private javax.swing.JLabel gioitinh;
    private javax.swing.JLabel iconHome;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelThongtinnhanvien;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lương;
    private javax.swing.JLabel mã;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JPanel panelListEmployee;
    private javax.swing.JPanel panelListProduct;
    private javax.swing.JPanel panelStatusClient;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JLabel ten;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtSearchClient;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables

    //thuộc paneldata
    private void showTableNV() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        nhanvien = new BLL.BLL_nhanvien().getListNV();
        ModelTBNV.setRowCount(0);
        for (M_Nhanvien nv : nhanvien) {
            ModelTBNV.addRow(new Object[]{
                TableNV.getRowCount() + 1, nv.getManv(), nv.getTennv(), nv.getChucvu(), sdf.format(nv.getDate()), nv.getGt(), nv.getDiachi(), nv.getEmail(), nv.getLuong()
            });
        }
        TableNV.setRowHeight(30);
        TableNV.setShowGrid(true);
        TableNV.setBackground(new Color(255, 255, 255, 255));
        TableNV.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
        TableNV.getTableHeader().setOpaque(false);
        TableNV.getTableHeader().setBackground(new Color(111, 86, 153));
        TableNV.getTableHeader().setForeground(new Color(255, 255, 255));
        TableNV.setBackground(Color.WHITE);
        Color purple = new Color(204, 204, 255);
        TableNV.setSelectionBackground(purple);
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        TableNV.setFont(font);
        JTableHeader tableHeader = TableNV.getTableHeader();
        Font headerFont = new Font("Segoe UI", Font.BOLD, 18);
        tableHeader.setFont(headerFont);
    }

    private void showTableClient(List<M_Client> client) {
        ModelTBClient.setRowCount(0);

        for (M_Client c : client) {
            ModelTBClient.addRow(new Object[]{
                TableClient.getRowCount() + 1, c.getUsername(), c.getBlock()
            });
        }
        TableClient.setRowHeight(30);
        TableClient.setShowGrid(true);
        TableClient.setBackground(new Color(255, 255, 255, 255));
        TableClient.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
        TableClient.getTableHeader().setOpaque(false);
        TableClient.getTableHeader().setBackground(new Color(111, 86, 153));
        TableClient.getTableHeader().setForeground(new Color(255, 255, 255));
        TableClient.setBackground(Color.WHITE);
        Color purple = new Color(204, 204, 255);
        TableClient.setSelectionBackground(purple);
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        TableClient.setFont(font);
        JTableHeader tableHeader = TableClient.getTableHeader();
        Font headerFont = new Font("Segoe UI", Font.BOLD, 18);
        tableHeader.setFont(headerFont);
    }

    private void showTableLog(List<M_Log> Log) {
        ModelTBLog.setRowCount(0);

        for (M_Log l : Log) {
            ModelTBLog.addRow(new Object[]{
                TableLog.getRowCount() + 1, l.getPerformer_name(), l.getTable_name(), l.getAction_type(), l.getRecord_id(), l.getChange_time()
            });
        }
        TableLog.setRowHeight(30);
        TableLog.setShowGrid(true);
        TableLog.setBackground(new Color(255, 255, 255, 255));
        TableLog.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
        TableLog.getTableHeader().setOpaque(false);
        TableLog.getTableHeader().setBackground(new Color(111, 86, 153));
        TableLog.getTableHeader().setForeground(new Color(255, 255, 255));
        TableLog.setBackground(Color.WHITE);
        Color purple = new Color(204, 204, 255);
        TableLog.setSelectionBackground(purple);
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        TableLog.setFont(font);
        JTableHeader tableHeader = TableLog.getTableHeader();
        Font headerFont = new Font("Segoe UI", Font.BOLD, 18);
        tableHeader.setFont(headerFont);
    }

    private void showTableSP() {
        sanpham = new BLL.BLL_sanpham().getListSP();
        ModelTBSP.setRowCount(0);
        for (M_Sanpham sp : sanpham) {
            ModelTBSP.addRow(new Object[]{
                TableSP.getRowCount(), sp.getMasp(), sp.getTensp(), sp.getTenloai(), sp.getSoluong(), sp.getGia()
            });
        }
        TableSP.setBackground(new Color(255, 255, 255, 255));
        TableSP.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        TableSP.getTableHeader().setOpaque(false);
        TableSP.getTableHeader().setBackground(new Color(111, 86, 153));
        TableSP.getTableHeader().setForeground(new Color(255, 255, 255));

        TableSP.setRowHeight(30);
        TableSP.setShowGrid(true);
        //TableSPCT.setGridColor(Color.BLACK);
        TableSP.setBackground(Color.WHITE);
        Color purple = new Color(204, 204, 255);
        TableSP.setSelectionBackground(purple);
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        TableSP.setFont(font);
        JTableHeader tableHeader = TableSP.getTableHeader();
        Font headerFont = new Font("Segoe UI", Font.BOLD, 16);
        tableHeader.setFont(headerFont);
    }

    private void showTableSPCT() {
        sanphamCT = new BLL.BLL_sanphamCT().getListSPCT();
        ModelTBSPCT.setRowCount(0);
        for (M_SanphamCT spct : sanphamCT) {
            ModelTBSPCT.addRow(new Object[]{
                TableSPCT.getRowCount(), spct.getMaloai(), spct.getTenloai(), spct.getMota()
            });
        }
        TableSPCT.setRowHeight(30);
        TableSPCT.setShowGrid(true);
        TableSPCT.setBackground(new Color(255, 255, 255, 255));
        TableSPCT.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        TableSPCT.getTableHeader().setOpaque(false);
        TableSPCT.getTableHeader().setBackground(new Color(111, 86, 153));
        TableSPCT.getTableHeader().setForeground(new Color(255, 255, 255));
        TableSPCT.setBackground(Color.WHITE);

        Color purple = new Color(204, 204, 255);
        TableSPCT.setSelectionBackground(purple);
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        TableSPCT.setFont(font);
        JTableHeader tableHeader = TableSPCT.getTableHeader();
        Font headerFont = new Font("Segoe UI", Font.BOLD, 18);
        tableHeader.setFont(headerFont);
    }

    public void updateListModelClient(List<M_ClientSocket> ClientOnline) {
        modelList.clear();
        for (M_ClientSocket cl : ClientOnline) {
            modelList.addElement(cl.getUsername());
        }
        ListClient.setModel(modelList);

    }

}
