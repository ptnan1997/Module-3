package Session9.Bai2.ra.entity;

import java.util.Scanner;

public abstract class Pet {
    private String id;
    private String petName;
    private int age;
    // Constructor không tham số
    public Pet(){

    }
    // Constructor có tham số
    public Pet(String id, String petName, int age) {
        this.id = id;
        this.petName = petName;
        this.age = age;
    }
    // Phương thức getter và setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // Phương thức inputData (Scanner scanner) cho phép nhập đầy đủ thông tin của thú cưng
    public void inputData(Scanner scanner){
        System.out.println("_______ Nhập thông tin thú cưng ______");
        System.out.print("1. Nhập mã thú cưng: ");
        this.id = scanner.nextLine();
        System.out.print("2. Nhập tên thú cưng: ");
        this.petName = scanner.nextLine();
        System.out.print("3. Nhập tuổi thú cưng: ");
        this.age = scanner.nextInt();
        System.out.println("Nhập thông tin thành công ✅");
    }
    // Phương thức displayData () cho phép hiển thị thông tin của thú cưng
    public String displayData(){
        return "Mã thú cưng: " + id + "\n"+ "Tên thú cưng: " + petName + "\n" + "Số tuổi: " + age + "\n";
    }
    // Phương thức trừu tượng speak()
    public abstract void speak();
}
