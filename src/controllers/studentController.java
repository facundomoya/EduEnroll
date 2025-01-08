package controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import views.addStudentView;
import views.studentView;
import javax.swing.JOptionPane;
import static models.Person.isValidAge;
import static models.Person.isValidDNI;
import static models.dbConnection.checkDNIandEmail;
import static models.dbConnection.newStudent;

public class studentController {

    public static studentView view = new studentView();
    public static addStudentView view_addStudent = new addStudentView();
    
    public static void addStudentButton() {
        view_addStudent.setVisible(true);
        view_addStudent.setDefaultCloseOperation(addStudentView.DISPOSE_ON_CLOSE);
    }
    
    public static void validationStudentandAddStudent() {
    String name = view_addStudent.getAddStudentTextField1().getText();
    String lastname = view_addStudent.getAddStudentTextField2().getText();
    String dniStr = view_addStudent.getAddStudentTextField3().getText();
    String email = view_addStudent.getAddStudentTextField4().getText();
    String nationality = view_addStudent.getAddStudentTextField5().getText();
    String ageStr = view_addStudent.getAddStudentTextField6().getText();
    String degree = (String) view_addStudent.getAddStudentComboBox().getSelectedItem();
    String status = "active";
    
    if(dniStr != null && !dniStr.trim().isEmpty() && ageStr != null && !ageStr.trim().isEmpty() && !(name.equals("") || lastname.equals("") || email.equals("") || nationality.equals("") || degree.equals("..."))){
    if(isValidDNI(dniStr)){
    if(isValidAge(ageStr)){
    try{
    int dni = Integer.parseInt(dniStr);
    int age = Integer.parseInt(ageStr);
    checkDNIandEmail(dni,email);   
    newStudent(status, degree, name, lastname, age, nationality, email, dni);
    JOptionPane.showMessageDialog(null, "The student has been successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
    cleanTextFieldsAddStudent();
    }catch(NumberFormatException e){
    }
    }else{
    JOptionPane.showMessageDialog(null, "Age is invalid", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    }else{
    JOptionPane.showMessageDialog(null, "DNI is invalid", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    }else{
    JOptionPane.showMessageDialog(null, "You have to complete all fields", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
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


