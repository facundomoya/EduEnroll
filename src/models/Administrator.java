package models;

public class Administrator extends Person {
    private int adminID;

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public Administrator(int adminID, String name, String lastname, int age, String nationality, String email, int dni) {
        super(name, lastname, age, nationality, email, dni);
        this.adminID = adminID;
    }

    public Administrator() {
    }

}
