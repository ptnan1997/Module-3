package Session10.Bai1;

public class Student {
    private int studentId;
    private String fullName;
    private double avg;

    // Constructor không tham số
    public Student(){

    }
    // Constructor có tham số
    public Student(int studentId, String fullName, double avg) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.avg = avg;
    }
    // Getter and setter

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", avg=" + avg +
                '}';
    }
}
