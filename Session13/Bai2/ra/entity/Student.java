package Session13.Bai2.ra.entity;


import java.util.Date;


public class Student {

    private Integer studentId;
    private String fullName;
    private Date dateOfBirth;
    private String email;
    // Constructor không tham số
    public Student(){

    }
    // Constructor có tham số
    public Student(String fullName, Date dateOfBirth, String email) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }
    // Phương thức Getter và Setter


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}
