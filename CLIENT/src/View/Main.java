package View;


import BLL.*;
import DTO.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Main extends javax.swing.JFrame {
    
    private List<M_Nhanvien> nhanvien  ;
    private List<M_Sanpham> sanpham;
    private List<M_SanphamCT> sanphamCT;
    
    
    private DefaultTableModel ModelNV;
    private DefaultTableModel ModelSP;
    private DefaultTableModel ModelSPCT;
    
        // đối tượng để gọi về BLL
    private BLL_nhanvien BLLnv;    
    private BLL_sanpham BLLsp;
    private BLL_sanphamCt BLLspct;

        private Timer timer;
        private CSocket soc ;
    public Main() {
        initComponents();
        Show();
        init();
    }

    public Main(CSocket socket) {
        this.soc = socket;
        this.BLLnv = new BLL_nhanvien(soc);        
        this.BLLsp = new BLL_sanpham(soc);
        this.BLLspct = new BLL_sanphamCt(soc);

        initComponents();
        Show();
        init();
                
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(soc.Main){
                    soc.Main = false;
                    if(soc.TableNV){
                        soc.TableNV=false;
                        ShowNVTable(BLLnv.getListNV());
                    }
                    else if(soc.TableSP){
                        soc.TableSP=false;
                        ShowSPTable(BLLsp.getListSP());
                    }
                    else if(soc.TableSPCT){
                        soc.TableSPCT=false;
                        ShowSPCTTable(BLLspct.getListSPCT());
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Sai Username hoạc Password bạn cần nhập lại");
                    }
                }
                
            }
        });// Bắt đầu timer
        timer.start();
    }

     public void Show(){
        panelNhanvien.setVisible(true);
        panelDonhang.setVisible(false);
        pnSanpham.setVisible(false);
    }
     private void init(){

        ShowNVTable(BLLnv.getListNV());
        ShowSPTable(BLLsp.getListSP());
        ShowSPCTTable(BLLspct.getListSPCT());
        nhanvien = BLLnv.getListNV();
        sanpham=BLLsp.getListSP();
        sanphamCT=BLLspct.getListSPCT();
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        sidepanel = new javax.swing.JPanel();
        btnNhanvien = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnSanpham = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnDonhang = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnĐangxuat = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        panelContainer = new javax.swing.JPanel();
        panelNhanvien = new javax.swing.JPanel();
        pnThongTin = new javax.swing.JPanel();
        btShow = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableNhanVien = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        pnSanpham = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableSPCT = new javax.swing.JTable();
        btUpdateCT = new javax.swing.JButton();
        btAddCT = new javax.swing.JButton();
        btDelCT = new javax.swing.JButton();
        txtSearchCT = new javax.swing.JTextField();
        btnFindCT = new javax.swing.JButton();
        btResetSP1 = new javax.swing.JButton();
        PanelTTSp = new javax.swing.JPanel();
        btUpdateSP = new javax.swing.JButton();
        btDelSP = new javax.swing.JButton();
        btResetSP = new javax.swing.JButton();
        btAddSP = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableSP = new javax.swing.JTable();
        btnFindSP = new javax.swing.JButton();
        txtSearchSP = new javax.swing.JTextField();
        panelDonhang = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtTenkh = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTensp = new javax.swing.JTextField();
        txtMasp = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        comboboxLoai = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCTSP = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableSP22 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableHoadon = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnaddSp = new javax.swing.JButton();
        btnaddHD = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepanel.setBackground(new java.awt.Color(54, 33, 89));
        sidepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNhanvien.setBackground(new java.awt.Color(85, 65, 118));
        btnNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhanvienMouseClicked(evt);
            }
        });
        btnNhanvien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NHÂN VIÊN");
        btnNhanvien.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 150, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/employee.png"))); // NOI18N
        btnNhanvien.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 60));

        sidepanel.add(btnNhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 260, 90));

        btnSanpham.setBackground(new java.awt.Color(85, 65, 118));
        btnSanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSanphamMouseClicked(evt);
            }
        });
        btnSanpham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("SẢN PHẨM");
        btnSanpham.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 140, -1));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/gift.png"))); // NOI18N
        btnSanpham.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 70));

        sidepanel.add(btnSanpham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 260, 80));

        btnDonhang.setBackground(new java.awt.Color(85, 65, 118));
        btnDonhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDonhangMouseClicked(evt);
            }
        });
        btnDonhang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ĐƠN HÀNG");
        btnDonhang.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 150, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clipboard.png"))); // NOI18N
        btnDonhang.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 60));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clipboard.png"))); // NOI18N
        btnDonhang.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 60));

        sidepanel.add(btnDonhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 260, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PORT:");
        sidepanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 60, 30));

        txtPort.setEditable(false);
        txtPort.setBackground(new java.awt.Color(54, 33, 89));
        txtPort.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPort.setForeground(new java.awt.Color(255, 255, 255));
        txtPort.setText("     1234");
        txtPort.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        sidepanel.add(txtPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 110, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/client (1).png"))); // NOI18N
        sidepanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 120, 130));

        btnĐangxuat.setBackground(new java.awt.Color(85, 65, 118));
        btnĐangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnĐangxuatMouseClicked(evt);
            }
        });
        btnĐangxuat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("ĐĂNG XUẤT");
        btnĐangxuat.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 150, -1));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logout (1).png"))); // NOI18N
        btnĐangxuat.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 60));

        sidepanel.add(btnĐangxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 260, 80));

        jPanel3.add(sidepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 800));

        panelContainer.setBackground(new java.awt.Color(204, 204, 255));
        panelContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelNhanvien.setBackground(new java.awt.Color(204, 204, 255));
        panelNhanvien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnThongTin.setBackground(new java.awt.Color(204, 204, 255));
        pnThongTin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true));
        pnThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btShow.setBackground(new java.awt.Color(54, 33, 89));
        btShow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btShow.setForeground(new java.awt.Color(255, 255, 255));
        btShow.setText("Show");
        btShow.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btShowActionPerformed(evt);
            }
        });
        pnThongTin.add(btShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 100, 40));

        btnAdd.setBackground(new java.awt.Color(54, 33, 89));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("THÊM");
        btnAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnThongTin.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 100, 40));

        btUpdate.setBackground(new java.awt.Color(54, 33, 89));
        btUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btUpdate.setText("SỬA");
        btUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });
        pnThongTin.add(btUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 100, 40));

        btnFind.setBackground(new java.awt.Color(54, 33, 89));
        btnFind.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFind.setForeground(new java.awt.Color(255, 255, 255));
        btnFind.setText("TÌM KIẾM");
        btnFind.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        pnThongTin.add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 110, 40));

        btnDelete.setBackground(new java.awt.Color(54, 33, 89));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("XÓA");
        btnDelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnThongTin.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 30, 100, 40));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        TableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã nhân viên", "Họ tên", "Chức vụ", "Ngày sinh", "Giới tính", "Địa chỉ", "Email", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableNhanVien);

        pnThongTin.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1180, 660));

        txtSearch.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        pnThongTin.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 390, 40));

        panelNhanvien.add(pnThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 770));

        panelContainer.add(panelNhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 1450));

        pnSanpham.setBackground(new java.awt.Color(204, 204, 255));
        pnSanpham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã loại", "Tên loại ", "Mô tả"
            }
        ));
        TableSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSPCTMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TableSPCT);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1170, 610));

        btUpdateCT.setBackground(new java.awt.Color(54, 33, 89));
        btUpdateCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btUpdateCT.setForeground(new java.awt.Color(255, 255, 255));
        btUpdateCT.setText("SỬA");
        btUpdateCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateCTActionPerformed(evt);
            }
        });
        jPanel1.add(btUpdateCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 110, 44));

        btAddCT.setBackground(new java.awt.Color(54, 33, 89));
        btAddCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btAddCT.setForeground(new java.awt.Color(255, 255, 255));
        btAddCT.setText("THÊM");
        btAddCT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btAddCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddCTActionPerformed(evt);
            }
        });
        jPanel1.add(btAddCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 110, 44));

        btDelCT.setBackground(new java.awt.Color(54, 33, 89));
        btDelCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btDelCT.setForeground(new java.awt.Color(255, 255, 255));
        btDelCT.setText("XÓA");
        btDelCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDelCTActionPerformed(evt);
            }
        });
        jPanel1.add(btDelCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 110, 44));

        txtSearchCT.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtSearchCT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        jPanel1.add(txtSearchCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 390, 40));

        btnFindCT.setBackground(new java.awt.Color(54, 33, 89));
        btnFindCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFindCT.setForeground(new java.awt.Color(255, 255, 255));
        btnFindCT.setText("TÌM KIẾM");
        btnFindCT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnFindCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCTActionPerformed(evt);
            }
        });
        jPanel1.add(btnFindCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 110, 40));

        btResetSP1.setBackground(new java.awt.Color(54, 33, 89));
        btResetSP1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btResetSP1.setForeground(new java.awt.Color(255, 255, 255));
        btResetSP1.setText("Show");
        btResetSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetSP1ActionPerformed(evt);
            }
        });
        jPanel1.add(btResetSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 106, 40));

        jTabbedPane1.addTab("Loại sản phẩm", jPanel1);

        PanelTTSp.setBackground(new java.awt.Color(204, 204, 255));
        PanelTTSp.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true), "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 24), new java.awt.Color(54, 33, 89))); // NOI18N
        PanelTTSp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btUpdateSP.setBackground(new java.awt.Color(54, 33, 89));
        btUpdateSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btUpdateSP.setForeground(new java.awt.Color(255, 255, 255));
        btUpdateSP.setText("SỬA");
        btUpdateSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateSPActionPerformed(evt);
            }
        });
        PanelTTSp.add(btUpdateSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 106, 44));

        btDelSP.setBackground(new java.awt.Color(54, 33, 89));
        btDelSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btDelSP.setForeground(new java.awt.Color(255, 255, 255));
        btDelSP.setText("XÓA");
        btDelSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDelSPActionPerformed(evt);
            }
        });
        PanelTTSp.add(btDelSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 60, 106, 44));

        btResetSP.setBackground(new java.awt.Color(54, 33, 89));
        btResetSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btResetSP.setForeground(new java.awt.Color(255, 255, 255));
        btResetSP.setText("Show");
        btResetSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetSPActionPerformed(evt);
            }
        });
        PanelTTSp.add(btResetSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 106, 40));

        btAddSP.setBackground(new java.awt.Color(54, 33, 89));
        btAddSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btAddSP.setForeground(new java.awt.Color(255, 255, 255));
        btAddSP.setText("THÊM");
        btAddSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btAddSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddSPActionPerformed(evt);
            }
        });
        PanelTTSp.add(btAddSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 114, 44));

        TableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Tên loại", "Số lượng", "Giá"
            }
        ));
        TableSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSPMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TableSP);

        PanelTTSp.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1180, 540));

        btnFindSP.setBackground(new java.awt.Color(54, 33, 89));
        btnFindSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFindSP.setForeground(new java.awt.Color(255, 255, 255));
        btnFindSP.setText("TÌM KIẾM");
        btnFindSP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnFindSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindSPActionPerformed(evt);
            }
        });
        PanelTTSp.add(btnFindSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 110, 40));

        txtSearchSP.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txtSearchSP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
        PanelTTSp.add(txtSearchSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 390, 40));

        jTabbedPane1.addTab("Sản phẩm", PanelTTSp);

        pnSanpham.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 800));

        panelContainer.add(pnSanpham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 800));

        panelDonhang.setBackground(new java.awt.Color(204, 204, 255));
        panelDonhang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Số điện thoại");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Đơn hàng");

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        txtTenkh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenkh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Địa chỉ");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Ngày đặt");

        txtDiachi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiachi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        panelDonhang.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 560, 140));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 2, true));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Tên sản phẩm");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Mã sản phẩm");

        txtTensp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTensp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        txtMasp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMasp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Loại");

        txtSoluong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoluong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Số lượng");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Giá");

        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        comboboxLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxLoai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));
        comboboxLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxLoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboboxLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTensp, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        panelDonhang.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 610, -1));

        tableCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã sản phẩm", "Số lượng", "Giá"
            }
        ));
        jScrollPane2.setViewportView(tableCTSP);

        panelDonhang.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 600, 240));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(54, 33, 89));
        jLabel24.setText("CHI TIẾT SẢN PHẨM ĐỂ BÁN");
        panelDonhang.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 250, 30));

        TableSP22.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã sản phẩm", "Tên sản phẩm", "Loại ", "Số lượng", "Giá"
            }
        ));
        TableSP22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSP22MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableSP22);

        panelDonhang.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 600, 280));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(54, 33, 89));
        jLabel25.setText("BẢNG SẢN PHẨM");
        panelDonhang.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 180, 20));

        tableHoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày đặt", "Thành tiền"
            }
        ));
        jScrollPane4.setViewportView(tableHoadon);

        panelDonhang.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 550, 280));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Mã sản phẩm");
        panelDonhang.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 690, -1, -1));

        jTextField13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));
        panelDonhang.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 690, 151, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Ngày đặt");
        panelDonhang.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 710, 70, 20));

        jTextField14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));
        panelDonhang.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 730, 151, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Tên sản phẩm");
        panelDonhang.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 730, 99, 24));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(54, 33, 89));
        jLabel36.setText("BẢNG HÓA ĐƠN");
        panelDonhang.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnaddSp.setBackground(new java.awt.Color(54, 33, 89));
        btnaddSp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnaddSp.setForeground(new java.awt.Color(255, 255, 255));
        btnaddSp.setText("THÊM SẢN PHẨM\n");

        btnaddHD.setBackground(new java.awt.Color(54, 33, 89));
        btnaddHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnaddHD.setForeground(new java.awt.Color(255, 255, 255));
        btnaddHD.setText("THÊM HÓA ĐƠN");
        btnaddHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddHDActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(54, 33, 89));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("LƯU");

        btnXoa.setBackground(new java.awt.Color(54, 33, 89));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("XÓA HÓA ĐƠN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnaddHD, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnaddSp, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaddHD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddSp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelDonhang.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 480, 120));

        panelContainer.add(panelDonhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 800));

        jPanel3.add(panelContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1210, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1482, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 66, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhanvienMouseClicked
        panelNhanvien.setVisible(true);
        panelDonhang.setVisible(false);
        pnSanpham.setVisible(false);
    }//GEN-LAST:event_btnNhanvienMouseClicked

    private void btnSanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanphamMouseClicked
        panelNhanvien.setVisible(false);
        panelDonhang.setVisible(false);
        pnSanpham.setVisible(true);

    }//GEN-LAST:event_btnSanphamMouseClicked

    private void btnDonhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDonhangMouseClicked
        panelNhanvien.setVisible(false);
        panelDonhang.setVisible(true);
        pnSanpham.setVisible(false);

    }//GEN-LAST:event_btnDonhangMouseClicked

    private void btAddCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddCTActionPerformed
        frameSPCT spObj=new frameSPCT(soc);
        spObj.show();
    }//GEN-LAST:event_btAddCTActionPerformed

    private void btUpdateCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateCTActionPerformed

        sanphamCT=new BLL_sanphamCt().getListSPCT();
        int selectedIndexspct=TableSPCT.getSelectedRow();
        if(selectedIndexspct != -1){
            M_SanphamCT spct=sanphamCT.get(selectedIndexspct);
            if(spct.isStatus()){
                soc.SendMess("Obj_Is_Changing:SPCT:"+spct.getMaloai());
                frameSPCT obj=new frameSPCT(spct,soc);
                obj.show(); 
            } else   JOptionPane.showMessageDialog(this, "Đối tượng đang được chỉnh sửa");

        }
        else{
             // Không có dòng nào được chọn
            JOptionPane.showMessageDialog(this, "Chưa chọn đối tượng để cập nhật thông tin");
        }
    }//GEN-LAST:event_btUpdateCTActionPerformed

    private void btDelCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDelCTActionPerformed
        int selectedIndexspct=TableSPCT.getSelectedRow();
        M_SanphamCT spct=sanphamCT.get(selectedIndexspct);
       if(!spct.isStatus()){
           JOptionPane.showMessageDialog(this, "Đối tượng đang được chỉnh sửa");
       }else     BLLspct.deleteSPCT(spct.getMaloai());

    }//GEN-LAST:event_btDelCTActionPerformed

    private void btUpdateSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateSPActionPerformed
        sanpham = new BLL_sanpham().getListSP();
        int selectedIndex = TableSP.getSelectedRow();
        if (selectedIndex != -1) {
            // Có dòng được chọn
            M_Sanpham sp = sanpham.get(selectedIndex);
            if(sp.isStatus()){
                soc.SendMess("Obj_Is_Changing:SP:"+sp.getMasp());
                frameSanPham spObj=new frameSanPham(sp,soc);
                spObj.show();    
            }
            else {JOptionPane.showMessageDialog(this, "Đối tượng đang được chỉnh sửa");}
        } else {
            // Không có dòng nào được chọn
            JOptionPane.showMessageDialog(this, "Chưa chọn đối tượng để cập nhật thông tin");
        }

    }//GEN-LAST:event_btUpdateSPActionPerformed

    private void btDelSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDelSPActionPerformed
       int selectedIndexsp = TableSP.getSelectedRow();
       M_Sanpham sp = sanpham.get(selectedIndexsp);
              if(!sp.isStatus()){
           JOptionPane.showMessageDialog(this, "Đối tượng đang được chỉnh sửa");
       }else 
       BLLsp.deleteSP(sp.getMasp());
    }//GEN-LAST:event_btDelSPActionPerformed

    private void btResetSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetSPActionPerformed
        ShowSPTable(sanpham);
    }//GEN-LAST:event_btResetSPActionPerformed

    private void btAddSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddSPActionPerformed
        frameSanPham spObj=new frameSanPham(soc);
        spObj.show();
    }//GEN-LAST:event_btAddSPActionPerformed

    private void TableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSPMouseClicked

    }//GEN-LAST:event_TableSPMouseClicked

    private void comboboxLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxLoaiActionPerformed

    private void btnaddHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddHDActionPerformed

    }//GEN-LAST:event_btnaddHDActionPerformed

    private void btShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btShowActionPerformed
        ShowNVTable(nhanvien);
    }//GEN-LAST:event_btShowActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        frameNhanVien nvObj=new frameNhanVien(soc);
        nvObj.show();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        nhanvien = new BLL_nhanvien().getListNV();
        int selectedIndex = TableNhanVien.getSelectedRow();
        if (selectedIndex != -1) {
            // Có dòng được chọn
            M_Nhanvien nv = nhanvien.get(selectedIndex);
            if(nv.isStatus()){
                soc.SendMess("Obj_Is_Changing:NV:"+nv.getId());
                frameNhanVien nvObj=new frameNhanVien(nv,soc);
                nvObj.show();
            }
            else   JOptionPane.showMessageDialog(this, "Đối tượng đang được chỉnh sửa");

        } else {
            // Không có dòng nào được chọn
            JOptionPane.showMessageDialog(this, "Chưa chọn đối tượng để cập nhật thông tin");
        }

    }//GEN-LAST:event_btUpdateActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // Đang xử lí 
            if(!txtSearch.getText().isBlank()){
            List<M_Nhanvien> ClientS  =new BLL_nhanvien().searchByName(txtSearch.getText());
            if(ClientS != null)
            ShowNVTable(ClientS);
        }
        else{
            ShowNVTable(new BLL_nhanvien().getListNV());
            JOptionPane.showMessageDialog(null, "Mời nhập Username");
        }   
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       int selectedIndex = TableNhanVien.getSelectedRow();
       M_Nhanvien nv = nhanvien.get(selectedIndex);
       if(!nv.isStatus()){
           JOptionPane.showMessageDialog(this, "Đối tượng đang được chỉnh sửa");
       }else BLLnv.deleteNV(nv.getId());
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void TableSP22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSP22MouseClicked

    }//GEN-LAST:event_TableSP22MouseClicked

    private void btnFindSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindSPActionPerformed

        if(!txtSearchSP.getText().isBlank()){
        try {    
            List<M_Sanpham> sp  = new BLL_sanpham().searchByName(txtSearchSP.getText());
                if(sp != null)
                    ShowSPTable(sp);
        
                else{
                    ShowSPTable(new BLL_sanpham().getListSP());
                    JOptionPane.showMessageDialog(this, "Mời nhập tên sản phẩm");
                }
        
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_btnFindSPActionPerformed

    private void btnĐangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnĐangxuatMouseClicked
        JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất?","Đăng xuất",JOptionPane.YES_NO_OPTION);
        this.dispose();
 
//        soc.Close();
    }//GEN-LAST:event_btnĐangxuatMouseClicked

    private void TableSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSPCTMouseClicked
//        int selectedIndexspct=TableSPCT.getSelectedRow();
//        M_SanphamCT spct=sanphamCT.get(selectedIndexspct);
//        txtMaloai.setText(spct.getMaloai()+"");
//        txtTenloai.setText(spct.getTenloai());
//        txtMota.setText(spct.getMota());
    }//GEN-LAST:event_TableSPCTMouseClicked

    private void btnFindCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCTActionPerformed
        if(!txtSearchCT.getText().isBlank()){
            try {
                List<M_SanphamCT> ct=new BLL_sanphamCt().searchByTenloai(txtSearchCT.getText());
                if(ct != null){
                    ShowSPCTTable(ct);
                }
                else{
                    ShowSPCTTable(new BLL_sanphamCt().getListSPCT());
                    JOptionPane.showMessageDialog(this, "Mời nhập tên loại");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   
         
    }//GEN-LAST:event_btnFindCTActionPerformed

    private void btResetSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetSP1ActionPerformed
        ShowSPCTTable(sanphamCT);
    }//GEN-LAST:event_btResetSP1ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTTSp;
    private javax.swing.JTable TableNhanVien;
    private javax.swing.JTable TableSP;
    private javax.swing.JTable TableSP22;
    private javax.swing.JTable TableSPCT;
    private javax.swing.JButton btAddCT;
    private javax.swing.JButton btAddSP;
    private javax.swing.JButton btDelCT;
    private javax.swing.JButton btDelSP;
    private javax.swing.JButton btResetSP;
    private javax.swing.JButton btResetSP1;
    private javax.swing.JButton btShow;
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btUpdateCT;
    private javax.swing.JButton btUpdateSP;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JPanel btnDonhang;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFindCT;
    private javax.swing.JButton btnFindSP;
    private javax.swing.JPanel btnNhanvien;
    private javax.swing.JPanel btnSanpham;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnaddHD;
    private javax.swing.JButton btnaddSp;
    private javax.swing.JPanel btnĐangxuat;
    private javax.swing.JTextField comboboxLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JPanel panelDonhang;
    private javax.swing.JPanel panelNhanvien;
    private javax.swing.JPanel pnSanpham;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JTable tableCTSP;
    private javax.swing.JTable tableHoadon;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMasp;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchCT;
    private javax.swing.JTextField txtSearchSP;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTenkh;
    private javax.swing.JTextField txtTensp;
    // End of variables declaration//GEN-END:variables

    
    // Định dạng ngày tháng
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    // ... Các phần khác của lớp của bạn

    // Hàm chuyển đổi Date thành chuỗi theo định dạng mong muốn
    private String formatDate(Date date) {
        if (date != null) {
            return DATE_FORMAT.format(date);
        }
        return ""; // hoặc giá trị mặc định tùy thuộc vào yêu cầu của bạn
    }
    private void ShowNVTable(List<M_Nhanvien> nhanvien) {
        if(nhanvien == null)
        System.out.println("View.Main.DesginNVTable()" + nhanvien);
        ModelNV=(DefaultTableModel)TableNhanVien.getModel();  //nhanvien
        ModelNV.setRowCount(0);
        for(M_Nhanvien nv:nhanvien){
            ModelNV.addRow(new Object[]{
            TableNhanVien.getRowCount()+1,nv.getManv(),nv.getTennv(),nv.getChucvu(),formatDate(nv.getDate()),nv.getGt(),nv.getDiachi(),nv.getEmail(),nv.getLuong()
        });
        }
        
        TableNhanVien.setRowHeight(30);
        TableNhanVien.setShowGrid(true);
        TableNhanVien.setBackground(new Color(255,255,255,255));
        TableNhanVien.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,18));
        TableNhanVien.getTableHeader().setOpaque(false);
        TableNhanVien.getTableHeader().setBackground(new Color(111,86,153));
        TableNhanVien.getTableHeader().setForeground(new Color(255,255,255));
        TableNhanVien.setBackground(Color.WHITE);
        Color purple = new Color(204,204,255);
        TableNhanVien.setSelectionBackground(purple);
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        TableNhanVien.setFont(font);
        JTableHeader tableHeader = TableSPCT.getTableHeader();
        Font headerFont = new Font("Segoe UI", Font.BOLD, 18);
        tableHeader.setFont(headerFont);
    }
        private void ShowSPTable(List<M_Sanpham> sanpham){
//        sanpham=BLLsp.getListSP();
        if(sanpham==null){
            System.out.println("View.Main.ShowSPTable()" + sanpham);
        }
        ModelSP=(DefaultTableModel) TableSP.getModel();
        ModelSP.setRowCount(0);
        for(M_Sanpham sp:sanpham){
            ModelSP.addRow(new Object[]{
                TableSP.getRowCount()+1,sp.getMasp(),sp.getTensp(),sp.getTenloai(),sp.getSoluong(),sp.getGia()
            });
        }
        TableSP.setRowHeight(30);
        TableSP.setShowGrid(true);
        TableSP.setBackground(new Color(255,255,255,255));
        TableSP.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,18));
        TableSP.getTableHeader().setOpaque(false);
        TableSP.getTableHeader().setBackground(new Color(111,86,153));
        TableSP.getTableHeader().setForeground(new Color(255,255,255));
        TableSP.setBackground(Color.WHITE);
        Color purple = new Color(204,204,255);
        TableSP.setSelectionBackground(purple);
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        TableSP.setFont(font);
        JTableHeader tableHeader = TableSP.getTableHeader();
        Font headerFont = new Font("Segoe UI", Font.BOLD, 18);
        tableHeader.setFont(headerFont);
    }
    private void ShowSPCTTable(List<M_SanphamCT> sanphamCT){
//        sanphamCT=BLLspct.getListSPCT();
        if(sanphamCT==null){
            System.out.println("View.Main.ShowSPCTTable()" + sanphamCT);
        }
        ModelSPCT=(DefaultTableModel) TableSPCT.getModel();
        
        ModelSPCT.setRowCount(0);
        for(M_SanphamCT spct:sanphamCT){
            ModelSPCT.addRow(new Object[]{
                TableSPCT.getRowCount()+1,spct.getMaloai(),spct.getTenloai(),spct.getMota()
            });
        }
        TableSPCT.setRowHeight(30);
        TableSPCT.setShowGrid(true);
        TableSPCT.setBackground(new Color(255,255,255,255));
        TableSPCT.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,18));
        TableSPCT.getTableHeader().setOpaque(false);
        TableSPCT.getTableHeader().setBackground(new Color(111,86,153));
        TableSPCT.getTableHeader().setForeground(new Color(255,255,255));
        TableSPCT.setBackground(Color.WHITE);
        Color purple = new Color(204,204,255);
        TableSPCT.setSelectionBackground(purple);
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        TableSPCT.setFont(font);
        JTableHeader tableHeader = TableSPCT.getTableHeader();
        Font headerFont = new Font("Segoe UI", Font.BOLD, 18);
        tableHeader.setFont(headerFont);
    }
    
}
