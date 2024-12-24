package models;
import java.sql.*;


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
            String query = "SELECT * FROM User WHERE user_name = ? AND password = ?";
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
}
 