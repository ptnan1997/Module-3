package Session8.Bai5;

public interface ICRUD {
    Category[] findAll();
    void addCategory (Category category);
    void updateCategory (Category category);
    void deleteCategory (int id);
}
