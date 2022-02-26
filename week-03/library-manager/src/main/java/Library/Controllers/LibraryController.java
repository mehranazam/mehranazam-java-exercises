package Library.Controllers;

import Library.Domain.BookResult;
import Library.Domain.LibraryService;
import Library.Models.Book;
import Library.UI.LibraryView;

public class LibraryController {
    private LibraryService service;
    private LibraryView view;



    public LibraryController(LibraryService service, LibraryView view){
            this.service = service;
            this.view = view;
    }

    public void run(){
        boolean exit = false;
        while(!exit) {
            int menuChoice = view.mainMenu();

            switch(menuChoice){
                case 1:
                    addBook();
                    break;
                case 2:
                    System.out.println("GET BY ID");
                    break;
                case 3:
                    System.out.println("GET ALL");
                    break;
                case 4:
                    System.out.println("GET BY TITLE");
                    break;
                case 5:
                    System.out.println("GET BY AUTHOR");
                    break;
                case 6:
                    System.out.println("GET BY RATING");
                    break;
                case 7:
                    System.out.println("GET BY YEAR");
                    break;
                case 8:
                    System.out.println("EDIT");
                    break;
                case 9:
                    System.out.println("DELETE");
                    break;
                case 10:
                   exit = true;
                    break;
            }

        }
    }

    private void addBook() {
        /*
        1. get Book object from ui
        2. pass Book object to service layer to be validated/saved
        3. if there are errors, display to user (using the view)
         */

        Book toAdd = view.createBook();

        BookResult addResult = service.addBook(toAdd);
        if(addResult.hasError()){
            view.printErrors(addResult.getErrorMessages());
        }else{
            view.displayBookDetails(addResult.getPayLoad());
        }


    }
}
