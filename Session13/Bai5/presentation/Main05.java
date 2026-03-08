package Session13.Bai5.presentation;

import Session13.Bai5.ra.dao.InputData13;
import Session13.Bai5.ra.dao.MovieManager;
import Session13.Bai5.ra.entity.Movies;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManager movieManager = new MovieManager();
        int choice;
        do {
            System.out.println("""
                    =========== QUẢN LÝ PHIM ==========
                    1.  Thêm phim
                    2.  Liệt kê phim
                    3.  Sửa phim
                    4.  Xóa phim
                    5.  Thoát
                    ===================================
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice  = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 ->{ // Thêm phim
                    String newTitle = InputData13.getString(sc,"Nhập title: ");
                    String newDirector = InputData13.getString(sc,"Nhập director: ");
                    int newYear = InputData13.getInt(sc,"Nhập năm sản xuất: ");
                    movieManager.addMovies(new Movies(newTitle,newDirector,newYear));
                }
                case 2 ->{ // Liệt kê phim
                    movieManager.listMovies();
                }
                case 3 ->{ // Sửa phim
                    int editMovieID = InputData13.getInt(sc,"Nhập mã phim muốn cập nhật: ");
                    String editTitle = InputData13.getString(sc,"Nhập title: ");
                    String editDirector = InputData13.getString(sc,"Nhập director: ");
                    int editYear = InputData13.getInt(sc,"Nhập năm sản xuất: ");
                    movieManager.editMovies(new Movies(editTitle,editDirector,editYear),editMovieID);
                }
                case 4 ->{ // Xóa phim
                    int deleteMovieId = InputData13.getInt(sc,"Nhập vào mã phim muốn xóa: ");
                    movieManager.deleteMoviesByID(deleteMovieId);
                }
                case 5 ->{ // Thoát
                    System.out.println("Kết thúc chương trình. Cảm ơn đã sử dụng");
                    sc.close();
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại");
            }
        } while (true);
    }
}
