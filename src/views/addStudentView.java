/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.studentController;

/**
 *
 * @author facun
 */
public class addStudentView extends javax.swing.JFrame {

    /**
     * Creates new form addStudent
     */
    public addStudentView() {
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

        addStudentDialog = new javax.swing.JDialog();
        addStudentLabel1 = new javax.swing.JLabel();
        addStudentLabel2 = new javax.swing.JLabel();
        addStudentLabel3 = new javax.swing.JLabel();
        addStudentTextField1 = new javax.swing.JTextField();
        addStudentLabel4 = new javax.swing.JLabel();
        addStudentLabel5 = new javax.swing.JLabel();
        addStudentLabel6 = new javax.swing.JLabel();
        addStudentTextField2 = new javax.swing.JTextField();
        addStudentTextField3 = new javax.swing.JTextField();
        addStudentTextField4 = new javax.swing.JTextField();
        addStudentTextField5 = new javax.swing.JTextField();
        addStudentTextField6 = new javax.swing.JTextField();
        addStudentLabel7 = new javax.swing.JLabel();
        addStudentComboBox = new javax.swing.JComboBox<>();
        addStudentCancelButton = new javax.swing.JButton();
        addStudentAddButton = new javax.swing.JButton();

        javax.swing.GroupLayout addStudentDialogLayout = new javax.swing.GroupLayout(addStudentDialog.getContentPane());
        addStudentDialog.getContentPane().setLayout(addStudentDialogLayout);
        addStudentDialogLayout.setHorizontalGroup(
            addStudentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        addStudentDialogLayout.setVerticalGroup(
            addStudentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addStudentLabel1.setText("Name:");

        addStudentLabel2.setText("Lastname:");

        addStudentLabel3.setText("DNI:");

        addStudentLabel4.setText("Email:");

        addStudentLabel5.setText("Nationality:");

        addStudentLabel6.setText("Age:");

        addStudentLabel7.setText("Degree:");

        addStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Electrical Engineering", "Civil Engineering", "Mechanical Engineering" }));
        addStudentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentComboBoxActionPerformed(evt);
            }
        });

