package Session7.Bai5;

import java.util.Scanner;

public class Exercise5 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        boolean isProgram = true;
        int count = 0;
        String id;
        String  name;
        double price;
        Product[] productArray = new Product[100];
        while(isProgram) {
            System.out.println("""
                ********** MENU **********
                1. Thêm mới sản phẩm
                2. Hiển thị danh sách sản phẩm
                3. Cập nhật sản phẩm
                4, Xóa sản phẩm
                5. Thoát
                **************************
                """);
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: // Thêm mới sản phẩm
                    if  (count >= productArray.length){
                        System.out.println("Danh sách đã đầy, không thể thêm nữa!");
                        break;
                    }
                    System.out.print("Nhập ID sản phẩm: ");
                    id = sc.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    name = sc.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    price = Double.parseDouble(sc.nextLine());
                    productArray[count] = new Product(id, name, price);
                    count ++;
                    bubbleSortByPrice(productArray, count);
                    System.out.println("Đã thêm sản phẩm!");
                    break;
                case 2: // Hiển thị danh sách sản phẩm
                    if (count == 0){
                        System.out.println("Danh sách rỗng!");
                    }
                    for (int i  = 0; i < count; i++) {
                        System.out.println(productArray[i]);
                    }
                    break;
                case 3: // Cập nhật sản phẩm
                    System.out.println("Nhập ID sản phẩm cần cập nhật: ");
                    id = sc.nextLine();
                    boolean found = false;
                    for (int i  = 0; i < count; i++) {
                        if (productArray[i].getId().equals(id)){
                            System.out.print("Nhập tên mới: ");
                            name = sc.nextLine();
                            productArray[i].setName(name);
                            System.out.print("Nhập giá mới: ");
                            price = sc.nextDouble();
                            productArray[i].setPrice(price);
                            found = true;
                            bubbleSortByPrice(productArray, count);
                            System.out.println("Sản phẩm đã được cập nhật.");
                            break;
                        }
                    }
                    if (!found){
                        System.out.println("Không tìm thấy sản phẩm!");
                    }
                    break;
                case 4: // Xóa sản phẩm
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    id = sc.nextLine();
                    // 1. Tìm vị trí cần xóa
                    int deleteIndex = linearSearch(productArray,count,id);

                    // 2. Nếu không tìm thấy
                    if (deleteIndex == -1) {
                        System.out.println("Không tìm thấy sản phẩm có ID: " + id);
                        break;
                    }

                    // 3. Dịch mảng sang trái
                    for (int i = deleteIndex; i < count - 1; i++) {
                        productArray[i] = productArray[i + 1];
                    }

                    // 4. Xóa phần tử cuối + giảm count
                    productArray[count - 1] = null;
                    count--;

                    System.out.println("Đã xóa sản phẩm thành công!");
                    break;
                case 5: // Thoát
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
    static int linearSearch(Product[] arr, int count, String id) {
        for (int i = 0; i < count; i++) {
            if (arr[i].getId().equals(id)) {
                return i; // tìm thấy → trả về vị trí
            }
        }
        return -1; // không tìm thấy
    }
    // Phương thức sắp xếp danh sách sản phẩm
    static void bubbleSortByPrice(Product[] productArray, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (productArray[j].getPrice() > productArray[j + 1].getPrice()) {
                    Product temp = productArray[j];
                    productArray[j] = productArray[j + 1];
                    productArray[j + 1] = temp;
                }
            }
        }
    }
}
