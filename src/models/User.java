package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
