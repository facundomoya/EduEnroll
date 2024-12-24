package models;

public class Administrator extends User {
    private int adminID;

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public Administrator(int adminID, String name, String lastname, int age, String nationality, String email, String user_name, String password, String user_type) {
        super(name, lastname, age, nationality, email, user_name, password, user_type);
        this.adminID = adminID;
    }

    public Administrator() {
    }

}
