/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.menuController;
import controllers.studentController;

/**
 *
 * @author facun
 */
public class studentView extends javax.swing.JFrame {

    /**
     * Creates new form studentView
     */
    public studentView() {
        initComponents();
    }
    
     // Establecer el texto del placeholder

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        printButton = new javax.swing.JButton();
        addStudentButton = new javax.swing.JButton();
        editStudentButton = new javax.swing.JButton();
        searchStudentButton = new javax.swing.JButton();
        deleteStudentButton = new javax.swing.JButton();
        backStudentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studentLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        studentLabel1.setText("STUDENT");

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Name", "Lastname", "Date of birth", "Nacionality", "Degree", "DNI", "Status"
            }
        ));
        jScrollPane1.setViewportView(studentTable);
        if (studentTable.getColumnModel().getColumnCount() > 0) {
            studentTable.getColumnModel().getColumn(5).setPreferredWidth(110);
        }

        printButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\facun\\OneDrive\\Documents\\NetBeansProjects\\EduEnroll\\resources\\images\\print-icon.png")); // NOI18N

        addStudentButton.setText("Add new student");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        editStudentButton.setText("Edit student");
        editStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStudentButtonActionPerformed(evt);
            }
        });

        searchStudentButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\facun\\OneDrive\\Documents\\NetBeansProjects\\EduEnroll\\resources\\images\\search-icon.png")); // NOI18N

        deleteStudentButton.setText("Delete student");

        backStudentButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\facun\\OneDrive\\Documents\\NetBeansProjects\\EduEnroll\\resources\\images\\back-icon.png")); // NOI18N
        backStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentLabel1)
                        .addGap(146, 146, 146)
                        .addComponent(searchStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(addStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(studentLabel1)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backStudentButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(searchStudentButton)
                                .addComponent(printButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addStudentButton)
                .addGap(18, 18, 18)
                .addComponent(editStudentButton)
                .addGap(18, 18, 18)
                .addComponent(deleteStudentButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
        // TODO add your handling code here:
        studentController.addStudentButton();
    }//GEN-LAST:event_addStudentButtonActionPerformed

    private void backStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backStudentButtonActionPerformed
        // TODO add your handling code here:
        menuController.showMenu();
        studentController.hideStudentView();        
    }//GEN-LAST:event_backStudentButtonActionPerformed

    private void editStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStudentButtonActionPerformed
        // TODO add your handling code here:
        studentController.showEditStudentView();
    }//GEN-LAST:event_editStudentButtonActionPerformed

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
            java.util.logging.Logger.getLogger(studentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentView().setVisible(true);
            }
        });
    }
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudentButton;
    private javax.swing.JButton backStudentButton;
    private javax.swing.JButton deleteStudentButton;
    private javax.swing.JButton editStudentButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printButton;
    private javax.swing.JButton searchStudentButton;
    private javax.swing.JLabel studentLabel1;
    private javax.swing.JTable studentTable;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getAddStudentButton() {
        return addStudentButton;
    }

    public void setAddStudentButton(javax.swing.JButton addStudentButton) {
        this.addStudentButton = addStudentButton;
    }

    public javax.swing.JButton getEditStudentButton() {
        return editStudentButton;
    }

    public void setEditStudentButton(javax.swing.JButton editStudentButton) {
        this.editStudentButton = editStudentButton;
    }

    public javax.swing.JButton getPrintButton() {
        return printButton;
    }

    public void setPrintButton(javax.swing.JButton printButton) {
        this.printButton = printButton;
    }

    public javax.swing.JLabel getStudentLabel1() {
        return studentLabel1;
    }

    public void setStudentLabel1(javax.swing.JLabel studentLabel1) {
        this.studentLabel1 = studentLabel1;
    }

    public javax.swing.JTable getStudentTable() {
        return studentTable;
    }

    public void setStudentTable(javax.swing.JTable studentTable) {
        this.studentTable = studentTable;
    }

    public javax.swing.JButton getBackStudentButton() {
        return backStudentButton;
    }

    public void setBackStudentButton(javax.swing.JButton backStudentButton) {
        this.backStudentButton = backStudentButton;
    }

    public javax.swing.JButton getDeleteStudentButton() {
        return deleteStudentButton;
    }

    public void setDeleteStudentButton(javax.swing.JButton deleteStudentButton) {
        this.deleteStudentButton = deleteStudentButton;
    }

    public javax.swing.JButton getSearchStudentButton() {
        return searchStudentButton;
    }

    public void setSearchStudentButton(javax.swing.JButton searchStudentButton) {
        this.searchStudentButton = searchStudentButton;
    }

    
}
