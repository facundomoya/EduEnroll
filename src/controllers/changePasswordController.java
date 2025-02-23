package controllers;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import models.User;
import static models.dbConnection.changePassword;
import static models.dbConnection.getUser;
import views.changePasswordView;
import views.menuView;

public class changePasswordController {
    public static menuView menuView = new menuView();
    public static changePasswordView changePasswordView = new changePasswordView();
    
    public static void showChangePasswordView(){
    changePasswordView.setVisible(true);
    changePasswordView.setDefaultCloseOperation(changePasswordView.DISPOSE_ON_CLOSE);
    }
    
    public static void setUserValue(){
    JLabel menuLabel2 = menuController.view.getMenuLabel2();
    String userlabel = menuLabel2.getText();
    changePasswordView.getChangePasswordTextField1().setEnabled(false);
    changePasswordView.getChangePasswordTextField1().setText(userlabel);
    }
    
    public static void changePass(){
    String username = changePasswordView.getChangePasswordTextField1().getText();
    String pass = changePasswordView.getChangePasswordTextField2().getText();
    User user = getUser(username);
    changePassword(user, pass);
    changePasswordView.getChangePasswordTextField2().setText("");
    JOptionPane.showMessageDialog(null, "Password has been successfully changed. Restart the application", "Success", JOptionPane.INFORMATION_MESSAGE);
    changePasswordView.setVisible(false);
    }
}
