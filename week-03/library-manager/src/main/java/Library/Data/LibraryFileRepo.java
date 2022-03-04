package Library.Data;

import Library.Models.Book;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryFileRepo implements LibraryRepo{


    @Override
    public Book addBook(Book toAdd) {
        toAdd.setBookId(allBooks.stream().mapToInt(Book::getBookId).max().orElse(0) + 1);

        allBooks.add(toAdd);
        return toAdd;
    }

    @Override
    public Book getById(int id) {
        return allBooks.stream().filter(b -> b.getBookId() == id).findAny().orElse(null);
    }

    @Override
    public List<Book> getByAuthor(String author) {
        return allBooks.stream().filter(b -> b.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public void editBook(Book updated) {
        allBooks = allBooks.stream()
                .map(b -> b.getBookId() == updated.getBookId() ? updated : b)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        allBooks = allBooks.stream().filter(b -> b.getBookId() != id).collect(Collectors.toList());
    }
}
