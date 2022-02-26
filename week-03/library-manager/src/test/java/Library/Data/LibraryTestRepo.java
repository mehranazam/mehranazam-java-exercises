package Library.Data;

import Library.Models.Book;
import Library.Models.Genre;

import java.util.ArrayList;
import java.util.List;

//full fake
//will do all real operations
//just in memory
public class LibraryTestRepo implements LibraryRepo{
    List<Book> allBooks = new ArrayList<>();

    public LibraryTestRepo() {
        Book first = new Book();
        first.setTitle("Fellowship of the Rings");
        first.setAuthor("JRR Tolkien");
        first.setBookGenre(Genre.FANTASY);
        first.setBookId(1);
        first.setYear(1930);
        first.setRating(10);
        allBooks.add(first);
    }

    @Override
    public Book addBook(Book toAdd) {
        int newId = -1;

        for(Book toCheck : allBooks){
            if(toCheck.getBookId() > newId){
                newId = toAdd.getBookId();
            }
        }
        newId++;
        toAdd.setBookId(newId);
        allBooks.add(toAdd);

        return toAdd;
    }
}
