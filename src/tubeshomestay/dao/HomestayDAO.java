package tubeshomestay.dao;

import tubeshomestay.HomestayItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomestayDAO {

    // Method untuk menggabungkan Checkbox Fasilitas menjadi 1 teks String (contoh: "AC, WiFi")
    private String formatFasilitas(HomestayItem h) {
        List<String> list = new ArrayList<>();
        if (h.isFasilitasAc()) list.add("AC");
        if (h.isFasilitasWifi()) list.add("WiFi");
        if (h.isFasilitasWaterHeater()) list.add("Water Heater");
        return String.join(", ", list);
    }

    // 1. Tambah Homestay Baru
    public boolean tambahHomestay(HomestayItem h) {
        String sql = "INSERT INTO homestay (owner_id, nama_homestay, kategori, alamat, fasilitas, harga_per_malam, status, gambar) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, h.getOwnerId());
            ps.setString(2, h.getNama());
            ps.setString(3, h.getKategori());
            ps.setString(4, h.getLokasi());
            ps.setString(5, formatFasilitas(h));
            ps.setDouble(6, h.getHarga());
            ps.setString(7, h.getStatus() != null ? h.getStatus() : "tersedia");
            ps.setString(8, h.getGambar());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 2. Update Data Homestay
    public boolean updateHomestay(HomestayItem h) {
        String sql = "UPDATE homestay SET nama_homestay = ?, kategori = ?, alamat = ?, fasilitas = ?, "
                   + "harga_per_malam = ?, status = ?, gambar = ? WHERE id = ?";

        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, h.getNama());
            ps.setString(2, h.getKategori());
            ps.setString(3, h.getLokasi());
            ps.setString(4, formatFasilitas(h));
            ps.setDouble(5, h.getHarga());
            ps.setString(6, h.getStatus());
            ps.setString(7, h.getGambar());
            ps.setInt(8, h.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 3. Hapus Homestay
    public boolean hapusHomestay(int id, int ownerId) {
        String sql = "DELETE FROM homestay WHERE id = ? AND owner_id = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setInt(2, ownerId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 4. Helper Pemetaan ResultSet ke HomestayItem
    private HomestayItem mapResultSetToHomestay(ResultSet rs) throws SQLException {
        // Membaca kolom fasilitas untuk mengaktifkan checkbox boolean
        String fasilitas = rs.getString("fasilitas");
        boolean ac = fasilitas != null && fasilitas.contains("AC");
        boolean wifi = fasilitas != null && fasilitas.contains("WiFi");
        boolean waterHeater = fasilitas != null && fasilitas.contains("Water Heater");

        return new HomestayItem(
            rs.getInt("id"),
            rs.getInt("owner_id"),
            rs.getString("nama_homestay"),
            rs.getString("kategori"),
            rs.getString("alamat"),
            rs.getDouble("harga_per_malam"),
            0.0, // rating default
            0,   // kamar default
            ac,
            wifi,
            waterHeater,
            rs.getString("deskripsi"),
            rs.getString("status"),
            rs.getString("gambar")
        );
    }
}