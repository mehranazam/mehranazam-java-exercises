package learn.domain;


import learn.data.DataException;
import learn.data.StudentRepo;
import learn.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public List<Student> getStudentsByLastName(String lastName) throws DataException {

        List<Student> matchingStudents = repo.getStudentsByLastName(lastName);

       return matchingStudents;
    }
}
