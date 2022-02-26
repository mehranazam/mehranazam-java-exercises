package Library.UI;

import Library.Models.Book;
import Library.Models.Genre;

import java.util.List;
import java.util.Scanner;

public class LibraryView {

    private TextIO console;

    public LibraryView( TextIO console){
        this.console = console;
    }

    public int mainMenu(){

        console.print("1. Add book\n2. Get Book by ID\n3. Get All Books\n4. Get Book by Title\n5. Get Book by Author\n6. Get Book by Rating\n7. Get Book by Year\n8. Edit Book\n9. Delete Book\n10. Exit\n");
        return console.readInt("Please enter selection: ", 1, 10);
    }

    public Book createBook(){
        Book toReturn = new Book();
        toReturn.setTitle(console.readString("Please enter title: "));
        toReturn.setAuthor(console.readString("Please enter author: "));
        toReturn.setBookGenre(getGenre());
        toReturn.setYear(console.readInt("Please enter year: ", 1500, 2022));
        toReturn.setRating(console.readInt("Please enter (half-star) rating: ", 0, 10));

        return toReturn;
    }

    private Genre getGenre(){
        Genre toReturn = null;

        console.print("Choose a genre:\n" +
                "1. SciFi\n" +
                "2. Mystery\n" +
                "3. Fantasy\n" +
                "4. Adventure\n" +
                "5. Romance\n");

        switch (console.readInt("Please enter selection: ", 1, 5)){
            case 1:
                toReturn = Genre.SCIFI;
                break;
            case 2:
                toReturn = Genre.MYSTERY;
                break;
            case 3:
                toReturn = Genre.FANTASY;
                break;
            case 4:
                toReturn = Genre.ADVENTURE;
                break;
            case 5:
                toReturn = Genre.ROMANCE;
                break;
        }

        return toReturn;
    }

    public void printErrors(List<String> errorMessages) {
        throw new UnsupportedOperationException();
    }

    public void displayBookDetails(Book toDisplay) {
        throw new UnsupportedOperationException();
    }
}
