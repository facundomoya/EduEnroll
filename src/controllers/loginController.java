package controllers;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import models.User;
import static models.dbConnection.getConnection;
import static models.dbConnection.isValidUser;
import views.loginView;

public class loginController {

    public static loginView view = new loginView();
   
    public static void show(){
    view.setVisible(true);
    }
    
    public static void loginButton(){
        String user_name = view.getUserTextField1().getText();
        String pass = view.getPassTextField().getText();
        JLabel menuLabel2 = menuController.view.getMenuLabel2();
        getConnection();

        // Verificar si el usuario y contraseña son correctos
        User user = isValidUser(user_name, pass);       
        if (user != null) {
            if(user.getUser_type() == 1){
            // Si es válido, realizar las acciones necesarias, como redirigir a otra vista
            menuController.view.setVisible(true);   
            view.setVisible(false);           
            menuLabel2.setText(user_name);
            view.getUserTextField1().setText("");
            view.getPassTextField().setText("");
            menuController.view.getMenuStudentButton().setEnabled(true);
            menuController.view.getMenuCourseButton().setEnabled(true);
            menuController.view.getMenuDegreeButton().setEnabled(true);
            menuController.view.getMenuAddUserButton().setEnabled(true);
            studentController.view.getAddStudentButton().setEnabled(true);
            studentController.view.getEditStudentButton().setEnabled(true);
            studentController.view.getDeleteStudentButton().setEnabled(true);
            professorController.view.getEditProfessorButton().setEnabled(true);
            professorController.view.getDeleteProfessorButton().setEnabled(true);
            }else{
            menuController.view.setVisible(true);   
            view.setVisible(false);           
            menuLabel2.setText(user_name);
            view.getUserTextField1().setText("");
            view.getPassTextField().setText("");
            menuController.view.getMenuAddUserButton().setEnabled(false);
            studentController.view.getAddStudentButton().setEnabled(false);
            studentController.view.getEditStudentButton().setEnabled(false);
            studentController.view.getDeleteStudentButton().setEnabled(false);
            professorController.view.getEditProfessorButton().setEnabled(false);
            professorController.view.getDeleteProfessorButton().setEnabled(false);
            }           
        }else {
            JOptionPane.showMessageDialog(null, "Incorrect username or password", "Alert", JOptionPane.INFORMATION_MESSAGE);         
        }
    }
}
