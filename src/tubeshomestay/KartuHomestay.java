package tubeshomestay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Consumer;

public class KartuHomestay extends JPanel {

    private static final Color WARNA_PRIMARY = new Color(51, 153, 255);
    private static final Color WARNA_BORDER = new Color(224, 224, 224);

    public KartuHomestay(HomestayItem item, Consumer<HomestayItem> onSewa) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(WARNA_BORDER, 1),
                new EmptyBorder(12, 12, 12, 12)
        ));

        // 1. Gambar Homestay (Atas) - Menggunakan method helper buildLabelFoto agar ukuran & rasio konsisten
        JLabel lblGambar = buildLabelFoto(item);
        add(lblGambar, BorderLayout.NORTH);

        // 2. Info Detail Homestay (Tengah)
        JPanel pnlInfo = new JPanel();
        pnlInfo.setLayout(new BoxLayout(pnlInfo, BoxLayout.Y_AXIS));
        pnlInfo.setBackground(Color.WHITE);
        pnlInfo.setBorder(new EmptyBorder(10, 0, 10, 0));

        // Nama Homestay
        JLabel lblNama = new JLabel(item.getNama());
        lblNama.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblNama.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Rating & Kategori
        JPanel pnlRatingKategori = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        pnlRatingKategori.setBackground(Color.WHITE);
        pnlRatingKategori.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblBintang = new JLabel("\u2605"); // Simbol Unicode Bintang
        lblBintang.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
        lblBintang.setForeground(new Color(255, 180, 0)); // Warna Emas/Kuning

        String kategoriText = (item.getKategori() != null && !item.getKategori().isEmpty()) ? item.getKategori() : "STANDARD";
        JLabel lblRatingText = new JLabel(String.format("%.1f", item.getRating()) + "  •  " + kategoriText);
        lblRatingText.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblRatingText.setForeground(Color.GRAY);

        pnlRatingKategori.add(lblBintang);
        pnlRatingKategori.add(lblRatingText);

        // Lokasi / Alamat
        JLabel lblLokasi = new JLabel(item.getLokasi());
        lblLokasi.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblLokasi.setForeground(Color.DARK_GRAY);
        lblLokasi.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Fasilitas
        JLabel lblFasilitas = new JLabel("Fasilitas: " + buildFasilitasText(item));
        lblFasilitas.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        lblFasilitas.setForeground(new Color(100, 100, 100));
        lblFasilitas.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Harga per malam
        JLabel lblHarga = new JLabel(formatRupiah(item.getHarga()) + " / malam");
        lblHarga.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblHarga.setForeground(WARNA_PRIMARY);
        lblHarga.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Susun elemen ke pnlInfo
        pnlInfo.add(lblNama);
        pnlInfo.add(Box.createRigidArea(new Dimension(0, 4)));
        pnlInfo.add(pnlRatingKategori);
        pnlInfo.add(Box.createRigidArea(new Dimension(0, 4)));
        pnlInfo.add(lblLokasi);
        pnlInfo.add(Box.createRigidArea(new Dimension(0, 4)));
        pnlInfo.add(lblFasilitas);
        pnlInfo.add(Box.createRigidArea(new Dimension(0, 8)));
        pnlInfo.add(lblHarga);

        add(pnlInfo, BorderLayout.CENTER);

        // 3. Tombol Sewa (Bawah)
        JButton btnSewa = new JButton("Sewa Sekarang");
        btnSewa.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSewa.setBackground(WARNA_PRIMARY);
        btnSewa.setForeground(Color.WHITE);
        btnSewa.setFocusPainted(false);
        btnSewa.setBorderPainted(false);
        btnSewa.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSewa.setPreferredSize(new Dimension(0, 34));
        btnSewa.addActionListener(e -> onSewa.accept(item));

        add(btnSewa, BorderLayout.SOUTH);
    }

    private JLabel buildLabelFoto(HomestayItem h) {
        // PERBAIKAN: Mengatur proporsi tinggi dan lebar gambar (300 x 170)
        Dimension ukuran = new Dimension(300, 170);
        ImageIcon icon = muatIkonGambar(h.getGambar(), ukuran);

        JLabel lblFoto;
        if (icon != null) {
            lblFoto = new JLabel(icon, SwingConstants.CENTER);
        } else {
            lblFoto = new JLabel(kategoriToEmoji(h.getKategori()), SwingConstants.CENTER);
            lblFoto.setFont(new Font("Segoe UI", Font.PLAIN, 48));
        }
        
       
        lblFoto.setOpaque(true);
        lblFoto.setBackground(Color.WHITE);
        lblFoto.setPreferredSize(ukuran);
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        return lblFoto;
    }

    private ImageIcon muatIkonGambar(String namaFile, Dimension ukuran) {
        if (namaFile == null || namaFile.trim().isEmpty()) {
            return null;
        }
        URL url = getClass().getResource("/images/" + namaFile.trim());
        if (url == null) {
            return null;
        }
        ImageIcon asli = new ImageIcon(url);
        
        Image hasil = asli.getImage().getScaledInstance(ukuran.width, ukuran.height, Image.SCALE_SMOOTH);
        return new ImageIcon(hasil);
    }

    private String buildFasilitasText(HomestayItem h) {
        StringBuilder sb = new StringBuilder();
        if (h.isFasilitasAc()) sb.append("AC  ");
        if (h.isFasilitasWifi()) sb.append("WiFi  ");
        if (h.isFasilitasWaterHeater()) sb.append("Water Heater");
        return sb.length() == 0 ? "-" : sb.toString().trim();
    }

    private String kategoriToEmoji(String kategori) {
        if (kategori == null) return "\uD83C\uDFE0";
        switch (kategori.toUpperCase()) {
            case "VIP": return "\uD83C\uDFE1";
            case "DELUXE": return "\uD83C\uDFE0";
            default: return "\uD83C\uDFE2";
        }
    }

    private String formatRupiah(double harga) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        format.setMaximumFractionDigits(0);
        return format.format(harga);
    }
}
