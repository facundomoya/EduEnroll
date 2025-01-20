package controllers;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import views.addStudentView;
import views.studentView;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import static models.Person.isValidBirth;
import static models.Person.isValidDNI;
import static models.Person.isValidEmail;
import models.Student;
import static models.Student.isValidStudentID;
import static models.dbConnection.checkDNIStudentEdit;
import static models.dbConnection.checkDNIandEmailStudent;
import static models.dbConnection.deleteStudent;
import static models.dbConnection.editStudent;
import static models.dbConnection.newStudent;
import static models.dbConnection.searchStudent;
import static models.dbConnection.searchStudentEdit;
import static models.dbConnection.showStudent;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import views.deleteStudentView;
import views.editStudentView;
import views.searchStudentView;


public class studentController {

    public static studentView view = new studentView();
    public static addStudentView view_addStudent = new addStudentView();
    public static editStudentView view_editStudent = new editStudentView();
    public static deleteStudentView view_deleteStudent = new deleteStudentView();
    public static searchStudentView view_searchStudent = new searchStudentView();
    
    public static void showStudentView(){
    view.setVisible(true);
    view.setDefaultCloseOperation(addStudentView.DISPOSE_ON_CLOSE);
    showStudent();  
    }
    
    public static void showAddStudent() {
    view_addStudent.setVisible(true);
    view_addStudent.setDefaultCloseOperation(addStudentView.DISPOSE_ON_CLOSE);
    cleanTextFieldsAddStudent();
    }
    
    public static void showEditStudentView(){
    view_editStudent.setVisible(true);
    view_editStudent.setDefaultCloseOperation(addStudentView.DISPOSE_ON_CLOSE);
    cleanTextFieldEditStudent();
    }
    
    public static void showDeleteStudentView(){
    view_deleteStudent.setVisible(true);
    view_deleteStudent.setDefaultCloseOperation(addStudentView.DISPOSE_ON_CLOSE);
    cleanTextFieldDeleteStudent();
    }
    
    public static void showSearchStudentView(){
    view_searchStudent.setVisible(true);
    view_searchStudent.setDefaultCloseOperation(addStudentView.DISPOSE_ON_CLOSE);
    }
    
    public static void hideDeleteStudentView(){
    view_deleteStudent.setVisible(false);
    cleanTextFieldDeleteStudent();
    }
    
    public static void hideStudentView(){
    view.setVisible(false);
    }
    
    public static void hideAddStudentView(){
    studentController.view_addStudent.setVisible(false);
    cleanTextFieldsAddStudent();
    }
    
