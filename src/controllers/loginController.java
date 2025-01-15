package controllers;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import models.User;
import static models.dbConnection.isValidUser;
import views.loginView;
import views.menuView;

public class loginController {

    public static loginView view = new loginView();
   
    public static void show(){
    view.setVisible(true);
    }
    
    public static void loginButton(){
        String user_name = view.getUserTextField1().getText();
        String pass = view.getPassTextField().getText();
        JLabel menuLabel2 = menuController.view.getMenuLabel2();

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
            }else{
            menuController.view.getMenuStudentButton().setEnabled(false);
            menuController.view.getMenuCourseButton().setEnabled(false);
            menuController.view.getMenuDegreeButton().setEnabled(false);
            menuController.view.getMenuAddUserButton().setEnabled(false);
            }           
        } else {
            // Si no es válido, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Incorrect username or password", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
