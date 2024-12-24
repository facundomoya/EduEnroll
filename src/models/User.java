package models;

public class User {
    private String name;
    private String lastname;
    private int age;
    private String nationality;
    private String email;
    private String user_name;
    private String password;
    private String user_type;
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public User(String name, String lastname, int age, String nationality, String email, String user_name, String password, String user_type) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.nationality = nationality;
        this.email = email;
        this.user_name = user_name;
        this.password = password;
        this.user_type = user_type;
    }

    public User() {
    }
}
