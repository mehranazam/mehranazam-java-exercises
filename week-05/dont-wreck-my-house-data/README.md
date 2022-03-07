# Don't Wreck My House Plan
## High-level Requirements
User is an accommodation administrator.
- View existing reservations for a host.
- Create reservations for a guest with a host.
- Edit existing reservations.
- Cancel future reservations.
## Reservations
### Data
- **ID**: GUID for reservation.
- **Start Date**: Date when reservation begins.
- **End Date**: Date when reservation ends.
- **Guest Name**: Name of guest holding reservation (Last name, First name).
- **Guest Email**: Email address of guest.

### Validation
- **ID** is required and cannot be blank.
- **Start Date** must take place in the future and come before the end date. Can be edited.
- **End Date** must take place in the future and come after the start date. Can be edited.
- **Guest Name** must not be blank or null.
- **Guest Email** must not be blank or null.
- **Guest** and **Host** must already exist in the "database". **Guest** and **Host** cannot be created.
- The combined values of **Date**, **Guest Name**, and **Guest Email** may not be duplicated.
- Reservation may never overlap existing reservation dates.
- Cannot cancel reservation in the past.
## Technical Requirements
- Must be a Maven project.
- Spring dependency injection configured with either XML or annotations.
- All financial math must use BigDecimal.
- Dates must be LocalDate, never strings.
- All file data must be represented in models in the application.
- Reservation identifiers are unique per host, not unique across the entire application. Effectively, the combination of a reservation identifier and a host identifier is required to uniquely identify a reservation.
- Three layer architecture
- Data stored in a delimited file.
- Repositories should throw a custom exception, never file-specific exceptions.
- Repository and service classes must be fully tested with both negative and positive cases. Do not use your "production" data file to test your repository.

## Package/Class Overview
```
src
├───main
│   └───java
│       └───learn
│           └───solar
│               │   App.java                      -- app entry point
│               │
│               ├───data
│               │       DataException.java        -- data layer custom exception
│               │       ReservationFileRepository.java  -- concrete repository
│               │       ReservationRepository.java      -- repository interface
│               │
│               ├───domain
│               │       ReservationResult.java          -- domain result for handling success/failure
│               │       ReservationService.java         -- panel validation/rules
│               │
│               ├───models
│               │       Guest.java             -- Guest model
│               │       Host.java                -- Host model
│               │       Location.java            -- Location model
|               |       Reservation.java         -- Reservation model
|               |
│               └───ui
│                       Controller.java           -- UI controller
│                       View.java                 -- all console input/output
│
└───test
    └───java
        └───learn
            └───solar
                ├───data
                │       ReservationFileRepositoryTest.java    -- ReservationFileRepository tests
                │       ReservationRepositoryTestDouble.java  -- helps tests the service, implements ReservationRepository
                │
                └───domain
                        ReservationServiceTest.java           -- ReservationService tests
```
## Class Details
### App
- `public static void main(String[])` -- instantiate all required classes with valid arguments, dependency injection. run controller
### data.DataException
Custom data layer exception.
- `public DataException(String, Throwable)` -- constructor, Throwable arg is the root cause exception
### data.ReservationFileRepository
- `private String filePath`
- `public List<Reservation> findById(String)` -- finds all Reservations by ID, uses the private `findAll` method
- `public Reservation add(Reservation)` -- create a Reservation
- `public boolean edit(Reservation)` -- edit a Reservation
- `public boolean deleteById(int)` -- delete a Reservation by its id
- `private List<Reservation> findAll()` -- finds all Reservations in the data source (file), does not need to be public
- `private String serialize(Reservation)` -- convert a Reservation into a String (a line) in the file
- `private Reservation deserialize(String)` -- convert a String into a Reservation
### data.ReservationRepository (interface)
Contract for ReservationFileRepository and ReservationRepositoryTestDouble.
- `List<Reservation> findById(String)`
- `Reservation add(Reservation)`
- `boolean edit(Reservation)`
- `boolean deleteById(int)`
### domain.ReservationResult
- `private ArrayList<String> messages` -- error messages
- `private Reservation reservation` -- an optional Reservation
- `public boolean isSuccess()` -- calculated getter, true if no error messages
- `public List<String> getMessages()` -- messages getter, create a new list
- `public Reservation getReservation()` -- Reservation getter
- `public void setReservation(Reservation)` -- Reservation setter
- `public void addMessage(String)` -- adds an error message to messages
### domain.ReservationService
-  `private ReservationRepository repository` -- required data dependency
-  `public ReservationService(ReservationRepository)` -- constructor
-  `public List<Reservation> findById(String)` -- pass-through to repository
-  `public ReservationResult add(Reservation)` -- validate, then add via repository
-  `public ReservationResult edit(Reservation)` -- validate, then edit via repository
-  `public ReservationResult deleteById(int)` -- pass-through to repository
-  `private ReservationResult validate(Reservation)` -- general-purpose validation routine
### models.Location
- Class that holds location of reservation.
### models.Reservation
- `private int id`
- `private LocalDate startDate`
- `private LocalDate endDate`
- `private String firstName`
- `private String lastName`
- Full getters and setters
- override `equals` and `hashCode`
### ui.Controller
- `private View view` -- required View dependency
- `private ReservationService service` -- required service dependency
- `public Controller(View, ReservationService)` -- constructor with dependencies
- `public void run()` -- kicks off the whole app, menu loop
- `private void viewById()` -- coordinates between service and view to display reservations by Id.
- `private void addReservation()` -- coordinates between service and view to add a new reservation.
- `private void editReservation()` -- coordinates between service and view to edit a reservation.
- `private void deleteReservation()` -- coordinates between service and view to delete a reservation.
### ui.View
- `private Scanner console` -- a Scanner to be used across all methods
- `public int chooseOptionFromMenu()` -- display the main menu and select an option, used to Controller.run()
- `public void printHeader(String)` -- display text to the console with emphasis
- `public void printResult(ReservationResult)` -- display a ReservationResult with either success or failure w/ messages included
- `public void printReservations(int id, List<Reservation>)` -- display Reservations by Id.
- `public Reservation chooseReservation(int id, List<Reservation>)` -- choose a Reservation from a list of options (useful for edit and delete)
- `public Reservation makeReservation()` -- make a Reservation from scratch, used in Controller.addReservation
- `public Panel edit(Reservation)` -- accept an existing Reservation, edit it, and return it, used in Controller.editReservation
- `public int readId()` -- reads a section name, used in Controller: viewById, editReservation (must search first), and deleteReservation
- `private String readString(String)` -- general-purpose console method for reading a string
- `private String readRequiredString(String)` -- general-purpose console method for reading a required string
- `private int readInt(String)` -- general-purpose console method for reading an integer
- `private int readInt(String, int min, int max)` -- general-purpose console method for reading an integer with a min and max

