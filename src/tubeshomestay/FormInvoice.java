package tubeshomestay;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FormInvoice extends JDialog {

    public FormInvoice(JFrame parent, String namaPemesan, String namaHomestay, int lamaMalam, String checkIn, String checkOut, double totalHarga) {
        super(parent, "Invoice / Struk Pemesanan", true);
        setSize(420, 520);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

       
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("Rp #,###", symbols);
        String totalFormatted = df.format(totalHarga);

        // Header Invoice
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(new Color(41, 128, 185)); // Warna Biru Elegan
        headerPanel.setBorder(BorderFactory.createEmptyBorder(18, 15, 18, 15));

        JLabel lblTitle = new JLabel("INVOICE PEMESANAN");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSub = new JLabel("Bukti Transaksi Homestay");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblSub.setForeground(Color.WHITE);
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(lblTitle);
        headerPanel.add(Box.createVerticalStrut(5));
        headerPanel.add(lblSub);

        // Detail Isi Invoice
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 5, 8, 5);

        int row = 0;
        addRow(contentPanel, gbc, row++, "Status:", "BERHASIL / LUNAS", true);
        addRow(contentPanel, gbc, row++, "Nama Pemesan:", namaPemesan, false);
        addRow(contentPanel, gbc, row++, "Nama Homestay:", namaHomestay, false);
        addRow(contentPanel, gbc, row++, "Durasi Menginap:", lamaMalam + " Malam", false);
        addRow(contentPanel, gbc, row++, "Check-in:", checkIn, false);
        addRow(contentPanel, gbc, row++, "Check-out:", checkOut, false);
        
        // Garis Pemisah (Garis Putus/Separator)
        gbc.gridx = 0; gbc.gridy = row++; gbc.gridwidth = 2;
        contentPanel.add(new JSeparator(), gbc);

        // Total Pembayaran
        gbc.gridwidth = 1;
        addRow(contentPanel, gbc, row++, "Total Bayar:", totalFormatted, true);

        // Tombol Tutup
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 10));

        JButton btnTutup = new JButton("Selesai & Cetak Struk");
        btnTutup.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnTutup.setBackground(new Color(46, 204, 113)); // Warna Hijau
        btnTutup.setForeground(Color.WHITE);
        btnTutup.setFocusPainted(false);
        btnTutup.addActionListener(e -> dispose());

        footerPanel.add(btnTutup);

        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, int row, String label, String value, boolean isBold) {
        gbc.gridy = row;
        
        gbc.gridx = 0;
        gbc.weightx = 0.4;
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("SansSerif", isBold ? Font.BOLD : Font.PLAIN, 13));
        panel.add(lbl, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.6;
        JLabel val = new JLabel(value);
        val.setFont(new Font("SansSerif", isBold ? Font.BOLD : Font.PLAIN, 13));
        
        if (isBold && label.contains("Status")) {
            val.setForeground(new Color(39, 174, 96)); // Hijau
        } else if (isBold && label.contains("Total")) {
            val.setForeground(new Color(192, 57, 43)); // Merah
        }
        
        panel.add(val, gbc);
    }
}