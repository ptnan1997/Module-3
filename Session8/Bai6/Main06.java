package Session8.Bai6;

import java.util.Scanner;

public class Main06 {
    static void main() {
        Scanner sc  = new Scanner(System.in);
        BookManager  manager = new BookManager();
        while (true){
            System.out.println("""
                Chọn chức năng:
                1. Thêm sách
                2. Hiển thị sách
                3. Xóa sách
                4. Thoát
                """);
            int choice  = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1 -> { // Thêm sách
                    System.out.print("Nhập tiêu đề: ");
                    String title = sc.nextLine();
                    System.out.print("Nhập tác giả: ");
                    String author = sc.nextLine();
                    System.out.print("Nhập ISBN");
                    String isbn = sc.nextLine();
                    System.out.print("Nhập năm xuất bản: ");
                    int year  = Integer.parseInt(sc.nextLine());

                    manager.addBook(new Books(title, author, isbn, year));
                }
                case 2 -> { // Hiển thị danh sách
                    Books[] book = manager.displayBook();
                    if (book.length == 0 ){
                        System.out.println("Danh sách rỗng");
                    } else {
                        for (Books b : book) {
                            System.out.println(b.getDetail());
                        }
                    }
                }
                case 3 -> { // Xóa sách
                    System.out.print("Nhập vào ISBN: ");
                    String isbn = sc.nextLine();
                    manager.removeBook(isbn);
                }
                case 4 -> { // Thoát
                    System.out.println("Kết thúc chương trình");
                    return;
                }
                default -> System.out.println("Giá trị nhập vào không hợp lệ");
            }
        }
    }

}
