
package tubeshomestay;

/**
 *
 * @author pmaul
 */
public class FromLogin extends javax.swing.JFrame {

  
    public FromLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnPengunjung = new javax.swing.JToggleButton();
        btnOwner = new javax.swing.JToggleButton();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnMasuk = new javax.swing.JButton();
        lblDaftar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(243, 246, 250));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(243, 246, 250));
        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 767;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/House-logo-by-yahyaanasatokillah.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setText("Homestay Ku");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Silakan Masuk Ke Akun");

        buttonGroup1.add(btnPengunjung);
        btnPengunjung.setLabel("Pengunjung");
        btnPengunjung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengunjungActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnOwner);
        btnOwner.setLabel("Owner");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnMasuk.setBackground(new java.awt.Color(51, 153, 255));
        btnMasuk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMasuk.setForeground(new java.awt.Color(255, 255, 255));
        btnMasuk.setText("Masuk");
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });

        lblDaftar.setForeground(new java.awt.Color(51, 153, 255));
        lblDaftar.setText("Belum Punya Akun Daftar");
        lblDaftar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDaftarMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Pilih Peran Anda");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("USERNAME");

        label1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        label1.setText("PASSWORD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(lblDaftar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnPengunjung, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel4))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel1)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPengunjung, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDaftar)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPengunjungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengunjungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPengunjungActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        // TODO add your handling code here:
        // 1. Ambil input dari form
    String username = txtUsername.getText().trim();
    String password = new String(txtPassword.getPassword()).trim();
    
    // 2. Cek apakah Peran/Role sudah dipilih
    if (!btnPengunjung.isSelected() && !btnOwner.isSelected()) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Silakan pilih peran Anda terlebih dahulu (Pengunjung / Owner)!", 
            "Peringatan", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // 3. Cek apakah Username kosong
    if (username.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Username tidak boleh kosong!", 
            "Peringatan", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
        txtUsername.requestFocus();
        return;
    }
    
    // 4. Cek apakah Password kosong
    if (password.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Password tidak boleh kosong!", 
            "Peringatan", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
        txtPassword.requestFocus();
        return;
    }
  // 5. Verifikasi Login ke Database
    tubeshomestay.dao.AkunDAO akunDAO = new tubeshomestay.dao.AkunDAO();
    String[] dataUser = akunDAO.loginUser(username, password); 

    if (dataUser == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Username atau password salah. Silakan daftar dulu jika belum punya akun.",
            "Gagal Masuk",
            javax.swing.JOptionPane.ERROR_MESSAGE); // <-- DIBETULKAN: Tanpa Tanda Kutip " "
        return;
    }

    // Deklarasikan variabel idUserFromDB dari array index [0]
    int idUserFromDB = Integer.parseInt(dataUser[0]); 
    String roleDatabase = dataUser[1];                 
    String namaUser = dataUser[2];                     

    String peranDipilih = btnPengunjung.isSelected() ? "Pengunjung" : "Owner";

    // Validasi kesesuaian role (Visitor / Owner)
    boolean isVisitorMatch = peranDipilih.equalsIgnoreCase("Pengunjung") && 
                             (roleDatabase.equalsIgnoreCase("visitor") || roleDatabase.equalsIgnoreCase("pengunjung"));
                             
    boolean isOwnerMatch = peranDipilih.equalsIgnoreCase("Owner") && 
                           roleDatabase.equalsIgnoreCase("owner");

    if (!isVisitorMatch && !isOwnerMatch) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Akun ini terdaftar sebagai " + roleDatabase + ", bukan " + peranDipilih + ".",
            "Gagal Masuk",
            javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Panggil SesiUser dengan idUserFromDB yang sudah jadi int
    SesiUser.login(namaUser, idUserFromDB, roleDatabase);

    javax.swing.JOptionPane.showMessageDialog(this, 
        "Selamat Datang, " + namaUser + "!", 
        "Login Berhasil", 
        javax.swing.JOptionPane.INFORMATION_MESSAGE);

    // Buka Dashboard sesuai peran
    if (isVisitorMatch) {
        new DashboardPengunjung().setVisible(true);
    } else {
        new DashboardOwner().setVisible(true);
    }
    
    this.dispose(); // Tutup form login
    }//GEN-LAST:event_btnMasukActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void lblDaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDaftarMouseClicked
        // TODO add your handling code here:
        // 1. Buat dan tampilkan FormRegister
    FromRegister reg = new FromRegister();
    
    // 1. Tampilkan dan fokuskan form register ke paling depan
    reg.setVisible(true);
    reg.toFront();
    reg.requestFocus();
    
    // 2. Sembunyikan form login terlebih dahulu, baru di-dispose
    this.setVisible(false);
    this.dispose();
    }//GEN-LAST:event_lblDaftarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FromLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMasuk;
    private javax.swing.JToggleButton btnOwner;
    private javax.swing.JToggleButton btnPengunjung;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label1;
    private javax.swing.JLabel lblDaftar;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
