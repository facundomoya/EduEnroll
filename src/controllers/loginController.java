package controllers;
import javax.swing.JOptionPane;
import static models.dbConnection.isValidUser;
import views.loginView;

public class loginController {
    
    static loginView view = new loginView();
    
    public static void show(){
    view.setVisible(true);
    }
    
    public static void loginButton(){
        String user = view.getUserTextField1().getText();
        String pass = view.getPassTextField().getText();
        // Verificar si el usuario y contraseña son correctos
        if (isValidUser(user, pass)) {
            // Si es válido, realizar las acciones necesarias, como redirigir a otra vista
            System.out.println("Valid user");
        } else {
            // Si no es válido, mostrar un mensaje de error
            System.out.println("Invalid user");
            JOptionPane.showMessageDialog(null, "Incorrect username or password", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
