package Library.Domain;

import Library.Data.LibraryRepo;
import Library.Models.Book;

public class LibraryService {

    private LibraryRepo repo;

    public LibraryService(LibraryRepo repo){
        this.repo = repo;
    }

    public BookResult addBook(Book toAdd){
        BookResult result = validate(toAdd);
        if(!result.hasError()){
            repo.addBook(toAdd);
            result.setPayLoad(toAdd);

        }


        return result;

    }
//
//    getById(){
//
//    }
//
//    getAllBooks(){
//
//
//    }
//
//    getByTitle(String title){
//
//
//    }
//
//
//    getByAuthor(String author){
//
//
//
//    }
//
//
//    getByRating(int halfStar){
//
//    }
//
//
//    getByYear(int year){
//
//
//    }
//
//    updateBook(Book updated){
//
//
//    }
//
//    delete(int id){
//
//
//    }

    private BookResult validate(Book toCheck){
        BookResult result = new BookResult();
        if(toCheck == null){
            result.addErrorMessage("Book cannot be null.");
            return result;
        }
        if(toCheck.getBookGenre() == null){
            result.addErrorMessage("Missing genre");
        }
        if(toCheck.getTitle() == null || toCheck.getTitle().isBlank()){
            result.addErrorMessage("Missing title.");

        }else if(toCheck.getTitle().length() < 5){
            result.addErrorMessage("Title must be 5 characters");
        }if(toCheck.getRating() < 0 || toCheck.getRating() > 10){
            result.addErrorMessage("Rating must be between 0 and 10");
        }
        if(toCheck.getYear() > 2022){
            result.addErrorMessage("Year cannot be in future.");
        }
        if(toCheck.getAuthor() == null || toCheck.getAuthor().isBlank()){
            result.addErrorMessage("Missing author.");
        }

       return result;
    }
}
