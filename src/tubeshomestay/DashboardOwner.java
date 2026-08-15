package tubeshomestay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.net.URL;
import tubeshomestay.dao.KoneksiDB;


public class DashboardOwner extends JFrame {

    private static final Color WARNA_BG = new Color(243, 246, 250);
    private static final Color WARNA_PRIMARY = new Color(51, 153, 255);
    private static final Color WARNA_BORDER = new Color(224, 224, 224);
    private static final Color WARNA_SIDEBAR = new Color(24, 32, 46);

    private JTable tabelHomestay;
    private DefaultTableModel modelTabel;

    public DashboardOwner() {
        
        setTitle("Homestay Ku - Dashboard Owner");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1080, 680);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(WARNA_BG);

        add(buildHeader(), BorderLayout.NORTH);
        add(buildSidebar(), BorderLayout.WEST);
        add(buildContent(), BorderLayout.CENTER);

        muatDataTabel();
    }

    private JPanel buildHeader() {
        JPanel pnlHeader = new JPanel(new BorderLayout());
        pnlHeader.setBackground(Color.WHITE);
        pnlHeader.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, WARNA_BORDER),
                new EmptyBorder(14, 24, 14, 24)));

        JLabel lblLogo = new JLabel("Homestay Ku \u2022 Owner Panel");
        lblLogo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblLogo.setForeground(WARNA_PRIMARY);
        ImageIcon ikonLogo = muatIkon("House-logo-by-yahyaanasatokillah.jpg", 26, 26);
        if (ikonLogo != null) {
            lblLogo.setIcon(ikonLogo);
            lblLogo.setIconTextGap(8);
            lblLogo.setHorizontalTextPosition(SwingConstants.RIGHT);
        }

        JLabel lblHalo = new JLabel("Halo, " + SesiUser.getNamaUser());
        lblHalo.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        JButton btnLogout = new JButton("Keluar");
        btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnLogout.setFocusPainted(false);
        btnLogout.addActionListener(e -> logout());

        JPanel pnlKanan = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        pnlKanan.setBackground(Color.WHITE);
        pnlKanan.add(lblHalo);
        pnlKanan.add(btnLogout);

        pnlHeader.add(lblLogo, BorderLayout.WEST);
        pnlHeader.add(pnlKanan, BorderLayout.EAST);
        return pnlHeader;
    }

    /**
    
     */
    private ImageIcon muatIkon(String namaFile, int lebar, int tinggi) {
        URL url = getClass().getResource("/images/" + namaFile);
        if (url == null) {
            return null;
        }
        Image img = new ImageIcon(url).getImage().getScaledInstance(lebar, tinggi, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private JPanel buildSidebar() {
        JPanel pnlSidebar = new JPanel();
        pnlSidebar.setLayout(new BoxLayout(pnlSidebar, BoxLayout.Y_AXIS));
        pnlSidebar.setBackground(WARNA_SIDEBAR);
        pnlSidebar.setPreferredSize(new Dimension(200, 0));
        pnlSidebar.setBorder(new EmptyBorder(20, 0, 0, 0));

        JButton btnKelola = buildSidebarButton("KELOLA HOMESTAY", true);
        JButton btnLaporan = buildSidebarButton("LAPORAN BOOKING", false);
        btnLaporan.addActionListener(e -> new LaporanBooking(SesiUser.getIdUser()).setVisible(true));

        pnlSidebar.add(btnKelola);
        pnlSidebar.add(btnLaporan);
        pnlSidebar.add(Box.createVerticalGlue());

        return pnlSidebar;
    }

    private JButton buildSidebarButton(String label, boolean aktif) {
        JButton btn = new JButton(label);
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setMaximumSize(new Dimension(200, 46));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBackground(aktif ? WARNA_PRIMARY : WARNA_SIDEBAR);
        btn.setForeground(Color.WHITE);
        btn.setBorder(new EmptyBorder(0, 20, 0, 0));
        return btn;
    }

    private JPanel buildContent() {
        JPanel pnlContent = new JPanel(new BorderLayout());
        pnlContent.setBackground(WARNA_BG);
        pnlContent.setBorder(new EmptyBorder(20, 24, 20, 24));

        JLabel lblJudul = new JLabel("Kelola Homestay");
        lblJudul.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblJudul.setBorder(new EmptyBorder(0, 0, 12, 0));

        pnlContent.add(lblJudul, BorderLayout.NORTH);
        pnlContent.add(buildTablePanel(), BorderLayout.CENTER);
        pnlContent.add(buildToolbar(), BorderLayout.SOUTH);

        return pnlContent;
    }

    private JScrollPane buildTablePanel() {
        String[] kolom = {"ID", "Nama Homestay", "Kategori", "Lokasi", "Harga/Malam", "Rating", "Kamar"};
        modelTabel = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelHomestay = new JTable(modelTabel);
        tabelHomestay.setRowHeight(28);
        tabelHomestay.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tabelHomestay.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabelHomestay.setSelectionBackground(new Color(220, 235, 255));

        JScrollPane scroll = new JScrollPane(tabelHomestay);
        scroll.setBorder(BorderFactory.createLineBorder(WARNA_BORDER));
        return scroll;
    }

    private JPanel buildToolbar() {
        JPanel pnlToolbar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 12));
        pnlToolbar.setBackground(WARNA_BG);

        JButton btnTambah = buildToolbarButton("+ Tambah", WARNA_PRIMARY);
        btnTambah.addActionListener(e -> bukaFormTambah());

        JButton btnEdit = buildToolbarButton("Edit", new Color(255, 149, 0));
        btnEdit.addActionListener(e -> bukaFormEdit());

        JButton btnHapus = buildToolbarButton("Hapus", new Color(220, 53, 69));
        btnHapus.addActionListener(e -> hapusHomestay());

        JButton btnRefresh = buildToolbarButton("Refresh", new Color(108, 117, 125));
        btnRefresh.addActionListener(e -> muatDataTabel());

        pnlToolbar.add(btnTambah);
        pnlToolbar.add(btnEdit);
        pnlToolbar.add(btnHapus);
        pnlToolbar.add(btnRefresh);
        return pnlToolbar;
    }

    private JButton buildToolbarButton(String label, Color warna) {
        JButton btn = new JButton(label);
        btn.setBackground(warna);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(110, 34));
        return btn;
    }

