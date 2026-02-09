package Session8.Bai2;

public abstract class Vehicle {
    // Các thuộc tính
    private String name;
    private int speed;
    // Constructor
    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    // Phương thức getter

    public int getSpeed() {
        return speed;
    }
    public String getName() {
        return name;
    }



    // PHương thức thông thường
    public void start(){
        System.out.println("Vehicle is starting ... ");
    }
    // Phương thúc trừu tượng
    public abstract void displayInfo ();


}
