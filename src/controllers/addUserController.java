package controllers;

import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import static models.Person.isValidBirth;
import static models.Person.isValidDNI;
import static models.Person.isValidEmail;
import static models.dbConnection.addUser;
import static models.dbConnection.checkDNIandEmailAdministrator;
import static models.dbConnection.checkDNIandEmailProfessor;
import static models.dbConnection.checkUser;
import views.addUserView.addUserView;

public class addUserController {
    public static addUserView view_addUser = new addUserView();
    
    public static void showAddUserView(){
    view_addUser.setVisible(true);
    view_addUser.setDefaultCloseOperation(view_addUser.DISPOSE_ON_CLOSE);
    }
    
    public static void hideAddUserView(){
    view_addUser.setVisible(false);
    }
    
    public static void selectComboBox1(){
    String userType = (String) view_addUser.getAddUserComboBox1().getSelectedItem();
    if(userType == "Professor"){
    view_addUser.getAddUserComboBox2().setEnabled(true);
    }else{
    view_addUser.getAddUserComboBox2().setEnabled(false);
    }
    }
    
    public static void addUserButton(){
    String name = view_addUser.getAddUserTextField1().getText();
    String lastname = view_addUser.getAddUserTextField2().getText();
    String dniStr = view_addUser.getAddUserTextField3().getText();
    String birthStr = view_addUser.getAddUserTextField4().getText();
    String nationality = view_addUser.getAddUserTextField5().getText();
    String email = view_addUser.getAddUserTextField6().getText();
    String user_typeStr = (String) view_addUser.getAddUserComboBox1().getSelectedItem();
    String professorType = (String) view_addUser.getAddUserComboBox2().getSelectedItem();
    String user_nameStr = view_addUser.getAddUserTextField7().getText();
    String password = view_addUser.getAddUserTextField8().getText();
    
   if(!checkUser(user_nameStr)){
       System.out.println(checkUser(user_nameStr));
   if(dniStr != null && !dniStr.trim().isEmpty() && !(name.equals("") || birthStr.equals("") || email.equals("") || user_nameStr.equals("") || password.equals("") || lastname.equals("") || nationality.equals("") || user_typeStr.equals("...")|| professorType.equals("..."))){
  
    if(isValidDNI(dniStr)){
    int dni = Integer.parseInt(dniStr);
    if(isValidBirth(birthStr)){
    LocalDate birth = LocalDate.parse(birthStr);
    if(isValidEmail(email)){
    
if (user_typeStr.equals("Administrator") ) {
    boolean flagValidationsAdministrator = checkDNIandEmailAdministrator(dni, email);
    if (!flagValidationsAdministrator) {
    addUser(name, lastname, dni, birth ,nationality, email, user_typeStr, professorType, user_nameStr, password);
    JOptionPane.showMessageDialog(null, "The user has been successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    }
    else if (user_typeStr.equals("Professor")) {
    boolean flagValidationsProfessor = checkDNIandEmailProfessor(dni, email);
    if (!flagValidationsProfessor) {       
     addUser(name, lastname, dni, birth ,nationality, email, user_typeStr, professorType, user_nameStr, password);
    JOptionPane.showMessageDialog(null, "The user has been successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    }}else{
    JOptionPane.showMessageDialog(null, "Email is invalid", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    }else{
    JOptionPane.showMessageDialog(null, "Date of birth is invalid", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    }else{
    JOptionPane.showMessageDialog(null, "DNI is invalid", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    }else{
    JOptionPane.showMessageDialog(null, "You have to complete all fields", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
   }else{
   JOptionPane.showMessageDialog(null, "Incorrect user, it already exists", "Alert", JOptionPane.INFORMATION_MESSAGE);
   }
   }
}
