package Session8.Bai1;

public class Cat extends Animals {
    private String furColor;

    //Constructor
    public Cat (String name,int age,String furColor){
        super(name,age);
        this.furColor = furColor;
    }
    // Ghi đè phương thức makeSound
    @Override
    public String makeSound()
    {
        return "Meow Meow";
    }
    //Ghi đè phương thức displayInfo
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Fur Color: "+furColor);
    }
}
