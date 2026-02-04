package Session7.Bai2;

public class Exercise2 {
    static void main() {
        Book myBook = new Book();
        // Thiết lập thuộc tính
        myBook.setTitle("Java Programming");
        myBook.setAuthor("James Gosling");
        // Thiết lập giá hợp lệ
        myBook.setPrice(29.99);
        // Hiển thị thông tin sách
        System.out.println("Tiêu đề: " + myBook.getTitle());
        System.out.println("Tác giả: " + myBook.getAuthor());
        System.out.println("Giá: " + myBook.getPrice());
        // Thử thay đổi giá thành công
        myBook.setPrice(35.50);
        System.out.println("Giá mới: " + myBook.getPrice());
        // Thử thay đổi giá không hợp lệ
        myBook.setPrice(-5.00);
        System.out.println("Giá mới: " + myBook.getPrice());
    }
}
