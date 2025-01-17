package models;
import controllers.studentController;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dbConnection {
    
     private static Connection con = null;

    // Obtener la conexión única para toda la aplicación
    public static Connection getConnection() {
        if (con == null) {
            con = connect(); // Si no existe, crea una nueva conexión
        }
        return con;
    }

    // Crear una nueva conexión si no existe
    public static Connection connect() {
        Connection con = null;
        Properties prop = new Properties();

        try (InputStream input = dbConnection.class.getResourceAsStream("/resources/config.properties")) {
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String pass = prop.getProperty("db.pass");

            con = DriverManager.getConnection(url, user, pass);
            
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    // Cerrar la conexión cuando ya no se necesite
    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
 public static User isValidUser(String user_name, String password) {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    // Inicializa el objeto User
    User user = new User(user_name, password, 0);

    try {
        con = dbConnection.getConnection();

        // SQL para consultar si el usuario y la contraseña coinciden
        String query = "SELECT * FROM User WHERE BINARY user_name = ? AND BINARY password = ?";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, user.getUser_name());
        preparedStatement.setString(2, user.getPassword());

        resultSet = preparedStatement.executeQuery();

        // Si la consulta devuelve un registro, asignamos el user_type
        if (resultSet.next()) {
            int user_type = resultSet.getInt("user_type");  // Asume que 'user_type' es una columna en la tabla 'User'
            user.setUser_type(user_type);  // Establece el valor de user_type en el objeto User
            // Si la consulta devuelve un registro, el usuario es válido
            return user; // El usuario es válido
        } else {
            return null; // No se encontró el usuario
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    } finally {
        // Cerrar recursos
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

 public static void showStudent() {
    Connection con = null;
    Statement stmt = null;
    ResultSet resultset = null;

    ArrayList<Student> studentList = new ArrayList<>();

    // Crear el modelo de la tabla
    DefaultTableModel model = new DefaultTableModel();
    
    // Agregar las columnas al modelo
    model.addColumn("Student ID");
    model.addColumn("Name");
    model.addColumn("Lastname");
    model.addColumn("Birth");
    model.addColumn("Nationality");
    model.addColumn("Degree");
    model.addColumn("DNI");
    model.addColumn("Status");

    try {
        // Conexión a la base de datos
        con = dbConnection.getConnection();
        stmt = con.createStatement();
        String query = "SELECT s.studentID, s.name, s.lastname, s.birth, s.nationality, s.degree, s.status, s.dni " +
                       "FROM student s ";
        resultset = stmt.executeQuery(query);

        // Recorrer el ResultSet y agregar los datos a las listas
        while (resultset.next()) {
            Date sqlDate = resultset.getDate("birth");
            LocalDate birth = sqlDate != null ? sqlDate.toLocalDate() : null;
            Student student = new Student(
                resultset.getInt("studentID"),
                resultset.getString("status"),
                resultset.getString("degree"),
                resultset.getString("name"),
                resultset.getString("lastname"),
                birth,
                resultset.getString("nationality"),
                null,
                resultset.getInt("dni")            
            );

            studentList.add(student);

            // Crear la fila para la tabla
            Object[] row = new Object[8];
            row[0] = student.getStudentID();
            row[1] = student.getName();
            row[2] = student.getLastname();
            row[3] = student.getBirth();
            row[4] = student.getNationality();
            row[5] = student.getDegree();
            row[6] = student.getDni();
            row[7] = student.getStatus();

            // Agregar la fila al modelo de la tabla
            model.addRow(row);
        }

        // Asignar el modelo de datos a la JTable
        studentController.view.getStudentTable().setModel(model);
        // Cambia el tamaño de la columna degree en la tabla
        studentController.view.getStudentTable().getColumnModel().getColumn(5).setPreferredWidth(150);
        studentController.view.getStudentTable().revalidate();
        studentController.view.getStudentTable().repaint();
        
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar los recursos
        try {
            if (resultset != null) resultset.close();
            if (stmt != null) stmt.close();           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 
 public static boolean checkDNIandEmail(int dni, String email){
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet resultset = null;
    boolean flagValidations = false;

    try{
       con = dbConnection.getConnection();
       String query = "SELECT s.dni, s.email FROM student s WHERE s.dni = ? OR s.email = ?";
       pstmt = con.prepareStatement(query);
      
       pstmt.setInt(1, dni);
       pstmt.setString(2, email);
       resultset = pstmt.executeQuery();

       if(resultset.next()){
       int db_dni = resultset.getInt("dni");
       String db_email = resultset.getString("email");
       
       if(db_dni == dni && !db_email.equals(email)){
        JOptionPane.showMessageDialog(null, "Incorrect dni, it already exists", "Alert", JOptionPane.INFORMATION_MESSAGE);
        flagValidations = true;
       }else if(db_email.equals(email) && db_dni != dni){
        JOptionPane.showMessageDialog(null, "Incorrect email, it already exists ", "Alert", JOptionPane.INFORMATION_MESSAGE);
        flagValidations = true;
       }else if(db_dni == dni && db_email.equals(email) ){
        JOptionPane.showMessageDialog(null, "Incorrect dni and email, they already exist", "Alert", JOptionPane.INFORMATION_MESSAGE);
        flagValidations = true;
       }
       }
    }catch(SQLException e){
    e.printStackTrace();
    }
    return flagValidations;
 }
 
 public static void newStudent(int studentID, String status, String degree, String name, String lastname, LocalDate birth, String nationality, String email, int dni){
    Connection con = null;
    PreparedStatement pstmt = null;

    Student student = new Student(studentID, status,degree,name,lastname,birth,nationality,email,dni);

    try{
       con = dbConnection.getConnection();
       String query = "INSERT INTO student(status, degree, name, lastname, birth, nationality, email, dni, codeDegree) VALUES (?,?,?,?,?,?,?,?, \n" +
       "CASE\n" +
       "        WHEN degree = 'Electrical Engineering' THEN 1\n" +
       "        WHEN degree = 'Civil Engineering' THEN 2\n" +
       "        WHEN degree = 'Mechanical Engineering' THEN 3\n" +
       "        ELSE 0\n" +
       "    END\n" +
       ")";
       pstmt = con.prepareStatement(query);
 
       pstmt.setString(1, student.getStatus());
       pstmt.setString(2, student.getDegree()); 
       pstmt.setString(3, student.getName()); 
       pstmt.setString(4, student.getLastname()); 
       pstmt.setDate(5, student.getBirth() != null ? java.sql.Date.valueOf(student.getBirth()) : null); // Se maneja null en caso de que age sea null
       pstmt.setString(6, student.getNationality()); 
       pstmt.setString(7, student.getEmail()); 
       pstmt.setInt(8, student.getDni()); 

       pstmt.executeUpdate();
       
    }catch(SQLException e){e.printStackTrace();}
 }
 
 public static ArrayList<Student> searchStudentEdit(int studentID){
   Connection con = null;
   PreparedStatement pstmt = null;
   ResultSet resultset = null;
   ArrayList<Student> studentList = new ArrayList<>();
 
   try{
    con = dbConnection.getConnection();
    String query = "SELECT s.dni, s.name, s.lastname, s.nationality, s.status, s.degree FROM student s WHERE s.studentID = ?";
    pstmt = con.prepareStatement(query);
    pstmt.setInt(1, studentID);
    resultset = pstmt.executeQuery(); 
   
    while (resultset.next()) {
            Student student = new Student(
                studentID,
                resultset.getString("status"),
                resultset.getString("degree"),
                resultset.getString("name"),
                resultset.getString("lastname"),
                null,
                resultset.getString("nationality"),
                null,
                resultset.getInt("dni")           
            );
            
             studentList.add(student);
    }  

    }catch(SQLException e){e.printStackTrace();}
   
     return studentList;
 }
 
 public static void editStudent(int studentID, int dni, String name, String lastname, String nationality, String status, String degree){
 
  Connection con = null;
  PreparedStatement pstmt = null;

  Student student = new Student(studentID, status,degree,name,lastname,null,nationality,null,dni);

  int codeDegree = 0;

  Degree degreeObject = Degree.getDegreeByName(degree);  // Este método devuelve un objeto Degree basado en el nombre del degree
  codeDegree = degreeObject.getCodeDegree();  // Obtener el codeDegree desde el objeto Degree

  try{
   con = dbConnection.getConnection();
   String query = "UPDATE student SET dni = ?, name = ?, lastname = ?, nationality = ?, status = ?, degree = ?, codeDegree = ? WHERE studentID = ?";
   pstmt = con.prepareStatement(query);

      pstmt.setInt(1, student.getDni());
      pstmt.setString(2, student.getName());
      pstmt.setString(3, student.getLastname());
      pstmt.setString(4, student.getNationality());
      pstmt.setString(5, student.getStatus());
      pstmt.setString(6, student.getDegree());
      pstmt.setInt(7, codeDegree);
      pstmt.setInt(8, student.getStudentID());

      pstmt.executeUpdate();
   
  }catch(SQLException e){e.printStackTrace();}
 }
 
 public static boolean checkDNIStudentEdit(String studentIDStr, int dni){
 
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet resultset = null;
  boolean flagValidations = false;
  
  int studentID = Integer.parseInt(studentIDStr);  // Conversión correcta de String a int
  Student student = new Student(studentID,null,null,null,null,null,null,null,dni);
  
  try{
      
      con = dbConnection.getConnection();
      String query = "SELECT s.dni FROM student s WHERE s.dni = ? AND s.studentID != ?";
      pstmt = con.prepareStatement(query);

      pstmt.setInt(1, student.getDni());
      pstmt.setInt(2, student.getStudentID());
      resultset = pstmt.executeQuery();

      if(resultset.next()){
      int db_dni = resultset.getInt("dni");
      if(db_dni == dni){
       JOptionPane.showMessageDialog(null, "Incorrect dni, it already exists", "Alert", JOptionPane.INFORMATION_MESSAGE);
       flagValidations = true;
       }
       }
  }catch(SQLException e){
  e.printStackTrace();
  }
  return flagValidations;
 }
 
 public static void deleteStudent(String studentIDStr){
   Connection con = null;
   PreparedStatement pstmt = null;
  
   int studentID = Integer.parseInt(studentIDStr);
  
   Student student = new Student(studentID, null, null, null, null, null, null, null, 0);

   try{
      
       con = dbConnection.getConnection();
       String query = "DELETE FROM student WHERE studentID = ?";
       pstmt = con.prepareStatement(query);            
       pstmt.setInt(1, student.getStudentID());
       pstmt.executeUpdate();
       
  }catch(SQLException e){
  e.printStackTrace();
  }
 }
 
 public static ArrayList<Student> searchStudent(String studentIDStr){
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet resultset = null;
  
  ArrayList<Student> studentList = new ArrayList<>();

  try{
      
  int studentID = Integer.parseInt(studentIDStr);
  con = dbConnection.getConnection();
  String query = "SELECT s.name, s.lastname, s.dni, s.email, s.birth, s.nationality, s.degree FROM student s WHERE s.studentID = ?";
  pstmt = con.prepareStatement(query); 
  pstmt.setInt(1, studentID);
  resultset = pstmt.executeQuery();

   while (resultset.next()) {
        Date sqlDate = resultset.getDate("birth");
        LocalDate birth = sqlDate != null ? sqlDate.toLocalDate() : null;      
            Student student = new Student(
                studentID,
                null,
                resultset.getString("degree"),
                resultset.getString("name"),
                resultset.getString("lastname"),
                birth,
                resultset.getString("nationality"),
                resultset.getString("email"),
                resultset.getInt("dni")
            );

            studentList.add(student);

        }

    if(studentList.size() == 0){
     JOptionPane.showMessageDialog(null, "studentId doesn't exist.", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
  
  }catch(SQLException e){e.printStackTrace();}
  
  return studentList;
 }
}

       