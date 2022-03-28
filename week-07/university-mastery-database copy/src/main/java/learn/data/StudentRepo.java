package learn.data;

import learn.models.Student;

import java.util.List;

public interface StudentRepo {

    List<Student> getStudentsByLastName( String lastName ) throws DataException;

    Student getStudentById(int id) throws DataException;
}
