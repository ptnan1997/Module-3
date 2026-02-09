package Session8.Bai6;

public class Books {
    private String title; // Tiêu đề sách
    private String author; // Tác giả sách
    private final String isbn; // Mã ISBN
    private int year; // Năm xuất bản
    public Books(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }
    // Getter and Setter

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Phương thức
    public String getDetail(){
        return "Tiêu đề: " + title + "\n " +"Tác giả: " + author + "\n " +"Mã ISBN: " + isbn + "\n " +"Năm xuất bản: " + year;
    }
    public String getIsbn(){
        return isbn;
    }

}
