package learn.data;

import learn.models.Course;

import java.util.List;

public interface CourseRepo {

    List<Course> getCoursesByName(String courseName) throws DataException;

    Course getCourseById(String id) throws DataException;
}
