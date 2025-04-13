package task1.service.impl;
import task1.db.DataBase;
import task1.models.Library;
import task1.models.Reader;
import task1.service.ReaderService;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public void saveReader(Reader reader) {
        DataBase.readers.add(reader);
        System.out.println("Reader saved!");
    }

    @Override
    public List<Reader> getAllReaders() {
        return DataBase.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader : DataBase.readers) {
            if (reader.getId().equals(id)){
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader reader1 : DataBase.readers) {
            if (reader1.getId().equals(id)){
                reader1.setFullName(reader.getFullName());
                reader1.setPhoneNumber(reader.getPhoneNumber());
                reader1.setEmail(reader.getEmail());
                return reader1;
            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Reader reader = getReaderById(readerId);
        for (Library library : DataBase.libraries) {
            if (library.getId().equals(libraryId)){
                library.getReaders().add(reader);
            }
        }
    }
}
