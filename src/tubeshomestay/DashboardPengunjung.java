package tubeshomestay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import tubeshomestay.dao.KoneksiDB;

public class DashboardPengunjung extends JFrame {

    private static final Color WARNA_BG = new Color(243, 246, 250);
    private static final Color WARNA_PRIMARY = new Color(51, 153, 255);
    private static final Color WARNA_BORDER = new Color(224, 224, 224);

    private final List<JButton> tombolFilterKategori = new ArrayList<>();

    private JTextField txtSearch;
    private JPanel pnlGridHomestay;
    private String kategoriAktif = "SEMUA";

    public DashboardPengunjung() {
        setTitle("Homestay Ku - Dashboard Pengunjung");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 680);
        setLocationRelativeTo(null);
        getContentPane().setBackground(WARNA_BG);
        setLayout(new BorderLayout());

        add(buildHeader(), BorderLayout.NORTH);
        add(buildContent(), BorderLayout.CENTER);

        muatDataHomestay();
    }

    private JPanel buildHeader() {
        JPanel pnlHeader = new JPanel(new BorderLayout());
        pnlHeader.setBackground(Color.WHITE);
        pnlHeader.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, WARNA_BORDER),
                new EmptyBorder(14, 24, 14, 24)));

        JLabel lblLogo = buatLabelLogo("Homestay Ku", new Font("Tahoma", Font.BOLD, 20));
        lblLogo.setForeground(WARNA_PRIMARY);

        txtSearch = new JTextField();
        txtSearch.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtSearch.setPreferredSize(new Dimension(320, 34));
        txtSearch.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(WARNA_BORDER),
                new EmptyBorder(4, 10, 4, 10)));
        txtSearch.addActionListener(e -> muatDataHomestay());

        JButton btnCari = new JButton("Cari");
        btnCari.setBackground(WARNA_PRIMARY);
        btnCari.setForeground(Color.WHITE);
        btnCari.setFocusPainted(false);
        btnCari.setBorderPainted(false);
        btnCari.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCari.addActionListener(e -> muatDataHomestay());

        JPanel pnlSearch = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        pnlSearch.setBackground(Color.WHITE);
        pnlSearch.add(txtSearch);
        pnlSearch.add(btnCari);

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
        pnlHeader.add(pnlSearch, BorderLayout.CENTER);
        pnlHeader.add(pnlKanan, BorderLayout.EAST);

        return pnlHeader;
    }

    private JLabel buatLabelLogo(String teks, Font font) {
        JLabel lbl = new JLabel(teks);
        lbl.setFont(font);
        ImageIcon icon = muatIkonLogo(28, 28);
        if (icon != null) {
            lbl.setIcon(icon);
            lbl.setIconTextGap(8);
            lbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        }
        return lbl;
    }

    private ImageIcon muatIkonLogo(int lebar, int tinggi) {
        URL url = getClass().getResource("/images/House-logo-by-yahyaanasatokillah.jpg");
        if (url == null) {
            return null;
        }
        Image img = new ImageIcon(url).getImage().getScaledInstance(lebar, tinggi, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

   private JPanel buildContent() {
    JPanel pnlContent = new JPanel(new BorderLayout());
    pnlContent.setBackground(WARNA_BG);
    pnlContent.setBorder(new EmptyBorder(16, 24, 24, 24));

     pnlContent.add(buildFilterBar(), BorderLayout.NORTH);

    
    pnlGridHomestay = new JPanel(new GridLayout(0, 3, 16, 16));
    pnlGridHomestay.setBackground(WARNA_BG);

    
    JPanel pnlWrapper = new JPanel(new BorderLayout());
    pnlWrapper.setBackground(WARNA_BG);
    pnlWrapper.add(pnlGridHomestay, BorderLayout.NORTH);

    JScrollPane scroll = new JScrollPane(pnlWrapper);
    scroll.setBorder(null);
    scroll.getVerticalScrollBar().setUnitIncrement(16);
    scroll.setBackground(WARNA_BG);
    scroll.getViewport().setBackground(WARNA_BG);
    
    pnlContent.add(scroll, BorderLayout.CENTER);

    return pnlContent;
}

    private JPanel buildFilterBar() {
        JPanel pnlFilter = new JPanel(new BorderLayout());
        pnlFilter.setBackground(WARNA_BG);
        pnlFilter.setBorder(new EmptyBorder(0, 0, 16, 0));

        JPanel pnlKategori = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        pnlKategori.setBackground(WARNA_BG);
        tombolFilterKategori.clear();
        pnlKategori.add(buildFilterButton("Semua", "SEMUA"));
        pnlKategori.add(buildFilterButton("VIP", "VIP"));
        pnlKategori.add(buildFilterButton("Deluxe", "DELUXE"));
        pnlKategori.add(buildFilterButton("Standard", "STANDARD"));

        JLabel lblFasilitasInfo = new JLabel("Fasilitas tersedia: AC \u2022 WiFi \u2022 Water Heater");
        lblFasilitasInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblFasilitasInfo.setForeground(new Color(120, 128, 140));

        JPanel pnlBawah = new JPanel(new BorderLayout());
        pnlBawah.setBackground(WARNA_BG);
        pnlBawah.setBorder(new EmptyBorder(8, 0, 0, 0));
        pnlBawah.add(lblFasilitasInfo, BorderLayout.WEST);

        pnlFilter.add(pnlKategori, BorderLayout.NORTH);
        pnlFilter.add(pnlBawah, BorderLayout.CENTER);
        return pnlFilter;
    }

    private JButton buildFilterButton(String label, String kategori) {
        JButton btn = new JButton(label);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.putClientProperty("kategori", kategori);
        styleFilterButton(btn, kategori.equals(kategoriAktif));
        btn.addActionListener(e -> {
            kategoriAktif = kategori;
            muatDataHomestay();
        });
        tombolFilterKategori.add(btn);
        return btn;
    }

    private void styleFilterButton(JButton btn, boolean aktif) {
        if (aktif) {
            btn.setBackground(WARNA_PRIMARY);
            btn.setForeground(Color.WHITE);
            btn.setBorderPainted(false);
        } else {
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.DARK_GRAY);
            btn.setBorder(BorderFactory.createLineBorder(WARNA_BORDER));
        }
    }

    private void muatDataHomestay() {
        for (JButton btn : tombolFilterKategori) {
            String kategoriTombol = (String) btn.getClientProperty("kategori");
            styleFilterButton(btn, kategoriTombol.equals(kategoriAktif));
        }

        pnlGridHomestay.removeAll();
        String keyword = txtSearch != null ? txtSearch.getText().trim() : "";

        List<HomestayItem> daftar = new ArrayList<>();

        // 1. TAMBAHKAN FILTER KATEGORI DI QUERY SQL
        StringBuilder sql = new StringBuilder("SELECT * FROM homestay WHERE status = 'tersedia'");

        if (!kategoriAktif.equals("SEMUA")) {
            sql.append(" AND UPPER(kategori) = ?");
        }
        if (!keyword.isEmpty()) {
            sql.append(" AND nama_homestay LIKE ?");
        }

        try (java.sql.Connection conn = KoneksiDB.getConnection();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            int paramIndex = 1;
            if (!kategoriAktif.equals("SEMUA")) {
                ps.setString(paramIndex++, kategoriAktif.toUpperCase());
            }
            if (!keyword.isEmpty()) {
                ps.setString(paramIndex, "%" + keyword + "%");
            }

            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int ownerId = rs.getInt("owner_id");
                String nama = rs.getString("nama_homestay");
                String kategori = rs.getString("kategori"); // Membaca kolom kategori
                String lokasi = rs.getString("alamat");
                double harga = rs.getDouble("harga_per_malam");
                String status = rs.getString("status");
                String gambar = rs.getString("gambar");

               
                String fasilitas = rs.getString("fasilitas");
                boolean ac = fasilitas != null && fasilitas.contains("AC");
                boolean wifi = fasilitas != null && fasilitas.contains("WiFi");
                boolean waterHeater = fasilitas != null && fasilitas.contains("Water Heater");

                
                HomestayItem item = new HomestayItem(
                        id, ownerId, nama, kategori, lokasi, harga, 5.0, 1, 
                        ac, wifi, waterHeater, "", status, gambar
                );
                daftar.add(item);
            }

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Gagal mengambil data homestay dari MySQL: " + e.getMessage(),
                    "Error Database",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (daftar.isEmpty()) {
            JLabel lblKosong = new JLabel("Tidak ada homestay yang cocok.", SwingConstants.CENTER);
            lblKosong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            pnlGridHomestay.setLayout(new BorderLayout());
            pnlGridHomestay.add(lblKosong, BorderLayout.CENTER);
        } else {
            pnlGridHomestay.setLayout(new GridLayout(0, 3, 16, 16));
            for (HomestayItem h : daftar) {
                pnlGridHomestay.add(new KartuHomestay(h, this::prosesSewa));
            }
        }

        pnlGridHomestay.revalidate();
        pnlGridHomestay.repaint();
    }

    private void prosesSewa(HomestayItem homestay) {
        FormBooking dialog = new FormBooking(this, homestay, SesiUser.getNamaUser());
        dialog.setVisible(true);
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
}