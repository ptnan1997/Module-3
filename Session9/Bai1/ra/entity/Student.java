package Session9.Bai1.ra.entity;

import java.util.Scanner;

public class Student {
    private int id;
    private String fullName;
    private int age;
    private String major;
    // Constructor không tham số
    public Student (){

    }
    // Constuctor có tham số
    public Student (int id, String fullName, int age, String major) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.major = major;
    }
    // Phương thức getter và setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    // Phương thức inputData(Scanner scanner)

    public void inputData(Scanner scanner){
        System.out.print("Nhập mã sinh viên: ");
        this.id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên sinh viên: ");
        this.fullName = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập chuyên ngành: ");
        this.major = scanner.nextLine();
    }


    public void displayData() {
        System.out.println("Mã sinh viên: " + id + "\n" + "Tên sinh viên " + fullName + "\n" + "Tuổi: " + age + "\n" +"Major: " + major + "\n");
    }
}
