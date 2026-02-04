package Session7.Bai3;

import java.util.Scanner;

public class Excersice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Tạo đối tượng Person 1
        Person person1 =  new Person();
        System.out.print("Nhập tên người thứ nhất: ");
        person1.setName(sc.nextLine());
        System.out.print("Nhập tuổi người thứ nhất: ");
        person1.setAge(Integer.parseInt(sc.nextLine()));
        // Tạo đối tượng Person 2
        Person  person2 =  new Person();
        System.out.print("Nhập tên người thứ hai: ");
        person2.setName(sc.nextLine());
        System.out.print("Nhập tuổi người thứ hai: ");
        person2.setAge(sc.nextInt());

        // So sánh tuổi
        if (person1.getAge() > person2.getAge()) {
            System.out.println(person1.getName() + " lớn tuổi hơn " + person2.getName());
        } else if (person1.getAge() < person2.getAge()) {
            System.out.println(person2.getName() + " lớn tuổi hơn " + person1.getName());
        } else {
            System.out.println("Cả hai người có cùng tuổi.");
        }

        sc.close();
    }
}
