package Session9.Bai2.ra.entity;

public class Dog extends Pet{
    // Constructor không tham số
    public Dog(){
    }
    // Constructor có tham số
    public Dog(String id,String fullName,int age){
        super(id,fullName,age);
    }
    @Override
    public void speak() {
        System.out.println("Gâu Gâu");
    }
}
