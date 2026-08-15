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
public class FromRegister extends javax.swing.JFrame {

    /**
     * Creates new form FromRegister
     */
public FromRegister() {
    initComponents();
    this.setLocationRelativeTo(null);
    this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    
   
    jLabel4.setVisible(false);          
    btnRegOwner.setVisible(false);      
    btnRegPengunjung.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnRegPengunjung = new javax.swing.JToggleButton();
        btnRegOwner = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        txtRegNama = new javax.swing.JTextField();
        txtRegEmail = new javax.swing.JTextField();
        txtRegUsername = new javax.swing.JTextField();
        txtRegNoHP = new javax.swing.JTextField();
        txtRegPassword = new javax.swing.JPasswordField();
        btnDaftar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(243, 246, 250));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/House-logo-by-yahyaanasatokillah.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Daftar Akun Baru");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Silahkan isi data diri");

        buttonGroup1.add(btnRegPengunjung);
        btnRegPengunjung.setText("Pengunjung");
        btnRegPengunjung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPengunjungActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnRegOwner);
        btnRegOwner.setText("Owner");
        btnRegOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegOwnerActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Pilih Peran");

        txtRegNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegNamaActionPerformed(evt);
            }
        });

        txtRegNoHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegNoHPActionPerformed(evt);
            }
        });

        btnDaftar.setBackground(new java.awt.Color(51, 153, 255));
        btnDaftar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDaftar.setForeground(new java.awt.Color(255, 255, 255));
        btnDaftar.setText("DAFTAR");
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Nama Lengkap");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Username");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("No WhatsApp / HP");

        lblLogin.setForeground(new java.awt.Color(51, 153, 255));
        lblLogin.setText("Sudah punya akun? Login");
        lblLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnRegPengunjung, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(btnRegOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(txtRegNama)
                            .addComponent(jLabel5)
                            .addComponent(txtRegEmail)
                            .addComponent(txtRegPassword)
                            .addComponent(jLabel7)
                            .addComponent(txtRegUsername)
                            .addComponent(jLabel8)
                            .addComponent(txtRegNoHP)
                            .addComponent(btnDaftar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(113, 113, 113)))
                .addGap(60, 60, 60))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lblLogin))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel3)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(213, 213, 213))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegPengunjung, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegNama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
                .addComponent(txtRegPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addComponent(txtRegNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLogin)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        // TODO add your handling code here:
        
        FromLogin login = new FromLogin();

        // 1. Tampilkan dan fokuskan form login ke paling depan
        login.setVisible(true);
        login.toFront();
        login.requestFocus();

        // 2. Sembunyikan form register terlebih dahulu, baru di-dispose
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_lblLoginMouseClicked

    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarActionPerformed
        // TODO add your handling code here:
        // 1. Ambil data dari semua kotak input
        String nama = txtRegNama.getText().trim();
        String email = txtRegEmail.getText().trim();
        String username = txtRegUsername.getText().trim();
        String password = new String(txtRegPassword.getPassword());
        String noHP = txtRegNoHP.getText().trim();

        // 2. Cek Nama Lengkap
        if (nama.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Nama lengkap wajib diisi!",
            "Peringatan",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        txtRegNama.requestFocus();
        return;
        }

        // 2. Cek Email
        if (email.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Email wajib diisi!",
            "Peringatan",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        txtRegEmail.requestFocus();
        return;
        }

        // 5. Cek Username
        if (username.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Username wajib diisi!",
            "Peringatan",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        txtRegUsername.requestFocus();
        return;
        }

        // 6. Cek Password
        if (password.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Password wajib diisi!",
            "Peringatan",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        txtRegPassword.requestFocus();
        return;
        }

        // 7. Cek No. WhatsApp / HP
        if (noHP.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Nomor WhatsApp / HP wajib diisi!",
            "Peringatan",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        txtRegNoHP.requestFocus();
        return;
        }
        // KUNCI ROLE LANGSUNG KE 'visitor'
    String role = "visitor";

    // Panggil AkunDAO
    tubeshomestay.dao.AkunDAO akunDAO = new tubeshomestay.dao.AkunDAO();
    
        if (akunDAO.cekUsernameAda(username)) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Username sudah dipakai, silakan pilih username lain.",
            "Peringatan",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        txtRegUsername.requestFocus();
        return;
        }

        // 9. Simpan akun baru ke Database MySQL
        boolean berhasil = akunDAO.mendaftarAkun(username, password, nama, email, role);

        if (berhasil) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Pendaftaran Berhasil! Silakan login dengan akun Anda.",
            "Sukses",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);

            // 10. Arahkan ke halaman login
        FromLogin login = new FromLogin();
        login.setVisible(true);
        login.toFront();
        login.requestFocus();
        this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
            "Gagal mendaftar ke database! Periksa koneksi MySQL Anda.",
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_btnDaftarActionPerformed

    private void txtRegNoHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegNoHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegNoHPActionPerformed

    private void txtRegNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegNamaActionPerformed

    private void btnRegOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegOwnerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegOwnerActionPerformed

    private void btnRegPengunjungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPengunjungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegPengunjungActionPerformed
                        
   
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
            java.util.logging.Logger.getLogger(FromRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDaftar;
    private javax.swing.JToggleButton btnRegOwner;
    private javax.swing.JToggleButton btnRegPengunjung;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JTextField txtRegEmail;
    private javax.swing.JTextField txtRegNama;
    private javax.swing.JTextField txtRegNoHP;
    private javax.swing.JPasswordField txtRegPassword;
    private javax.swing.JTextField txtRegUsername;
    // End of variables declaration//GEN-END:variables
}
