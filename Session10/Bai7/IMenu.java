package Session10.Bai7;

public interface IMenu <T>{
    void add(Student students);
    void findStudentByName(String studentName);
    void classifyGPA (double gpa);
    void display();
}
