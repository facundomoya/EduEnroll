package models;

public abstract class Person {
    private String name;
    private String lastname;
    private int age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public Person(String name, String lastname, int age, String nationality, String email, int dni) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.nationality = nationality;
        this.email = email;
        this.dni = dni;
    }

    public Person() {
    }

}
