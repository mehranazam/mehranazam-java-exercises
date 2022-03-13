# Sustainable Foraging Plan
## High-level Requirements
- User tracks foragers, forageable items, and successful forages.
- Must add forager.
- Must be able to create report that displays kilograms of each item collected in one day.
- Must create a report that displays the total value of each Category collected on one day.
## Solar Panels
### Data
- **First Name** of forager.
- **Last Name** of forager.
- **State** of where forager lives.
- **Item ID** is a system-generated unique sequential integer.
- **Name** of item.
- **Category** of item.
### Validation
- **First Name** is required and cannot be blank.
- **Last Name** is required and cannot be blank.
- **State** is required and cannot be blank.
- **Category** is required and cannot be blank.
- **Dollars/Kg** is required and cannot be blank and must be between $0 and $7500.
- **Name** of item required
- **Item** is required
- 
- The combined values of **First Name**, **Last Name**, and **State** may not be duplicated.
## Technical Requirements
- Three layer architecture
- Data stored in a delimited file.
- Repositories should throw a custom exception, never file-specific exceptions.
- Repository and service classes must be fully tested with both negative and positive cases. Do not use your "production" data file to test your repository.
## Package/Class Overview
```
src
├───main
│   ├───java
│   │   └───learn
│   │       └───foraging
│   │           │   App.java
│   │           │
│   │           ├───data
│   │           │       DataException.java
│   │           │       ForageFileRepository.java
│   │           │       ForageRepository.java
│   │           │       ForagerFileRepository.java
│   │           │       ForagerRepository.java
│   │           │       ItemFileRepository.java
│   │           │       ItemRepository.java
│   │           │
│   │           ├───domain
│   │           │       ForagerService.java
│   │           │       ForageService.java
│   │           │       ItemService.java
│   │           │       Response.java
│   │           │       Result.java
│   │           │
│   │           ├───models
│   │           │       Category.java
│   │           │       Forage.java
│   │           │       Forager.java
│   │           │       Item.java
│   │           │
│   │           └───ui
│   │                   ConsoleIO.java
│   │                   Controller.java
│   │                   GenerateRequest.java
│   │                   MainMenuOption.java
│   │                   View.java
│   │
│   └───resources
└───test
    └───java
        └───learn
            └───foraging
                ├───data
                │       ForageFileRepositoryTest.java
                │       ForageRepositoryDouble.java
                │       ForagerFileRepositoryTest.java
                │       ForagerRepositoryDouble.java
                │       ItemFileRepositoryTest.java
                │       ItemRepositoryDouble.java
                │
                └───domain
                        ForageServiceTest.java
                        ItemServiceTest.java
```
## Class Details

### data.PanelFileRepository
- `public Panel add(Panel)` -- create a Panel
- `public List<Forage> findByDate(LocalDate date)` -- Finds forages by date
### domain.ForageService
-  `private PanelRepository repository` -- required data dependency
-  `public PanelService(PanelRepository)` -- constructor
-  `public Result<Forage> add(Forage forage)` -- validate, then add via repository
-  `private Result<Forage> validate(Forage forage)` -- general-purpose validation routine
### ui.Controller
- `private View view` -- required View dependency
- `public Controller(ForagerService foragerService, ForageService forageService, ItemService itemService, View view)` -- constructor with dependencies
- `private void viewByDate()` -- views forage by date
- `private void addForage()` -- coordinates between service and view to add a new forage
- `private void viewItems()` -- view items obtained in a forage.
- `private void addForager()` -- coordinates between service and view to add a new forager
- `private void viewItemWeight()` -- Displays weight of each item collected on one day
- `private void viewCategoryValue()` -- Displays total value of each Category collected on one day
### ui.View
- `public Forage makeForage(Forager forager, Item item)` -- make a forage from scratch, used in Controller.addForage
- `public Forager makeForager()` -- make a forager from scratch, used in Controller.addForager
## Steps
1. Create a Maven project.
2. Add jUnit 5, Jupiter, as a Maven dependency and refresh Maven
3. Create packages.
4. Edit private Result<Forage> validate(Forage forage) to include additional requirements.
5. Add private void addForage() method
6. Add private void viewItemWeight() method
7. Add private void viewCategoryValue() method
8. Add public Forage makeForage(Forager forager, Item item) method
9. Add public Forager makeForager() method
## Controller Perspectives
### View Panels by Date
1. collect Date from the view
2. use the name to fetch Forages from the service
3. use the view to display Forages
### Add a Forager
1. collect a complete and new Forager from the view
2. use the service to add the Forager and grab its result
3. display the result in the view
