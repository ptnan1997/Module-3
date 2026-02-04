package Session7.Bai6;

import java.util.Scanner;

public class Exercise6 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        boolean isProgram = true;
        int count = 0;
        String id;
        String  name;
        String description;
        Category[] cateArray = new Category[100];
        while(isProgram) {
            System.out.println("""
                ********** MENU **********
                1. Thêm mới danh mục
                2. Hiển thị danh sách danh mục
                3. Cập nhật danh mục
                4, Xóa danh mục
                5. Tìm kiếm danh mục theo tên
                6. Thoát
                **************************
                """);
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: // Thêm mới sản phẩm
                    if  (count >= cateArray.length){
                        System.out.println("Danh sách đã đầy, không thể thêm nữa!");
                        break;
                    }
                    System.out.print("Nhập ID sản phẩm: ");
                    id = sc.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    name = sc.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    description = sc.nextLine();
                    cateArray[count] = new Category(id, name, description);
                    count ++;
                    System.out.println("Đã thêm sản phẩm!");
                    break;
                case 2: // Hiển thị danh sách sản phẩm
                    if (count == 0){
                        System.out.println("Danh sách rỗng!");
                    }
                    for (int i  = 0; i < count; i++) {
                        System.out.println(cateArray[i]);
                    }
                    break;
                case 3: // Cập nhật danh mục
                    System.out.println("Nhập ID sản phẩm cần cập nhật: ");
                    id = sc.nextLine();
                    boolean found = false;
                    for (int i  = 0; i < count; i++) {
                        if (cateArray[i].getId().equals(id)){
                            System.out.print("Nhập tên mới: ");
                            name = sc.nextLine();
                            cateArray[i].setName(name);
                            System.out.print("Nhập giá mới: ");
                            description = sc.nextLine();
                            cateArray[i].setDescription(description);
                            found = true;

                            System.out.println("Danh mục đã được cập nhật.");
                            break;
                        }
                    }
                    if (!found){
                        System.out.println("Không tìm thấy sanh mục!");
                    }
                    break;
                case 4: // Xóa danh mục
                    System.out.print("Nhập ID danh mục cần xóa: ");
                    id = sc.nextLine();
                    // 1. Tìm vị trí cần xóa
                    int deleteIndex = linearSearch(cateArray,count,id);

                    // 2. Nếu không tìm thấy
                    if (deleteIndex == -1) {
                        System.out.println("Không tìm thấy danh mục có ID: " + id);
                        break;
                    }

                    // 3. Dịch mảng sang trái
                    for (int i = deleteIndex; i < count - 1; i++) {
                        cateArray[i] = cateArray[i + 1];
                    }

                    // 4. Xóa phần tử cuối + giảm count
                    cateArray[count - 1] = null;
                    count--;

                    System.out.println("Đã xóa danh mục thành công!");
                    break;
                case 5: // Tìm kiếm danh mục theo tên
                    System.out.print("Nhập tên danh mục cần tìm: ");
                    name = sc.nextLine();
                    int isFind = linearSearchByName(cateArray, count, name);

                    if (isFind == -1) {
                        System.out.println("Không tìm thấy danh mục");
                        break;
                    } else {
                        System.out.println(cateArray[isFind]);
                    }

                    break;
                case 6: // Thoát
                    System.out.println("Chương trình đã kết thúc. Cảm ơn đã sử dụng.");
                    isProgram = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }


    }
    // Phương thức tìm kiếm vị trí sản phẩm theo id
    static int linearSearch(Category[] arr, int count, String id) {
        for (int i = 0; i < count; i++) {
            if (arr[i].getId().equals(id)) {
                return i; // tìm thấy → trả về vị trí
            }
        }
        return -1; // không tìm thấy
    }
    // Phương thức tìm kiếm danh mục theo tên
    static int linearSearchByName (Category [] arr, int count, String name){
        for (int i = 0; i < count; i++) {
            if (arr[i].getName().equals(name)) {
                return i; // Tìm thấy -> trả về vị trí
            }
        }
        return -1; // Không tìm thấy
    }

}
