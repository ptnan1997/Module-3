package Session10.Bai8;

import java.util.List;
import java.util.Scanner;

public class Main08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager manager = new BookManager();
        int choice;
        List<Book> filtered;
        while (true){
            System.out.println("""
                    -------- QUẢN LÝ SÁCH -------
                    1. Thêm sách vào bộ sưu tập
                    2. Lọc sách theo năm xuất bản
                    3. Sắp xếp sách theo tên
                    4. Hiển thị danh sách Sách
                    5. Thoát
                    --------------------------------
                    """);

            choice = InputData08.getInt(sc,"Lựa chọn của bạn: ");
            switch (choice){
                case 1 -> { // Thêm sách vào bộ sưu tập
                    while(true){
                        String id = InputData08.getString(sc,"Nhập vào id sách: ");
                        String title = InputData08.getString(sc,"Nhập vào title: ");
                        String author = InputData08.getString(sc,"Nhập tên tác giả: ");
                        int year = InputData08.getInt(sc,"Nhập năm xuất bản: ");
                        Book book = new Book(id,title,author,year);
                        if (!manager.addBook(book)) {
                            System.out.println("Id đã tồn tại! Vui lòng nhập lại");
                        } else {
                            System.out.println("✅ Thêm sách thành công");
                            break;
                        }
                    }
                }
                case 2 -> { // Lọc sách theo năm xuất bản
                    int year = InputData08.getInt(sc,"Nhập năm cần lọc: ");
                    filtered = manager.filterByYear(year);
                    System.out.println("Danh sách lọc theo năm xuất bản: \n" + filtered);

                   ;
                }
                case 3 -> { // Sắp xếp danh sách theo tên
                    List <Book> sorted= manager.getAllBooksSortedByTitle();
                    System.out.println("✅ Danh sách sau khi sắp xếp:");
                    for (Book b : sorted) {
                        System.out.println(b);
                    }
                }
                case 4 -> { // Hiển thị danh sách
                    manager.display();
                }
                case 5 -> {
                    System.out.println("Kết thúc chương trình !! Cảm ơn");
                    return;
                }
                default -> System.out.println("Lựa chọn không hơp lệ!!");
            }
        }
    }
}
