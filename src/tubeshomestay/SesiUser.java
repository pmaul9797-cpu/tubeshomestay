package tubeshomestay;

public class SesiUser {
    private static int idUser = 0;
    private static String namaUser = "";
    private static String role = "";

    public static void login(String nama, int id, String userRole) {
        namaUser = nama;
        idUser = id; 
        role = userRole;
    }

    public static void logout() {
        idUser = 0;
        namaUser = "";
        role = "";
    }

    public static int getIdUser() {
        return idUser;
    }

    public static String getNamaUser() {
        return namaUser;
    }

    public static String getRole() {
        return role;
    }
}