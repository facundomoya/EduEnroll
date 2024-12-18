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
}
