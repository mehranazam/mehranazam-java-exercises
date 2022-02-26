package Library;

import Library.Controllers.LibraryController;
import Library.Data.LibraryFileRepo;
import Library.Data.LibraryRepo;
import Library.Domain.LibraryService;
import Library.UI.LibraryView;
import Library.UI.TextIO;

public class App {

    public static void main(String[] args) {


        LibraryRepo repo = new LibraryFileRepo();
        LibraryService service = new LibraryService(repo);


        TextIO console = new TextIO();
        LibraryView view = new LibraryView(console);

        LibraryController controller = new LibraryController(service, view);

        controller.run();
    }
}
