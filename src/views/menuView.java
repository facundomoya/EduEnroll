/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.menuController;


/**
 *
 * @author facun
 */
public class menuView extends javax.swing.JFrame {

    /**
     * Creates new form menuView
     */
    public menuView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuLabel1 = new javax.swing.JLabel();
        menuLabel2 = new javax.swing.JLabel();
        menuLabel3 = new javax.swing.JLabel();
        menuLabel4 = new javax.swing.JLabel();
        menuLabel5 = new javax.swing.JLabel();
        menuLabel6 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        menuLabel7 = new javax.swing.JLabel();
        menuLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        menuLabel1.setText("MENU");

        menuLabel2.setText("jLabel2");

        menuLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        menuLabel3.setForeground(new java.awt.Color(0, 0, 255));
        menuLabel3.setText("o Student");

        menuLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        menuLabel4.setForeground(new java.awt.Color(0, 0, 255));
        menuLabel4.setText("o Professor");

        menuLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        menuLabel5.setForeground(new java.awt.Color(0, 0, 255));
        menuLabel5.setText("o Change password");

        menuLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        menuLabel6.setForeground(new java.awt.Color(0, 0, 255));
        menuLabel6.setText("o Degree");

        exitButton.setText("Exit");
        exitButton.setName("exitButton"); // NOI18N
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        menuLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        menuLabel7.setForeground(new java.awt.Color(0, 0, 255));
        menuLabel7.setText("o Course");

        menuLabel8.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        menuLabel8.setForeground(new java.awt.Color(0, 0, 255));
        menuLabel8.setText("o Add admin user");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuLabel1)
                        .addGap(89, 89, 89)
                        .addComponent(menuLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuLabel1)
                    .addComponent(menuLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menuLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        menuController.exitButton();
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(menuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel menuLabel1;
    private javax.swing.JLabel menuLabel2;
    private javax.swing.JLabel menuLabel3;
    private javax.swing.JLabel menuLabel4;
    private javax.swing.JLabel menuLabel5;
    private javax.swing.JLabel menuLabel6;
    private javax.swing.JLabel menuLabel7;
    private javax.swing.JLabel menuLabel8;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getjButton2() {
        return exitButton;
    }

    public void setjButton2(javax.swing.JButton jButton2) {
        this.exitButton = jButton2;
    }

    public javax.swing.JLabel getMenuLabel1() {
        return menuLabel1;
    }

    public void setMenuLabel1(javax.swing.JLabel menuLabel1) {
        this.menuLabel1 = menuLabel1;
    }

    public javax.swing.JLabel getMenuLabel2() {
        return menuLabel2;
    }

    public void setMenuLabel2(javax.swing.JLabel menuLabel2) {
        this.menuLabel2 = menuLabel2;
    }

    public javax.swing.JLabel getMenuLabel3() {
        return menuLabel3;
    }

    public void setMenuLabel3(javax.swing.JLabel menuLabel3) {
        this.menuLabel3 = menuLabel3;
    }

    public javax.swing.JLabel getMenuLabel4() {
        return menuLabel4;
    }

    public void setMenuLabel4(javax.swing.JLabel menuLabel4) {
        this.menuLabel4 = menuLabel4;
    }

    public javax.swing.JLabel getMenuLabel5() {
        return menuLabel5;
    }

    public void setMenuLabel5(javax.swing.JLabel menuLabel5) {
        this.menuLabel5 = menuLabel5;
    }

    public javax.swing.JLabel getMenuLabel6() {
        return menuLabel6;
    }

    public void setMenuLabel6(javax.swing.JLabel menuLabel6) {
        this.menuLabel6 = menuLabel6;
    }

    public javax.swing.JLabel getMenuLabel7() {
        return menuLabel7;
    }

    public void setMenuLabel7(javax.swing.JLabel menuLabel7) {
        this.menuLabel7 = menuLabel7;
    }   
}
