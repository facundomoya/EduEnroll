package controllers;
import views.addStudentView;
import views.studentView;


public class studentController {
    public static studentView  view = new studentView();
    public static addStudentView view_addStudent = new addStudentView();
            
    public static void addStudentButton(){
    view_addStudent.setVisible(true);
    view_addStudent.setDefaultCloseOperation(addStudentView.DISPOSE_ON_CLOSE);
    }
}
