package learn.models;

import java.time.LocalDate;
import java.util.List;

public class Grade {
    int id;
    LocalDate gradDate;
    String letterGrade;

    // Option 1.  Add the id fields to the object that references
    //              other objects.
//    String courseId;
//    String instructorId;
//    String studentId;

    // Option 2.  Add the other models directly for easy lookup layer
    Course gradeCourse;
    Instructor courseInstructor;
    Student gradeStudent;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getGradDate() {
        return gradDate;
    }

    public void setGradDate(LocalDate gradDate) {
        this.gradDate = gradDate;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public Course getGradeCourse() {
        return gradeCourse;
    }

    public void setGradeCourse(Course gradeCourse) {
        this.gradeCourse = gradeCourse;
    }

    public Instructor getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(Instructor courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public Student getGradeStudent() {
        return gradeStudent;
    }

    public void setGradeStudent(Student gradeStudent) {
        this.gradeStudent = gradeStudent;
    }


}
