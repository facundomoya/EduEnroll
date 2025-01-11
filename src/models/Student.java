package models;

import java.time.LocalDate;



public class Student extends Person {
    private String status;
    private String degree;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Student(String status, String degree, String name, String lastname, LocalDate birth, String nationality, String email, int dni) {
        super(name, lastname, birth, nationality, email, dni);
        this.status =  status;
        this.degree = degree;
    }
    
    public Student() {
    } 
}