        addStudentCancelButton.setText("Cancel");
        addStudentCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentCancelButtonActionPerformed(evt);
            }
        });

        addStudentAddButton.setText("Add");
        addStudentAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addStudentLabel2)
                            .addComponent(addStudentLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStudentLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStudentLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addStudentTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(addStudentTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addStudentTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(addStudentTextField5, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addStudentLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(addStudentTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addStudentLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStudentLabel7))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(addStudentAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(addStudentCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE))
                            .addComponent(addStudentTextField6)
                            .addComponent(addStudentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addStudentLabel1)
                    .addComponent(addStudentTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addStudentLabel2)
                    .addComponent(addStudentTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addStudentLabel3)
                    .addComponent(addStudentTextField3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addStudentLabel4)
                    .addComponent(addStudentTextField4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addStudentLabel5)
                    .addComponent(addStudentTextField5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addStudentLabel6)
                    .addComponent(addStudentTextField6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addStudentLabel7)
                    .addComponent(addStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStudentCancelButton)
                    .addComponent(addStudentAddButton))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStudentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStudentComboBoxActionPerformed

    private void addStudentAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentAddButtonActionPerformed
        // TODO add your handling code here:
        boolean success = studentController.validationStudentandAddStudent();
        if(success){studentController.cleanTextFieldsAddStudent();}
    }//GEN-LAST:event_addStudentAddButtonActionPerformed

    private void addStudentCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentCancelButtonActionPerformed
        // TODO add your handling code here:
        studentController.cleanTextFieldsAddStudent();
    }//GEN-LAST:event_addStudentCancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(addStudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addStudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addStudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addStudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addStudentView().setVisible(true);
            }
        });
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudentAddButton;
    private javax.swing.JButton addStudentCancelButton;
    private javax.swing.JComboBox<String> addStudentComboBox;
    private javax.swing.JDialog addStudentDialog;
    private javax.swing.JLabel addStudentLabel1;
    private javax.swing.JLabel addStudentLabel2;
    private javax.swing.JLabel addStudentLabel3;
    private javax.swing.JLabel addStudentLabel4;
    private javax.swing.JLabel addStudentLabel5;
    private javax.swing.JLabel addStudentLabel6;
    private javax.swing.JLabel addStudentLabel7;
    private javax.swing.JTextField addStudentTextField1;
    private javax.swing.JTextField addStudentTextField2;
    private javax.swing.JTextField addStudentTextField3;
    private javax.swing.JTextField addStudentTextField4;
    private javax.swing.JTextField addStudentTextField5;
    private javax.swing.JTextField addStudentTextField6;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getAddStudentAddButton() {
        return addStudentAddButton;
    }

    public void setAddStudentAddButton(javax.swing.JButton addStudentAddButton) {
        this.addStudentAddButton = addStudentAddButton;
    }

    public javax.swing.JButton getAddStudentCancelButton() {
        return addStudentCancelButton;
    }

    public void setAddStudentCancelButton(javax.swing.JButton addStudentCancelButton) {
        this.addStudentCancelButton = addStudentCancelButton;
    }

    public javax.swing.JComboBox<String> getAddStudentComboBox() {
        return addStudentComboBox;
    }

    public void setAddStudentComboBox(javax.swing.JComboBox<String> addStudentComboBox) {
        this.addStudentComboBox = addStudentComboBox;
    }

    public javax.swing.JLabel getAddStudentLabel1() {
        return addStudentLabel1;
    }

    public void setAddStudentLabel1(javax.swing.JLabel addStudentLabel1) {
        this.addStudentLabel1 = addStudentLabel1;
    }

    public javax.swing.JLabel getAddStudentLabel2() {
        return addStudentLabel2;
    }

    public void setAddStudentLabel2(javax.swing.JLabel addStudentLabel2) {
        this.addStudentLabel2 = addStudentLabel2;
    }

    public javax.swing.JLabel getAddStudentLabel3() {
        return addStudentLabel3;
    }

    public void setAddStudentLabel3(javax.swing.JLabel addStudentLabel3) {
        this.addStudentLabel3 = addStudentLabel3;
    }

    public javax.swing.JLabel getAddStudentLabel4() {
        return addStudentLabel4;
    }

    public void setAddStudentLabel4(javax.swing.JLabel addStudentLabel4) {
        this.addStudentLabel4 = addStudentLabel4;
    }

    public javax.swing.JLabel getAddStudentLabel5() {
        return addStudentLabel5;
    }

    public void setAddStudentLabel5(javax.swing.JLabel addStudentLabel5) {
        this.addStudentLabel5 = addStudentLabel5;
    }

    public javax.swing.JLabel getAddStudentLabel6() {
        return addStudentLabel6;
    }

    public void setAddStudentLabel6(javax.swing.JLabel addStudentLabel6) {
        this.addStudentLabel6 = addStudentLabel6;
    }

    public javax.swing.JLabel getAddStudentLabel7() {
        return addStudentLabel7;
    }

    public void setAddStudentLabel7(javax.swing.JLabel addStudentLabel7) {
        this.addStudentLabel7 = addStudentLabel7;
    }

    public javax.swing.JTextField getAddStudentTextField1() {
        return addStudentTextField1;
    }

    public void setAddStudentTextField1(javax.swing.JTextField addStudentTextField1) {
        this.addStudentTextField1 = addStudentTextField1;
    }

    public javax.swing.JTextField getAddStudentTextField2() {
        return addStudentTextField2;
    }

    public void setAddStudentTextField2(javax.swing.JTextField addStudentTextField2) {
        this.addStudentTextField2 = addStudentTextField2;
    }

    public javax.swing.JTextField getAddStudentTextField3() {
        return addStudentTextField3;
    }

    public void setAddStudentTextField3(javax.swing.JTextField addStudentTextField3) {
        this.addStudentTextField3 = addStudentTextField3;
    }

    public javax.swing.JTextField getAddStudentTextField4() {
        return addStudentTextField4;
    }

    public void setAddStudentTextField4(javax.swing.JTextField addStudentTextField4) {
        this.addStudentTextField4 = addStudentTextField4;
    }

    public javax.swing.JTextField getAddStudentTextField5() {
        return addStudentTextField5;
    }

    public void setAddStudentTextField5(javax.swing.JTextField addStudentTextField5) {
        this.addStudentTextField5 = addStudentTextField5;
    }

    public javax.swing.JTextField getAddStudentTextField6() {
        return addStudentTextField6;
    }

    public void setAddStudentTextField6(javax.swing.JTextField addStudentTextField6) {
        this.addStudentTextField6 = addStudentTextField6;
    }

    public javax.swing.JDialog getAddStudentDialog() {
        return addStudentDialog;
    }

    public void setAddStudentDialog(javax.swing.JDialog addStudentDialog) {
        this.addStudentDialog = addStudentDialog;
    }
}
