package Session8.Bai6;

public class BookManager implements IBookManager{
    private final Books [] book;
    private int count;
    private int indexOfBook(String isbn){
        for(int i=0;i<count;i++){
            if (book[i].getIsbn().equals(isbn) ){
                return i;
            }
        }
        return -1;
    }
    public BookManager (){
        book = new Books[100];
        count = 0;
    }
    @Override
    public void addBook (Books Book){
        if (indexOfBook(Book.getIsbn())!=-1){
            System.out.println("Books already exists");
            return ;
        }
        if (count >= book.length){
            System.out.println("BookCase is out of space");
            return;
        }
        book[count++]=Book;
        System.out.println("Books added ✅");
    }
    @Override
    public void removeBook (String isbn){
            int idx =  indexOfBook(isbn);
            if (idx == -1){
                System.out.println("Your book is not exist");
                return;
            }
            // Dồn mảng
            for (int i = idx; i< count-1 ;i++){
                book[i] = book[i+1];
            }
            book[count-1] = null;
            count--;
        System.out.println("Book deleted ✅");
    }
    @Override
    public Books[] displayBook (){
        Books[] result = new Books[count];
        System.arraycopy(book, 0, result, 0, count);
        return result;
    }
}
