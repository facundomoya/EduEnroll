package controllers;

import javax.swing.JOptionPane;
import views.addStudentView;
import views.studentView;
import javax.swing.JOptionPane;
import static models.dbConnection.checkDNIandEmail;
import static models.dbConnection.newStudent;

public class studentController {

    public static studentView view = new studentView();
    public static addStudentView view_addStudent = new addStudentView();
    
    public static void addStudentButton() {
        view_addStudent.setVisible(true);
        view_addStudent.setDefaultCloseOperation(addStudentView.DISPOSE_ON_CLOSE);
    }
    
    public static void validationStudent() {
    String name = view_addStudent.getAddStudentTextField1().getText();
    String lastname = view_addStudent.getAddStudentTextField2().getText();
    String dniStr = view_addStudent.getAddStudentTextField3().getText();  
    String email = view_addStudent.getAddStudentTextField4().getText();
    String nationality = view_addStudent.getAddStudentTextField5().getText();
    String ageStr = view_addStudent.getAddStudentTextField6().getText();  
    String degree = (String) view_addStudent.getAddStudentComboBox().getSelectedItem();
        if ((name.equals("")) || (lastname.equals("") || (dniStr.equals("")) || email.equals("") || nationality.equals("")) || (ageStr.equals("")) || degree.equals("...")) {
             JOptionPane.showMessageDialog(null, "You have to complete all fields", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }     
        
    Integer dni = null;
    Integer age = null;

    try {
        dni = Integer.parseInt(dniStr); // Intentar convertir el DNI a entero
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "DNI must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir si el DNI no es válido
    }

    try {
        age = Integer.parseInt(ageStr); // Intentar convertir la edad a entero
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Age must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir si la edad no es válida
    }

    // Si todo es válido, proceder con la verificación del DNI y el correo
    checkDNIandEmail(dni, email);
    }
    
    public static void confirmStudent(){
    String name = studentController.view_addStudent.getAddStudentTextField1().getText();
    String lastname = studentController.view_addStudent.getAddStudentTextField2().getText();
    int age = Integer.parseInt(studentController.view_addStudent.getAddStudentTextField6().getText());
    String nationality = studentController.view_addStudent.getAddStudentTextField5().getText();
    String email = studentController.view_addStudent.getAddStudentTextField4().getText();
    int dni = Integer.parseInt(studentController.view_addStudent.getAddStudentTextField3().getText());
    String degree = (String) studentController.view_addStudent.getAddStudentComboBox().getSelectedItem();
    String status = "active";
    newStudent(status, degree, name, lastname, age, nationality, email, dni);
    JOptionPane.showMessageDialog(null, "The student has been successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
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
