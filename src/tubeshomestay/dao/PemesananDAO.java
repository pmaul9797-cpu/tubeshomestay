package tubeshomestay.dao;

import java.sql.*;

public class PemesananDAO {

    // Fitur: Pengunjung Membuat Pemesanan Baru
    public boolean buatPemesanan(int visitorId, int homestayId, Date checkIn, Date checkOut, double totalHarga) {
        String sql = "INSERT INTO pemesanan (visitor_id, homestay_id, tgl_checkin, tgl_checkout, total_harga, status) VALUES (?, ?, ?, ?, ?, 'pending')";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, visitorId);
            ps.setInt(2, homestayId);
            ps.setDate(3, checkIn);
            ps.setDate(4, checkOut);
            ps.setDouble(5, totalHarga);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fitur: Owner Mengubah Status Pemesanan (Setuju/Batal)
    public boolean ubahStatusPemesanan(int pemesananId, String status) {
        String sql = "UPDATE pemesanan SET status = ? WHERE id = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, status);
            ps.setInt(2, pemesananId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}