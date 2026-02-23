package Session10.Bai7;

public class Student {
    private int studentId;
    private String studentName;
    private double gpa;
    //Constructor
    public  Student(int studentId, String studentName, double gpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gpa = gpa;
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
