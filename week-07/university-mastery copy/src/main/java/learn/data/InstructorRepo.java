package learn.data;

import learn.models.Instructor;

import java.util.List;

public interface InstructorRepo {

    List<Instructor> getInstructorsByLastName(String lastName ) throws DataException;

    Instructor getInstructorById(String id) throws DataException;
}
