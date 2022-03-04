package Library.Data;

import Library.Models.Book;

import java.util.List;

public interface LibraryRepo {

//    getAll();
//    getById();
//    getByTitle();

    public Book addBook(Book toAdd);

    Book getById(int id);

    List<Book> getByAuthor(String author);

    void editBook(Book updated);

    void deleteById(int id);




}
