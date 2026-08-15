package tubeshomestay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import tubeshomestay.dao.KoneksiDB;

public class FormBooking extends JDialog {

    private static final Color WARNA_PRIMARY = new Color(51, 153, 255);
    private static final Color WARNA_DISKON = new Color(220, 53, 69);
    private static final double PERSEN_DISKON = 0.20;
    private static final int MINIMAL_MALAM_DISKON = 3;

    private final HomestayItem homestay;
    private final String namaPemesan;
    private final SimpleDateFormat formatTanggal = new SimpleDateFormat("dd/MM/yyyy");

    private JSpinner spinnerCheckIn;
    private JSpinner spinnerMalam;
    private JLabel lblCheckOut;
    private JLabel lblSubtotal;
    private JLabel lblDiskon;
    private JLabel lblTotal;

    public FormBooking(Frame parent, HomestayItem homestay, String namaPemesan) {
        super(parent, true);
        this.homestay = homestay;
        this.namaPemesan = namaPemesan;

        setTitle("Booking - " + homestay.getNama());
        setSize(380, 460);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        add(buildForm(), BorderLayout.CENTER);
        add(buildTombol(), BorderLayout.SOUTH);
    }

    private JPanel buildForm() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        pnl.setBorder(new EmptyBorder(16, 16, 16, 16));

        JLabel lblNamaHomestay = new JLabel(homestay.getNama());
        lblNamaHomestay.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNamaHomestay.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblHargaSatuan = new JLabel(formatRupiah(homestay.getHarga()) + " / malam");
        lblHargaSatuan.setForeground(WARNA_PRIMARY);
        lblHargaSatuan.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblHargaSatuan.setBorder(new EmptyBorder(2, 0, 14, 0));

        JLabel lblPemesan = new JLabel("Atas nama: " + namaPemesan);
        lblPemesan.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblPemesan.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblPemesan.setBorder(new EmptyBorder(0, 0, 12, 0));

        // Tanggal Check-in
        JLabel lblLabelCheckIn = new JLabel("Tanggal Check-in");
        lblLabelCheckIn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblLabelCheckIn.setAlignmentX(Component.LEFT_ALIGNMENT);

        spinnerCheckIn = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        spinnerCheckIn.setEditor(new JSpinner.DateEditor(spinnerCheckIn, "dd/MM/yyyy"));
        spinnerCheckIn.setAlignmentX(Component.LEFT_ALIGNMENT);
        spinnerCheckIn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        spinnerCheckIn.addChangeListener(e -> perbaruiRingkasan());

        // Jumlah Malam 
        JLabel lblMalam = new JLabel("Jumlah Malam");
        lblMalam.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblMalam.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblMalam.setBorder(new EmptyBorder(10, 0, 2, 0));

        spinnerMalam = new JSpinner(new SpinnerNumberModel(1, 1, 365, 1));
        spinnerMalam.setAlignmentX(Component.LEFT_ALIGNMENT);
        spinnerMalam.setMaximumSize(new Dimension(100, 32));
        spinnerMalam.addChangeListener(e -> perbaruiRingkasan());

        // Tanggal Check-out
        lblCheckOut = new JLabel();
        lblCheckOut.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblCheckOut.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblCheckOut.setBorder(new EmptyBorder(10, 0, 14, 0));

        // Ringkasan Harga
        lblSubtotal = new JLabel();
        lblSubtotal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblSubtotal.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblDiskon = new JLabel();
        lblDiskon.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblDiskon.setForeground(WARNA_DISKON);
        lblDiskon.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblDiskon.setBorder(new EmptyBorder(2, 0, 0, 0));

        lblTotal = new JLabel();
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTotal.setForeground(WARNA_PRIMARY);
        lblTotal.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblTotal.setBorder(new EmptyBorder(8, 0, 0, 0));

        pnl.add(lblNamaHomestay);
        pnl.add(lblHargaSatuan);
        pnl.add(lblPemesan);
        pnl.add(lblLabelCheckIn);
        pnl.add(spinnerCheckIn);
        pnl.add(lblMalam);
        pnl.add(spinnerMalam);
        pnl.add(lblCheckOut);
        pnl.add(new JSeparator());
        pnl.add(lblSubtotal);
        pnl.add(lblDiskon);
        pnl.add(lblTotal);