## Steps
1. Create a Maven project.
2. Add jUnit 5, Jupiter, as a Maven dependency and refresh Maven
3. Create packages.
4. Create the `Guest` model.
5. Create the `Host` model.
6. Create the `Location` model.
7. Create the data layer's custom `DataException`
8. Create the `ReservationFileRepository` class.
   All methods should catch IOExceptions and throw `DataException`.
    - add the filePath field and create a constructor to initialize the field
    - generate tests for `ReservationFileRepository`, should be located in `src/test/java/learn/house/data/ReservationFileRepositoryTest`
    - create a `data` directory in the project root. add test, seed, and production data files
    - implement `findAll`, `serialize`, and `deserialize`. these are all private method. may be useful to make `findAll` public temporarily and test it quick.
    - implement `findById`, it uses `findAll`. test it naively (no known-good-state for now)
    - implement `add`
    - improve tests by establishing known-good-state with `@BeforeAll`
    - test `add`
    - implement `edit`
    - test `edit`
    - implement `deleteById`
    - test `deleteById`
9. Extract the `ReservationRepository` interface (IntelliJ: Refactor -> Extract Interface) from `ReservationFileRepository`.
10. Create `ReservationResult`.
11. Create `ReservationService`.
    - add a `ReservationRepository` (interface) field with a corresponding constructor
    - generate tests for `ReservationService`
    - create `ReservationRepositoryTestDouble` to support service testing, this test class implements `ReservationRepository`
    - implement `findById` and test, implement just enough code in `ReservationRepositoryTestDouble` to enable service testing
    - implement `add` and test, requires validation
    - implement `edit` and test, requires validation
    - implement `deleteById` and test
12. Create `View`
    - add `Scanner` field
    - create read* methods: `readString`, `readRequiredString`, `readInt`, `readInt` (with min/max)
13. Create `Controller`
    - add fields for service and view with corresponding constructor
    - add a `run` method
14. Create `App` and the `main` method.
    - instantiate all required objects: repository, service, view, and controller
    - run the controller
15. Work back and forth between controller and view.
    Run early and often. Add `System.out.println`s as breadcrumbs in controller, but don't forget to remove them when development is complete.
    Determine the correct sequence for service calls and view calls. What is the order?
    - implement `chooseOptionFromMenu` and `printHeader` in view
    - use them in the controller's `run`
    - implement `viewById` in controller, complete required view methods: `readSection`, `printReservations`
    - implement `addReservation` in controller, complete required view methods: `makeReservation`, `printResult`
    - implement `editReservation` in controller, complete required view methods: `chooseReservation`, `edit`
    - implement `deleteReservation` in controller, complete required view methods (`deleteReservation` can re-use `chooseReservation`)
## Controller Perspectives
### View Reservations by Section
1. collect section name from the view
2. use the name to fetch Reservations from the service
3. use the view to display Reservations
### Add a Panel
1. collect a complete and new Reservation from the view
2. use the service to add the Reservation and grab its result
3. display the Reservation in the view
### Update a Panel
1. collect id from the view
2. use the name to fetch Reservations from the service
3. display the Reservations in the view and allow the user to choose a Reservation (if no Reservation selected, abort)
4. update Reservation properties (setters) in the view
5. use the service to edit/save the Reservation and grab its result
6. display the result in the view
### Delete a Panel
1. collect id from the view
2. use the id to fetch Reservations from the service
3. display the Reservations in the view and allow the user to choose a Reservation (if no Reservation selected, abort)
4. use the service to delete the Reservation by its identifier
5. display success or failure in the view