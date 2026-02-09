package Session8.Bai1;

public class Dog extends Animals {
    private final String breed;
    public Dog(String name, int age,String breed){
        super(name,age);
        this.breed = breed;
    }
    @Override
    public String makeSound(){
        return "Woof Woof";
    }
    public void displayInfo(){
       super.displayInfo();// Call procedure of the father class
        System.out.println("Breed: " + breed);
    }
}
