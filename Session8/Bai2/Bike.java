package Session8.Bai2;

public class Bike extends Vehicle{
    public Bike (String name, int speed) {
        super(name, speed);
    }
    @Override
    public void displayInfo() {
        System.out.println("Bike Name: " + super.getName());
        System.out.println("Bike Speed: " + super.getSpeed());
    }
}
