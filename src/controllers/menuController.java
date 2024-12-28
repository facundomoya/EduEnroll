package controllers;
import views.menuView;

public class menuController {
    static menuView view = new menuView();
    
    public static void exitButton(){
    view.setVisible(false);
    }
    
}
