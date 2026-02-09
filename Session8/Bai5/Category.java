package Session8.Bai5;

public class Category {
    private int id ;
    private String name;
    private String description;

    // Phương thức getter và setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // Constructor không tham số
    public Category(){

    }
    // Constructor có tham số
    public Category(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
}
