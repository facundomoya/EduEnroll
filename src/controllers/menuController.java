package controllers;
import javax.swing.JOptionPane;
import static models.dbConnection.showStudent;
import views.menuView;

public class menuController {
    public static menuView view = new menuView();
    
    public static void showMenu(){
    view.setVisible(true);
    }
    
    public static void exitButton(){
       int option = JOptionPane.showConfirmDialog(
                null,                          // El componente padre (null para que sea una ventana emergente)
                "Are you sure you want to logout?", // El mensaje a mostrar
                "Logout confirmation",      // El título de la ventana
                JOptionPane.YES_NO_OPTION,     // Los botones: "YES" y "NO"
                JOptionPane.QUESTION_MESSAGE   // Tipo de mensaje (en este caso, una pregunta)
        );
    if(option == 0){
    loginController.view.setVisible(true);
    view.setVisible(false);
    }  
    }
    
    public static void studentClick(){
    studentController.view.setVisible(true);
    view.setVisible(false);
    showStudent();
    }
}
