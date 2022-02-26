# Library Manager

## Data (Books)

0. Id - int
1. Genre - enum (Sci-Fi, Mystery, Fantasy, Adventure, Romance)
2. Title - String, non-blank, min length: 5 characters
3. Rating - int (half stars), min: 0, max: 10
4. Year - int, in the past (or this year)
5. Author - String, non-blank

## Use Cases

We want full CRUD, so we'll need standard set of use cases:

1. Add Book
2. List all Books
3. Display Book by Id
4. List Books by author
5. List Books by title
6. List Books by Rating
7. List Books by Year
8. Edit Book
9. Delete Book

## Add a Book

1. UI - Gather details of new book from user into Book object.
2. Domain - validate Book details
3. Repo - compute max id + 1 for new id, then save to file
4. UI - display the updated Book (with new id) to the user

### TODO: add more....

## Program Structure

Layers

1. Data - handles "persistence" (storing/retrieving data from database)
   1. 
2. Models - common "language" between layers (functions will send models around)
3. UI - handles user interaction (both displaying and receiving data)
4. Domain - handles "business logic" (validation, algorithm, etc)
5. Controllers - manages top-level control of program flow (traffic cop between ui and domain)

Classes/Interfaces

1. Models
   1. Genre
      1. Sci-Fi 
      2. Mystery 
      3. Fantasy 
      4. Adventure 
      5. Romance
   2. Book
      1. ctor (command shortcut for constructor)
      2. getId()
      3. setId()
      4. getTitle()
      5. setTitle()
      6. getAuthor()
      7. setAuthor()
      8. getYear()
      9. setYear()
      10. getRating()
      11. setRating()
      12. getGenre()
      13. setGenre()
2. Controllers
   1. LibraryController
      1. run() - to be called by main(), kicks off the action
3. UI
   1. LibraryView
      1. mainMenu() - Displays main menu and asks for user input
      2. addBook() - gather book details, output a Book object
      3. ???
   2. TextIO
      1. print(String toPrint)
      2. readString(String prompt)
      3. editString(String prompt, String oldValue)
      4. readInt(String prompt)
      5. readInt(String prompt, int min, int max)
      6. editInt(String prompt, int oldValue)
      7. editInt(String prompt, int oldValue, int min, int max)
4. Domain
   1. LibraryService
      1. addBook()
      2. getById()
      3. getAllBooks()
      4. getByTitle(String title)
      5. getByAuthor(String author)
      6. getByRating(int halfStar)
      7. getByYear(int year)
      8. updateBook(Book updated)
      9. delete(int id)
   2. BookResult - wrapper to indicate success or failure
5. Data
   1. LibraryRepo - repo interface
      1. getAll()
      2. getById()
      3. getByTitle()
      4. ...
   2. LibraryFileRepo - implements LibraryRepo
   
## Programming Tasks

* [x] Create Layers
* [x] Create Classes
* [x] Add field variable to our structural classes (non-models)
  * [x] Add service to controller
  * [x] Add view to controller
  * [x] Add repo (interface) to the service
  * [x] Add TextIO to view
* [x] Add constructors to our structural classes
  * [x] controller will take in service & view
  * [x] service will take in repo (interface)
  * [x] view will take in TextIO
* [x] Instantiate controller in main()
  * [x] Instantiate service object in main()
    * [x] Instantiate repo object in main()
  *[x] instantiate view object in main()
    * [x] instantiate TextIO object in main()
* [x] call run() to make sure our controller is running
* [x] add Book fields
* [x] add Genre enum values
* [x] add main loop to run() in controller
* [x] add mainMenu() method to the view
  * [x] add print() to TextIO
  * [x] add readString() to TextIO
  * [x] add Scanner field variable to TextIO
  * [x] add readInt() to TextIO
* [x] call mainMenu() from the controller (inside the loop)
  * [x] add public Book createBook() function to view
    * [x] add private Genre getGenre() method to view
*[] add a public BookResult addBook(Book toAdd) function to service layer
    * [] add private validate() function to service layer
    * [] add a public Book addBook(Book toAdd) function to the DAO