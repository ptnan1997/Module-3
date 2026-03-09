package Session13.Bai7.ra.dao;

import Session13.Bai7.JDBC.database_bai7;
import Session13.Bai7.ra.entity.Book;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BookManager implements IBookManager {

    @Override
    public List<Book> listAllBook() {
        List<Book> books = new ArrayList<>();
        // Mở kết nối
        Connection con = database_bai7.openConnection();
        try {
            // Truy vấn bằng CallableStatement
            CallableStatement call = con.prepareCall("{Call list_All_book()}");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                  rs.getString("title"),
                  rs.getString("author"),
                  Year.of(rs.getInt("published_year")),
                  rs.getDouble("price")
                );
                book.setBookId(rs.getInt("id"));
                books.add(book);
            }
            if (books.isEmpty()) {
                System.out.println("No books found");
            } else {
                for (Book book : books) {
                    System.out.println(book);
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book findBookByAuthor(String author) {
        // Mở kết nối
        Connection con = database_bai7.openConnection();
        try {
            // Truy vấn bằng CallableStatement
            CallableStatement call = con.prepareCall("{Call find_book_by_author(?)}");
            call.setString(1, author);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        Year.of(rs.getInt("published_year")),
                        rs.getDouble("price")
                );
                book.setBookId(rs.getInt("id"));
                System.out.println(book);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void addBook(Book book) {
        // Mở kết nối
        Connection con = database_bai7.openConnection();
        try {
            // Truy vấn bằng CallableStatement
            CallableStatement call = con.prepareCall("{Call add_book(?,?,?,?)}");
            call.setString(1, book.getTitle());
            call.setString(2, book.getAuthor());
            call.setString(3, String.valueOf(book.getPublishedYear()));
            call.setDouble(4, book.getPrice());
            call.executeUpdate();
            call.close();
            System.out.println("Book added ✅");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBook(int bookId, Book book) {
        // Mở kết nối
        Connection con = database_bai7.openConnection();
        try {
            // Truy vấn bằng CallableStatement
            CallableStatement call = con.prepareCall("{Call update_book(?,?,?,?,?)}");
            call.setString(2, book.getTitle());
            call.setString(3, book.getAuthor());
            call.setString(4, String.valueOf(book.getPublishedYear()));
            call.setDouble(5, book.getPrice());
            call.setInt(1, bookId);
            call.executeUpdate();
            call.close();
            System.out.println("Book updated ✅");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBook(int bookId) {
        // Mở kết nối
        Connection con = database_bai7.openConnection();
        try {
            // Truy vấn bằng CallableStatement
            CallableStatement call = con.prepareCall("{Call delete_book(?)}");
            call.setInt(1, bookId);
            call.executeUpdate();
            call.close();
            System.out.println("Book deleted ✅");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
