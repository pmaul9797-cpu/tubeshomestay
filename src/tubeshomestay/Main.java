package tubeshomestay;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
           
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FromLogin loginForm = new FromLogin();
                loginForm.setLocationRelativeTo(null);
                loginForm.setVisible(true);
            }
        });
    }
}