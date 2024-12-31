package models;
import controllers.studentController;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class dbConnection {
    static String url="jdbc:mysql://localhost/eduenroll";
    static String user="root";
    static String pass="1234";
    
    public static Connection connect()
    {
       Connection con=null;
       try
       {
       con=DriverManager.getConnection(url,user,pass);
           System.out.println("Connection successful");
       }catch(SQLException e)
       {
        e.printStackTrace();
       }
        return con;
             
    }
    
    public static boolean isValidUser(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dbConnection.connect();
            
            // SQL para consultar si el usuario y la contraseña coinciden
            String query = "SELECT * FROM User WHERE BINARY user_name = ? AND BINARY password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            resultSet = preparedStatement.executeQuery();
            
            // Si la consulta devuelve un registro, el usuario es válido
            return resultSet.next(); // Si hay algún registro, el login es válido
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
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
    model.addColumn("Name");
    model.addColumn("Lastname");
    model.addColumn("Age");
    model.addColumn("Nationality");
    model.addColumn("Degree");
    model.addColumn("DNI");
    model.addColumn("Status");

    try {
        // Conexión a la base de datos
        con = dbConnection.connect();
        stmt = con.createStatement();
        String query = "SELECT s.name, s.lastname, s.age, s.nationality, s.degree, s.status, s.dni " +
                       "FROM student s ";
        resultset = stmt.executeQuery(query);

        // Recorrer el ResultSet y agregar los datos a las listas
        while (resultset.next()) {
            Student student = new Student(
                0,
                resultset.getString("status"),
                resultset.getString("degree"),
                resultset.getString("name"),
                resultset.getString("lastname"),
                resultset.getInt("age"),
                resultset.getString("nationality"),
                null,
                resultset.getInt("dni")            
            );

        
            studentList.add(student);

            // Crear la fila para la tabla
            Object[] row = new Object[7];
            row[0] = student.getName();
            row[1] = student.getLastname();
            row[2] = student.getAge();
            row[3] = student.getNationality();
            row[4] = student.getDegree();
            row[5] = student.getDni();
            row[6] = student.getStatus();

            // Agregar la fila al modelo de la tabla
            model.addRow(row);
        }

        // Asignar el modelo de datos a la JTable
        studentController.view.getStudentTable().setModel(model);
        // Cambia el tamaño de la columna degree en la tabla
        studentController.view.getStudentTable().getColumnModel().getColumn(4).setPreferredWidth(150);
        studentController.view.getStudentTable().revalidate();
        studentController.view.getStudentTable().repaint();


    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar los recursos
        try {
            if (resultset != null) resultset.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}