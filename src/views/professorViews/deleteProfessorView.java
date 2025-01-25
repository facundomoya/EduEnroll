/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.professorViews;

import controllers.professorController;

/**
 *
 * @author facun
 */
public class deleteProfessorView extends javax.swing.JFrame {

    /**
     * Creates new form deleteProfessorView
     */
    public deleteProfessorView() {
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

        deleteProfessorLabel1 = new javax.swing.JLabel();
        deleteProfessorTextField1 = new javax.swing.JTextField();
        deleteProfessorButton1 = new javax.swing.JButton();
        deleteProfessorButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deleteProfessorLabel1.setText("Professor ID:");

        deleteProfessorButton1.setText("Delete");
        deleteProfessorButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProfessorButton1ActionPerformed(evt);
            }
        });

        deleteProfessorButton2.setText("Cancel");
        deleteProfessorButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProfessorButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(deleteProfessorLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteProfessorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(deleteProfessorButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteProfessorTextField1)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteProfessorLabel1)
                    .addComponent(deleteProfessorTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteProfessorButton1)
                    .addComponent(deleteProfessorButton2))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteProfessorButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProfessorButton1ActionPerformed
        // TODO add your handling code here:
        professorController.deleteButton();
        professorController.cleanTextFieldDeleteProfessor();
    }//GEN-LAST:event_deleteProfessorButton1ActionPerformed

    private void deleteProfessorButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProfessorButton2ActionPerformed
        // TODO add your handling code here:
        professorController.hideDeleteProfessorView();
    }//GEN-LAST:event_deleteProfessorButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(deleteProfessorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deleteProfessorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deleteProfessorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deleteProfessorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deleteProfessorView().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteProfessorButton1;
    private javax.swing.JButton deleteProfessorButton2;
    private javax.swing.JLabel deleteProfessorLabel1;
    private javax.swing.JTextField deleteProfessorTextField1;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getDeleteProfessorButton1() {
        return deleteProfessorButton1;
    }

    public void setDeleteProfessorButton1(javax.swing.JButton deleteProfessorButton1) {
        this.deleteProfessorButton1 = deleteProfessorButton1;
    }

    public javax.swing.JButton getDeleteProfessorButton2() {
        return deleteProfessorButton2;
    }

    public void setDeleteProfessorButton2(javax.swing.JButton deleteProfessorButton2) {
        this.deleteProfessorButton2 = deleteProfessorButton2;
    }

    public javax.swing.JLabel getDeleteProfessorLabel1() {
        return deleteProfessorLabel1;
    }

    public void setDeleteProfessorLabel1(javax.swing.JLabel deleteProfessorLabel1) {
        this.deleteProfessorLabel1 = deleteProfessorLabel1;
    }

    public javax.swing.JTextField getDeleteProfessorTextField1() {
        return deleteProfessorTextField1;
    }

    public void setDeleteProfessorTextField1(javax.swing.JTextField deleteProfessorTextField1) {
        this.deleteProfessorTextField1 = deleteProfessorTextField1;
    }
}
