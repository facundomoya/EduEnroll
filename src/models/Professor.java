package models;

public class Professor extends Person {
    private int professorID;
    private String email;
    private String professorType;

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfessorType() {
        return professorType;
    }

    public void setProfessorType(String professorType) {
        this.professorType = professorType;
    }

    public Professor(int professorID, String email, String professorType, String name, String lastname, int age, String nationality) {
        super(name, lastname, age, nationality);
        this.professorID = professorID;
        this.email = email;
        this.professorType = professorType;
    }

    public Professor() {
    }
}
