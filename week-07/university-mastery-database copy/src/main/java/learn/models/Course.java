package learn.models;

import java.util.List;

public class Course {
    int id;
    String name;

    Instructor teacher;
    List<Student> students;
    List<Grade> grades;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public Instructor getTeacher() {
        return teacher;
    }

    public void setTeacher(Instructor teacher) {
        this.teacher = teacher;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

}
