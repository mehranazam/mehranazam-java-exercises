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
│               │       Material.java             -- enum representing the 5 materials
│               │       Panel.java                -- solar panel model
│               │
│               └───ui
│                       Controller.java           -- UI controller
│                       View.java                 -- all console input/output
│
└───test
    └───java
        └───learn
            └───solar
                ├───data
                │       PanelFileRepositoryTest.java    -- PanelFileRepository tests
                │       PanelRepositoryTestDouble.java  -- helps tests the service, implements PanelRepository
                │
                └───domain
                        PanelServiceTest.java           -- PanelService tests
```
## Class Details
### App
- `public static void main(String[])` -- instantiate all required classes with valid arguments, dependency injection. run controller
### data.DataException
Custom data layer exception.
- `public DataException(String, Throwable)` -- constructor, Throwable arg is the root cause exception
### data.PanelFileRepository
- `private String filePath`
- `public List<Panel> findBySection(String)` -- finds all Panels in a section, uses the private `findAll` method
- `public Panel add(Panel)` -- create a Panel
- `public boolean update(Panel)` -- update a Panel
- `public boolean deleteById(int)` -- delete a Panel by its id
- `private List<Panel> findAll()` -- finds all Panels in the data source (file), does not need to be public
- `private String serialize(Panel)` -- convert a Panel into a String (a line) in the file
- `private Panel deserialize(String)` -- convert a String into a Panel
### data.PanelRepository (interface)
Contract for PanelFileRepository and PanelRepositoryTestDouble.
- `List<Panel> findBySection(String)`
- `Panel add(Panel)`
- `boolean update(Panel)`
- `boolean deleteById(int)`
### domain.PanelResult
- `private ArrayList<String> messages` -- error messages
- `private Panel panel` -- an optional Panel
- `public boolean isSuccess()` -- calculated getter, true if no error messages
- `public List<String> getMessages()` -- messages getter, create a new list
- `public Panel getPanel()` -- Panel getter
- `public void setPanel(Panel)` -- Panel setter
- `public void addMessage(String)` -- adds an error message to messages
### domain.PanelService
-  `private PanelRepository repository` -- required data dependency
-  `public PanelService(PanelRepository)` -- constructor
-  `public List<Panel> findBySection(String)` -- pass-through to repository
-  `public PanelResult add(Panel)` -- validate, then add via repository
-  `public PanelResult update(Panel)` -- validate, then update via repository
-  `public PanelResult deleteById(int)` -- pass-through to repository
-  `private PanelResult validate(Panel)` -- general-purpose validation routine
### models.Material
An enum with five values: multicrystalline silicon, monocrystalline silicon, amorphous silicon, cadmium telluride, copper indium gallium selenide. Can use industry abbreviations or full names.
### models.Panel
- `private int id`
- `private String section`
- `private int row`
- `private int column`
- `private int installationYear`
- `private Material material`
- `private boolean tracking`
- Full getters and setters
- override `equals` and `hashCode`
### ui.Controller
- `private View view` -- required View dependency
- `private PanelService service` -- required service dependency
- `public Controller(View, PanelService)` -- constructor with dependencies
- `public void run()` -- kicks off the whole app, menu loop
- `private void viewBySection()` -- coordinates between service and view to display panels in a section
- `private void addPanel()` -- coordinates between service and view to add a new panel
- `private void updatePanel()` -- coordinates between service and view to update a panel
- `private void deletePanel()` -- coordinates between service and view to delete a panel
### ui.View
- `private Scanner console` -- a Scanner to be used across all methods
- `public int chooseOptionFromMenu()` -- display the main menu and select an option, used to Controller.run()
- `public void printHeader(String)` -- display text to the console with emphasis
- `public void printResult(PanelResult)` -- display a PanelResult with either success or failure w/ messages included
- `public void printPanels(String sectionName, List<Panel>)` -- display panels in a section with the section's name
- `public Panel choosePanel(String sectionName, List<Panel>)` -- choose a panel from a list of options (useful for update and delete)
- `public Panel makePanel()` -- make a panel from scratch, used in Controller.addPanel
- `public Panel update(Panel)` -- accept and existing Panel, update it, and return it, used in Controller.updatePanel
- `public String readSection()` -- reads a section name, used in Controller: viewBySection, updatePanel (must search first), and deletePanel
- `private String readString(String)` -- general-purpose console method for reading a string
- `private String readRequiredString(String)` -- general-purpose console method for reading a required string
- `private int readInt(String)` -- general-purpose console method for reading an integer
- `private int readInt(String, int min, int max)` -- general-purpose console method for reading an integer with a min and max
- `private Material readMaterial()` -- domain-specific console method for choosing a Material
## Steps
1. Create a Maven project.
2. Add jUnit 5, Jupiter, as a Maven dependency and refresh Maven
3. Create packages.
4. Create the `Panel` model.
5. Create the `Material` enum.
6. Create the data layer's custom `DataException`
7. Create the `PanelFileRepository` class.
   All methods should catch IOExceptions and throw `DataException`.
    - add the filePath field and create a constructor to initialize the field
    - generate tests for `PanelFileRepository`, should be located in `src/test/java/learn/solar/data/PanelFileRepositoryTest`
    - create a `data` directory in the project root. add test, seed, and production data files
    - implement `findAll`, `serialize`, and `deserialize`. these are all private method. may be useful to make `findAll` public temporarily and test it quick.
    - implement `findBySection`, it uses `findAll`. test it naively (no known-good-state for now)
    - implement `add`
    - improve tests by establishing known-good-state with `@BeforeAll`
    - test `add`
    - implement `update`
    - test `update`
    - implement `deleteById`
    - test `deleteById`
8. Extract the `PanelRepository` interface (IntelliJ: Refactor -> Extract Interface) from `PanelFileRepository`.
9. Create `PanelResult`.
10. Create `PanelService`.
    - add a `PanelRepository` (interface) field with a corresponding constructor
    - generate tests for `PanelService`
    - create `PanelRepositoryTestDouble` to support service testing, this test class implements `PanelRepository`
    - implement `findBySection` and test, implement just enough code in `PanelRepositoryTestDouble` to enable service testing
    - implement `add` and test, requires validation
    - implement `update` and test, requires validation
    - implement `deleteById` and test
11. Create `View`
    - add `Scanner` field
    - create read* methods: `readString`, `readRequiredString`, `readInt`, `readInt` (with min/max)
12. Create `Controller`
    - add fields for service and view with corresponding constructor
    - add a `run` method
13. Create `App` and the `main` method.
    - instantiate all required objects: repository, service, view, and controller
    - run the controller
14. Work back and forth between controller and view.
    Run early and often. Add `System.out.println`s as breadcrumbs in controller, but don't forget to remove them when development is complete.
    Determine the correct sequence for service calls and view calls. What is the order?
    - implement `chooseOptionFromMenu` and `printHeader` in view
    - use them in the controller's `run`
    - implement `viewBySection` in controller, complete required view methods: `readSection`, `printPanels`
    - implement `addPanel` in controller, complete required view methods: `makePanel`, `readMaterial`, `printResult`
    - implement `updatePanel` in controller, complete required view methods: `choosePanel`, `update`
    - implement `deletePanel` in controller, complete required view methods (`deletePanel` can re-use `choosePanel`)
## Controller Perspectives
### View Panels by Section
1. collect section name from the view
2. use the name to fetch panels from the service
3. use the view to display panels
### Add a Panel
1. collect a complete and new panel from the view
2. use the service to add the panel and grab its result
3. display the result in the view
### Update a Panel
1. collect section name from the view
2. use the name to fetch panels from the service
3. display the panels in the view and allow the user to choose a panel (if no panel selected, abort)
4. update panel properties (setters) in the view
5. use the service to update/save the panel and grab its result
6. display the result in the view
### Delete a Panel
1. collect section name from the view
2. use the name to fetch panels from the service
3. display the panels in the view and allow the user to choose a panel (if no panel selected, abort)
4. use the service to delete the panel by its identifier
5. display success or failure in the view