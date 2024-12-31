package models;

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

    public Professor(int professorID, String professorType, String name, String lastname, int age, String nationality, String email, int dni) {
        super(name, lastname, age, nationality, email, dni);
        this.professorID = professorID;
        this.professorType = professorType;
    }

    public Professor() {
    }
}
