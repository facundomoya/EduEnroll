package controllers;

import views.addStudentView;
import views.studentView;
import javax.swing.JOptionPane;
import static models.Person.isValidAge;
import static models.Person.isValidDNI;
import static models.Person.isValidEmail;
import static models.dbConnection.checkDNIandEmail;
import static models.dbConnection.newStudent;
import static models.dbConnection.showStudent;
import views.editStudentView;

public class studentController {

    public static studentView view = new studentView();
    public static addStudentView view_addStudent = new addStudentView();
    public static editStudentView view_editStudent = new editStudentView();
    
    public static void hideStudentView(){
    view.setVisible(false);
    }
    
    public static void addStudentButton() {
        view_addStudent.setVisible(true);
        view_addStudent.setDefaultCloseOperation(addStudentView.DISPOSE_ON_CLOSE);
    }
    
    public static void showEditStudentView(){
    view_editStudent.setVisible(true);
    view_editStudent.setDefaultCloseOperation(addStudentView.DISPOSE_ON_CLOSE);
    }
    
    public static boolean validationStudentandAddStudent() {
    String name = view_addStudent.getAddStudentTextField1().getText();
    String lastname = view_addStudent.getAddStudentTextField2().getText();
    String dniStr = view_addStudent.getAddStudentTextField3().getText();
    String email = view_addStudent.getAddStudentTextField4().getText();
    String nationality = view_addStudent.getAddStudentTextField5().getText();
    String ageStr = view_addStudent.getAddStudentTextField6().getText();
    String degree = (String) view_addStudent.getAddStudentComboBox().getSelectedItem();
    String status = "active";
    
    boolean flag = false;
    
    if(dniStr != null && !dniStr.trim().isEmpty() && ageStr != null && !ageStr.trim().isEmpty() && !(name.equals("") || lastname.equals("") || email.equals("") || nationality.equals("") || degree.equals("..."))){
    if(isValidDNI(dniStr)){
    if(isValidAge(ageStr)){
        if(isValidEmail(email)){
            try{
    int dni = Integer.parseInt(dniStr);
    int age = Integer.parseInt(ageStr);
    boolean flagValidations = checkDNIandEmail(dni,email);
    if(flagValidations == false){
    newStudent(status, degree, name, lastname, age, nationality, email, dni);
    JOptionPane.showMessageDialog(null, "The student has been successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
    showStudent();
    flag = true;
    }
    }catch(NumberFormatException e){
    }
    }else{
    JOptionPane.showMessageDialog(null, "Email is invalid", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    }else{
    JOptionPane.showMessageDialog(null, "Age is invalid", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    }else{
    JOptionPane.showMessageDialog(null, "DNI is invalid", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    }else{
    JOptionPane.showMessageDialog(null, "You have to complete all fields", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    return flag;
    }
    
    public static void cleanTextFieldsAddStudent(){
    view_addStudent.setVisible(false);
    studentController.view_addStudent.getAddStudentTextField1().setText("");
    studentController.view_addStudent.getAddStudentTextField2().setText("");
    studentController.view_addStudent.getAddStudentTextField3().setText("");
    studentController.view_addStudent.getAddStudentTextField4().setText("");
    studentController.view_addStudent.getAddStudentTextField5().setText("");
    studentController.view_addStudent.getAddStudentTextField6().setText("");
    studentController.view_addStudent.getAddStudentComboBox().setSelectedIndex(0);
    }
    
    
}


