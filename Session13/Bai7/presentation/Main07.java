package Session13.Bai7.presentation;

import Session13.Bai7.ra.dao.BookManager;
import Session13.Bai7.ra.dao.InputData13_7;
import Session13.Bai7.ra.entity.Book;

import java.time.Year;
import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager Manager  = new BookManager();
        int choice;
        do{
            System.out.println("""
                    ======= QUẢN LÝ SÁCH =============
                    1. Thêm sách
                    2. Cập nhật thông tin sách
                    3. Xóa sách
                    4. Tìm kiếm sách
                    5. Hiển thị danh sách tất cả sách
                    6. Thoát
                    ==================================
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 ->{ // Thêm sách
                    String tilte = InputData13_7.getString(sc,"Nhập title: ");
                    String author = InputData13_7.getString(sc,"Nhận Author: ");
                    Year year = InputData13_7.getYear(sc,"Nhập năm xuất bản: ");
                    double price = InputData13_7.getDouble(sc,"Nhập giá:");
                    Manager.addBook(new Book(tilte,author,year,price));
                }
                case 2 ->{ // Cập nhật thông tin sách
                    int bookIdUpdate = InputData13_7.getInt(sc,"Nhập bookId:");
                    String tilteUpdate = InputData13_7.getString(sc,"Nhập title: ");
                    String authorUpdate = InputData13_7.getString(sc,"Nhận Author: ");
                    Year yearUpdate = InputData13_7.getYear(sc,"Nhập năm xuất bản: ");
                    double priceUpdate = InputData13_7.getDouble(sc,"Nhập giá:");
                    Manager.updateBook(bookIdUpdate,new  Book(tilteUpdate,authorUpdate,yearUpdate,priceUpdate));
                }
                case 3 ->{ // Xóa sách
                    int bookIdDelete = InputData13_7.getInt(sc,"Nhập bookId cần xóa:");
                    Manager.deleteBook(bookIdDelete);
                }
                case 4 ->{ // Tìm kiếm sách
                    String authorName = InputData13_7.getString(sc,"Nhập tên tác giả: ");
                    Manager.findBookByAuthor(authorName);
                }
                case 5 -> // Hiển thị tất cả sách
                    Manager.listAllBook();

                case 6 ->{
                    System.out.println("Kết thúc quản lý. Cảm ơn đã sử dụng");
                    sc.close();
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại");
            }
        } while (choice!=6);
    }
}
