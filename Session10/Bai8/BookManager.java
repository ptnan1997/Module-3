package Session10.Bai8;

import java.util.*;

public class BookManager {
    private Set<Book> books = new HashSet<>();
    public boolean addBook(Book book){
        return books.add(book);
    }
    public List<Book> filterByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > year) {
                result.add(book);
            }
        }
        return result;
    }
    public void display(){
        for (int i=0; i<books.size(); i++){
            System.out.println(books);
        }
    }
    public void sortByTitle(List<Book> list) {
        Collections.sort(list,Comparator.comparing(Book::getTitle));
    }
    public List<Book> getAllBooksSortedByTitle(){
        List<Book> result = new ArrayList<>(books);
        result.sort(Comparator.comparing(Book::getTitle));
        return result;
    }
}
