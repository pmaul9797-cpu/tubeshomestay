package tubeshomestay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AkunDAO {

    
    public boolean cekUsernameAda(String username) {
        String sql = "SELECT id FROM users WHERE username = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next(); 
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public String[] loginUser(String username, String password) {
    String sql = "SELECT id, role, nama_lengkap FROM users WHERE username = ? AND password = ?";
    try (Connection conn = KoneksiDB.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, username);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            
            return new String[] {
                String.valueOf(rs.getInt("id")), 
                rs.getString("role"), 
                rs.getString("nama_lengkap")
            };
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; 
}

    
    public boolean mendaftarAkun(String username, String password, String nama, String email, String role) {
        String sql = "INSERT INTO users (username, password, nama_lengkap, email, role) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, nama);
            ps.setString(4, email);
            ps.setString(5, role);
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}