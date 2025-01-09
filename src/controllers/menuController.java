package controllers;
import static models.dbConnection.showStudent;
import views.menuView;

public class menuController {
    public static menuView view = new menuView();
    
    public static void showMenu(){
    view.setVisible(true);
    }
    
    public static void exitButton(){
    loginController.view.setVisible(true);
    view.setVisible(false);
    }
    
    public static void studentClick(){
    studentController.view.setVisible(true);
    view.setVisible(false);
    showStudent();
    }
}
