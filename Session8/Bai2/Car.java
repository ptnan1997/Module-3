package Session8.Bai2;

public class Car extends Vehicle{
    public Car (String name,int speed){
        super(name,speed);
    }
    @Override
    public void displayInfo(){
        System.out.println("Car Name: " + super.getName());
        System.out.println("Car Speed: " + super.getSpeed());
    }
}
