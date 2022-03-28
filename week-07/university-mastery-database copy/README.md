# University Mastery Project

This project is meant to demonstrate some design patterns closely following the data structures used for the mastery
project.

## User Stories

1. As a user, I should be able to add a Grade for a particular Student taking a particular Course with a particular Instructor.
2. As a user, I should be able to delete a Grade.
3. As a user, I should be able to edit an existing Grade.
4. As a user, I should be able to look up all Grades for a given Course.


## Adding a Grade

1. User will select the Course as a search by name.  {getCoursesByName()}
2. User will select the Instructor as a search by last name.  {getInstructorsByLastName()}
3. User will select the Student as a search by last name. {getStudentsByLastName()}
4. User will directly enter the graduation date.
5. User will directly enter the letter grade.
6. Build a Grade object
7. Send Grade object to service/repo for validation/saving  {addGrade()}

## Deleting a Grade
1. User will select the Course as a search by name.
2. User will select the Grade Id  { getGradesByCourse() }
3. Display Grade to user { getGrade( courseId, gradeId ) }
4. Confirm deletion with user
5. Send the Course Id & Grade Id to the service/repo for validation/deletion  { deleteGrade() }

## Editing an existing Grade
1. User will select the Course as a search by name.
2. User will select the Grade Id  { getGradesByCourse() }
3. Display Grade to user { getGrade( courseId, gradeId ) }
4. Allow user to change letter grade and graduation date.
5. Confirm edit with user
6. Send the edited Grade to the service/repo for validation/edit { updateGrade() }

## Get All Grades for a given Course
1. User will select the Course as a search by name.
2. Get all grades for the selected course by course id { getGradesByCourse() }
3. Display to user (pagination)