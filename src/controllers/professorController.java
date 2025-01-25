package controllers;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import static models.Person.isValidDNI;
import models.Professor;
import static models.Professor.isValidProfessorID;
import static models.Student.isValidStudentID;
import static models.dbConnection.checkDNIProfessorEdit;
import static models.dbConnection.deleteProfessor;
import static models.dbConnection.editProfessor;
import static models.dbConnection.searchProfessorEdit;
import static models.dbConnection.showProfessor;
import views.professorViews.deleteProfessorView;
import views.professorViews.editProfessorView;
import views.professorViews.professorView;

public class professorController {
    
    public static professorView view = new professorView();
    public static editProfessorView view_editProfessor = new editProfessorView();
    public static deleteProfessorView view_deleteProfessor = new deleteProfessorView();
    
    public static void showProfessorView() {
        view.setVisible(true);
        showProfessor();
    }
    
    public static void showDeleteProfessorView() {
        view_deleteProfessor.setVisible(true);
        view_deleteProfessor.setDefaultCloseOperation(deleteProfessorView.DISPOSE_ON_CLOSE);
    }
    
    public static void hideProfessorView() {
        view.setVisible(false);
    }
    
    public static void hideDeleteProfessorView() {
        view_deleteProfessor.setVisible(false);
    }
    
    public static void showEditProfessorView() {
        view_editProfessor.setVisible(true);
        view_editProfessor.setDefaultCloseOperation(editProfessorView.DISPOSE_ON_CLOSE);
    }
    
    public static void cleanTextFieldEditProfessor() {
        professorController.view_editProfessor.getEditProfessorLabel2().setEnabled(false);
        professorController.view_editProfessor.getEditProfessorLabel3().setEnabled(false);
        professorController.view_editProfessor.getEditProfessorLabel4().setEnabled(false);
        professorController.view_editProfessor.getEditProfessorLabel5().setEnabled(false);
        professorController.view_editProfessor.getEditProfessorLabel6().setEnabled(false);
        professorController.view_editProfessor.getEditProfessorTextField2().setEnabled(false);
        professorController.view_editProfessor.getEditProfessorTextField3().setEnabled(false);
        professorController.view_editProfessor.getEditProfessorTextField4().setEnabled(false);
        professorController.view_editProfessor.getEditProfessorTextField5().setEnabled(false);
        professorController.view_editProfessor.getEditProfessorComboBox1().setEnabled(false);
        professorController.view_editProfessor.getEditProfessorButton().setEnabled(false);
        professorController.view_editProfessor.getEditProfessorTextField1().setText("");
        professorController.view_editProfessor.getEditProfessorTextField2().setText("");
        professorController.view_editProfessor.getEditProfessorTextField3().setText("");
        professorController.view_editProfessor.getEditProfessorTextField4().setText("");
        professorController.view_editProfessor.getEditProfessorTextField5().setText("");
        professorController.view_editProfessor.getEditProfessorComboBox1().setSelectedIndex(0);
    }
    
    public static void cleanTextFieldDeleteProfessor() {
        professorController.view_deleteProfessor.getDeleteProfessorTextField1().setText("");
    }
    
    public static void searchEditButton() {
        String professorIDStr = professorController.view_editProfessor.getEditProfessorTextField1().getText();
        if (isValidStudentID(professorIDStr)) {
            int professorID = Integer.parseInt(professorIDStr);
            ArrayList<Professor> professorList = searchProfessorEdit(professorID);
            if (professorList.size() == 0) {
                cleanTextFieldEditProfessor();
                JOptionPane.showMessageDialog(null, "No student was found with that ID", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }
            for (Professor p : professorList) {
                professorController.view_editProfessor.getEditProfessorTextField2().setText(String.valueOf(p.getDni()));
                professorController.view_editProfessor.getEditProfessorTextField3().setText(p.getName());
                professorController.view_editProfessor.getEditProfessorTextField4().setText(p.getLastname());
                professorController.view_editProfessor.getEditProfessorTextField5().setText(p.getNationality());
                professorController.view_editProfessor.getEditProfessorComboBox1().setSelectedItem(p.getProfessorType());
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "ProfessorID is invalid or doesn't exist.", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public static boolean editButton() {
        String professorIDStr = professorController.view_editProfessor.getEditProfessorTextField1().getText();
        String dniStr = professorController.view_editProfessor.getEditProfessorTextField2().getText();
        String name = professorController.view_editProfessor.getEditProfessorTextField3().getText();
        String lastname = professorController.view_editProfessor.getEditProfessorTextField4().getText();
        String nationality = professorController.view_editProfessor.getEditProfessorTextField5().getText();
        String professorType = (String) view_editProfessor.getEditProfessorComboBox1().getSelectedItem();
        
        boolean flag = false;
        
        if (dniStr != null && !dniStr.trim().isEmpty() && !(name.equals("") || lastname.equals("") || nationality.equals("") || professorType.equals("..."))) {
            int professorID = Integer.parseInt(professorIDStr);
            if (isValidDNI(dniStr)) {
                try {
                    int dni = Integer.parseInt(dniStr);
                    boolean flagValidations = checkDNIProfessorEdit(professorIDStr, dni);
                    if (flagValidations == false) {
                        editProfessor(professorID, dni, name, lastname, nationality, professorType);
                        JOptionPane.showMessageDialog(null, "The professor has been successfully edited", "Success", JOptionPane.INFORMATION_MESSAGE);
                        showProfessor();
                        flag = true;
                    }
                } catch (NumberFormatException e) {
                }
            } else {
                JOptionPane.showMessageDialog(null, "DNI is invalid", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You have to complete all fields", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
        return flag;
    }
    
    public static void deleteButton() {
        String professorIDStr = professorController.view_deleteProfessor.getDeleteProfessorTextField1().getText();
        if (isValidProfessorID(professorIDStr)) {
            int row = deleteProfessor(professorIDStr);
            if(row == 0){
            JOptionPane.showMessageDialog(null, "ProfessorID doesn't exist.", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }else{
            JOptionPane.showMessageDialog(null, "The professor has been succesfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
            showProfessor();
            }          
        } else {
            JOptionPane.showMessageDialog(null, "ProfessorID is invalid", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
