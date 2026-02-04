package Session7.Bai6;

public class Category {
    private final String id;
    private String name;
    private String description;
    // Constructor
    public  Category (String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    // Phương thức getter và setter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
}
