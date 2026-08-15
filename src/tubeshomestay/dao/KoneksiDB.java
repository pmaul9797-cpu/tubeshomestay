
package tubeshomestay.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pmaul
 */

    public class KoneksiDB {
    private static final String URL = "jdbc:mysql://localhost:3306/db_homestay?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = ""; 

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC tidak ditemukan: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

