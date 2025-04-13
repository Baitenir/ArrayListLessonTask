package task1;
import task1.db.DataBase;
import task1.enums.Gender;
import task1.enums.Genre;
import task1.generateId.IdGenerator;
import task1.models.Book;
import task1.models.Library;
import task1.models.Reader;
import task1.service.BookService;
import task1.service.LibraryService;
import task1.service.ReaderService;
import task1.service.impl.BookServiceImpl;
import task1.service.impl.LibraryServiceImpl;
import task1.service.impl.ReaderServiceImpl;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryServiceImpl();
        BookService bookService = new BookServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();
        Scanner scannerForNumbers = new Scanner(System.in);
        Scanner scannerForLine = new Scanner(System.in);
        while (true){
            System.out.println("""
                    
                    Select action:
                    1. Save library
                    2. Get all libraries
                    3. Get library by id
                    4. Update library
                    5. Delete library
                    6. Save book
                    7. Get all books
                    8. Get book by id
                    9. delete book
                    10. Clear books by library id
                    11. Save reader
                    12. Get all readers
                    13. Get reader by id
                    14 Update reader
                    15. Assign reader to library
                    16. Exit
                    """);

            switch (scannerForNumbers.nextInt()){
                case 1:
                    Library lib = new Library();
                    lib.setId(IdGenerator.generateIdForLibraries());
                    System.out.println("Write name library: ");
                    lib.setName(scannerForLine.nextLine());
                    System.out.println("Write address library: ");
                    lib.setAddress(scannerForLine.nextLine());
                    libraryService.saveLibrary(List.of(lib));
                    System.out.println("Library saved!");
                    break;
                case 2:
                    for (Library allLibrary : libraryService.getAllLibraries()) {
                        System.out.println(allLibrary);
                    }
                    break;
                case 3:
                    System.out.println("Write the library id:");
                    System.out.println(libraryService.getLibraryById(scannerForNumbers.nextLong()));
                    break;
                case 4:
                    Library updateLib = new Library();
                    System.out.println("Write id for updating library: ");
                    long id = scannerForNumbers.nextLong();
                    System.out.println("Write new name for library:");
                    updateLib.setName(scannerForLine.nextLine());
                    System.out.println("Write new address for library:");
                    updateLib.setAddress(scannerForLine.nextLine());
                    System.out.println(libraryService.updateLibrary(id, updateLib));
                    break;
                case 5:
                    System.out.println("Write id for delete library");
                    libraryService.deleteLibrary(scannerForNumbers.nextLong());
                    break;
                case 6:
                    Book book = new Book();
                    book.setId(IdGenerator.generateIdForBooks());
                    System.out.println("Write book name:");
                    book.setName(scannerForLine.nextLine());
                    System.out.println("Write book author:");
                    book.setAuthor(scannerForLine.nextLine());
                    int c = 0;
                    System.out.println("Write the genre:");
                    for (Genre value : Genre.values()) {
                        System.out.println(++c + ". " +value);
                    }
                    c = scannerForNumbers.nextInt();
                    if (c == 0) System.out.println("null bro (test)");
                    else if (c == 1) book.setGenre(Genre.HISTORY);
                    else if (c == 2) book.setGenre(Genre.FANTASY);
                    else if (c == 3) book.setGenre(Genre.DETECTIVE);
                    else if (c == 4) book.setGenre(Genre.FICTION);
                    else if (c == 5) book.setGenre(Genre.NONFICTION);
                    else if (c == 6) book.setGenre(Genre.SCIENCE);
                    else System.out.println("Incorrect choice!");
                    System.out.println("Write library id:");
                    bookService.saveBook(scannerForNumbers.nextLong(), book);
                    break;
                case 7:
                    System.out.println("Write library id:");
                    for (Book allBook : bookService.getAllBooks(scannerForNumbers.nextLong())) {
                        System.out.println(allBook);
                    }
                    break;
                case 8:
                    System.out.println("Write library and book id:");
                    System.out.println(bookService.getBookById(scannerForNumbers.nextLong(), scannerForNumbers.nextLong()));
                    break;
                case 9:
                    System.out.println("Write library and book id:");
                    System.out.println(bookService.deleteBook(scannerForNumbers.nextLong(), scannerForNumbers.nextLong()));
                    break;
                case 10:
                    System.out.println("Write library id:");
                    bookService.clearBooksByLibraryId(scannerForNumbers.nextLong());
                    break;
                case 11:
                    Reader reader = new Reader();
                    reader.setId(IdGenerator.generateIdForReaders());
                    System.out.println("Write full name:");
                    reader.setFullName(scannerForLine.nextLine());
                    System.out.println("Write phone number:");
                    reader.setPhoneNumber(scannerForLine.nextLine());
                    System.out.println("Write email:");
                    reader.setEmail(scannerForLine.nextLine());
                    int c2 = 0;
                    for (Gender value : Gender.values()) {
                        System.out.println(++c2 + ". " + value);
                    }
                    System.out.println("Select gender:");
                    c2 = scannerForNumbers.nextInt();
                    if (c2 == 1) reader.setGender(Gender.MALE);
                    else if (c2 == 2) reader.setGender(Gender.FEMALE);
                    else System.out.println("Incorrect choice!");
                    readerService.saveReader(reader);
                    break;
                case 12:
                    for (Reader allReader : readerService.getAllReaders()) {
                        System.out.println(allReader);
                    }
                    break;
                case 13:
                    System.out.println("Write reader id:");
                    System.out.println(readerService.getReaderById(scannerForNumbers.nextLong()));
                    break;
                case 14:
                    Reader updateReader = new Reader();
                    System.out.println("Write reader id for update reader information:");
                    long rId = scannerForNumbers.nextLong();
                    System.out.println("Write new name for reader:");
                    updateReader.setFullName(scannerForLine.nextLine());
                    System.out.println("Write new phone number for reader:");
                    updateReader.setPhoneNumber(scannerForLine.nextLine());
                    System.out.println("Write new email for reader:");
                    updateReader.setEmail(scannerForLine.nextLine());
                    System.out.println(readerService.updateReader(rId, updateReader));
                    break;
                case 15:
                    System.out.println("Write reader and library id:");
                    readerService.assignReaderToLibrary(scannerForNumbers.nextLong(), scannerForNumbers.nextLong());
                    break;
                case 16:
                    return;
                default:
                    System.out.println("Incorrect choice!");
            }
        }
    }
}