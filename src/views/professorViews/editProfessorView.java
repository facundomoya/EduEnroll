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
public class editProfessorView extends javax.swing.JFrame {

    /**
     * Creates new form editProfessorView
     */
    public editProfessorView() {
        initComponents();
        editProfessorLabel2.setEnabled(false);
        editProfessorLabel3.setEnabled(false);
        editProfessorLabel4.setEnabled(false);
        editProfessorLabel5.setEnabled(false);
        editProfessorLabel6.setEnabled(false);
        editProfessorTextField2.setEnabled(false);
        editProfessorTextField3.setEnabled(false);
        editProfessorTextField4.setEnabled(false);
        editProfessorTextField5.setEnabled(false);
        editProfessorComboBox1.setEnabled(false);
        editProfessorButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editProfessorLabel1 = new javax.swing.JLabel();
        editProfessorTextField1 = new javax.swing.JTextField();
        searchEditProfessorButton = new javax.swing.JButton();
        editProfessorTextField2 = new javax.swing.JTextField();
        editProfessorLabel2 = new javax.swing.JLabel();
        editProfessorLabel3 = new javax.swing.JLabel();
        editProfessorTextField3 = new javax.swing.JTextField();
        editProfessorLabel4 = new javax.swing.JLabel();
        editProfessorTextField4 = new javax.swing.JTextField();
        editProfessorLabel5 = new javax.swing.JLabel();
        editProfessorTextField5 = new javax.swing.JTextField();
        editProfessorLabel6 = new javax.swing.JLabel();
        editProfessorComboBox1 = new javax.swing.JComboBox<>();
        editProfessorButton = new javax.swing.JButton();
        cancelProfessorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editProfessorLabel1.setText("ProfessorID:");

        searchEditProfessorButton.setText("Search");
        searchEditProfessorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEditProfessorButtonActionPerformed(evt);
            }
        });

        editProfessorLabel2.setText("DNI:");

        editProfessorLabel3.setText("Name:");

        editProfessorTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfessorTextField3ActionPerformed(evt);
            }
        });

        editProfessorLabel4.setText("Lastname:");

        editProfessorLabel5.setText("Nationality:");

        editProfessorLabel6.setText("Type:");

        editProfessorComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Permanent", "Substitute" }));

        editProfessorButton.setText("Edit");
        editProfessorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfessorButtonActionPerformed(evt);
            }
        });

        cancelProfessorButton.setText("Cancel");
        cancelProfessorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelProfessorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editProfessorLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editProfessorTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchEditProfessorButton, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(editProfessorLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editProfessorLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                .addComponent(editProfessorLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(editProfessorLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editProfessorLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editProfessorTextField2)
                            .addComponent(editProfessorTextField3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editProfessorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(cancelProfessorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(editProfessorTextField5)
                            .addComponent(editProfessorTextField4)
                            .addComponent(editProfessorComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchEditProfessorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProfessorLabel1)
                    .addComponent(editProfessorTextField1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editProfessorLabel2)
                    .addComponent(editProfessorTextField2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editProfessorLabel3)
                    .addComponent(editProfessorTextField3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editProfessorTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProfessorLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editProfessorTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProfessorLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editProfessorLabel6)
                    .addComponent(editProfessorComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editProfessorButton)
                    .addComponent(cancelProfessorButton))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchEditProfessorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEditProfessorButtonActionPerformed
        // TODO add your handling code here:
        editProfessorLabel2.setEnabled(true);
        editProfessorLabel3.setEnabled(true);
        editProfessorLabel4.setEnabled(true);
        editProfessorLabel5.setEnabled(true);
        editProfessorLabel6.setEnabled(true);
        editProfessorTextField2.setEnabled(true);
        editProfessorTextField3.setEnabled(true);
        editProfessorTextField4.setEnabled(true);
        editProfessorTextField5.setEnabled(true);
        editProfessorComboBox1.setEnabled(true);
        editProfessorButton.setEnabled(true);
        professorController.searchEditButton();
    }//GEN-LAST:event_searchEditProfessorButtonActionPerformed

    private void editProfessorTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfessorTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProfessorTextField3ActionPerformed

    private void editProfessorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfessorButtonActionPerformed
        // TODO add your handling code here:
        boolean success = professorController.editButton();
        if(success){professorController.cleanTextFieldEditProfessor();}
    }//GEN-LAST:event_editProfessorButtonActionPerformed

    private void cancelProfessorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelProfessorButtonActionPerformed
        // TODO add your handling code here:
        professorController.view_editProfessor.setVisible(false);
        professorController.cleanTextFieldEditProfessor();
    }//GEN-LAST:event_cancelProfessorButtonActionPerformed

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
            java.util.logging.Logger.getLogger(editProfessorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editProfessorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editProfessorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editProfessorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editProfessorView().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelProfessorButton;
    private javax.swing.JButton editProfessorButton;
    private javax.swing.JComboBox<String> editProfessorComboBox1;
    private javax.swing.JLabel editProfessorLabel1;
    private javax.swing.JLabel editProfessorLabel2;
    private javax.swing.JLabel editProfessorLabel3;
    private javax.swing.JLabel editProfessorLabel4;
    private javax.swing.JLabel editProfessorLabel5;
    private javax.swing.JLabel editProfessorLabel6;
    private javax.swing.JTextField editProfessorTextField1;
    private javax.swing.JTextField editProfessorTextField2;
    private javax.swing.JTextField editProfessorTextField3;
    private javax.swing.JTextField editProfessorTextField4;
    private javax.swing.JTextField editProfessorTextField5;
    private javax.swing.JButton searchEditProfessorButton;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getCancelProfessorButton() {
        return cancelProfessorButton;
    }

    public void setCancelProfessorButton(javax.swing.JButton cancelProfessorButton) {
        this.cancelProfessorButton = cancelProfessorButton;
    }

    public javax.swing.JButton getEditProfessorButton() {
        return editProfessorButton;
    }

    public void setEditProfessorButton(javax.swing.JButton editProfessorButton) {
        this.editProfessorButton = editProfessorButton;
    }

    public javax.swing.JComboBox<String> getEditProfessorComboBox1() {
        return editProfessorComboBox1;
    }

    public void setEditProfessorComboBox1(javax.swing.JComboBox<String> editProfessorComboBox1) {
        this.editProfessorComboBox1 = editProfessorComboBox1;
    }

    public javax.swing.JLabel getEditProfessorLabel1() {
        return editProfessorLabel1;
    }

    public void setEditProfessorLabel1(javax.swing.JLabel editProfessorLabel1) {
        this.editProfessorLabel1 = editProfessorLabel1;
    }

    public javax.swing.JLabel getEditProfessorLabel2() {
        return editProfessorLabel2;
    }

    public void setEditProfessorLabel2(javax.swing.JLabel editProfessorLabel2) {
        this.editProfessorLabel2 = editProfessorLabel2;
    }

    public javax.swing.JLabel getEditProfessorLabel3() {
        return editProfessorLabel3;
    }

    public void setEditProfessorLabel3(javax.swing.JLabel editProfessorLabel3) {
        this.editProfessorLabel3 = editProfessorLabel3;
    }

    public javax.swing.JLabel getEditProfessorLabel4() {
        return editProfessorLabel4;
    }

    public void setEditProfessorLabel4(javax.swing.JLabel editProfessorLabel4) {
        this.editProfessorLabel4 = editProfessorLabel4;
    }

    public javax.swing.JLabel getEditProfessorLabel5() {
        return editProfessorLabel5;
    }

    public void setEditProfessorLabel5(javax.swing.JLabel editProfessorLabel5) {
        this.editProfessorLabel5 = editProfessorLabel5;
    }

    public javax.swing.JLabel getEditProfessorLabel6() {
        return editProfessorLabel6;
    }

    public void setEditProfessorLabel6(javax.swing.JLabel editProfessorLabel6) {
        this.editProfessorLabel6 = editProfessorLabel6;
    }

    public javax.swing.JTextField getEditProfessorTextField1() {
        return editProfessorTextField1;
    }

    public void setEditProfessorTextField1(javax.swing.JTextField editProfessorTextField1) {
        this.editProfessorTextField1 = editProfessorTextField1;
    }

    public javax.swing.JTextField getEditProfessorTextField2() {
        return editProfessorTextField2;
    }

    public void setEditProfessorTextField2(javax.swing.JTextField editProfessorTextField2) {
        this.editProfessorTextField2 = editProfessorTextField2;
    }

    public javax.swing.JTextField getEditProfessorTextField3() {
        return editProfessorTextField3;
    }

    public void setEditProfessorTextField3(javax.swing.JTextField editProfessorTextField3) {
        this.editProfessorTextField3 = editProfessorTextField3;
    }

    public javax.swing.JTextField getEditProfessorTextField4() {
        return editProfessorTextField4;
    }

    public void setEditProfessorTextField4(javax.swing.JTextField editProfessorTextField4) {
        this.editProfessorTextField4 = editProfessorTextField4;
    }

    public javax.swing.JTextField getEditProfessorTextField5() {
        return editProfessorTextField5;
    }

    public void setEditProfessorTextField5(javax.swing.JTextField editProfessorTextField5) {
        this.editProfessorTextField5 = editProfessorTextField5;
    }

    public javax.swing.JButton getSearchEditProfessorButton() {
        return searchEditProfessorButton;
    }

    public void setSearchEditProfessorButton(javax.swing.JButton searchEditProfessorButton) {
        this.searchEditProfessorButton = searchEditProfessorButton;
    }
}
