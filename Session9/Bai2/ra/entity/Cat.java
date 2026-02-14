package Session9.Bai2.ra.entity;

public class Cat extends Pet{
    // Constructor không tham số
    public Cat (){
        super();
    }
    // Constructor có tham số
    public Cat(String id, String fullName, int age){
        super(id, fullName, age);
    }
    @Override
    public void speak() {
        System.out.println("Meow Meow");
    }
}