    public static void hideSearchStudentView(){
    studentController.view_searchStudent.setVisible(false);
    cleanTextFieldSearchStudent();
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
    boolean flagValidations = checkDNIandEmailStudent(dni,email);
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
    
    public static void cleanTextFieldSearchStudent(){
    studentController.view_searchStudent.getSearchStudentTextField1().setText("");
    studentController.view_searchStudent.getSearchStudentTextField2().setText("");
    studentController.view_searchStudent.getSearchStudentTextField3().setText("");
    studentController.view_searchStudent.getSearchStudentTextField4().setText("");
    studentController.view_searchStudent.getSearchStudentTextField5().setText("");
    studentController.view_searchStudent.getSearchStudentTextField6().setText("");
    studentController.view_searchStudent.getSearchStudentTextField7().setText("");
    studentController.view_searchStudent.getSearchStudentTextField8().setText("");
    }
    
    public static void cleanTextFieldDeleteStudent(){
    studentController.view_deleteStudent.getDeleteStudentTextField1().setText("");
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
    JOptionPane.showMessageDialog(null, "StudentID is invalid or doesn't exist.", "Alert", JOptionPane.INFORMATION_MESSAGE);
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
    int studentID = Integer.parseInt(studentIDStr);
    if(isValidDNI(dniStr)){
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
    
    public static void deleteButton(){
    String studentIDStr = studentController.view_deleteStudent.getDeleteStudentTextField1().getText();  
    if(isValidStudentID(studentIDStr)){
    deleteStudent(studentIDStr);
    JOptionPane.showMessageDialog(null, "The student has been succesfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
    showStudent();
    cleanTextFieldDeleteStudent();
    }else{
    JOptionPane.showMessageDialog(null, "StudentID is invalid or doesn't exist.", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    }

    public static void generatePdfFromStudentTable(JTable studentTable) {
    try {
        // Crea el documento
        PDDocument document = new PDDocument();
        
        // Crea una página A4
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        PDPageContentStream content = new PDPageContentStream(document, page);
        
        // Establecer fuente y tamaño
        content.setFont(PDType1Font.HELVETICA_BOLD, 9);
        
        // Calcular la posición inicial para centrar el contenido
        float margin = 50;
        float degreeColumnWidth = 120;  // Ancho de la columna "degree"
        float otherColumnWidth = 60;    // Ancho de las otras columnas
        float tableWidth = (otherColumnWidth * (studentTable.getColumnCount() - 1)) + degreeColumnWidth;
        float startX = (PDRectangle.A4.getWidth() - tableWidth) / 2;
        float startY = PDRectangle.A4.getHeight() - margin + 25;

        content.beginText();
        content.newLineAtOffset(startX, startY);  // Posición inicial del texto (X, Y)

        // Imprimir encabezados de la tabla
        TableModel model = studentTable.getModel();  // Obtener el modelo de datos de la tabla
        for (int col = 0; col < model.getColumnCount(); col++) {
            content.showText(model.getColumnName(col));  // Mostrar nombre de la columna (encabezado)
            if (col == 5) {  // Si es la columna "degree"
                content.newLineAtOffset(degreeColumnWidth, 0);  // Ajuste de espaciado para la columna "degree"
            } else {
                content.newLineAtOffset(otherColumnWidth, 0);  // Ajuste de espaciado para las otras columnas
            }
        }
        
        content.newLineAtOffset(-tableWidth, -20);  // Espaciado después de los encabezados y reiniciar la posición X

        // Imprimir el contenido de la tabla (filas)
        for (int row = 0; row < model.getRowCount(); row++) {
            content.newLineAtOffset(0, -15);  // Ajustar la posición inicial de cada fila (X, Y)
            for (int col = 0; col < model.getColumnCount(); col++) {
                String cellValue = model.getValueAt(row, col).toString();  // Obtener el valor de la celda
                content.showText(cellValue);  // Mostrar el valor de la celda
                if (col == 5) {  // Si es la columna "degree"
                    content.newLineAtOffset(degreeColumnWidth, 0);  // Ajuste de espaciado para la columna "degree"
                } else {
                    content.newLineAtOffset(otherColumnWidth, 0);  // Ajuste de espaciado para las otras columnas
                }
            }
            content.newLineAtOffset(-tableWidth, 0);  // Reiniciar la posición X para la siguiente fila
        }
        
        // Cerrar el contenido
        content.endText();
        content.close();

        // Guardar el documento en un archivo seleccionado por el usuario
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as PDF");
        fileChooser.setSelectedFile(new File("students.pdf"));
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF files", "pdf"));
        
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            
            // Verificar si tiene la extensión .pdf, si no agregarla
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }
            
            // Guardar el documento en el archivo seleccionado
            document.save(filePath);
            JOptionPane.showMessageDialog(null, "PDF saved correctly in: " + filePath);
        } else {
            JOptionPane.showMessageDialog(null, "Canceled operation.");
        }

        // Cerrar el documento
        document.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static void loupeButton(){
    String studentIDStr = studentController.view_searchStudent.getSearchStudentTextField1().getText();


    if(isValidStudentID(studentIDStr)){
    ArrayList<Student> studentList = searchStudent(studentIDStr);

    for(Student s : studentList){
    studentController.view_searchStudent.getSearchStudentTextField2().setText(s.getName());
    studentController.view_searchStudent.getSearchStudentTextField3().setText(s.getLastname());
    studentController.view_searchStudent.getSearchStudentTextField4().setText(String.valueOf(s.getDni()));
    studentController.view_searchStudent.getSearchStudentTextField5().setText(s.getEmail());
    studentController.view_searchStudent.getSearchStudentTextField6().setText(s.getBirth().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    studentController.view_searchStudent.getSearchStudentTextField7().setText(s.getNationality());
    studentController.view_searchStudent.getSearchStudentTextField8().setText(s.getDegree());
    }
    }else{
    JOptionPane.showMessageDialog(null, "Invalid studentID", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    } 
}
