package models;

public class Professor extends User {
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

    public Professor(int professorID, String professorType, String name, String lastname, int age, String nationality, String email, String user_name, String password, String user_type) {
        super(name, lastname, age, nationality, email, user_name, password, user_type);
        this.professorID = professorID;
        this.professorType = professorType;
    }

    public Professor() {
    }
}
