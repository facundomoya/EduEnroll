package models;

public class Course {
    private String courseName;
    private int courseCode;
    private int year;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public int getyear() {
        return year;
    }

    public void setDuration(int year) {
        this.year= year;
    }

    public Course(String courseName, int courseCode, int year) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.year = year;
    }

    public Course() {
    }
}
