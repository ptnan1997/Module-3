package Session13.Bai7.ra.dao;

import Session13.Bai7.ra.entity.Book;

import java.util.List;

public interface IBookManager {
    List<Book> listAllBook();
    Book  findBookByAuthor(String author);
    void addBook (Book book);
    void updateBook (int bookId,Book book);
    void deleteBook (int bookId);

}
