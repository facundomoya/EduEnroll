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
import static models.User.checkPassword;
import static models.User.sha256;

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
    
 public static User isValidUser(String user_name, String password) {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    // Inicializa el objeto User
    User user = new User(0, user_name, password, 0);

    try {
        con = dbConnection.getConnection();

        // SQL para consultar si el usuario y la contraseña coinciden
        String query = "SELECT * FROM User WHERE BINARY user_name = ?";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, user.getUser_name());

        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String storedHashedPassword = resultSet.getString("password");  // Recuperamos el hash almacenado en la BD
            String enteredPasswordHash = sha256(password);
            boolean isPasswordValid = checkPassword(password, storedHashedPassword);  // Verificamos la contraseña
             if (isPasswordValid || storedHashedPassword.equals(enteredPasswordHash)) {
                int user_type = resultSet.getInt("user_type");  // Asume que 'user_type' es una columna en la tabla 'User'
                user.setUser_type(user_type);  // Establece el valor de user_type en el objeto User
                return user;  // La contraseña es válida
            }
        } else {
            return null; // No se encontró el usuario
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
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
 
 public static boolean checkDNIandEmailStudent(int dni, String email){
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
 
 //Metodos para addUserController
 
 public static boolean checkUser(String user_nameStr){
  Connection con = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
  boolean flagValidations = false;
  
  User user = new User(0, user_nameStr, null, 0);
   
   try{
    con = dbConnection.getConnection();
   String query = "SELECT u.user_name \n" +
"FROM user u \n" +
"WHERE BINARY u.user_name = ?";
      ps = con.prepareStatement(query);
      ps.setString(1, user.getUser_name());
      rs = ps.executeQuery();
      
      if(rs.next()){
      String db_user_name = rs.getString("user_name");
      if(db_user_name.equals(user_nameStr)){
       flagValidations = true;
       }
      }
   }catch(SQLException e){e.printStackTrace();}
   return flagValidations;
 }
 
 public static void addUser(String name, String lastname, int dni, LocalDate birth , String nationality, String email, String user_typeStr, String professorType, String user_nameStr, String hashedPassword){
    Connection con = null;
    PreparedStatement ps = null;
    int user_type = 0;
    ResultSet rs = null;
    
    if(user_typeStr.equals("Administrator")){
    user_type = 1;
    }else{
    user_type = 2;
    }

    User user = new User(0, user_nameStr, hashedPassword, user_type);
    Administrator admin = new Administrator(0, name, lastname, birth, nationality, email, dni);
    Professor prof = new Professor(0, professorType, name, lastname, birth, nationality, email, dni);

 try{
    con = dbConnection.getConnection();
    String query = "INSERT INTO user(user_name, password, user_type) VALUES (?,?,?)";
       ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);            
       ps.setString(1, user.getUser_name());
       ps.setString(2, hashedPassword);
       ps.setInt(3, user.getUser_type());
       ps.executeUpdate();
       rs = ps.getGeneratedKeys();  // Obtener las claves generadas
        int user_id = 0;
        if (rs.next()) {
            user_id = rs.getInt(1);  // La primera columna es la clave primaria generada
        }
       if(user_type == 1){
       String query_adm = "INSERT INTO administrator(user_id, name, lastname, birth, nationality, email, dni) VALUES (?,?,?,?,?,?,?)";
        ps = con.prepareStatement(query_adm);
            ps.setInt(1, user_id);  // Asignamos el user_id generado en la tabla 'user'
            ps.setString(2, admin.getName());
            ps.setString(3, admin.getLastname());
            ps.setDate(4, admin.getBirth() != null ? java.sql.Date.valueOf(admin.getBirth()) : null);  // Convertir LocalDate a java.sql.Date
            ps.setString(5, admin.getNationality());
            ps.setString(6, admin.getEmail());
            ps.setInt(7, admin.getDni());
            ps.executeUpdate();
       }else{
       String query_adm = "INSERT INTO professor(professorType, dni, name, lastname, birth, nationality, email, user_id) VALUES (?,?,?,?,?,?,?,?)";
        ps = con.prepareStatement(query_adm);
            ps.setString(1, prof.getProfessorType());  // Asignamos el user_id generado en la tabla 'user'
            ps.setInt(2, prof.getDni());
            ps.setString(3, prof.getName());
            ps.setString(4, prof.getLastname());
            ps.setDate(5, prof.getBirth() != null ? java.sql.Date.valueOf(prof.getBirth()) : null);  // Convertir LocalDate a java.sql.Date
            ps.setString(6, prof.getNationality());
            ps.setString(7, admin.getEmail());
            ps.setInt(8, user_id);
            ps.executeUpdate();
       }
       
 }catch(SQLException e){e.printStackTrace();}
 }
 
 public static boolean checkDNIandEmailAdministrator(int dni, String email){
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet resultset = null;
    boolean flagValidationsAdministrator = false;

    try{
       con = dbConnection.getConnection();
       String query = "SELECT a.dni, a.email FROM administrator a WHERE a.dni = ? OR a.email = ?";
       pstmt = con.prepareStatement(query);
      
       pstmt.setInt(1, dni);
       pstmt.setString(2, email);
       resultset = pstmt.executeQuery();

       if(resultset.next()){
       int db_dni = resultset.getInt("dni");
       String db_email = resultset.getString("email");
       
       if(db_dni == dni && !db_email.equals(email)){
        JOptionPane.showMessageDialog(null, "Incorrect dni, it already exists", "Alert", JOptionPane.INFORMATION_MESSAGE);
        flagValidationsAdministrator = true;
       }else if(db_email.equals(email) && db_dni != dni){
        JOptionPane.showMessageDialog(null, "Incorrect email, it already exists ", "Alert", JOptionPane.INFORMATION_MESSAGE);
        flagValidationsAdministrator = true;
       }else if(db_dni == dni && db_email.equals(email) ){
        JOptionPane.showMessageDialog(null, "Incorrect dni and email, they already exist", "Alert", JOptionPane.INFORMATION_MESSAGE);
        flagValidationsAdministrator = true;
       }
       }
    }catch(SQLException e){
    e.printStackTrace();
    }
    return flagValidationsAdministrator;
 }
 
  public static boolean checkDNIandEmailProfessor(int dni, String email){
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet resultset = null;
    boolean flagValidationsProfessor = false;

    try{
       con = dbConnection.getConnection();
       String query = "SELECT p.dni, p.email FROM professor p WHERE p.dni = ? OR p.email = ?";
       pstmt = con.prepareStatement(query);
      
       pstmt.setInt(1, dni);
       pstmt.setString(2, email);
       resultset = pstmt.executeQuery();

       if(resultset.next()){
       int db_dni = resultset.getInt("dni");
       String db_email = resultset.getString("email");
       
       if(db_dni == dni && !db_email.equals(email)){
        JOptionPane.showMessageDialog(null, "Incorrect dni, it already exists", "Alert", JOptionPane.INFORMATION_MESSAGE);
        flagValidationsProfessor = true;
       }else if(db_email.equals(email) && db_dni != dni){
        JOptionPane.showMessageDialog(null, "Incorrect email, it already exists ", "Alert", JOptionPane.INFORMATION_MESSAGE);
        flagValidationsProfessor = true;
       }else if(db_dni == dni && db_email.equals(email) ){
        JOptionPane.showMessageDialog(null, "Incorrect dni and email, they already exist", "Alert", JOptionPane.INFORMATION_MESSAGE);
        flagValidationsProfessor = true;
       }
       }
    }catch(SQLException e){
    e.printStackTrace();
    }
    return flagValidationsProfessor;
 }
}
