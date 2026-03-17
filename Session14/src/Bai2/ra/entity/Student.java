package Bai2.ra.entity;

public class Student {
    private int studentId;
    private String studentName;
    private int age;
    // Constructor không tham số

    public Student() {
    }

    // Constructor
    public Student( String studentName, int age) {
        this.studentName = studentName;
        this.age = age;
    }
    // Getter and Setter

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                '}';
    }
}
