package Session8.Bai5;

public class CategoryManagement implements ICRUD{
    private Category[] categories;
    private int count;
    private int indexOfId (int id){
        for(int i=0;i<count;i++){
            if(categories[i].getId()==id) {
                return i;
            }
        }
        return -1;
    }
    public CategoryManagement() {
        categories = new Category[100];
        count = 0;
    }

    @Override
    public Category[] findAll() {
        Category[] result = new Category[count];
        System.arraycopy(categories, 0, result, 0, count);
        return result;
    }
    @Override
    public void addCategory(Category category) {
        // Kiểm tra có trùng Id không?
        if (indexOfId(category.getId()) != -1){
            System.out.println("Category already exists");
            return;
        }
        if(count >= categories.length){
            System.out.println("Danh sách đầy không thể thêm.");
            return;
        }
        categories[count++] = category;
        System.out.println("Thêm danh mục thành công ✅");
    }

    public void updateCategory(Category category) {
        int idx = indexOfId(category.getId());
        if (idx == -1){
            System.out.println("Category id not found");
            return;
        }
        categories[idx].setName(category.getName());
        categories[idx].setDescription(category.getDescription());
        System.out.println("Cập nhật thành công ✅");
    }

    @Override
    public void deleteCategory(int id) {
        int idx =  indexOfId(id);
        if (idx == -1){
            System.out.println("Category id not found");
            return;
        }
        // dồn mảng
        for (int i = idx; i < count -1; i++) {
            categories [i] = categories[i + 1];
        }
        categories[count - 1] = null;
        count--;
        System.out.println("Xóa thành công ✅");
    }

}
