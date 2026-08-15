package tubeshomestay;

import tubeshomestay.dao.HomestayDAO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FormKelolaHomestay extends JDialog {

    private static final Color WARNA_PRIMARY = new Color(51, 153, 255);

    private final int idOwner;
    private final HomestayItem editData;
    private final HomestayDAO homestayDAO;

    private JTextField txtNama, txtLokasi, txtHarga, txtRating, txtKamar, txtGambar;
    private JComboBox<String> cmbKategori;
    private JCheckBox chkAc, chkWifi, chkWaterHeater;
    private String namaFileGambar = "";
    private boolean berhasilSimpan = false;

    public FormKelolaHomestay(Frame owner, int idOwner, HomestayItem editData) {
        super(owner, true);
        this.idOwner = idOwner;
        this.editData = editData;
        this.homestayDAO = new HomestayDAO();

        setTitle(editData == null ? "Tambah Homestay" : "Edit Homestay");
        setSize(400, 600);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());

        add(buildForm(), BorderLayout.CENTER);
        add(buildTombol(), BorderLayout.SOUTH);

        if (editData != null) {
            isiDataUntukEdit();
        }
    }

    private JPanel buildForm() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        pnl.setBorder(new EmptyBorder(16, 16, 16, 16));

        txtNama = tambahField(pnl, "Nama Homestay");
        cmbKategori = tambahCombo(pnl, "Kategori", new String[]{"STANDARD", "DELUXE", "VIP"});
        txtLokasi = tambahField(pnl, "Lokasi / Alamat");
        txtHarga = tambahField(pnl, "Harga / Malam (Rp)");
        txtRating = tambahField(pnl, "Rating (0 - 5)");
        txtKamar = tambahField(pnl, "Jumlah Kamar");

        // Gambar
        JLabel lblGambarJudul = new JLabel("Gambar Homestay");
        lblGambarJudul.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblGambarJudul.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblGambarJudul.setBorder(new EmptyBorder(6, 0, 2, 0));
        pnl.add(lblGambarJudul);

        JPanel pnlGambar = new JPanel(new BorderLayout(6, 0));
        pnlGambar.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlGambar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));

        txtGambar = new JTextField();
        txtGambar.setEditable(false);
        txtGambar.setText("(belum ada gambar)");

        JButton btnPilihGambar = new JButton("Pilih Gambar...");
        btnPilihGambar.addActionListener(e -> pilihGambar());

        pnlGambar.add(txtGambar, BorderLayout.CENTER);
        pnlGambar.add(btnPilihGambar, BorderLayout.EAST);
        pnl.add(pnlGambar);

        // Fasilitas
        JLabel lblFasilitas = new JLabel("Fasilitas");
        lblFasilitas.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblFasilitas.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblFasilitas.setBorder(new EmptyBorder(8, 0, 4, 0));
        pnl.add(lblFasilitas);

        JPanel pnlFasilitas = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlFasilitas.setAlignmentX(Component.LEFT_ALIGNMENT);

        chkAc = new JCheckBox("AC");
        chkWifi = new JCheckBox("WiFi");
        chkWaterHeater = new JCheckBox("Water Heater");

        pnlFasilitas.add(chkAc);
        pnlFasilitas.add(chkWifi);
        pnlFasilitas.add(chkWaterHeater);
        pnl.add(pnlFasilitas);

        return pnl;
    }

    private JTextField tambahField(JPanel induk, String label) {
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        lbl.setBorder(new EmptyBorder(6, 0, 2, 0));

        JTextField txt = new JTextField();
        txt.setAlignmentX(Component.LEFT_ALIGNMENT);
        txt.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));

        induk.add(lbl);
        induk.add(txt);
        return txt;
    }

    private JComboBox<String> tambahCombo(JPanel induk, String label, String[] opsi) {
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        lbl.setBorder(new EmptyBorder(6, 0, 2, 0));

        JComboBox<String> cmb = new JComboBox<>(opsi);
        cmb.setAlignmentX(Component.LEFT_ALIGNMENT);
        cmb.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));

        induk.add(lbl);
        induk.add(cmb);
        return cmb;
    }

    private JPanel buildTombol() {
        JPanel pnl = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 10));

        JButton btnBatal = new JButton("Batal");
        btnBatal.addActionListener(e -> dispose());

        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBackground(WARNA_PRIMARY);
        btnSimpan.setForeground(Color.WHITE);
        btnSimpan.setFocusPainted(false);
        btnSimpan.setBorderPainted(false);
        btnSimpan.addActionListener(e -> simpan());

        pnl.add(btnBatal);
        pnl.add(btnSimpan);
        return pnl;
    }

    private void pilihGambar() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter(
                "Gambar (jpg, jpeg, png, gif)", "jpg", "jpeg", "png", "gif"));

        int pilihan = chooser.showOpenDialog(this);
        if (pilihan != JFileChooser.APPROVE_OPTION) return;

        File sumber = chooser.getSelectedFile();
        File folderImages = cariFolderImages();

        if (folderImages == null) {
            JOptionPane.showMessageDialog(this, "Tidak bisa menemukan folder images.", "Info", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Path tujuan = folderImages.toPath().resolve(sumber.getName());
            Files.copy(sumber.toPath(), tujuan, StandardCopyOption.REPLACE_EXISTING);
            namaFileGambar = sumber.getName();
            txtGambar.setText(namaFileGambar);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyalin gambar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private File cariFolderImages() {
        try {
            URL contoh = getClass().getResource("/images/House-logo-by-yahyaanasatokillah.jpg");
            if (contoh == null) return null;
            return new File(contoh.toURI()).getParentFile();
        } catch (URISyntaxException | IllegalArgumentException ex) {
            return null;
        }
    }

    private void isiDataUntukEdit() {
        if (editData != null) {
            txtNama.setText(editData.getNama());
            cmbKategori.setSelectedItem(editData.getKategori());
            txtLokasi.setText(editData.getLokasi());
            txtHarga.setText(String.valueOf((long) editData.getHarga()));
            txtRating.setText(String.valueOf(editData.getRating()));
            txtKamar.setText(String.valueOf(editData.getJumlahKamar()));
            chkAc.setSelected(editData.isFasilitasAc());
            chkWifi.setSelected(editData.isFasilitasWifi());
            chkWaterHeater.setSelected(editData.isFasilitasWaterHeater());

            if (editData.getGambar() != null && !editData.getGambar().trim().isEmpty()) {
                namaFileGambar = editData.getGambar();
                txtGambar.setText(namaFileGambar);
            }
        }
    }

    private void simpan() {
        String nama = txtNama.getText().trim();
        String lokasi = txtLokasi.getText().trim();
        String kategori = (String) cmbKategori.getSelectedItem();

        if (nama.isEmpty() || lokasi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama dan lokasi wajib diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double harga, rating;
        int kamar;
        try {
            harga = Double.parseDouble(txtHarga.getText().trim());
            rating = Double.parseDouble(txtRating.getText().trim());
            kamar = Integer.parseInt(txtKamar.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Harga, rating, dan jumlah kamar harus berupa angka valid.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (editData == null) {
            HomestayItem baru = new HomestayItem(0, idOwner, nama, kategori, lokasi, harga, rating, kamar,
                    chkAc.isSelected(), chkWifi.isSelected(), chkWaterHeater.isSelected(), "", "tersedia", namaFileGambar);
            
            // Simpan ke DB lewat DAO dan juga memory
            berhasilSimpan = homestayDAO.tambahHomestay(baru);
            DataHomestay.tambah(baru); 
        } else {
            editData.setNama(nama);
            editData.setKategori(kategori);
            editData.setLokasi(lokasi);
            editData.setHarga(harga);
            editData.setRating(rating);
            editData.setJumlahKamar(kamar);
            editData.setFasilitasAc(chkAc.isSelected());
            editData.setFasilitasWifi(chkWifi.isSelected());
            editData.setFasilitasWaterHeater(chkWaterHeater.isSelected());
            editData.setGambar(namaFileGambar);

            berhasilSimpan = homestayDAO.updateHomestay(editData);
            DataHomestay.perbarui(editData);
        }

        if (berhasilSimpan) {
            JOptionPane.showMessageDialog(this, "Data homestay berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data ke database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isBerhasilSimpan() {
        return berhasilSimpan;
    }
}