package task1.generateId;

public class IdGenerator {
    private static long counterForLibraries = 0;
    private static long counterForBooks = 0;
    private static long counterForReaders = 0;

    public static synchronized long generateIdForLibraries(){
        return ++counterForLibraries;
    }
    public static synchronized long generateIdForBooks(){
        return ++counterForBooks;
    }
    public static synchronized long generateIdForReaders(){
        return ++counterForReaders;
    }
}
