package Session8.Bai2;

public class ExerciseMain02 {
    static void main() {
        Vehicle bike1 = new Bike("Yamaha",80);
        Vehicle car1 = new Car("Toyota",120);

        // Gọi phương thức
        car1.start();
        car1.displayInfo();

        bike1.start();
        bike1.displayInfo();

    }
}
