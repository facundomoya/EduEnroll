package models;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person {
    private String name;
    private String lastname;
    private LocalDate birth;
    private String nationality;
    private String email;
    private int dni;

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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
      public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
       public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Person(String name, String lastname, LocalDate birth, String nationality, String email, int dni) {
        this.name = name;
        this.lastname = lastname;
        this.birth = birth;
        this.nationality = nationality;
        this.email = email;
        this.dni = dni;
    }

    public Person() {
    }
    
     public static boolean isValidDNI(String dniStr) {
        String dniRegex = "^[0-9]{1,8}$";
        Pattern pattern = Pattern.compile(dniRegex);
        Matcher matcher = pattern.matcher(dniStr);
        return matcher.matches();
    }
     
    public static boolean isValidBirth(String birth) {
    // Convertir LocalDate a String con el formato YYYY-MM-DD
    String ageStr = birth.toString(); // Esto convierte el LocalDate a un String en el formato adecuado
    
    // Expresión regular para una fecha en formato YYYY-MM-DD
    String dateRegex = "^(19|20)\\d\\d-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
    Pattern pattern = Pattern.compile(dateRegex);
    Matcher matcher = pattern.matcher(ageStr);
    
    return matcher.matches();
}

    public static boolean isValidEmail(String emailStr) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    Pattern pattern = Pattern.compile(emailRegex);
    Matcher matcher = pattern.matcher(emailStr);
    
    return matcher.matches();
}
}
