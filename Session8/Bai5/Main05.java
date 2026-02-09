package Session8.Bai5;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        CategoryManagement manager = new CategoryManagement();

        while (true){
            System.out.println("""
                    ======== QUẢN LÝ DANH MỤC =======
                    1. Thêm danh mục
                    2. Hiển thị danh mục
                    3. Cập nhật danh mục
                    4. Xóa danh mục theo ID
                    5. Thoát
                    =================================
                    """);
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1 -> {
                    System.out.print("Nhập ID: ");

                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập mô tả: ");
                    String description = sc.nextLine();

                    // Chương trình sẽ thực hiện thêm danh mục bằng
                    // các chức năng có trong manager
                    manager.addCategory(new Category(id,name,description));
                }
                case 2 -> {
                    Category [] list =  manager.findAll();
                    if (list.length == 0){
                        System.out.println("Danh sách rỗng");
                    } else {
                        for (Category c : list){
                            System.out.println(c);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Nhập ID cần cập nhật: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên mới: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập mô tả mới: ");
                    String desc = sc.nextLine();

                    manager.updateCategory(new Category(id, name, desc));
                }
                case 4 -> {
                    System.out.print("Nhập ID cần xoá: ");
                    int id = Integer.parseInt(sc.nextLine());
                    manager.deleteCategory(id);
                }
                case 5 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default ->
                    System.out.println("Không có chức năng đó !!!");
            }
        }
    }
}
