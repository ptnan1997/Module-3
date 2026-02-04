package Session7.Bai2;

public class Book {
    private  String  title;
    private  String author;
    private  double price;

    public Book() {
    }

    public Book(String author, double price, String title) {
        this.author = author;
        this.price = price;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Price is negative");
        } else {
            this.price = price;
        }
    }
}
