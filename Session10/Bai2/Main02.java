package Session10.Bai2;

import java.util.HashMap;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        BookManager manager = new  BookManager();
        Scanner sc  = new Scanner(System.in);
        int choice;

        while (true){
            // Hiển thị menu
            System.out.println("\n*************** MENU QUẢN LÝ SÁCH ***************");
            System.out.println("1. Thêm sách");
            System.out.println("2. Tìm kiếm sách");
            System.out.println("3. Hiển thị danh sách sách");
            System.out.println("4. Thoát");


            try {
                choice = inputData.getInt(sc,"Lựa chọn của bạn: ");

                switch (choice) {
                    case 1:
                        // Thêm sách
                        String title = inputData.getString(sc,"Nhập tên sách: ");
                        String author = inputData.getString(sc,"Nhập tác giả: ");
                        int yearPublished = inputData.getInt(sc,"Nhập năm xuất bản: ");
                        Book book = new Book(title, author, yearPublished);
                        manager.addBook(book);
                        System.out.println("Sách đã được thêm thành công.");
                        break;

                    case 2:
                        // Tìm kiếm sách
                        System.out.print("Nhập tên sách để tìm kiếm: ");
                        String searchTitle = sc.nextLine();
                        try {
                            Book foundBook = manager.findBook(searchTitle);
                            System.out.println("Thông tin sách tìm thấy: " + foundBook);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        // Hiển thị danh sách sách
                        System.out.println("\nDanh sách sách:");
                        manager.displayBooks();
                        break;

                    case 4:
                        // Thoát chương trình
                        System.out.println("Thoát chương trình.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập liệu! Vui lòng chọn một số hợp lệ.");
            }
        }
    }
}
