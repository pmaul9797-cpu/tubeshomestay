package tubeshomestay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import tubeshomestay.dao.KoneksiDB;

public class LaporanBooking extends JFrame {

    private static final Color WARNA_BG = new Color(243, 246, 250);
    private static final Color WARNA_PRIMARY = new Color(51, 153, 255);
    private static final Color WARNA_BORDER = new Color(224, 224, 224);

    private final int idOwner;
    private JLabel lblTotal;

    public LaporanBooking(int idOwner) {
        this.idOwner = idOwner;

        setTitle("Homestay Ku - Laporan Booking");
        setSize(760, 520);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(WARNA_BG);

        // Inisialisasi label total pendapatan terlebih dahulu
        lblTotal = new JLabel("Total Pendapatan: Rp0");
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblTotal.setForeground(WARNA_PRIMARY);

        add(buildContent(), BorderLayout.CENTER);
    }

    private JPanel buildContent() {
        JPanel pnl = new JPanel(new BorderLayout());
        pnl.setBackground(WARNA_BG);
        pnl.setBorder(new EmptyBorder(20, 24, 20, 24));

        JLabel lblJudul = new JLabel("Laporan Booking");
        lblJudul.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblJudul.setBorder(new EmptyBorder(0, 0, 12, 0));

        pnl.add(lblJudul, BorderLayout.NORTH);
        // Panggil buildTabel setelah lblTotal sudah diinisialisasi di konstruktor
        pnl.add(buildTabel(), BorderLayout.CENTER);
        pnl.add(buildFooter(), BorderLayout.SOUTH);

        return pnl;
    }

    private Component buildTabel() {
        String[] kolom = {"ID", "Homestay", "Pemesan", "Check-in", "Check-out", "Malam", "Total"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        rupiah.setMaximumFractionDigits(0);

        double totalPendapatan = 0;
        int jumlahData = 0;

       String sql = "SELECT p.id, h.nama_homestay AS nama_homestay, u.username AS nama_pemesan, " +
             "p.tgl_checkin, p.tgl_checkout, p.total_harga " +
             "FROM pemesanan p " +
             "JOIN homestay h ON p.homestay_id = h.id " +
             "JOIN users u ON p.visitor_id = u.id " +
             "WHERE h.owner_id = ? " +
             "ORDER BY p.id DESC";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idOwner);
            ResultSet rs = ps.executeQuery();

            SimpleDateFormat sdfTampil = new SimpleDateFormat("dd/MM/yyyy");

            while (rs.next()) {
                jumlahData++;
                int id = rs.getInt("id");
                String namaHomestay = rs.getString("nama_homestay");
                String namaPemesan = rs.getString("nama_pemesan");
                java.sql.Date tglCheckIn = rs.getDate("tgl_checkin");
                java.sql.Date tglCheckOut = rs.getDate("tgl_checkout");
                double totalHarga = rs.getDouble("total_harga");

                long diff = tglCheckOut.getTime() - tglCheckIn.getTime();
                int jumlahMalam = (int) (diff / (1000 * 60 * 60 * 24));
                if (jumlahMalam <= 0) jumlahMalam = 1;

                model.addRow(new Object[]{
                    id,
                    namaHomestay,
                    namaPemesan,
                    sdfTampil.format(tglCheckIn),
                    sdfTampil.format(tglCheckOut),
                    jumlahMalam,
                    rupiah.format(totalHarga)
                });

                totalPendapatan += totalHarga;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat laporan booking dari database: " + e.getMessage(), 
                "Error Database", JOptionPane.ERROR_MESSAGE);
        }

        // Update teks total pendapatan (sekarang lblTotal dijamin tidak null)
        lblTotal.setText("Total Pendapatan: " + rupiah.format(totalPendapatan));

        if (jumlahData == 0) {
            JPanel pnlKosong = new JPanel(new BorderLayout());
            pnlKosong.setBackground(Color.WHITE);
            JLabel lblKosong = new JLabel("Belum ada booking masuk untuk homestay Anda.", SwingConstants.CENTER);
            lblKosong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            pnlKosong.add(lblKosong, BorderLayout.CENTER);
            pnlKosong.setBorder(BorderFactory.createLineBorder(WARNA_BORDER));
            return pnlKosong;
        }

        JTable tabel = new JTable(model);
        tabel.setRowHeight(28);
        tabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tabel.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));

        JScrollPane scroll = new JScrollPane(tabel);
        scroll.setBorder(BorderFactory.createLineBorder(WARNA_BORDER));
        return scroll;
    }

    private JPanel buildFooter() {
        JPanel pnl = new JPanel(new BorderLayout());
        pnl.setBackground(WARNA_BG);
        pnl.setBorder(new EmptyBorder(14, 0, 0, 0));

        JButton btnTutup = new JButton("Tutup");
        btnTutup.addActionListener(e -> dispose());

        JPanel pnlTombol = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlTombol.setBackground(WARNA_BG);
        pnlTombol.add(btnTutup);

        pnl.add(lblTotal, BorderLayout.WEST);
        pnl.add(pnlTombol, BorderLayout.EAST);
        return pnl;
    }
}