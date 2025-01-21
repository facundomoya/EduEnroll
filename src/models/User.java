package models;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private int userID;
    private String user_name;
    private String password;
    private int user_type;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public User(int userID ,String user_name, String password, int user_type) {
        this.userID = userID;
        this.user_name = user_name;
        this.password = password;
        this.user_type = user_type;
    }
    
    public User() {
    }    
    
   public static String hashPassword(String password) {
        // Genera el hash con un salt aleatorio (12 rounds)
        String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        return hashedPassword;  // Devuelve el hash completo
    }
   
   public static boolean checkPassword(String password, String storedHashedPassword) {
    // Verifica si la contraseña en texto plano coincide con el hash almacenado en la base de datos
    BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), storedHashedPassword.toCharArray());
    return result.verified;  // Devuelve true si la contraseña coincide, false si no
}
   
    public static String sha256(String password) {
    try {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return null;
    }
}

}
