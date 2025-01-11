package models;

import java.time.LocalDate;

public class Administrator extends Person {
    private int adminID;

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public Administrator(int adminID, String name, String lastname, LocalDate birth, String nationality, String email, int dni) {
        super(name, lastname, birth, nationality, email, dni);
        this.adminID = adminID;
    }

    public Administrator() {
    }

}
