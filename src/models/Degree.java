package models;

public class Degree {
    private String nameDegree;
    private int codeDegree;

    public String getNameDegree() {
        return nameDegree;
    }

    public void setNameDegree(String nameDegree) {
        this.nameDegree = nameDegree;
    }

    public int getCodeDegree() {
        return codeDegree;
    }

    public void setCodeDegree(int codeDegree) {
        this.codeDegree = codeDegree;
    }

    public Degree(String nameDegree, int codeDegree) {
        this.nameDegree = nameDegree;
        this.codeDegree = codeDegree;
    }

    public Degree() {
    }
    
       public static Degree getDegreeByName(String degreeName) {
        // Dependiendo del nombre, se devuelve el grado correspondiente
        switch (degreeName) {
            case "Electrical Engineering":
                return new Degree("Electrical Engineering", 1);
            case "Civil Engineering":
                return new Degree("Civil Engineering", 2);
            case "Mechanical Engineering":
                return new Degree("Mechanical Engineering", 3);
            default:
                throw new IllegalArgumentException("Unknown degree name: " + degreeName);
        }
    }
}
