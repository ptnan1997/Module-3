package Session10.Bai4;

import java.util.ArrayList;

public class AttendantManager implements Manage <Student>{
    public ArrayList<Student> Student;
    public AttendantManager() {
        Student = new ArrayList<>();
    }
    @Override
    public void add(Student student) {
        Student.add(student);
    }

    @Override
    public void update(int index, Student students) {
        if(index>=0 && index<Student.size()){
            Student.set(index, students);
        }
    }
    @Override
    public void delete(int index) {
        if (index>=0 && index<Student.size()){
            Student.remove(index);
        }
    }
    @Override
    public void display() {
        if(Student.isEmpty()){
            System.out.println("Empty Student");
        }else {
            for (Student student : Student) {
                System.out.println(student);
            }
        }
    }
}
