package controllers;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static models.dbConnection.isValidUser;
import views.loginView;

public class loginController {

    public static loginView view = new loginView();
   
    public static void show(){
    view.setVisible(true);
    }
    
    public static void loginButton(){
        String user = view.getUserTextField1().getText();
        String pass = view.getPassTextField().getText();
        // Verificar si el usuario y contraseña son correctos
        if (isValidUser(user, pass)) {
            // Si es válido, realizar las acciones necesarias, como redirigir a otra vista            
            menuController.view.setVisible(true);
            view.setVisible(false);
            JLabel menuLabel2 = menuController.view.getMenuLabel2();
            menuLabel2.setText(user);
            view.getUserTextField1().setText("");
            view.getPassTextField().setText("");
        } else {
            // Si no es válido, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Incorrect username or password", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
