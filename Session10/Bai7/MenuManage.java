package Session10.Bai7;

import java.util.ArrayList;

public class MenuManage implements IMenu<Student>{
    public ArrayList<Student> students;
    public MenuManage(){
        students  = new ArrayList<>();
    }
    public void add(Student student){
        students.add(student);
    }
    public void findStudentByName (String studentName){
        int found = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentName().equals(studentName)) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            System.out.println("Không tồn tại tên sinh viên trong danh sách");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(found));
            }
        }
    }
    public void classifyGPA(double gpa){
            if (gpa >= 9) {
                System.out.println("Xếp loại: Xuất sắc");
            } else if (gpa >= 8) {
                System.out.println("Xếp loại: Giỏi");
            } else if (gpa >= 6.5) {
                System.out.println("Xếp loại: Khá");
            } else if (gpa >= 5) {
                System.out.println("Xếp loại: Trung bình");
            } else {
                System.out.println("Xếp loại: Yếu");
            }
    }
    public void display(){
        if(students.isEmpty()){
            System.out.println("There is no students in this menu");
        } else {
            for  (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
