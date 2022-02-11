# Capsule Hotel Plan

## Hotel Description

In this application we will simulate the administration of the hotel through checking in, checking out, and viewing the guests within the hotel.

## Functional Requirements

* .[_]. Ask user how many capsules are available.
* .[_]. Present the main menu and ask user which option to choose.
* .[_]. Allow user to check how main guests there are (5 above and below) next to a certain capsule.
* .[_]. Allow user to check guests in to available capsule
* .[_]. Allow user to check guests out of their capsule.

##### void main(String[] args)

This method starts off the application and calls the mainMenu() method.

##### int capsuleCount (String prompt)

This method will ask the user how many capsules are available.

##### int mainMenu(String prompt)

This method is in charge of the main menu, and asks the user what they want to do.

##### String name()

This method will ask for the name of the person being checked in/out.

##### int checkIn()

This method asks the user which room needs to be booked.

##### int checkOut()

This method asks the user which room needs to be checked out.

##### boolean exit()

This method asks the user if they want to exit the program.