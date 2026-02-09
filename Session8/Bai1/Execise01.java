package Session8.Bai1;

public class Execise01 {
    static void main() {
        Animals [] animalArray = new Animals[100];

        // Tạo đối tượng Dog và Cat
        Dog dog1 = new Dog("Bubby",3,"Golden Retriver");
        Cat cat1 = new Cat("Whiskers",2,"Ghi");

        // Thêm vào mảng
        animalArray[0]= dog1;
        animalArray[1]= cat1;

        // Hiển thị thông tin và âm thanh của từng đối tượng
        for (Animals animal : animalArray) {
            animal.displayInfo();
            System.out.println("Sound: " + animal.makeSound());
            System.out.println();
        }
    }


}
