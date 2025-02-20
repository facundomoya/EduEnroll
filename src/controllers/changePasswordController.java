package controllers;

import javax.swing.JOptionPane;
import models.User;
import static models.dbConnection.changePassword;
import static models.dbConnection.getUser;
import views.changePasswordView;
import views.loginView;

public class changePasswordController {
    public static loginView loginView = new loginView();
    public static changePasswordView changePasswordView = new changePasswordView();
    
    public static void showChangePasswordView(){
    changePasswordView.setVisible(true);

    }
    
    public static void changePass(){
    String username = loginView.getLoginLabel2().getText();
    String pass = changePasswordView.getChangePasswordTextField1().getText();
    User user = getUser(username);
    if(user != null){
    changePassword(user, pass);
    }else{
    JOptionPane.showMessageDialog(null, "No user was found with that user name", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    
    }
}