private void muatDataTabel() {
    modelTabel.setRowCount(0);
    int idOwner = SesiUser.getIdUser(); // Sesuaikan jika nama kelas/method sesi kamu berbeda

    NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
    rupiah.setMaximumFractionDigits(0);

    String sql = "SELECT * FROM homestay WHERE owner_id = ?";

    try (java.sql.Connection conn = KoneksiDB.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idOwner);
        java.sql.ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nama = rs.getString("nama_homestay"); 
            String kategori = rs.getString("kategori"); // Membaca kolom kategori yang baru ditambahkan
            String alamat = rs.getString("alamat");        
            double harga = rs.getDouble("harga_per_malam"); 
            String status = rs.getString("status");      

            modelTabel.addRow(new Object[]{
                id,                  
                nama,                
                (kategori != null && !kategori.isEmpty()) ? kategori : "-", // Menampilkan kategori di tabel GUI
                alamat,              
                rupiah.format(harga),
                "-",                 // Rating
                status               
            });
        }

    } catch (java.sql.SQLException e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Gagal memuat data dari database: " + e.getMessage(), 
            "Error Database", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}
private void bukaFormEdit() {
    int row = tabelHomestay.getSelectedRow();
    if (row < 0) {
        JOptionPane.showMessageDialog(this, "Pilih data homestay yang ingin diedit terlebih dahulu.");
        return;
    }
    
    int idHomestay = (int) modelTabel.getValueAt(row, 0);

    
    HomestayItem h = null;
    String sql = "SELECT * FROM homestay WHERE id = ?";
    
    try (java.sql.Connection conn = KoneksiDB.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setInt(1, idHomestay);
        java.sql.ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            
           h = new HomestayItem(
    rs.getInt("id"),
    rs.getInt("owner_id"),                 
    rs.getString("nama_homestay"),         
    "Umum",                                 
    rs.getDouble("harga_per_malam"),        
    rs.getString("alamat"),               
    rs.getString("status"),             
    ""                                    
);
        }
    } catch (java.sql.SQLException e) {
        e.printStackTrace();
    }

    if (h == null) {
        JOptionPane.showMessageDialog(this, "Data tidak ditemukan di database.");
        return;
    }

    int idOwner = SesiUser.getIdUser();
    FormKelolaHomestay dialog = new FormKelolaHomestay(this, idOwner, h);
    dialog.setVisible(true);
    muatDataTabel();
}

private void hapusHomestay() {
    int row = tabelHomestay.getSelectedRow();
    if (row < 0) {
        JOptionPane.showMessageDialog(this, "Pilih data homestay yang ingin dihapus terlebih dahulu.");
        return;
    }
    
    int idHomestay = (int) modelTabel.getValueAt(row, 0);
    String nama = (String) modelTabel.getValueAt(row, 1);

    int pilihan = JOptionPane.showConfirmDialog(this,
            "Yakin ingin menghapus \"" + nama + "\"?",
            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

    if (pilihan == JOptionPane.YES_OPTION) {
        
        String sql = "DELETE FROM homestay WHERE id = ?";
        
        try (java.sql.Connection conn = KoneksiDB.getConnection();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idHomestay);
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus dari database.");
                muatDataTabel();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data dari database.");
            }
            
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saat menghapus data: " + e.getMessage());
        }
    }
}

    private void logout() {
        int pilihan = JOptionPane.showConfirmDialog(this,
                "Yakin ingin keluar dari akun Anda?", "Konfirmasi Keluar",
                JOptionPane.YES_NO_OPTION);
        if (pilihan == JOptionPane.YES_OPTION) {
            SesiUser.logout();
            new FromLogin().setVisible(true);
            this.dispose();
        }
    }
    public void tampilkanData(){
        
    }
    private void bukaFormTambah() {
    int idOwner = SesiUser.getIdUser();
    
    // Membuka form tambah dengan parameter data homestay 'null' (karena data baru)
    FormKelolaHomestay dialog = new FormKelolaHomestay(this, idOwner, null);
    dialog.setVisible(true);
    
    // Refresh tabel setelah form dikembalikan/ditutup
    muatDataTabel();
}
   
}
