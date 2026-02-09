package Session8.Bai1;

public class Animals {
    private String name;
    private int age;
    // Constructor
    public Animals(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Tên không được để trống");
        }
        if (age < 0 ) {
            throw new IllegalArgumentException("Tuổi không được âm");
        }
        this.name = name;
        this.age = age;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < 0 ) {
            throw new IllegalArgumentException("Tuổi không được âm");
        }
        this.age = age;
    }
    // Display information of animal
    public void displayInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }
    public String makeSound(){
        return "Some generic sound";
    }
}
