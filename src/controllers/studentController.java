package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import views.addStudentView;
import views.studentView;
import javax.swing.JOptionPane;
import static models.Person.isValidBirth;
import static models.Person.isValidDNI;
import static models.Person.isValidEmail;
import models.Student;
import static models.Student.isValidStudentID;
import static models.dbConnection.checkDNIStudentEdit;
import static models.dbConnection.checkDNIandEmail;
import static models.dbConnection.editStudent;
import static models.dbConnection.newStudent;
import static models.dbConnection.searchStudentEdit;
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
        cleanTextFieldsAddStudent();
    }
    
    public static void showEditStudentView(){
    view_editStudent.setVisible(true);
    view_editStudent.setDefaultCloseOperation(addStudentView.DISPOSE_ON_CLOSE);
    cleanTextFieldEditStudent();
    }
    
    public static boolean validationStudentandAddStudent() {
    String name = view_addStudent.getAddStudentTextField1().getText();
    String lastname = view_addStudent.getAddStudentTextField2().getText();
    String dniStr = view_addStudent.getAddStudentTextField3().getText();
    String email = view_addStudent.getAddStudentTextField4().getText();
    String nationality = view_addStudent.getAddStudentTextField5().getText();
    String birthStr = view_addStudent.getAddStudentTextField6().getText();
    String degree = (String) view_addStudent.getAddStudentComboBox().getSelectedItem();
    String status = "active";
    
    boolean flag = false;
    
    
    if(dniStr != null && !dniStr.trim().isEmpty() && birthStr != null && !birthStr.trim().isEmpty() && !(name.equals("") || lastname.equals("") || email.equals("") || nationality.equals("") || degree.equals("..."))){
    if(isValidDNI(dniStr)){
    if(isValidBirth(birthStr)){
        LocalDate birth = LocalDate.parse(birthStr);
        if(isValidEmail(email)){
            try{
    int dni = Integer.parseInt(dniStr);
    boolean flagValidations = checkDNIandEmail(dni,email);
    if(flagValidations == false){
    newStudent(0, status, degree, name, lastname, birth, nationality, email, dni);
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
    JOptionPane.showMessageDialog(null, "Date of birth is invalid. Follow the format YYYY-MM-DD", "Alert", JOptionPane.INFORMATION_MESSAGE);
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
    studentController.view_addStudent.getAddStudentTextField1().setText("");
    studentController.view_addStudent.getAddStudentTextField2().setText("");
    studentController.view_addStudent.getAddStudentTextField3().setText("");
    studentController.view_addStudent.getAddStudentTextField4().setText("");
    studentController.view_addStudent.getAddStudentTextField5().setText("");
    studentController.view_addStudent.getAddStudentTextField6().setText("");
    studentController.view_addStudent.getAddStudentComboBox().setSelectedIndex(0);
    }
    
    public static void cleanTextFieldEditStudent(){
        studentController.view_editStudent.getEditStudentLabel2().setEnabled(false);
        studentController.view_editStudent.getEditStudentLabel3().setEnabled(false);
        studentController.view_editStudent.getEditStudentLabel4().setEnabled(false);
        studentController.view_editStudent.getEditStudentLabel5().setEnabled(false);
        studentController.view_editStudent.getEditStudentLabel6().setEnabled(false);
        studentController.view_editStudent.getEditStudentLabel7().setEnabled(false);
        studentController.view_editStudent.getEditStudentTextField2().setEnabled(false);
        studentController.view_editStudent.getEditStudentTextField3().setEnabled(false);
        studentController.view_editStudent.getEditStudentTextField4().setEnabled(false);
        studentController.view_editStudent.getEditStudentTextField5().setEnabled(false);
        studentController.view_editStudent.getEditStudentComboBox1().setEnabled(false);
        studentController.view_editStudent.getEditStudentComboBox2().setEnabled(false);
        studentController.view_editStudent.getEditEditStudentButton().setEnabled(false);
        studentController.view_editStudent.getEditStudentTextField1().setText("");
        studentController.view_editStudent.getEditStudentTextField2().setText("");
        studentController.view_editStudent.getEditStudentTextField3().setText("");
        studentController.view_editStudent.getEditStudentTextField4().setText("");
        studentController.view_editStudent.getEditStudentTextField5().setText("");
        studentController.view_editStudent.getEditStudentComboBox1().setSelectedIndex(0);
        studentController.view_editStudent.getEditStudentComboBox2().setSelectedIndex(0);
    }
    
    public static void searchEditButton(){
    String studentIDStr = studentController.view_editStudent.getEditStudentTextField1().getText();
  
    if(isValidStudentID(studentIDStr)){
    int studentID = Integer.parseInt(studentIDStr);
     ArrayList<Student> studentList = searchStudentEdit(studentID);
    
    if(studentList.size() == 0){
    cleanTextFieldEditStudent();
    JOptionPane.showMessageDialog(null, "No student was found with that ID", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    for(Student s : studentList){
    studentController.view_editStudent.getEditStudentTextField2().setText(String.valueOf(s.getDni()));
    studentController.view_editStudent.getEditStudentTextField3().setText(s.getName());
    studentController.view_editStudent.getEditStudentTextField4().setText(s.getLastname());
    studentController.view_editStudent.getEditStudentTextField5().setText(s.getNationality());
    studentController.view_editStudent.getEditStudentComboBox1().setSelectedItem(s.getStatus());
    studentController.view_editStudent.getEditStudentComboBox2().setSelectedItem(s.getDegree());   
    }     
    
    }else{
    JOptionPane.showMessageDialog(null, "The studentID is invalid", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
   
    }
    
    public static boolean editButton(){
    String studentIDStr = studentController.view_editStudent.getEditStudentTextField1().getText();
    String dniStr = studentController.view_editStudent.getEditStudentTextField2().getText();
    String name = studentController.view_editStudent.getEditStudentTextField3().getText();
    String lastname = studentController.view_editStudent.getEditStudentTextField4().getText();
    String nationality = studentController.view_editStudent.getEditStudentTextField5().getText();
    String status = (String) view_editStudent.getEditStudentComboBox1().getSelectedItem();
    String degree = (String) view_editStudent.getEditStudentComboBox2().getSelectedItem();
    
    boolean flag = false;
    
    if(dniStr != null && !dniStr.trim().isEmpty() && !(name.equals("") || lastname.equals("") || nationality.equals("") || degree.equals("...")|| status.equals("..."))){
    if(isValidDNI(dniStr)){
    int studentID = Integer.parseInt(studentIDStr);
    try{
    int dni = Integer.parseInt(dniStr);
    boolean flagValidations = checkDNIStudentEdit(studentIDStr, dni);
    if(flagValidations == false){
    editStudent(studentID, dni, name, lastname, nationality, status, degree);
    JOptionPane.showMessageDialog(null, "The student has been successfully edited", "Success", JOptionPane.INFORMATION_MESSAGE);
    showStudent();
    flag = true;
    }
    }catch(NumberFormatException e){
    }
    }else{
    JOptionPane.showMessageDialog(null, "DNI is invalid", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    }else{
    JOptionPane.showMessageDialog(null, "You have to complete all fields", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    return flag;
    }
    
}


