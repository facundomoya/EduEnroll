package models;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Professor extends Person {
    private int professorID;
    private String professorType;

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public String getProfessorType() {
        return professorType;
    }

    public void setProfessorType(String professorType) {
        this.professorType = professorType;
    }

    public Professor(int professorID, String professorType, String name, String lastname, LocalDate birth, String nationality, String email, int dni) {
        super(name, lastname, birth, nationality, email, dni);
        this.professorID = professorID;
        this.professorType = professorType;
    }

    public Professor() {
    }
    
    public static boolean isValidProfessorID(String professorIDStr) {
    String professorIDRegex = "^(?!0$)[0-9]{1,8}$";
    Pattern pattern = Pattern.compile(professorIDRegex);
    Matcher matcher = pattern.matcher(professorIDStr);
    return matcher.matches();
    }
}
