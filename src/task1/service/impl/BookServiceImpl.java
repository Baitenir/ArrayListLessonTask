package task1.service.impl;
import task1.db.DataBase;
import task1.models.Book;
import task1.models.Library;
import task1.service.BookService;
import task1.service.LibraryService;
import java.util.List;

public class BookServiceImpl implements BookService {
    LibraryService libraryService = new LibraryServiceImpl();

    @Override
    public Book saveBook(Long libraryId, Book book) {
        Library library = libraryService.getLibraryById(libraryId);
        if (library != null){
            library.getBooks().add(book);
            DataBase.books.add(book);
            return book;
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        return DataBase.books;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        Library library = libraryService.getLibraryById(libraryId);
        if (library != null){
            for (Book book : library.getBooks()) {
                if (book.getId().equals(bookId)){
                    return book;
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
//        Book book = getBookById(libraryId, bookId);
        Library library = libraryService.getLibraryById(libraryId);
        boolean removed = library.getBooks().removeIf(book -> book.getId().equals(bookId));
        return removed ? "Book deleted." : "Book not founded!";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        Library library = libraryService.getLibraryById(libraryId);
        if (library != null){
            library.getBooks().clear();
        }
    }


}
