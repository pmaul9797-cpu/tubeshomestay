/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubeshomestay;

/**
 *
 * @author pmaul
 */
public class Akun {

    private int id;
    private String nama;
    private String email;
    private String username;
    private String password;
    private String noHp;
    private String role;

    public Akun(int id, String nama, String email, String username, String password, String noHp, String role) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.username = username;
        this.password = password;
        this.noHp = noHp;
        this.role = role;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getNoHp() { return noHp; }
    public String getRole() { return role; }
    
}