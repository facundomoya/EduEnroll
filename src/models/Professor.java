package models;

import java.time.LocalDate;

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
}
