package controllers;
import views.menuView;

public class menuController {
    static menuView view = new menuView();
    
    public static void exitButton(){
    view.setVisible(false);
    loginController.view.setVisible(true);
    }
    
    public static void studentClick(){
    view.setVisible(false);
    studentController.view.setVisible(true);
    }
}
