package learn.controllers;

import learn.data.DataException;
import learn.domain.StudentService;
import learn.models.Grade;
import learn.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    StudentService service;

    public StudentController( StudentService service ){
        this.service = service;
    }

    @GetMapping("/api/student/{lastName}")
    public ResponseEntity getStudentsByLastName(@PathVariable String lastName){

        List<Student> matchingStudents = null;
        try {
            matchingStudents = service.getStudentsByLastName( lastName );
            return new ResponseEntity<>( matchingStudents, HttpStatus.OK );
        } catch (DataException e) {
            return new ResponseEntity( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
