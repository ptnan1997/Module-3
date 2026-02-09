package Session8.Bai6;

public interface IBookManager {
    void addBook (Books book);   // Thêm mới sách
    void removeBook (String isbn);// Xóa một quyển sách theo mã isbn
    Books[] displayBook ();          // Hiển thị danh sách các quyển sách
}
