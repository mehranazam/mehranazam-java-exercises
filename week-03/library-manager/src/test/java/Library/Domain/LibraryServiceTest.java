package Library.Domain;

import Library.Data.LibraryTestRepo;
import Library.Models.Book;
import Library.Models.Genre;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {
    LibraryService toTest = new LibraryService(new LibraryTestRepo());

    //good path

    @Test
    void shouldAddBook() {
        //Arrange
            Book toAdd = new Book();

            toAdd.setTitle("This is a good title");
            toAdd.setAuthor("This is a good author");
            toAdd.setYear(2020);
            toAdd.setRating(5);
            toAdd.setBookGenre(Genre.FANTASY);

            //Act
            BookResult result = toTest.addBook(toAdd);
            assertFalse(result.hasError());
            assertEquals("This is a good title", result.getPayLoad().getTitle());
        assertEquals("This is a good author", result.getPayLoad().getAuthor());
        assertEquals(2020, result.getPayLoad().getYear());
        assertEquals(5, result.getPayLoad().getRating());
        assertEquals("This is a good genre", result.getPayLoad().getBookGenre());
    }

    //bad path
    @Test
    void shouldNotAddNullBook(){

    }

    @Test
    void shouldNotAddBookWithNullTitle(){

    }

    @Test
    void shouldNotAddBookWithNullGenre(){

    }

    @Test
    void shouldNotAddBookWithNullAuthor(){

    }

    @Test
    void shouldNotAddBookWithFutureYear(){

    }

    @Test
    void shouldNotAddBookWithNegativeRating(){

    }

    @Test
    void shouldNotAddBookWithTooLargeRating(){

    }


    @Test
    void shouldNotAddBookWithBlankAuthor(){

    }

    @Test
    void shouldNotAddBookWithBlankTitle(){

    }

    @Test
    void shouldNotAddBookWithNegativeTitle(){

    }
}