        perbaruiRingkasan();
        return pnl;
    }

    private void perbaruiRingkasan() {
        int malam = (int) spinnerMalam.getValue();
        Date tanggalMasuk = (Date) spinnerCheckIn.getValue();

        Calendar kalender = Calendar.getInstance();
        kalender.setTime(tanggalMasuk);
        kalender.add(Calendar.DAY_OF_MONTH, malam);
        Date tanggalKeluar = kalender.getTime();

        lblCheckOut.setText("Tanggal Check-out: " + formatTanggal.format(tanggalKeluar));

        double subtotal = homestay.getHarga() * malam;
        double diskon = (malam > MINIMAL_MALAM_DISKON) ? subtotal * PERSEN_DISKON : 0;
        double total = subtotal - diskon;

        lblSubtotal.setText("Subtotal: " + formatRupiah(subtotal));
        if (diskon > 0) {
            lblDiskon.setText("Diskon 20% (Booking > 3 Malam): -" + formatRupiah(diskon));
            lblDiskon.setVisible(true);
        } else {
            lblDiskon.setVisible(false);
        }
        lblTotal.setText("Total: " + formatRupiah(total));
    }

    private JPanel buildTombol() {
        JPanel pnl = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 10));

        JButton btnBatal = new JButton("Batal");
        btnBatal.addActionListener(e -> dispose());

        JButton btnKonfirmasi = new JButton("Konfirmasi Booking");
        btnKonfirmasi.setBackground(WARNA_PRIMARY);
        btnKonfirmasi.setForeground(Color.WHITE);
        btnKonfirmasi.setFocusPainted(false);
        btnKonfirmasi.setBorderPainted(false);
        btnKonfirmasi.addActionListener(e -> konfirmasi());

        pnl.add(btnBatal);
        pnl.add(btnKonfirmasi);
        return pnl;
    }

    private void konfirmasi() {
        int malam = (int) spinnerMalam.getValue();
        Date tanggalMasuk = (Date) spinnerCheckIn.getValue();

        Calendar kalender = Calendar.getInstance();
        kalender.setTime(tanggalMasuk);
        kalender.add(Calendar.DAY_OF_MONTH, malam);
        Date tanggalKeluar = kalender.getTime();

        double subtotal = homestay.getHarga() * malam;
        double diskon = (malam > MINIMAL_MALAM_DISKON) ? subtotal * PERSEN_DISKON : 0;
        double total = subtotal - diskon;

        SimpleDateFormat sdfDatabase = new SimpleDateFormat("yyyy-MM-dd");
        String sqlCheckIn = sdfDatabase.format(tanggalMasuk);
        String sqlCheckOut = sdfDatabase.format(tanggalKeluar);

        String strCheckIn = formatTanggal.format(tanggalMasuk);
        String strCheckOut = formatTanggal.format(tanggalKeluar);

        int idUserPengunjung = SesiUser.getIdUser();

        String sqlInsertBooking = "INSERT INTO pemesanan (visitor_id, homestay_id, tgl_checkin, tgl_checkout, total_harga, status) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlUpdateHomestay = "UPDATE homestay SET status = 'tidak tersedia' WHERE id = ?";

        try (java.sql.Connection conn = KoneksiDB.getConnection()) {
            conn.setAutoCommit(false);

            try (java.sql.PreparedStatement psBooking = conn.prepareStatement(sqlInsertBooking);
                 java.sql.PreparedStatement psUpdate = conn.prepareStatement(sqlUpdateHomestay)) {

                psBooking.setInt(1, idUserPengunjung);
                psBooking.setInt(2, homestay.getId());
                psBooking.setString(3, sqlCheckIn);
                psBooking.setString(4, sqlCheckOut);
                psBooking.setDouble(5, total);
                psBooking.setString(6, "Pending");
                psBooking.executeUpdate();

                psUpdate.setInt(1, homestay.getId());
                psUpdate.executeUpdate();

                conn.commit();

                // Update memori lokal
                BookingItem booking = new BookingItem(0, homestay.getId(), homestay.getIdOwner(),
                        homestay.getNama(), namaPemesan, strCheckIn, strCheckOut, malam, total);
                DataBooking.tambah(booking);

                // Tampilkan Tampilan Invoice
                tampilkanInvoiceDialog(namaPemesan, homestay.getNama(), malam, strCheckIn, strCheckOut, subtotal, diskon, total);

                dispose();

            } catch (java.sql.SQLException ex) {
                conn.rollback();
                throw ex;
            }

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Gagal menyimpan ke Database: " + e.getMessage(),
                    "Error Database",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilkanInvoiceDialog(String pemesan, String namaHomestay, int durasi, String in, String out, double subtotal, double diskon, double total) {
        JDialog invoiceDialog = new JDialog(this, "Invoice Pembayaran", true);
        invoiceDialog.setSize(380, 480);
        invoiceDialog.setLocationRelativeTo(this);
        invoiceDialog.setLayout(new BorderLayout());

        // Header Panel
        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(WARNA_PRIMARY);
        pnlHeader.setBorder(new EmptyBorder(15, 15, 15, 15));
        pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.Y_AXIS));

        JLabel lblJudul = new JLabel("INVOICE BUKTI BOOKING");
        lblJudul.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblJudul.setForeground(Color.WHITE);
        lblJudul.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblStatus = new JLabel("Status: SUKSES (Tersimpan)");
        lblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblStatus.setForeground(Color.WHITE);
        lblStatus.setAlignmentX(Component.CENTER_ALIGNMENT);

        pnlHeader.add(lblJudul);
        pnlHeader.add(Box.createVerticalStrut(4));
        pnlHeader.add(lblStatus);

        // Body Panel / Detail Struk
        JPanel pnlBody = new JPanel(new GridBagLayout());
        pnlBody.setBorder(new EmptyBorder(15, 20, 15, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 4, 6, 4);

        int r = 0;
        tambahBarisInvoice(pnlBody, gbc, r++, "Atas Nama Pemesan:", pemesan, true);
        tambahBarisInvoice(pnlBody, gbc, r++, "Homestay:", namaHomestay, false);
        tambahBarisInvoice(pnlBody, gbc, r++, "Durasi Menginap:", durasi + " Malam", false);
        tambahBarisInvoice(pnlBody, gbc, r++, "Tanggal Check-in:", in, false);
        tambahBarisInvoice(pnlBody, gbc, r++, "Tanggal Check-out:", out, false);

        gbc.gridx = 0; gbc.gridy = r++; gbc.gridwidth = 2;
        pnlBody.add(new JSeparator(), gbc);
        gbc.gridwidth = 1;

        tambahBarisInvoice(pnlBody, gbc, r++, "Subtotal:", formatRupiah(subtotal), false);
        if (diskon > 0) {
            tambahBarisInvoice(pnlBody, gbc, r++, "Diskon (20%):", "-" + formatRupiah(diskon), false);
        }
        tambahBarisInvoice(pnlBody, gbc, r++, "Total Bayar:", formatRupiah(total), true);

        // Footer Panel / Button
        JPanel pnlFooter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlFooter.setBorder(new EmptyBorder(5, 10, 15, 10));

        JButton btnSelesai = new JButton("Selesai & Tutup");
        btnSelesai.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSelesai.setBackground(WARNA_PRIMARY);
        btnSelesai.setForeground(Color.WHITE);
        btnSelesai.setFocusPainted(false);
        btnSelesai.addActionListener(e -> invoiceDialog.dispose());

        pnlFooter.add(btnSelesai);

        invoiceDialog.add(pnlHeader, BorderLayout.NORTH);
        invoiceDialog.add(pnlBody, BorderLayout.CENTER);
        invoiceDialog.add(pnlFooter, BorderLayout.SOUTH);

        invoiceDialog.setVisible(true);
    }

    private void tambahBarisInvoice(JPanel panel, GridBagConstraints gbc, int row, String label, String nilai, boolean bold) {
        gbc.gridy = row;

        gbc.gridx = 0;
        gbc.weightx = 0.45;
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Segoe UI", bold ? Font.BOLD : Font.PLAIN, 12));
        panel.add(lbl, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.55;
        JLabel val = new JLabel(nilai);
        val.setFont(new Font("Segoe UI", bold ? Font.BOLD : Font.PLAIN, 12));
        if (bold && label.contains("Total")) {
            val.setForeground(WARNA_PRIMARY);
        } else if (label.contains("Diskon")) {
            val.setForeground(WARNA_DISKON);
        }
        panel.add(val, gbc);
    }

    private String formatRupiah(double harga) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        format.setMaximumFractionDigits(0);
        return format.format(harga);
    }
}