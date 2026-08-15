package tubeshomestay;

import java.util.ArrayList;
import java.util.List;

public class DataAkun {

    private static final List<Akun> DAFTAR = new ArrayList<>();
    private static int autoId = 1;

    private DataAkun() {
    }

    public static synchronized boolean usernameSudahDipakai(String username) {
        for (Akun a : DAFTAR) {
            if (a.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public static synchronized Akun daftar(String nama, String email, String username,
            String password, String noHp, String role) {
        Akun akun = new Akun(autoId++, nama, email, username, password, noHp, role);
        DAFTAR.add(akun);
        return akun;
    }

    public static synchronized Akun cariByUsername(String username) {
        for (Akun a : DAFTAR) {
            if (a.getUsername().equalsIgnoreCase(username)) {
                return a;
            }
        }
        return null;
    }
}