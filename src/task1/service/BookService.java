package task1.service;
import task1.models.Book;
import java.util.List;

public interface BookService {
    Book saveBook(Long libraryId,Book book);
    List<Book> getAllBooks(Long libraryId);
    Book getBookById(Long libraryId, Long bookId);
    String deleteBook(Long libraryId,Long bookId);
    void clearBooksByLibraryId(Long libraryId);
}
