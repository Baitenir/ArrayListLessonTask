package task1.service.impl;
import task1.db.DataBase;
import task1.generateId.IdGenerator;
import task1.models.Library;
import task1.service.LibraryService;
import java.util.List;
import java.util.Objects;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        DataBase.libraries.addAll(libraries);
        for (Library library : DataBase.libraries) {
            if (library.getId() == null){
                library.setId(IdGenerator.generateIdForLibraries());
            }
        }
        return DataBase.libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return DataBase.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : DataBase.libraries) {
            if (library != null) {
                if (library.getId().equals(id)) {
                    return library;
                }
            } else {
                System.out.println("Library is null!");
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (Library lib : DataBase.libraries) {
            if (lib.getId().equals(id)){
                lib.setName(library.getName());
                lib.setAddress(library.getAddress());
                return lib;
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        boolean removed = DataBase.libraries.removeIf(library -> library.getId().equals(id));
        return removed ? "Library deleted." : "Library not founded";
    }
}
